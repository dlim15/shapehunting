/* FileName: AttackShape.java
 * Description: AttackShape is the class that implements the mouselistener that will be
 * used to game playing. 
 * It will check if clicked object is SpawnShape, then it will either remove the shape
 * or deducts the penalty depends on user's choice's correctness.
 */
package gameStradegy;
import gameMaterial.GameElem;
import gameMaterial.GameImg;
import gameMaterial.GameLife;
import gameMaterial.GamePenalty;
import gameMaterial.GameScore;
import gameMaterial.TimerSet;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AttackShape implements MouseListener, MouseMotionListener{

	private JPanel panel;
	private KeyTracker tracker;
	private GameScore score;
	private GamePenalty penalty;
	private GameLife life;
	private GameImg img;
	private JLabel mouseImg;
	private TimerSet timer;
	private Runnable runnable;
	private Thread gunAnim;
	public AttackShape(JPanel panel, GameScore score, GamePenalty penalty, GameLife life, GameImg img, TimerSet timer){
		init(panel, score, penalty, life, img, timer);
	}
	private void init(JPanel panel, GameScore score, GamePenalty penalty, GameLife life, GameImg img, TimerSet timer){
		this.panel = panel;
		this.score = score;
		this.penalty = penalty;
		this.life = life;
		this.img = img;
		mouseImg = new JLabel(img.getGunMotion(0));
		mouseImg.setSize(100, 100);
		this.timer = timer;
		panel.add(mouseImg);
		panel.repaint();
		tracker = KeyTracker.getInstance();
		initRunnable();
	}
	private void attackElem(MouseEvent e){
		GameElem selected = (GameElem)e.getSource();
		if(selected.getDamage(tracker.getCurColPos(),tracker.getCurShapePos()))
			removeElem(selected);
		else{
			penalty.actionByUser();
			if(penalty.specialEffect()){
				life.actionByUser();
				penalty.reset();
			}
		}

	}
	private void removeElem(GameElem selected){
		shotAnimation();
		selected.removeMouseListener(this);
		panel.remove(selected);
		selected = null;
		panel.repaint();
		score.actionByUser();
	}
	private void mouseMoving(Object on, int x, int y){
		if(on instanceof GameElem)
			mouseImg.setLocation(((GameElem) on).getX()+x, ((GameElem) on).getY()+y);
		else 
			mouseImg.setLocation(x, y);
		
		panel.repaint();
	}
	private void initRunnable(){
		runnable = new Runnable() {
			@Override
			public void run() {
				for(int i=1; i<21; i++){
					mouseImg.setIcon(img.getGunMotion(i));
					panel.repaint();
					timer.setPause(3);
				}
				for(int i=19; i>=0; i--){
					mouseImg.setIcon(img.getGunMotion(i));
					panel.repaint();
					timer.setPause(3);
				}
			}
		};
		gunAnim = new Thread(runnable);
	}
	private void shotAnimation(){
		new Thread(runnable).start();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
//		if(e.getSource() instanceof GamePanel){
//			mouseImg.setVisible(true);
//			panel.repaint();
//		}
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
//		if(e.getSource() instanceof GamePanel){
//			mouseImg.setVisible(false);
//			panel.repaint();
//		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		attackElem(e);
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		mouseMoving(e.getSource(), e.getX()+4, e.getY()+4);
	}
	
}
