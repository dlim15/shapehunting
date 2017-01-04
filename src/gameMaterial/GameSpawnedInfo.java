/* FileName: GameSpawnedInfo.java
 * Description: GameSpawnedInfo is the class that extends from the GameFactsBase that will keep track
 * of spawn left using JLabel. Every time the element is spawned, the spawned will be reduced.
 * Once Spawned gets to 0, it will move into next level unless user loses all his life.
 */
package gameMaterial;

public class GameSpawnedInfo extends GameFactsBase{
	private int spawned;
	public GameSpawnedInfo(String title, TimerSet set){
		super(title, set);
		setBounds(210, 10, 200, 70);
		labels[0].setBounds(0, 0, 100, 70);
		labels[1].setBounds(100, 0, 110, 70);
	}
	public void setSpawned(int num){
		spawned = num;
		labels[1].setText(num+"");
	}
	public void actionByUser(){
		spawned--;
		labels[1].setText(""+spawned);
	}
//	public boolean specialEffect(){
//		return life == 0;
//	}
}
