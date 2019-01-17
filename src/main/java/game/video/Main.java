package game.video;

import java.io.IOException;

import game.video.service.GameService;

/**
 * This would be the entry point of the game.
 */
public class Main {
	
	public static void main(String[] args) {
		
		try {
			GameService.startGame();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
