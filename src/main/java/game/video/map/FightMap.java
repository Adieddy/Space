package game.video.map;

import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

import game.video.characters.EnemyPlanet;
import game.video.characters.Player;
import game.video.constants.GameConstants;
import game.video.constants.GameMenu;

/**
 * The Class FightMap: this class would be used when the Player enters Enemy planet.
 */
public class FightMap {
	
	private final static PrintStream out = new PrintStream(System.out);
	
	private static Scanner scanner;
	private static boolean flag;
	
	/**
	 * Fight enemy map: Method showing fight details.
	 *
	 */
	public static boolean fightEnemyMap(EnemyPlanet enemyPlanet, Player player) {
		flag = true;
		printEnemyDetails(enemyPlanet);
		scanner = new Scanner(System.in);
		String selection;
		int enemyAttack = enemyPlanet.getAttack();
		int playerAttack = player.getAttack();
		while(flag) {
			Map<String, String> fightMenu = GameMenu.getMenu(GameConstants.FIGHT_MENU);
			out.println(fightMenu.get(GameConstants.FIGHT_MENU));
			selection = scanner.next();
			if(!(selection.length()==1 && fightMenu.get(GameConstants.OPTIONS).contains(selection))) {
				out.println("Dude!!! Don't make that alien more angry... Do something right....");
			}
			else if("H".equals(selection.toUpperCase())) {
				enemyPlanet.setHealth(enemyPlanet.getHealth()-playerAttack);
				player.setHealth(player.getHealth()-enemyAttack);
				if(player.getHealth()<=0) {
					out.print("Farewell Captain... See you on the other side...");
					System.exit(0);
				}
				out.print(GameConstants.NEW_LINE_CHAR);
				out.println("That's a nice attack Captain "+player.getName());
				out.println("Enemy's Health: "+enemyPlanet.getHealth());
				out.println("Your Health: "+player.getHealth());
			}
			else if("B".equals(selection.toUpperCase())) {
				flag = false;
			}
			if(enemyPlanet.getHealth()<=0) {
				flag = false;
				enemyPlanet.setDead(true);
			}
		}
		return enemyPlanet.isDead();
	}
	
	/**
	 * Prints the enemy details.
	 *
	 */
	private static void printEnemyDetails(EnemyPlanet enemyPlanet) {
		out.println(GameConstants.DIVIDER);
		out.println("You are on an enemy planet.....  Your enemy details are:");
		out.print(GameConstants.NEW_LINE_CHAR);
		out.println("Planet Name:"+GameConstants.BIG_SPACE+enemyPlanet.getName());
		out.println("About:"+GameConstants.BIG_SPACE+enemyPlanet.getDescription());
		out.println("Ruler:"+GameConstants.BIG_SPACE+enemyPlanet.getGodName());
		out.println("Attack:"+GameConstants.BIG_SPACE+enemyPlanet.getAttack());
		out.println("Healtn:"+GameConstants.BIG_SPACE+enemyPlanet.getHealth());
		out.println(GameConstants.DIVIDER);
		out.print(GameConstants.NEW_LINE_CHAR);
		out.println(GameConstants.BIG_SPACE+"\""+enemyPlanet.getGodName().toUpperCase()+"\" says: "+enemyPlanet.getSalutation());
	}
}
