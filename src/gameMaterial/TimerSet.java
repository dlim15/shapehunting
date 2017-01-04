/* FileName: TimerSet.java
 * Description: TimerSet is the class that has the sleep and schedule function implemented.
 * Since Sleep requires to surrounded with try catch which will increase the number of lines
 * every time using it, i put it in this class. 
 * Timer is just to show the color change of the JLabel after set seconds.
 */
package gameMaterial;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

public class TimerSet{

	public TimerSet(){
	}
	public void setPause(long millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setTimer(JLabel label, long millis){
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				label.setForeground(Color.BLACK);
			}
		}, millis);
	}
}
