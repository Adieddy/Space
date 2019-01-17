package game.video.map;

import java.io.PrintStream;

import game.video.characters.Allies;
import game.video.characters.Player;
import game.video.constants.GameConstants;

/**
 * This class would be used when a Player visits an Ally location.
 */
public class AllyMap {
	
	private final static PrintStream out = new PrintStream(System.out);
	
	/**
	 * Visit ally: method to invoke when player visits Ally.
	 *
	 */
	public static void visitAlly(Player player, Allies allies) {
		if(GameConstants.ALL.equalsIgnoreCase(allies.getCategory()) || (player.getCategory().equalsIgnoreCase(allies.getCategory()))) {
			out.println("Is it your lucky day??? Well yes it is.... Here.. have some advanced weapons...");
			player.setAttack(player.getAttack()+allies.getEnhancedWeapon());
			if(!GameConstants.ALL.equalsIgnoreCase(allies.getCategory())) {
				player.setHealth(player.getHealth()+(player.getHealth()/2));
			}
		}
		else {
			out.println("Well it's very nice for you to visit here... But we don't have anything special for you... Hope to see you again... ADIOS...");
		}
		allies.setVisited(true);
	}
}
