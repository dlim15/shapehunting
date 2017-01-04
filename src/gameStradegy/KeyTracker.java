/* FileName: KeyTracker.java
 * Description: KeyTracker is the class to track of current selected key from the keyboard
 * to compare with the clicked shape.
 */
package gameStradegy;

public class KeyTracker {
	private static KeyTracker tracker;
	private int curPoses[];
	private KeyTracker(){
		curPoses = new int[2];
		init();
	}
	private void init(){
		curPoses[0] = 0;
		curPoses[1] = 0;
	}
	public static KeyTracker getInstance(){
		if(tracker == null)
			tracker = new KeyTracker();
		return tracker;
	}
	public void setCurColPos(int i){
		curPoses[0] = i;
	}
	public void setCurShapePos(int i){
		curPoses[1] = i;
	}
	public int getCurColPos(){
		return curPoses[0];
	}
	public int getCurShapePos(){
		return curPoses[1];
	}
}
