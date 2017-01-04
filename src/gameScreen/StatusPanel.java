/* FileName: StatusPanel.java
 * Description: StatusPanel is the class that extends JPanel. It is the panel that shows
 * all the information that is used in the game. It tracks the score, level, selected image,
 * life left, penalty status. They will be dynamically changed upon the action of user and
 * game playing.
 */
package gameScreen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JLabel;
import javax.swing.JPanel;
import gameMaterial.GameFactsBase;
import gameMaterial.GameImg;
import gameMaterial.GameScore;
import gameMaterial.GameShapeTrack;
import gameStradegy.KeyTracker;

public class StatusPanel extends JPanel{
	private JLabel selectedImg;
	private GameImg img;
	private KeyTracker tracker;
	private GameShapeTrack shapeTrack;
	public StatusPanel(LayoutManager l,GameImg a) {
		super(l);
		init(a);
	}
	private void init(GameImg a){
		setBackground(new Color(255,248,220));
		setPreferredSize(new Dimension(1300, 150));
		img = a;
		tracker = KeyTracker.getInstance();
		addSelectedImg();
	}
	private void addSelectedImg(){
		shapeTrack = new GameShapeTrack("Selected Img:");
		shapeTrack.updateImg(img.getImg(0, 0));
		add(shapeTrack);
		repaint();
	}
	public void doShapeColUpdate(){
		shapeTrack.updateImg(img.getImg(tracker.getCurColPos(), tracker.getCurShapePos()));
	}
	public void setScore(GameScore score){
		add(score);
	}
	public void addStats(GameFactsBase list[]){
		for(int i=0; i<4; i++)
			add(list[i]);
		repaint();
	}
}
