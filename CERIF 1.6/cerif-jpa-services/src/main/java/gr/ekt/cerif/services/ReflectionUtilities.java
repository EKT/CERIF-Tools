package gr.ekt.cerif.services;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import gr.ekt.cerif.CerifEntity;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.enumerations.semantics.ClassEnum;
import gr.ekt.cerif.features.multilingual.CerifMultipleLanguageFeature;

public final class ReflectionUtilities {
	
	private static final Logger LOGGER = Logger.getLogger(ReflectionUtilities.class);
	
	private ReflectionUtilities() {
		// nothing to implement here
	}
	
	/**
	 * Checks whether the provided field is a multilingual one.
	 * @param entityName The entity name.
	 * @param fieldName The field name.
	 * @return false/true.
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isMultilingualField(Field field) {
		Type type = field.getGenericType();
		return type instanceof ParameterizedType && CerifMultipleLanguageFeature.class.isAssignableFrom((java.lang.Class)((ParameterizedType)type).getActualTypeArguments()[0]);
	}

	
	/**
	 * Checks whether the provided field is a linked one.
	 * @param entityName The entity name.
	 * @param fieldName The field name.
	 * @return false/true.
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isLinkField(Field field) {
		boolean result = false;
		Type type = field.getGenericType();
		if (type instanceof ParameterizedType) {
			java.lang.Class clazz = (java.lang.Class)((ParameterizedType)type).getActualTypeArguments()[0];
			result = CerifLinkEntity.class.isAssignableFrom(clazz) && !clazz.getSimpleName().endsWith("_Class");
		}
		return result;
	}
	
	/**
	 * Checks whether the provided field is a linked one.
	 * @param entityName The entity name.
	 * @param fieldName The field name.
	 * @return false/true.
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isClassificationField(Field field) {
		boolean result = false;
		Type type = field.getGenericType();
		if (type instanceof ParameterizedType) {
			java.lang.Class clazz = (java.lang.Class)((ParameterizedType)type).getActualTypeArguments()[0];
			result = CerifLinkEntity.class.isAssignableFrom(clazz) && clazz.getSimpleName().endsWith("_Class");
		}
		return result;
	}
	
	/**
	 * Extracts the actual type of a linked field.
	 * @param field The field
	 * @return a type.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static java.lang.Class<? extends CerifEntity> getTypeOfLinkField(Field field) {
		Type type = field.getGenericType();
		return (java.lang.Class)((ParameterizedType)type).getActualTypeArguments()[0];
	}
	
	public static <T> Field getClassField(java.lang.Class<T> entityClass) {
		Field result = null;
		Field[] fields = entityClass.getDeclaredFields();
		for (Field field : fields) {
			if (ReflectionUtilities.isClassificationField(field)) {
				result = field;
				LOGGER.debug("class: " + field.getName());
				break;
			}
		}
		return result;
	}
	
	/**
	 * Gets, via reflection, the fields which refer to linked entities filtered with links.
	 * @param entityClass The entity class.
	 * @return some fields
	 * @throws IntrospectionException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public static <T> List<Field> getLinkFields(java.lang.Class<T> entityClass, List<ClassEnum> links, Object entity) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final List<Field> result = new ArrayList<Field>();
		final Field[] fields = entityClass.getDeclaredFields();
		
		for (Field field : fields) {
			if (ReflectionUtilities.isLinkField(field)) {
				boolean addedToResult = false;
				java.lang.Class<? extends CerifEntity> fieldClass = ReflectionUtilities.getTypeOfLinkField(field);
				for (ClassEnum enumeration : links) {
					if (fieldClass.getSimpleName().contains(enumeration.getEntityClass().getSimpleName())) {
						LOGGER.debug("link: " + field.getName());
						result.add(field);
						addedToResult = true;
						break;
					}
				}
				if (!addedToResult) {
					// empty field
					new PropertyDescriptor(field.getName(), entity.getClass()).getWriteMethod().invoke(entity, Collections.emptySet());
				}
			}
		}
		return result;
	}
	
	/**
	 * Gets, via reflection, all the fields which refer to multilingual entities.
	 * @param entityClass The entity class.
	 * @return some fields
	 * @throws IntrospectionException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public static <T> List<Field> getMultilingualFields(java.lang.Class<T> entityClass, Object entity) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final List<Field> result = new ArrayList<Field>();
		final Field[] fields = entityClass.getDeclaredFields();
		
		for (Field field : fields) {
			if (ReflectionUtilities.isMultilingualField(field)) {
				result.add(field);
				// empty field
				new PropertyDescriptor(field.getName(), entity.getClass()).getWriteMethod().invoke(entity, Collections.emptySet());
			}
		}
		return result;
	}
	
	/**
	 * Sets empty collections to the linked fields of the entity.
	 * @param entity The CERIF entity.
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws IntrospectionException
	 */
	public static void emptyLinks(Object entity) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		Field[] fields = entity.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (ReflectionUtilities.isLinkField(field)) {
				new PropertyDescriptor(field.getName(), entity.getClass()).getWriteMethod().invoke(entity, Collections.emptySet());
			}
		}
	}
	
	public static void emptyClassifications(Object entity) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		Field[] fields = entity.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (ReflectionUtilities.isClassificationField(field)) {
				new PropertyDescriptor(field.getName(), entity.getClass()).getWriteMethod().invoke(entity, Collections.emptySet());
			}
		}
	}
	
}
