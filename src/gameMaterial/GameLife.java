/* FileName: GameLife.java
 * Description: GameLife is the class that extends from the GameFactsBase that will keep track
 * of gameLife Left using JLabel. Life gets deducted when user fails to get shape before
 * timeout or have three penalties.
 */
package gameMaterial;

import java.awt.Color;
public class GameLife extends GameFactsBase{
	private int life;
	public GameLife(String title, TimerSet set){
		super(title, set);
		setBounds(1100, 0, 400, 70);
		life = 10;
		labels[1].setText(life+"");
		labels[0].setBounds(0, 0, 100, 70);
		labels[1].setBounds(100, 0, 300, 70);
	}
	public void actionByUser(){
		life = life <= 0 ? 0 : life-1;
		update(life+"", Color.RED);
	}
	public boolean specialEffect(){
		return life <= 0;
	}
	
}
