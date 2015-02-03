package gr.ekt.cerif.enumerations;

import java.io.Serializable;

public enum LanguageSkills implements Serializable {
	
	/**
	 * Mother tongue or native language.
	 */
	m,
	
	/**
	 * Fluent in the language.
	 */
	f,
	
	/**
	 * Working knowledge of the language
	 */
	w;
	
	/**
	 * Returns the mother language level.
	 * @return a language level.
	 */
	public LanguageSkills getMother() {
		return m;
	}
	
	/**
	 * Returns the mother language level.
	 * @return a language level.
	 */
	public LanguageSkills getFluent() {
		return f;
	}
	
	/**
	 * Returns the mother language level.
	 * @return a language level.
	 */
	public LanguageSkills getWorking() {
		return w;
	}

}
