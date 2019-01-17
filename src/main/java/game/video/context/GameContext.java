package game.video.context;

import game.video.config.GameConfigurations;

/**
 * The Class GameContext is used to store all configurations in a session.
 * With this class, configurations can be used anywhere in the game.
 */
public class GameContext {
	
	/** Session context. */
	public static final ThreadLocal<GameConfigurations> context = new ThreadLocal<>();
	
	/**
	 * Sets the session context.
	 *
	 */
	public static void set(GameConfigurations gameConfigurations) {
		context.set(gameConfigurations);
	}
	
	/**
	 * Un-set session context.
	 */
	public static void unset() {
		context.remove();
	}
	
	/**
	 * Gets the current game context.
	 *
	 * @return the game configurations
	 */
	public static GameConfigurations get(){
		return context.get();
	}
}
