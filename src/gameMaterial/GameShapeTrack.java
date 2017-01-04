/* FileName: GameShapeTrack.java
 * Description: GameShapTrack is the class that extends from the GameFactsBase that will keep track
 * of selected shape using JLabel. Shape will be changed corresponds to user's typing.
 * Shapes are :
 * 	1 : circle
 *  2 : triangle
 *  3 : rectangle
 * Colors Are :
 *  a : Ashed Gray
 *  b : Black
 *  g : Green
 *  n : Navy
 *  r : Red
 *  s : Sky blue
 *  t : Tangerine
 *  v : Violet
 *  y : Yellow
 */
package gameMaterial;
import javax.swing.Icon;

public class GameShapeTrack extends GameFactsBase{

	public GameShapeTrack(String title){
		super(title, new TimerSet());
		setBounds(600, 40, 280, 90);
		labels[0].setBounds(5, 10, 200, 90);
		labels[1].setBounds(200, 10, 70, 70);
	}
	public void updateImg(Icon img){
		labels[1].setIcon(img);
		repaint();
	}
	
}
