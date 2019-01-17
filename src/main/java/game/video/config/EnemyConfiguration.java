package game.video.config;

import java.util.ArrayList;
import java.util.List;

import game.video.characters.EnemyPlanet;
import game.video.location.MapLocation;

/**
 * EnemyConfiguration class.
 * This will instantiate all Enemies with name, description, map location and other information
 */
public class EnemyConfiguration {
	
	/** The enemies group. */
	private static List<EnemyPlanet> enemiesGroup;
	static {
		enemiesGroup = new ArrayList<>();
		initEnemies();
	}
	
	/**
	 * Inits the enemies.
	 */
	public static void initEnemies() {
		enemiesGroup.add(new EnemyPlanet("Ariston", "Planet for mechanical Insects", "ZZZZ.... Hello there little insect.... Do you wish to die???? ZZZZ....", "Aris", 10, 70, new MapLocation(6, 2)));
		enemiesGroup.add(new EnemyPlanet("Shi'ar", "Mutants and only Mutants", "Come here little one... I've some upgrades for you",  "Vulcan", 40, 90, new MapLocation(1, 2)));
		enemiesGroup.add(new EnemyPlanet("Taa", "What's that???", "You don't know me... which will help me to kill you easily...", "Galactus", 60, 400, new MapLocation(6, 7)));
		enemiesGroup.add(new EnemyPlanet("Netherworlds", "Planet for sorcerers..", "I'll capture you and make you my slave... HAHAHA",  "Dormammu", 70, 450, new MapLocation(1, 6)));
		enemiesGroup.add(new EnemyPlanet("Hala", "Home planet for Krees", "You've entered a wrong planet BOY!!!! How dare you challenge me!!!!", "Ronan", 100, 420, new MapLocation(3, 3)));
		enemiesGroup.add(new EnemyPlanet("Titan", "Father Planet", "You are mine... No one can save you now...",  "Thanos", 120, 430, new MapLocation(4, 5)));
	}
	
	/**
	 * Gets the enemies list.
	 *
	 * @return the enemies list
	 */
	public List<EnemyPlanet> getEnemiesList(){
		return enemiesGroup;
	}
}