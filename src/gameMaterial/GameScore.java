package gameMaterial;

import java.awt.Color;
public class GameScore extends GameFactsBase{
	private int score;
	public GameScore(String title, TimerSet set){
		super(title, set);
		score = 0;
		labels[1].setText(score+"");
		setBounds(10, 80, 200, 60);
		labels[0].setBounds(0, 0, 100, 60);
		labels[1].setBounds(100, 0, 110, 60);
		
	}
	public int getStat(){
		return score;
	}
	public void actionByUser(){
		score+=10;
		update(score+"", Color.GREEN);
	}
}
