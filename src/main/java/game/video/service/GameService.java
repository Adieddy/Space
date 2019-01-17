package game.video.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

import game.video.Main;
import game.video.constants.GameConstants;
import game.video.constants.GameMenu;
import game.video.context.SavedGameContext;
import game.video.map.GameMap;

/**
 * The Class GameService: Service class responsible to start a new game or load an existing one.
 */
public class GameService {
	
	/**
	 * Start new game.
	 *
	 */
	public static void startNewGame() throws IOException, InterruptedException, ClassNotFoundException {	
		GameManager.initialSetup();
		GameManager.playGame();
	}
	
	/**
	 * Load game: Method to load saved game.
	 *
	 */
	public static void loadGame(File file) throws IOException, ClassNotFoundException {
		
		FileInputStream fileInputStream = new FileInputStream(file);
		ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
		SavedGameContext context = (SavedGameContext)inputStream.readObject();
		inputStream.close();
		fileInputStream.close();
		GameMap.loadGame(context.getPlayer(), context.getEnemies(), context.getAllies(), context.getMapSize(), context.getToWinList());
		GameManager.playGame();
	}
	
	/**
	 * Start game.
	 *
	 */
	public static void startGame() throws IOException, ClassNotFoundException, InterruptedException {
		Scanner scanner = new Scanner(System.in);
		ClassLoader classLoader = Main.class.getClassLoader();
		PrintStream out = new PrintStream(System.out);
		boolean flag = true;
		try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream(GameConstants.INIT_FILE)))){
			String line = null;
			while((line = bufferedReader.readLine()) != null) {
				out.println(line);
			}
		}
		Map<String, String> mainMenu = GameMenu.getMenu(GameConstants.MAIN_MENU);
		while(flag) {
			out.println(mainMenu.get(GameConstants.MAIN_MENU));
			String selection = scanner.next();
			if(!(selection.length()==1 && mainMenu.get(GameConstants.OPTIONS).contains(selection))) {
				out.println("Sorry that's incorrect selection.... Please select again...");
			}
			else {
				switch (selection) {
				case "1":
					startNewGame();
					break;
				case "2":
					File file = new File(System.getProperty("user.dir"),GameConstants.SAVED_FILE);
					if(!file.exists()) {
						out.println("No data found... Play a new game...");
					}
					else {
						loadGame(file);
					}						
					break;
				case "3":
					System.exit(0);
					break;
				default:
					out.println("Something wrong happened...");
					break;
				}
			}
		}
		scanner.close();
	}
}
