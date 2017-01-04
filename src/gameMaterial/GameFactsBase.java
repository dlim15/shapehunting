/* FileName: GameFactsBase.java
 * Description: GameFactsBase is the abstract class that will be used to polymorphism.
 * It contains the Label that describes the next label and the actual label that contains the
 * values
 */
package gameMaterial;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameFactsBase extends JPanel{
	private TimerSet timers;
	protected JLabel labels[];
	private Font font;
	public GameFactsBase(String title,TimerSet set){
		init(title, set);
	}
	private void init(String title,TimerSet set){
		setLayout(null);
		setBackground(new Color(255,248,220));
		font = new Font("Serif",Font.BOLD,30);
		labels = new JLabel[2];
		labels[0] = new JLabel(title);
		labels[1] = new JLabel();
		timers = set;
		for(int i=0; i<2; i++){
			labels[i].setFont(font);
			add(labels[i]);
		}
	}
	public int getStat(){
		return 0;
	}
	public void actionByUser(){
		
	}
	protected void update(String s, Color color){
		labels[1].setText(s);
		labels[1].setForeground(color);
		timers.setTimer(labels[1], 500);
	}
	public boolean specialEffect(){
		return false;
	}
}
