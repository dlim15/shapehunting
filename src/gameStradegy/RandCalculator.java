/* FileName: RandCalculator.java
 * Description: RandCalculator is the class to calculate some random numbers for game
 * materials. It could be 
 * depended on the level of the game.
 */
package gameStradegy;

import java.util.Random;

public class RandCalculator {
	private Random random;
	private static RandCalculator randCalculator;
	private final static int WIDTH = 1300;
	private final static int HEIGHT = 700;
	private final static double HEALTH_INC_RATE = 0.3;
	private final static double EXPLOSION_DEC_RATE = 0.3;
	private final static int SPAWN_INC_RATE = 1;
	private RandCalculator(){
		random = new Random();
	}
	public int getColor(){
		return random.nextInt(9);
	}
	public int getShape(){
		return random.nextInt(3);
	}
	public int getHealth(){
		return 1;
	}
	public int getSpawnNum(int level){
		return 10;
	}
	public int getExplosionTime(int level){
		return random.nextInt(4) + 5 - (level >= 10 ? 2: (int)(level*EXPLOSION_DEC_RATE));
	}
	public int getSpawnX(){
		return random.nextInt(WIDTH - 70);
	}
	public int getSpawnY(){
		return random.nextInt(HEIGHT - 70);
	}
	public static RandCalculator getInstance(){
		if(randCalculator == null)
			randCalculator = new RandCalculator();
		return randCalculator;
	}
}
