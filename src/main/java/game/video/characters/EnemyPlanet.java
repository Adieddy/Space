package game.video.characters;

import game.video.location.MapLocation;

/**
 * This is class for Enemies Planets.
 */
public class EnemyPlanet extends Character implements Cloneable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Enemy Planet's fixed location. */
	private final MapLocation location;
	
	/** Enemy's attack damage. */
	private final Integer attack;
	
	/** Enemy's health. */
	private Integer health;
	
	/** To check if enemy is dead or not. */
	private boolean isDead;
	
	/** Enemy's god name. */
	private final String godName;
	
	/** Enemy's salutation. */
	private final String salutation;
	
	/**
	 * Instantiates a new enemy planet.
	 *
	 */
	public EnemyPlanet(String name, String description, String salutation, String godName, Integer attack, Integer health, MapLocation location) {
		super(name, description, null);
		this.attack = attack;
		this.health = health;
		this.isDead = false;
		this.location = location;
		this.godName = godName;
		this.salutation = salutation;
	}
	
	/**
	 * 
	 * This constructor would be helpful to clone object
	 */
	public EnemyPlanet(EnemyPlanet enemyPlanet) {
		super(enemyPlanet);
		this.location = enemyPlanet.location;
		this.attack = enemyPlanet.attack;
		this.health = enemyPlanet.health;
		this.isDead = enemyPlanet.isDead;
		this.godName = enemyPlanet.godName;
		this.salutation = enemyPlanet.salutation;
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
	 * Checks if is dead.
	 *
	 * @return true, if is dead
	 */
	public boolean isDead() {
		return isDead;
	}

	/**
	 * Sets the dead.
	 *
	 * @param isDead the new dead
	 */
	public void setDead(boolean isDead) {
		this.isDead = isDead;
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
	 * Gets the attack.
	 *
	 * @return the attack
	 */
	public Integer getAttack() {
		return attack;
	}

	/**
	 * Gets the god name.
	 *
	 * @return the god name
	 */
	public String getGodName() {
		return godName;
	}
	
	/**
	 * Gets the salutation.
	 *
	 * @return the salutation
	 */
	public String getSalutation() {
		return salutation;
	}

	/**
	 * Clone current EnemyPlanet object
	 */
	@Override
	public Character clone() {
		return new EnemyPlanet(this);
	}
}
