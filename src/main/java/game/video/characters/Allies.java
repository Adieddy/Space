package game.video.characters;

import game.video.constants.GameConstants;
import game.video.location.MapLocation;

/**
 * This class would be for the Allies of player.
 */
public class Allies extends Character{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Location in map where allies are located */
	private final MapLocation location;
	
	/** Flag to check if the Ally is visited or not. */
	private boolean visited;
	
	/** Enhanced weapon which would be given to the player on visit */
	private final Integer enhancedWeapon;
	
	/**
	 * Instantiates a new allies.
	 *
	 */
	public Allies(String name, String description, String category, MapLocation location, Integer enhancedWeapon, boolean visited) {
		super(name, description, category);
		this.location = location;
		this.visited = visited;
		this.enhancedWeapon = enhancedWeapon;
	}
	
	/**
	 * 
	 * This constructor would help to clone object
	 */
	public Allies(Allies allies) {
		super(allies);
		this.location = allies.location;
		this.visited = allies.visited;
		this.enhancedWeapon = allies.enhancedWeapon;
	}
	
	/**
	 * Checks if is visited.
	 *
	 * @return true, if is visited
	 */
	public boolean isVisited() {
		return visited;
	}
	
	/**
	 * Sets the visited.
	 *
	 * @param visited the new visited
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public MapLocation getLocation() {
		return location;
	}
	
	/**
	 * Gets the enhanced weapon.
	 *
	 * @return the enhanced weapon
	 */
	public Integer getEnhancedWeapon() {
		return enhancedWeapon;
	}
	
	@Override
	public String toString() {
		return GameConstants.DIVIDER+GameConstants.NEW_LINE_CHAR
				+"Ally Details: "+GameConstants.NEW_LINE_CHAR
				+GameConstants.DIVIDER+GameConstants.NEW_LINE_CHAR
				+"Planet Name:"+GameConstants.BIG_SPACE+getName()+GameConstants.NEW_LINE_CHAR
				+"Description:"+GameConstants.BIG_SPACE+getDescription()+GameConstants.NEW_LINE_CHAR
				+"Category:"+GameConstants.BIG_SPACE+getCategory()+GameConstants.NEW_LINE_CHAR+GameConstants.NEW_LINE_CHAR
				+GameConstants.DIVIDER;
	}

	/**
	 * Method to clone current object
	 */
	@Override
	public Character clone() {
		return new Allies(this);
	}
}
