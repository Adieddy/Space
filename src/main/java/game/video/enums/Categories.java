package game.video.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum Categories for player.
 */
public enum Categories {
	
	/** The centaur. */
	CENTAUR("1"),
	
	/** The racoon. */
	RACOON("2"),
	
	/** The tree. */
	TREE("3");
	
	/** The value. */
	private String value;
	
	/** The map of categories. */
	private static Map<String, Categories> map = new HashMap<>();
	
	/**
	 * Instantiates a new categories.
	 *
	 */
	private Categories(String value) {
		this.value = value;
	}
	
	static {
		for(Categories category:Categories.values()) {
			map.put(category.value, category);
		}
	}
	
	/**
	 * Get Category based on option.
	 *
	 */
	public static Categories categoryOf(String c) {
		return map.get(c);
	}
	
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
}
