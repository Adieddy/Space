package game.video.constants;

/**
 * All game related constants would be present here..
 */
public class GameConstants {
	
	/** The Constant X_AXIS. */
	public static final Integer X_AXIS = 9;
	
	/** The Constant Y_AXIS. */
	public static final Integer Y_AXIS = 9;

	/** The Constant DIVIDER. */
	public static final String DIVIDER = "-----------------------------------------------------------------------";
	
	/** The Constant EQUAL DIVIDER. */
	public static final String EQUAL_DIVIDER = "========================================================================";
	
	/** The Constant NEW_LINE_CHAR. */
	public static final String NEW_LINE_CHAR = "\n";
	
	/** The Constant BIG_SPACE. */
	public static final String BIG_SPACE = "\t";
	
	/** The Constant SLASH. */
	public static final String SLASH = "/";
	
	/** The Constant CATEGORY_MENU. */
	public static final String CATEGORY_MENU = "CATEGORIES_MENU";
	
	/** The Constant MOVEMENT_MENU. */
	public static final String MOVEMENT_MENU = "MOVEMENT_MENU";
	
	/** The Constant FIGHT_MENU. */
	public static final String FIGHT_MENU = "FIGHT_MENU";
	
	/** The Constant MAIN_MENU. */
	public static final String MAIN_MENU = "MAIN_MENU";
	
	/** The Constant OPTIONS. */
	public static final String OPTIONS = "OPTIONS";
	
	/** The Constant ENEMY_FILE. */
	public static final String ENEMY_FILE = "Art_Files/Enemy.txt";
	
	/** The Constant ALLY_FILE. */
	public static final String ALLY_FILE = "Art_Files/Ally.txt";
	
	/** The Constant SAVED_FILE. */
	public static final String SAVED_FILE = "saved_config.ser";
	
	/** The Constant INIT_FILE. */
	public static final String INIT_FILE = "Art_Files/Intro.txt";
	
	/** The Constant ALL. */
	public static final String ALL = "ALL";
	
	/**
	 * Clear screen.
	 *
	 */
	public static final void clearScreen() throws InterruptedException {
		try {
			final String os = System.getProperty("os.name");
			if(os.contains("Windows")) {
				Runtime.getRuntime().exec("cls");
			}
			else {
				Runtime.getRuntime().exec("clear");
			}
		}
		catch (Exception e) {
			return;
		}
	}
}
