package game.video.characters;

import game.video.constants.GameConstants;
import game.video.location.MapLocation;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
public class Player extends Character implements Cloneable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Player's attack damage. */
	private Integer attack;
	
	/** Player's health. */
	private Integer health;
	
	/** Points to reach next level. */
	private Integer nextLevelPoints;
	
	/** Current experience points. */
	private Integer currentLevelPoints;
	
	/** Player's variable location. */
	private MapLocation location;
	
	/** Player's current level. */
	private Integer level;
	
	/**
	 * Instantiates a new player.
	 *
	 */
	public Player(String name, String category, Integer attack, Integer health, MapLocation location, Integer nextLevel) {
		super(name, null, category);
		this.attack = attack;
		this.health = health;
		this.location = location;
		this.currentLevelPoints = 0;
		this.nextLevelPoints = nextLevel;
		this.level = 1;
	}
	
	/**
	 * This constructor would help for cloning object
	 * 
	 */
	public Player(Player player) {
		super(player);
		this.attack = player.attack;
		this.health = player.health;
		this.nextLevelPoints = player.nextLevelPoints;
		this.currentLevelPoints = player.currentLevelPoints;
		this.location = player.location;
		this.level = player.level;
	}
	
	@Override
	public String toString() {
		return GameConstants.DIVIDER+GameConstants.NEW_LINE_CHAR
				+"Player Details: "+GameConstants.NEW_LINE_CHAR
				+GameConstants.DIVIDER+GameConstants.NEW_LINE_CHAR
				+"Name:"+GameConstants.BIG_SPACE+getName()+GameConstants.NEW_LINE_CHAR
				+"Attack:"+GameConstants.BIG_SPACE+attack+GameConstants.NEW_LINE_CHAR
				+"Health:"+GameConstants.BIG_SPACE+health+GameConstants.NEW_LINE_CHAR
				+"Current Level:"+GameConstants.BIG_SPACE+level+GameConstants.NEW_LINE_CHAR
				+"Next Level:"+GameConstants.BIG_SPACE+currentLevelPoints+GameConstants.SLASH+nextLevelPoints+GameConstants.NEW_LINE_CHAR
				+GameConstants.DIVIDER;
	}
	
	/**
	 * This method will upgrade Player's level by increasing attack damage and health.
	 * This would also increment player's current level and increase next level points.
	 */
	public void upgradeLevel() {
		nextLevelPoints = nextLevelPoints+((level+1)*50);
		attack = attack + 25;
		health = health + 100;
		level++;
	}

	/**
	 * Gets the attack.
	 *
	 * @return the attack
	 */
	public Integer getAttack() {
		return attack;
	}

	/**
	 * Sets the attack.
	 *
	 * @param attack the new attack
	 */
	public void setAttack(Integer attack) {
		this.attack = attack;
	}

	/**
	 * Gets the health.
	 *
	 * @return the health
	 */
	public Integer getHealth() {
		return health;
	}

	/**
	 * Sets the health.
	 *
	 * @param health the new health
	 */
	public void setHealth(Integer health) {
		this.health = health;
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
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(MapLocation location) {
		this.location = location;
	}
	
	/**
	 * Gets the next level points.
	 *
	 * @return the next level points
	 */
	public Integer getNextLevelPoints() {
		return nextLevelPoints;
	}

	/**
	 * Gets the current level points.
	 *
	 * @return the current level points
	 */
	public Integer getCurrentLevelPoints() {
		return currentLevelPoints;
	}

	/**
	 * Sets the current level points.
	 *
	 * @param currentLevelPoints the new current level points
	 */
	public void setCurrentLevelPoints(Integer currentLevelPoints) {
		this.currentLevelPoints = currentLevelPoints;
	}

	/**
	 * This method will help player to Move up in the map.
	 * 
	 */
	public MapLocation moveUp() {
		return new MapLocation(location.getX()-1, location.getY());
	}
	
	/**
	 * This method will help player to Move down in the map.
	 * 
	 */
	public MapLocation moveDown() {
		return new MapLocation(location.getX()+1, location.getY());
	}
	
	/**
	 * This method will help player to Move left in the map.
	 * 
	 */
	public MapLocation moveLeft() {
		return new MapLocation(location.getX(), location.getY()-1);
	}
	
	/**
	 * This method will help player to Move right in the map.
	 * 
	 */
	public MapLocation moveRight() {
		return new MapLocation(location.getX()+1, location.getY()+2);
	}

	/**
	 * This method will clone the current object
	 */
	@Override
	public Character clone() {
		return new Player(this);
	}

}
