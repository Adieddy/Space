package game.video.map;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import game.video.characters.Allies;
import game.video.characters.Character;
import game.video.characters.EnemyPlanet;
import game.video.characters.Player;
import game.video.constants.GameConstants;
import game.video.constants.GameMenu;
import game.video.context.GameContext;
import game.video.context.SavedGameContext;
import game.video.location.MapLocation;

/**
 * The Class GameMap: This class is the base map of game.
 * Player could move around map and explore things.
 */
public class GameMap {
	
	private static Player player;
	private static Map<MapLocation, EnemyPlanet> enemies;
	private static Map<MapLocation, Allies> allies;
	
	private static Character[][] mapSize;
	
	private static List<MapLocation> toWinList;
	
	private static PrintStream out = new PrintStream(System.out);
	private static boolean flag;
	private static Scanner scanner;
	private static ClassLoader classLoader = GameMap.class.getClassLoader();
	
	/**
	 * Static block to initialize game details
	 */
	static {
		if(GameContext.get()!=null) {
			player = GameContext.get().getPlayerConfiguration().getPlayerDetails();
			enemies = new HashMap<>();
			allies = new HashMap<>();
			toWinList = new ArrayList<>();
			GameContext.get().getEnemyConfiguration().getEnemiesList().forEach(e->{
				enemies.put(e.getLocation(), e);
				toWinList.add(e.getLocation());
			});
			GameContext.get().getAlliesConfig().getAlliesList().forEach(e->{
				allies.put(e.getLocation(), e);
			});
			drawMap();
		}
	}
	
	/**
	 * Load game: This method would be used to load a saved game.
	 *
	 */
	public static void loadGame(Player playerDet, Map<MapLocation, EnemyPlanet> enemiesMap, Map<MapLocation, Allies> alliesMap, Character[][] mapsizeDet, List<MapLocation> toWin) {
		player = playerDet;
		enemies = enemiesMap;
		allies = alliesMap;
		mapSize = mapsizeDet;
		toWinList = toWin;
	}
	
	/**
	 * Draw map.
	 */
	public static void drawMap() {
		initMap();
		placeEnemyPlanets();
		placeAllies();
		placePlayer();
	}
	
	/**
	 * Initializes the map.
	 */
	private static void initMap() {
		mapSize = new Character[GameConstants.X_AXIS][GameConstants.Y_AXIS];
	}
	
	/**
	 * Place player onto the map.
	 */
	private static void placePlayer() {
		mapSize[player.getLocation().getX()][player.getLocation().getY()] = player;
	}
	
	/**
	 * Place enemy planets on map.
	 */
	private static void placeEnemyPlanets() {
		enemies.forEach((k,v)->{
			mapSize[k.getX()][k.getY()] = v;
		});
	}
	
	/**
	 * Place allies on map.
	 */
	private static void placeAllies() {
		allies.forEach((k,v)->{
			mapSize[k.getX()][k.getY()] = v;
		});
	}
	
	/**
	 * Show map to player to move.
	 * Player is denoted by P
	 * Enemies are shown by @
	 * Allies are shown by A
	 */
	public static void showMap() {
		out.println(GameConstants.NEW_LINE_CHAR);
		out.print(" ");
		for(int i=0;i<mapSize.length;i++) {
			out.print(" "+i);
		}
		for(int i=0;i<mapSize.length;i++) {
			out.println();
			out.print(i);
			for(int j=0;j<mapSize.length;j++) {
				if(mapSize[i][j] instanceof Player) {
					out.print(" P");
				}
				else if(mapSize[i][j] instanceof EnemyPlanet) {
					out.print(" @");
				}
				else if(mapSize[i][j] instanceof Allies) {
					out.print(" A");
				}
				else {
					out.print("  ");
				}
			}
		}
		out.println(GameConstants.NEW_LINE_CHAR);
		out.print("*");
		for(int i=0;i<mapSize.length;i++) {
			out.print("**");
		}
		if(toWinList.size()==0) {
			out.println(GameConstants.NEW_LINE_CHAR+GameConstants.BIG_SPACE+"Well done Captain "+player.getName()+". You have saved the universe.... It was nice roaming with you... See you in next quest...");
			System.exit(0);
		}
	}
	
	/**
	 * Valid player move: method to verify whether the player move is valid or not.
	 *
	 */
	public static boolean validPlayerMove(MapLocation newLocation) {
		if(newLocation.getX()<0 || newLocation.getX()>=mapSize.length) {
			return false;
		}
		if(newLocation.getY()<0 || newLocation.getY()>=mapSize[0].length) {
			return false;
		}
		return true;
	}
	
