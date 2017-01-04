/* FileName: SpawnShape.java
 * Description: SpawnShape is the class that extends the Thread. 
 * Each object will spawn random shape and color.
 * If user fails to get spawnedShape before it expires, it will attack the user and
 * user will lose a life.
 */
package gameStradegy;

import java.awt.Color;
import javax.swing.JPanel;
import gameMaterial.GameElem;
import gameMaterial.GameFactsBase;
import gameMaterial.GameImg;
import gameMaterial.TimerSet;

public class SpawnShape extends Thread{
	private GameElem elem;
	private JPanel panel;
	private GameImg imgs;
	private int explodeIn;
	private RandCalculator randCalculator;
	private int color;
	private int shape;
	private TimerSet timers;
	private GameFactsBase life;
	public void run(){
		spawn();
		setExplodeTimer();
	}
	public SpawnShape(JPanel panel, int level, GameImg img, TimerSet timer, GameFactsBase life){
		init(panel, level, img, timer, life);
	}
	private void init(JPanel panel, int level, GameImg img, TimerSet timer, GameFactsBase life){
		this.life = life;
		this.panel = panel;
		imgs = img;
		randCalculator = RandCalculator.getInstance();
		explodeIn = randCalculator.getExplosionTime(level);
		color = randCalculator.getColor();
		shape = randCalculator.getShape();
		elem = new GameElem(imgs.getImg(color, shape), level, color, shape);
		timers = timer;
	}
	public GameElem getElem(){
		return elem;
	}
	private void spawn(){
		elem.setBounds(randCalculator.getSpawnX(), randCalculator.getSpawnY(), 70, 70);
		setBrightTextForDarkBackGround();
		panel.add(elem);
		panel.repaint();
	}
	private void setBrightTextForDarkBackGround(){
		if(color > 6)
			elem.setForeground(Color.WHITE);
	}
	private void setExplodeTimer(){
		for(int i=explodeIn; i >= 0; i-- ){
			elem.setText(i+"");
			timers.setPause(1000);
			if(life.specialEffect() || elem.isKilled())
				break;
		}
		if(!life.specialEffect() && !elem.isKilled()){
			attack();
			panel.remove(elem);
			panel.repaint();
		}
		cleanUp();
		stop();
	}
	private void attack(){
		life.actionByUser();
	}
	private void cleanUp(){
		elem = null;
		panel = null;
		imgs = null;
		randCalculator = null;
		timers = null;
		life = null;
	}
}
