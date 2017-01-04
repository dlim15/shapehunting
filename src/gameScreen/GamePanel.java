/* FileName: GamePanel.java
 * Description: GamePanel is the class that extends JPanel. It is the panel where game will be
 * played and game over panel will be displayed.
 */
package gameScreen;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JPanel;

import gameMaterial.GameImg;

public class GamePanel extends JPanel{
	private GameImg img;
	public GamePanel(LayoutManager l, GameImg img) {
		super(l);
		init(img);
	}
	private void init(GameImg img){
		setPreferredSize(new Dimension(1300, 700));
		setBackground(Color.WHITE);
		this.img = img;
		
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(img.getPoint().getImage().getScaledInstance(10, 10, Image.SCALE_DEFAULT), new Point(12, 12), "point"));

	}
}
