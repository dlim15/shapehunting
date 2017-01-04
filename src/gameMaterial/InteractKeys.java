/* FileName: InteractKeys.java
 * Description: InteractKeys is the class that determines the value depends on the key that has been
 * typed. Other keys typed will be ignored.
 * Keys that will be used are :
 * Shapes are :
 * 	1 : circle
 *  2 : triangle
 *  3 : rectangle
 * Colors Are :
 *  a : Ashed Gray
 *  b : Black
 *  g : Green
 *  n : Navy
 *  r : Red
 *  s : Sky blue
 *  t : Tangerine
 *  v : Violet
 *  y : Yellow
 */
package gameMaterial;

public class InteractKeys {
	private char keysForColor[];
	private char keysForShape[];
	private int matchedLocation[];
	private static InteractKeys keys;
	private InteractKeys() {
		init();
	}
	public static InteractKeys getInstance(){
		if(keys == null)
			keys = new InteractKeys();
		return keys;
	}
	private void init(){
		keysForColor = new char[9];
		keysForShape = new char[3];
		matchedLocation = new int[128];
		for(int i=0; i<128; i++)
			matchedLocation[i] = -1;
		initColorKeys();
		initShapeKeys();
	}
	private void initColorKeys(){
		matchedLocation[keysForColor[0] ='r'] = 0;
		matchedLocation[keysForColor[1] ='t'] = 1;
		matchedLocation[keysForColor[2] ='y'] = 2;
		matchedLocation[keysForColor[3] ='g'] = 3;
		matchedLocation[keysForColor[4] ='s'] = 4;
		matchedLocation[keysForColor[5] ='v'] = 5;
		matchedLocation[keysForColor[6] ='a'] = 6;
		matchedLocation[keysForColor[7] ='n'] = 7;
		matchedLocation[keysForColor[8] ='b'] = 8;
		
	}
	private void initShapeKeys(){
		matchedLocation[keysForShape[0] = '1'] = 0;
		matchedLocation[keysForShape[1] = '2'] = 1;
		matchedLocation[keysForShape[2] = '3'] = 2;
	}
	public char getColorKey(int pos){
		if(pos >= 0 && pos < 9)
			return keysForColor[pos];
		return 0;
	}
	public char getShapeKey(int pos){
		if(pos >= 0 && pos < 4)
			return keysForShape[pos];
		return 0;
	}
	public int getPos(char c){
		return matchedLocation[c];
	}
}
