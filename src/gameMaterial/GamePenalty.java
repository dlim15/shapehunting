/* FileName: GamePenalty.java
 * Description: GamePenalty is the class that extends from the GameFactsBase that will keep track
 * of game penalty using JLabel. Penalty has three chances. Every time user choose the
 * unmatched shape and color, you will strike a penalty. Once you make 3 penalties, 
 * you will lose one life.
 */
package gameMaterial;

import java.awt.Color;
public class GamePenalty extends GameFactsBase{
	private int penalty;
	private String left;
	public GamePenalty(String title, TimerSet set){
		super(title, set);
		setBounds(1100, 80, 500, 70);
		penalty = 0;
		left = "OOO";
		labels[1].setText(left);
		labels[0].setBounds(0, 0, 130, 70);
		labels[1].setBounds(130, 0, 300, 70);
	}
	public void actionByUser(){
		penalty++;
		left = "";
		for(int i=0; i<3; i++){
			if(i<penalty)
				left += "X";
			else
				left += "0";
		}
		update(left, Color.RED);
	}
	public boolean specialEffect(){
		return penalty == 3;
	}
	public void reset(){
		penalty = 0;
		update("OOO", Color.WHITE);
	}
}
