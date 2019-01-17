package game.video.config;

/**
 * This is the base GameConfigurations class.
 * It would help in session building.
 */
public class GameConfigurations {
	
	/** The enemy config. */
	private EnemyConfiguration enemyConfig;
	
	/** The player config. */
	private PlayerConfiguration playerConfig;
	
	/** The allies config. */
	private AlliesConfiguration alliesConfig;
	
	/**
	 * Instantiates a new game configurations.
	 *
	 * @param name the name
	 * @param category the category
	 */
	public GameConfigurations(String name, String category) {
		initGameConfigurations(name, category);
	}
	
	/**
	 * Inits the game configurations.
	 *
	 * @param name the name
	 * @param category the category
	 */
	public void initGameConfigurations(String name, String category) {
		playerConfig = new PlayerConfiguration(name, category);
		enemyConfig = new EnemyConfiguration();
		alliesConfig = new AlliesConfiguration();
	}

	/**
	 * Gets the enemy configuration.
	 *
	 * @return the enemy configuration
	 */
	public EnemyConfiguration getEnemyConfiguration() {
		return enemyConfig;
	}

	/**
	 * Gets the player configuration.
	 *
	 * @return the player configuration
	 */
	public PlayerConfiguration getPlayerConfiguration() {
		return playerConfig;
	}

	/**
	 * Gets the allies config.
	 *
	 * @return the allies config
	 */
	public AlliesConfiguration getAlliesConfig() {
		return alliesConfig;
	}
	
}
