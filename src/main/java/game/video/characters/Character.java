package game.video.characters;

import java.io.Serializable;

/**
 * This is parent class for all kind of Characters.
 */
public abstract class Character implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Character Name. */
	private final String name;
	
	/** Character description. */
	private final String description;
	
	/** Character's category. */
	private final String category;
	
	/**
	 * Instantiates a new character.
	 *
	 */
	public Character(String name, String description, String category) {
		this.name = name;
		this.description = description;
		this.category = category;
	}
	
	public Character(Character character) {
		this.name = character.name;
		this.description = character.description;
		this.category = character.category;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	
	public abstract Character clone();
}
