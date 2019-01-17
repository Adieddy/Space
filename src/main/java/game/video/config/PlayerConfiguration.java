package game.video.config;

import game.video.characters.Player;
import game.video.location.MapLocation;

/**
 * PlayerConfiguration class.
 * This will instantiate the player with name, attack, health, map location and category
 */
public class PlayerConfiguration {
	
	/** The player. */
	private Player player;
	
	/**
	 * Instantiates a new player configuration.
	 *
	 * @param name the name
	 * @param category the category
	 */
	public PlayerConfiguration(String name, String category) {
		initPlayer(name, category);
	}
	
	/**
	 * Inits the player.
	 *
	 * @param name the name
	 * @param category the category
	 */
	public void initPlayer(String name, String category) {
		this.player = new Player(name, category, 20, 100, new MapLocation(8, 4),50);
	}
	
	/**
	 * Gets the player details.
	 *
	 * @return the player details
	 */
	public Player getPlayerDetails() {
		return player;
	}

}
