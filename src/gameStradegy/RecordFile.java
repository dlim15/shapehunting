/* FileName: RecordFile.java
 * Description: RecordFile is the class to export records to the textfile.
 */
package gameStradegy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RecordFile {
	private String name;
	private int age;
	private String gender;
	private String hadFun;
	private int score;
	private int level;
	private final static String FILENAME="record.txt";
	public RecordFile(int score, int level, String name,int age, String gender, String hadFun){
		this.score = score;
		this.level = level;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.hadFun = hadFun;
		export();
	}
	private void export(){
		FileWriter fileWriter = null;
		try {
			File file = new File(FILENAME);
			fileWriter = new FileWriter(file,true);
			fileWriter.write("Score : " + score + ", Level : " + level + ", Name : " + name 
					+ ", Age : " + age + ", Gender: " + gender + ", Had fun : " + hadFun);
			fileWriter.write(System.getProperty( "line.separator" ));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
