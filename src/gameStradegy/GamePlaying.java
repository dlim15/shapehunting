/* FileName: GamePlaying.java
 * Description: GamePlaying is the class that handles
 * spawning the elements and taking the actions from the user.
 * Game will be played until user lose all his life.
 * Game will move to next level once user clears all shapes spawned from previous level.
 * Game will spawn shape with rate that is calculated by current level. 
 */
package gameStradegy;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import gameMaterial.GameFactsBase;
import gameMaterial.GameImg;
import gameMaterial.GameLevel;
import gameMaterial.GameLife;
import gameMaterial.GamePenalty;
import gameMaterial.GameScore;
import gameMaterial.GameSpawnedInfo;
import gameMaterial.InteractKeys;
import gameMaterial.TimerSet;
import gameScreen.GamePanel;
import gameScreen.StatusPanel;

public class GamePlaying implements KeyListener{
	private int level;
	private int spawnNum;
	private GamePanel gPanel;
	private StatusPanel sPanel;
	private GameImg img;
	private TimerSet timers;
	private InteractKeys keys;
	private KeyTracker tracker;
	private AttackShape attacking;
	private GameFactsBase facts[];
	private GameSpawnedInfo spawnedInfo;
	private RandCalculator randCalculator;
	private ArrayList<SpawnShape> spawnedList;
	public GamePlaying(StatusPanel statusPanel, GamePanel gamePanel, GameImg img, TimerSet timer){
		init(statusPanel, gamePanel, img, timer);
	}
	private void init(StatusPanel statusPanel, GamePanel gamePanel, GameImg img, TimerSet timer){
		timers = timer;
		randCalculator = RandCalculator.getInstance();
		sPanel = statusPanel;
		gPanel = gamePanel;
		this.img = img;
		tracker = KeyTracker.getInstance();
		facts = new GameFactsBase[4];
		facts[0] = new GameScore("Score:",timers);
		facts[1] = new GameLife("Life:",timers);
		facts[2] = new GamePenalty("Penelty:",timers);
		facts[3] = new GameLevel("Level:",timers);
		spawnedList = new ArrayList<SpawnShape>();
		spawnedInfo = new GameSpawnedInfo("Left:", timers);
		sPanel.add(spawnedInfo);
		level = 0;
		levelUp();
		keys = InteractKeys.getInstance();
		sPanel.addStats(facts);
		attacking = new AttackShape(gPanel, (GameScore)facts[0], (GamePenalty)facts[2] ,(GameLife)facts[1], img, timer);
		gPanel.addMouseMotionListener(attacking);
	}
	public void levelUp(){
		spawnedInfo.setSpawned(spawnNum = randCalculator.getSpawnNum(++level));
		facts[3].actionByUser();
		spawnedList.clear();
	}
	public int getLevel(){
		return level;
	}
	public int getScore(){
		return facts[0].getStat();
	}
	public void play(){
		
		for(int i=0; i<spawnNum; i++){
			SpawnShape spawned = new SpawnShape(gPanel, level,img, timers, facts[1]);
			spawned.getElem().addMouseListener(attacking);
			spawned.getElem().addMouseMotionListener(attacking);
			spawnedList.add(spawned);
			(spawned).start();
			spawnedInfo.actionByUser();
			timers.setPause(getSpawnRate());
			if(gameOver())
				break;
		}
	}
	public boolean spawnedAll(){
		for(int i=0; i<spawnedList.size(); i++){
			if(spawnedList.get(i).isAlive())
				return false;
		}
		return true;
	}
	
	public void gameEnd(){
		gPanel.removeAll();
		gPanel.repaint();
	}
	public boolean gameOver(){
		return facts[1].specialEffect();
	}
	private int getSpawnRate(){
		return level > 6 ? 1000 :3500 - (level-1) * 500;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char key = e.getKeyChar();
		if(key>47 && key<128){
			if(key >= '1' && key <= '3'){
				tracker.setCurShapePos(keys.getPos(key));
				sPanel.doShapeColUpdate();
			}else if(keys.getPos(key) != -1){
				tracker.setCurColPos(keys.getPos(key));
				sPanel.doShapeColUpdate();
			}
		}
	}
}
