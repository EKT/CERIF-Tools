package gr.ekt.cerif;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.features.multilingual.CerifMultipleLanguageFeature;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Field[] f = Project.class.getDeclaredFields();
		for (Field fie:f) {
			System.out.println(fie.getType()+", "+fie.getName()+", "+fie.getGenericType());
			Type type = fie.getGenericType();
			if (type instanceof ParameterizedType) {
				ParameterizedType pt = (ParameterizedType)type;
				Type[] t = pt.getActualTypeArguments();
				for (Type tin:t) {
					System.out.println("name: "+((java.lang.Class)tin).getName());
				}
				boolean b = type instanceof ParameterizedType && 
						CerifLinkEntity.class.isAssignableFrom(
						(java.lang.Class)((ParameterizedType)type)
						.getActualTypeArguments()[0]);
				System.out.println("multi: "+b);
			}
		}

	}

}
