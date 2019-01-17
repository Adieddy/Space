package game.video.context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import game.video.characters.Allies;
import game.video.characters.Character;
import game.video.characters.EnemyPlanet;
import game.video.characters.Player;
import game.video.constants.GameConstants;
import game.video.location.MapLocation;

/**
 * The Class SavedGameContext is used to save current game status to a file using serialization.
 * This would help player to save game and load it whenever required.
 */
public class SavedGameContext implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -181778070130177724L;
	
	/** Player details. */
	private Player player;
	
	/** Enemies list based on location. */
	private Map<MapLocation, EnemyPlanet> enemies;
	
	/** Allies list based on location. */
	private Map<MapLocation, Allies> allies;
	
	/** The map size. */
	private Character[][] mapSize;
	
	/** The to win list. */
	private List<MapLocation> toWinList;
	
	/**
	 * Instantiates a new saved game context.
	 *
	 */
	public SavedGameContext(Player player, Map<MapLocation, EnemyPlanet> enemies, Map<MapLocation, Allies> allies, Character[][] mapSize, List<MapLocation> toWinList) {
		this.player = player;
		this.enemies = enemies;
		this.allies = allies;
		this.mapSize = mapSize;
		this.toWinList = toWinList;
	}
	
	/**
	 * Gets the player.
	 *
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Gets the enemies.
	 *
	 * @return the enemies
	 */
	public Map<MapLocation, EnemyPlanet> getEnemies() {
		return enemies;
	}

	/**
	 * Gets the allies.
	 *
	 * @return the allies
	 */
	public Map<MapLocation, Allies> getAllies() {
		return allies;
	}

	/**
	 * Gets the map size.
	 *
	 * @return the map size
	 */
	public Character[][] getMapSize() {
		return mapSize;
	}

	/**
	 * Gets the to win list.
	 *
	 * @return the to win list
	 */
	public List<MapLocation> getToWinList() {
		return toWinList;
	}

	/**
	 * Save game: This method would be used to save game configurations to a file.
	 *
	 */
	public void saveGame() throws IOException, ClassNotFoundException {
		
		File file = new File(System.getProperty("user.dir"),GameConstants.SAVED_FILE);
		if(!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		
		objectOutputStream.writeObject(this);
		
		objectOutputStream.close();
		fileOutputStream.close();
		
	}
	
}
