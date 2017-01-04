/* Author : Devin Lim
 * FileName: GraphicWindow.java
 * Project : 5
 * Description: GraphicWindow is the class that extends the JFrame. This is where calling all
 * other classes and add it to it self. It will play until user dies or gives up middle of the
 * play. For detailed info about project, read Readme
 */
package gameScreen;
import java.awt.BorderLayout;
import gameStradegy.*;
import gameMaterial.*;
import java.util.ArrayList;
import javax.swing.*;

public class GraphicWindow extends JFrame {
	private ArrayList<JPanel> panels;
	private GameOverPanel gOver;
	private GameImg img;
	private TimerSet timers;
	private GamePlaying game;
	public GraphicWindow(){
		setSize(1570, 940);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();
		setVisible(true);
	}
	private void init(){
		img = new GameImg();
		timers = new TimerSet();
		panels = new ArrayList<JPanel>();
		panels.add(new StatusPanel(null,img));
		panels.add(new InfoPanel(null,img));
		panels.add(new GamePanel(null,img));
		gOver = new GameOverPanel(null);
		add(panels.get(0),BorderLayout.NORTH);
		add(panels.get(1), BorderLayout.WEST);
		add(panels.get(2),BorderLayout.CENTER);
		game = new GamePlaying((StatusPanel)panels.get(0), (GamePanel)panels.get(2), img, timers);
		addKeyListener(game);
	}
	public void play(){
		while(true){
			game.play();
			if(gameOver()){
				gameEnd();
				break;
			}
			while(true){
				if(spawnedAll()){
					break;
				}
			}
			if(!gameOver() && popMessageAskingContinue()){
				levelUp();
			}
			else{
				gameEnd();
				break;
			}
		}
		gOver.setLevelAndScore(game.getLevel(), game.getScore());
		showGameOverScreen();
	}
	private boolean popMessageAskingContinue(){
		int selected = JOptionPane.showOptionDialog(null, "You have clear current level!"
				+ "\nDo you want to continue to next level?"
				+ "\nYes to continue, No to end.", "Level up!", JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, null, null);
		return (selected == JOptionPane.YES_OPTION);
	}
	private boolean gameOver(){
		return game.gameOver();
	}
	private void gameEnd(){
		game.gameEnd();
	}
	private boolean spawnedAll(){
		return game.spawnedAll();
	}
	private void levelUp(){
		game.levelUp();
	}
	private void showGameOverScreen(){
		panels.get(2).add(gOver);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphicWindow g = new GraphicWindow();
		g.play();
		
		
		
		
	}
}
