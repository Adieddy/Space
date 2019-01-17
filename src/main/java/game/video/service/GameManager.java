package game.video.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

import game.video.config.GameConfigurations;
import game.video.constants.GameConstants;
import game.video.constants.GameMenu;
import game.video.context.GameContext;
import game.video.enums.Categories;
import game.video.map.GameMap;

/**
 * The Class GameManager: base class for configuring player.
 */
public class GameManager {
	
	private final static Scanner scanner = new Scanner(System.in);
	private final static PrintStream out = new PrintStream(System.out);
	private static boolean flag = true;
	
	/**
	 * Inits the game: Method to initialize all configurations of game.
	 *
	 */
	private static void initGame(String playerName, String playerCategory) {
		GameConfigurations configurations = new GameConfigurations(playerName, playerCategory);
		GameContext.set(configurations);
	}
	
	/**
	 * Initial setup: this method will help to get and store player details.
	 *
	 */
	public static void initialSetup() throws InterruptedException, IOException {
		out.println(GameConstants.NEW_LINE_CHAR+"Hello there wanderer... What's your name???");
		String name = scanner.next();
		out.println(GameConstants.NEW_LINE_CHAR+"Nice to meet you Captain \""+name+"\". You know space is full of bad aliens.");
		out.println("We need to defeat them to save galaxy... But be very careful. Don't make your allies go against you.");
		out.print(GameConstants.NEW_LINE_CHAR);
		out.println("One more thing... To complete this quest... You shall kill all your enemies...");
		out.print(GameConstants.NEW_LINE_CHAR);
		out.println("Anyways let's start our journey, shall we??");
		out.print(GameConstants.NEW_LINE_CHAR);
		out.print("Before moving ahead, I want to know what kind of creature you are... Select any option from below");
		String categorySel = null;
		while(flag) {
			Map<String, String> categories = GameMenu.getMenu(GameConstants.CATEGORY_MENU);
			out.print(categories.get(GameConstants.CATEGORY_MENU));
			categorySel = scanner.next();
			if(!categories.get(GameConstants.OPTIONS).contains(categorySel)) {
				out.println("That's an incorrect selection. Please select again.");
			}
			else {
				flag = false;
			}
		}
		String category = Categories.categoryOf(categorySel).name();
		out.println(GameConstants.NEW_LINE_CHAR+"Interesting... I've never seen \""+category+"\" on this side of space before");
		out.println("Let's initialize launch sequence for you...");
		out.print(GameConstants.NEW_LINE_CHAR);
		initGame(name, category);
		Thread.sleep(3000);
		GameConstants.clearScreen();
		out.println("All configurations done... ");
		out.println("You could see yourself in the map as \"P\"... ");
		out.println("Your enemies are visible as \"@\"... And \"A\" are your allies...");
		out.println("Let's start our journey...");
		out.print(GameConstants.NEW_LINE_CHAR);
		printPlayerDetails();
	}
	
	/**
	 * Prints the player details.
	 */
	private static void printPlayerDetails() {
		out.println(GameContext.get().getPlayerConfiguration().getPlayerDetails());
	}
	
	/**
	 * Play game: method to play game.
	 *
	 */
	public static void playGame() throws FileNotFoundException, IOException, ClassNotFoundException {
		while(true) {
			GameMap.showMap();
			GameMap.movePlayer();
		}
	}
}
