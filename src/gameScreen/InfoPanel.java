/* FileName: InfoPanel.java
 * Description: InfoPanel is the class that extends JPanel. It is the panel where has information
 * about which key is representing shape and color for player's convenience.
 */
package gameScreen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.JLabel;
import javax.swing.JPanel;
import gameMaterial.GameImg;
import gameMaterial.InteractKeys;

public class InfoPanel extends JPanel{
	private GameImg imgs;
	private InteractKeys keys;
	private Font font;
	public InfoPanel(LayoutManager l, GameImg a) {
		super(l);
		init(a);
	}
	private void init(GameImg a){
		setPreferredSize(new Dimension(250,550));
		font = new Font("Serif",Font.BOLD,30);
		setBackground(new Color(255,248,220));
		imgs = a;
		keys = InteractKeys.getInstance();
		postTitle();
		postInfos();
	}
	private void postInfos(){
		for(int i=0; i<9; i++){
			int yLoc = 100+i*72;
			postColorInfo(i, yLoc);
			for(int j=0; j<3; j++){
				int xLoc = 30 + 72 * j;
				if(i==0){
					postNumInfo(j, xLoc);
				}	
				postElems(i, j, xLoc, yLoc);
			}
		}
	}
	private void postTitle(){
		JLabel t = new JLabel("   KEY INFO");
		t.setBounds(0 , 0, 250, 60);
		t.setBackground(new Color(217, 247, 246));
		t.setOpaque(true);
		t.setForeground(new Color(79, 195, 152));
		t.setFont(new Font("serif", Font.BOLD, 40));
		add(t);
	}
	private void postColorInfo(int i, int yLoc){
		JLabel k = new JLabel(keys.getColorKey(i)+"");
		k.setBounds(10, yLoc, 20, 70);
		k.setFont(font);
		add(k);
	}
	private void postNumInfo(int j, int xLoc){
		JLabel n = new JLabel(keys.getShapeKey(j)+"");
		n.setBounds(xLoc+25 , 70, 20, 30);
		n.setFont(font);
		add(n);
	}
	private void postElems(int i, int j, int xLoc, int yLoc){
		JLabel label = new JLabel(imgs.getImg(i, j));
		label.setBounds(xLoc, yLoc, 70, 70);
		add(label);
	}
}
