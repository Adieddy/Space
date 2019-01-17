package game.video.constants;

import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class GameMenu have all the menus shown in game.
 * This would be a common place for the menus.
 */
public class GameMenu {
	
	/** The menu. */
	private static StringBuilder menu;
	
	/** The options. */
	private static StringBuilder options;
	
	/** The menu list. */
	private static Map<String, String> menuList;
	
	/**
	 * Method to get the menu based on category asked.
	 *
	 */
	public static Map<String, String> getMenu(String menuType){
		switch (menuType) {
		case GameConstants.CATEGORY_MENU:
			categoryMenu();
			break;
		
		case GameConstants.MOVEMENT_MENU:
			moveMenu();
			break;
			
		case GameConstants.FIGHT_MENU:
			fightMenu();
			break;
			
		case GameConstants.MAIN_MENU:
			mainMenu();
			break;
			
		default:
			break;
		}
		menuList = new HashMap<>();
		menuList.put(GameConstants.OPTIONS, options.toString());
		menuList.put(menuType, menu.toString());
		return menuList;
	}
	
	/**
	 * Main menu.
	 */
	public static void mainMenu() {
		menu = new StringBuilder();
		menu.append(GameConstants.NEW_LINE_CHAR).append("1. New Game").append(GameConstants.NEW_LINE_CHAR)
			.append("2. Load Game").append(GameConstants.NEW_LINE_CHAR)
			.append("3. Exit").append(GameConstants.NEW_LINE_CHAR);
		options = new StringBuilder();
		options.append("123");
	}
	
	/**
	 * Player's category menu.
	 */
	public static void categoryMenu(){
		menu = new StringBuilder();
		menu.append(GameConstants.NEW_LINE_CHAR).append("1. Centaur").append(GameConstants.NEW_LINE_CHAR)
			.append("2. Racoon").append(GameConstants.NEW_LINE_CHAR)
			.append("3. Tree").append(GameConstants.NEW_LINE_CHAR);
		options = new StringBuilder();
		options.append("123");
	}
	
	/**
	 * Player's movement menu.
	 */
	public static void moveMenu(){
		menu = new StringBuilder();
		menu.append(GameConstants.NEW_LINE_CHAR).append(GameConstants.NEW_LINE_CHAR).append("W. Move Up").append(GameConstants.NEW_LINE_CHAR)
			.append("A. Move Left").append(GameConstants.NEW_LINE_CHAR)
			.append("S. Move Down").append(GameConstants.NEW_LINE_CHAR)
			.append("D. Move Right").append(GameConstants.NEW_LINE_CHAR)
			.append("V. View Player Stats").append(GameConstants.NEW_LINE_CHAR)
			.append("G. Save Game").append(GameConstants.NEW_LINE_CHAR)
			.append("X. Exit Game").append(GameConstants.NEW_LINE_CHAR);
		options = new StringBuilder();
		options.append("WASDXVGwasdxvg");
	}
	
	/**
	 * Player's fight menu.
	 */
	public static void fightMenu() {
		menu = new StringBuilder();
		menu.append(GameConstants.NEW_LINE_CHAR).append("H. Hit Enemy").append(GameConstants.NEW_LINE_CHAR)
			.append("B. Go Back to Map").append(GameConstants.NEW_LINE_CHAR);
		options = new StringBuilder();
		options.append("HhBb");
	}
}
