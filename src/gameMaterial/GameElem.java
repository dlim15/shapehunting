/* FileName: GameElem.java
 * Description: GameElem class is the element of the game which is the shape. Depends on the 
 * corresponding i,j, the shape and color gets different.
 */
package gameMaterial;
import javax.swing.Icon;
import javax.swing.JLabel;

public class GameElem extends JLabel{
	private boolean killed;
	private int color;
	private int shape;
	public GameElem(Icon img, int level, int i, int j){
		super(img);
		init(level, i, j);
	}
	private void init(int level, int i, int j){
		setVals(i, j);
		killed = false;
		setHorizontalTextPosition(JLabel.CENTER);
		setVerticalTextPosition(JLabel.CENTER);
	}
	public void setVals(int color, int shape){
		this.color = color;
		this.shape = shape;
	}
	public int getColor(){
		return color;
	}
	public int getShape(){
		return shape;
	}
	public boolean isAns(int c, int s){
		return color == c && shape == s;
	}
	public boolean getDamage(int i, int j){
		return killed = (color == i && shape == j);
	}
	public boolean isKilled(){
		return killed;
	}
	
}
