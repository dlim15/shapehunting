/* FileName: GameLevel.java
 * Description: Gamelevel is the class that extends from the GameFactsBase that will keep track
 * of gameLevel using JLabel.
 * Level go to next level once user clears previous level.
 */
package gameMaterial;

import java.awt.Color;

public class GameLevel extends GameFactsBase{
	private int level;
	public GameLevel(String title, TimerSet set){
		super(title, set);
		setBounds(10, 10, 200, 70);
		level = 0;
		labels[1].setText(level+"");
		labels[0].setBounds(0, 0, 100, 70);
		labels[1].setBounds(100, 0, 110, 70);
	}
	public void actionByUser(){
		level++;
		update(level+"", Color.GREEN);
	}
}