	/**
	 * Move player: method to move player on map.
	 *
	 */
	public static void movePlayer() throws FileNotFoundException, IOException, ClassNotFoundException {
		MapLocation newLocation = null;
		Map<String, String> moveMenu = GameMenu.getMenu(GameConstants.MOVEMENT_MENU);
		out.println(moveMenu.get(GameConstants.MOVEMENT_MENU));
		out.print(GameConstants.NEW_LINE_CHAR);
		out.println("Move to a location...");
		flag = true;
		String selection;
		
		scanner = new Scanner(System.in);
		while(flag) {
			selection = scanner.next();
			if(!(selection.length()==1 && moveMenu.get(GameConstants.OPTIONS).contains(selection))) {
				out.print("That's an incorrect move Captain... Select again else your ship will blow...");
			}
			else {
				switch (selection.toUpperCase()) {
				case "W":
					newLocation = new MapLocation(player.getLocation().getX()-1, player.getLocation().getY());
					exploreLocation(newLocation);
					break;
				case "A":
					newLocation = new MapLocation(player.getLocation().getX(), player.getLocation().getY()-1);
					exploreLocation(newLocation);
					break;
				case "S":
					newLocation = new MapLocation(player.getLocation().getX()+1, player.getLocation().getY());
					exploreLocation(newLocation);
					break;
				case "D":
					newLocation = new MapLocation(player.getLocation().getX(), player.getLocation().getY()+1);
					exploreLocation(newLocation);
					break;
				case "V":
					out.println(player.toString());
					newLocation = new MapLocation(player.getLocation().getX(), player.getLocation().getY());
					break;
				case "G":
					saveGame();
					break;
				case "X":
					System.exit(0);
				default:
					newLocation = new MapLocation(player.getLocation().getX(), player.getLocation().getY());
					break;
				}
			}
		}
		drawMap();
	}
	
	/**
	 * Save game: method to save current configurations of game.
	 *
	 */
	private static void saveGame() throws IOException, ClassNotFoundException {
		SavedGameContext context = new SavedGameContext(player, enemies, allies, mapSize, toWinList);
		context.saveGame();
		out.println("Alright Captain... You can take rest now... We will continue some time later...");
	}

	/**
	 * Explore location: method to explore Enemy or Ally planet.
	 *
	 */
	private static void exploreLocation(MapLocation newLocation) throws IOException {
		if(!validPlayerMove(newLocation)) {
			out.println(GameConstants.NEW_LINE_CHAR+"Are you mad??? Why do you want to go into Black Hole??? Make another move...");
		}
		else {
			if(enemies.containsKey(newLocation)) {
				EnemyPlanet enemyPlanetTemp = enemies.get(newLocation);
				if(enemies.get(newLocation).isDead()) {
					out.println(GameConstants.NEW_LINE_CHAR+GameConstants.EQUAL_DIVIDER
							+GameConstants.NEW_LINE_CHAR
							+"You've already conquered "+enemyPlanetTemp.getName()+" and killed "+enemyPlanetTemp.getGodName()+". Let's move ahead..."
							+GameConstants.NEW_LINE_CHAR+GameConstants.EQUAL_DIVIDER);
				}
				else {
					try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream(GameConstants.ENEMY_FILE)))){
						String line = null;
						while((line = bufferedReader.readLine()) != null) {
							out.println(line);
						}
					}
					Player playerClone = (Player)player.clone();
					EnemyPlanet enemyClone = (EnemyPlanet)enemyPlanetTemp.clone();
					if(FightMap.fightEnemyMap(enemyClone, playerClone)) {
						int levelPoints = player.getCurrentLevelPoints()+enemyPlanetTemp.getAttack();
						player.setCurrentLevelPoints(levelPoints);
						if(levelPoints>=player.getNextLevelPoints()) {
							player.upgradeLevel();
						}
						out.println(GameConstants.NEW_LINE_CHAR);
						out.println(GameConstants.NEW_LINE_CHAR+"Congratulations Captain... Finally you killed "+enemyClone.getGodName());
						enemyPlanetTemp.setHealth(0);
						enemyPlanetTemp.setDead(true);
						player.setLocation(newLocation);
						toWinList.remove(newLocation);
					}
					else {
						out.println(GameConstants.NEW_LINE_CHAR);
						out.println(GameConstants.NEW_LINE_CHAR+"No worries Captain... we will meet "+enemyClone.getGodName()+" some other day...");
					}
				}
			}
			else if(allies.containsKey(newLocation)) {
				Allies ally = allies.get(newLocation);
				if(ally.isVisited()) {
					out.println(GameConstants.NEW_LINE_CHAR+GameConstants.EQUAL_DIVIDER+
							GameConstants.NEW_LINE_CHAR+"You've already visited "+ally.getName()
							+GameConstants.NEW_LINE_CHAR+GameConstants.EQUAL_DIVIDER);
				}
				else {
					try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream(GameConstants.ALLY_FILE)))){
						String line = null;
						while((line = bufferedReader.readLine()) != null) {
							out.println(line);
						}
					}
					out.print(GameConstants.NEW_LINE_CHAR);
					out.println(ally);
					AllyMap.visitAlly(player, ally);
					player.setLocation(newLocation);
				}
			}
			else {
				out.println(GameConstants.NEW_LINE_CHAR+"Nice move... Let's go...");
				player.setLocation(newLocation);
			}
			flag = false;
		}
	}
}
