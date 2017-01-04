/* FileName: GameShowingPanel.java
 * Description: GameShowingPanel is the base class that extends JPanel. 
 * It sets default background color and size of the shape so that other class extends this
 * class to have same location and color.
 */
package gameScreen;

import java.awt.Color;
import java.awt.LayoutManager;
import javax.swing.JPanel;

public class GameShowingPanel extends JPanel{
	public GameShowingPanel(LayoutManager m){
		super(m);
		setBounds(60, 60, 1180, 580);
		setBackground(new Color(255,255,240));
	}
}
