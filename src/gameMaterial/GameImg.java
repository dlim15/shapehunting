/* FileName: GameImg.java
 * Description: GameImg class is the class to import the images and store them to use it later
 * with other class.
 */
package gameMaterial;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class GameImg {
	private final static String IMG_PATH = "img/";
	private ArrayList<ArrayList <Icon>> elem;
	private ArrayList<Icon> gunShot;
	private Icon point;
	public GameImg(){
		elem = new ArrayList<ArrayList<Icon>>();
		gunShot = new ArrayList<>();
		importImages();
	}
	private void importImages(){
		try{
			for(int i=0; i<9; i++){
				gunShot.add(new ImageIcon(ImageIO.read(new File(IMG_PATH+i+".png"))));
				for (int j=0; j<3; j++){
					elem.add(new ArrayList<Icon>());
					elem.get(i).add(new ImageIcon(ImageIO.read(new File(IMG_PATH+i+"_"+j+".png"))));
				}
					
			}
			for(int i=9; i<31; i++){
				gunShot.add(new ImageIcon(ImageIO.read(new File(IMG_PATH+i+".png"))));
			}
			point = new ImageIcon(ImageIO.read(new File(IMG_PATH+"point.png")));
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public Icon getImg(int i, int j){
		return elem.get(i).get(j);
	}
	public Icon getGunMotion(int i){
		return gunShot.get(i);
	}
	public ImageIcon getPoint(){
		return (ImageIcon)point;
	}
	
}
