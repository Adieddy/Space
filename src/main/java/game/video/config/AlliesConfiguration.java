package game.video.config;

import java.util.ArrayList;
import java.util.List;

import game.video.characters.Allies;
import game.video.location.MapLocation;

/**
 * AlliesConfiguration class.
 * This will instantiate all allies with name, description, category and map location
 */
public class AlliesConfiguration {
	
	private static List<Allies> allies;
	
	static {
		allies = new ArrayList<>();
		initAllies();
	}
	
	/**
	 * Inits the allies.
	 */
	public static void initAllies() {
		allies.add(new Allies("Xandar", "Nova Empire", "ALL", new MapLocation(3, 1), 30, false));
		allies.add(new Allies("Alpha Centauri","Blue Planet","Centaur", new MapLocation(2, 7), 50, false ));
		allies.add(new Allies("Halfworld","Planet for Animals","Racoon", new MapLocation(5, 0), 50, false ));
		allies.add(new Allies("Planet X","Unknown","Tree", new MapLocation(0, 4), 50, false ));
	}
	
	/**
	 * Gets the allies list.
	 *
	 */
	public List<Allies> getAlliesList(){
		return allies;
	}
}
