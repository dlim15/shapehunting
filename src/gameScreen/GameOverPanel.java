/* FileName: GameOverPanel.java
 * Description: GameOverPanel is the class that will is extended from GameShowingPanel.
 * It has all the input fields require users to fill in. 
 * Once they click submit, it will export filled in records to text file.
 */
package gameScreen;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import gameStradegy.RecordFile;

public class GameOverPanel extends GameShowingPanel{
	private int score;
	private int level;
	private ArrayList<JLabel> labels;
	private JTextField fields[];
	private JRadioButton[] gender;
	private ButtonGroup genderGroup;
	private JCheckBox isFun;
	private MouseListener forBtn;
	private KeyAdapter forName;
	private KeyAdapter forAge;
	private JButton submit;
	private Font font;
	public GameOverPanel(LayoutManager m){
		super(m);
		init();
	}
	private void init(){
		font = new Font("Serif",Font.BOLD,20);
		initListeners();
		initLabels();
		initFields();
		initRadio();
		initCheck();
		initButton();
	}
	public void setLevelAndScore(int level, int score){
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		this.level = level;
		this.score = score;
	}
	private void initButton(){
		submit = new JButton();
		submit.setBounds(450, 400, 200, 100);
		submit.setFont(new Font("Serif",Font.BOLD,40));
		submit.setText("Submit");
		submit.addMouseListener(forBtn);
		add(submit);
	}
	private void initLabels(){
		labels = new ArrayList<JLabel>();
		JLabel gameOver = new JLabel("Game Over");
		gameOver.setBounds(500, 10, 200, 70);
		labels.add(gameOver);
		JLabel name = new JLabel("Name:");
		name.setBounds(100, 100, 100, 100);
		labels.add(name);
		JLabel nameWarn = new JLabel("");
		nameWarn.setBounds(400, 100, 150, 100);
		nameWarn.setForeground(Color.RED);
		labels.add(nameWarn);
		JLabel gender = new JLabel("Gender:");
		gender.setBounds(800, 100, 100, 100);
		labels.add(gender);
		JLabel age = new JLabel("Age:");
		age.setBounds(100, 300, 100, 100);
		labels.add(age);
		JLabel ageWarn = new JLabel("");
		ageWarn.setBounds(300, 300, 200, 100);
		ageWarn.setForeground(Color.RED);
		labels.add(ageWarn);
		JLabel fun = new JLabel("Had fun?:");
		fun.setBounds(800, 300, 100, 100);
		labels.add(fun);
		for(int i=0; i<labels.size(); i++){
			labels.get(i).setFont(font);
			add(labels.get(i));
		}
		labels.get(0).setFont(new Font("Serif",Font.BOLD,40));
	}
	private void initFields(){
		fields = new JTextField[2];
		JTextField name = new JTextField();
		name.setBounds(200, 135, 200, 40);
		name.addKeyListener(forName);
		fields[0] =name;
		JTextField age = new JTextField();
		age.setBounds(200, 335, 100, 40);
		age.addKeyListener(forAge);
		fields[1] =age;
		for(int i=0; i<2; i++){
			fields[i].setFont(font);
			add(fields[i]);
		}
	}
	private void initRadio(){
		gender = new JRadioButton[2];
		genderGroup = new ButtonGroup();
		
		gender[0] = new JRadioButton("Male");
		gender[0].setSelected(true);
		gender[0].setBounds(900, 135, 70, 40);
		gender[1] = new JRadioButton("Female");
		gender[1].setBounds(970, 135, 100, 40);
		for(int i=0; i<2; i++){
			gender[i].setFont(font);
			genderGroup.add(gender[i]);
			add(gender[i]);
		}
	}
	private void initCheck(){
		isFun = new JCheckBox("");
		isFun.setBounds(900, 335, 100, 40);
		add(isFun);
		
	}
	private void initListeners(){
		initKeyforName();
		initKeyforAge();
		initMouseForBtn();
	}
	private void initMouseForBtn(){
		forBtn = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
					if(fields[0].getText().equals("")){
						labels.get(2).setText("Cannot be empty");
						return;
					}
					if(fields[1].getText().equals("")){
						labels.get(5).setText("Cannot be empty");
						return;
					}
					showRecord();
					popMessageAndEnd();
			}
		};
	}
	private void showRecord(){
		new RecordFile(score, level, fields[0].getText(), Integer.parseInt(fields[1].getText())
				, getGender(), getIsFun());
	}
	private void popMessageAndEnd(){
		int selected = JOptionPane.showOptionDialog(null, "Thanks for playing, "+ fields[0].getText() +"."
				+ "\nYour record has been recorded to record.txt file."
				+ "\nPlease try again later!", "Thanks for playing", JOptionPane.OK_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, null, null);
		if (selected == JOptionPane.OK_OPTION || selected == JOptionPane.CLOSED_OPTION|| selected == JOptionPane.NO_OPTION)
			System.exit(0);
	}
	private String getGender(){
		return gender[0].isSelected() ? gender[0].getText() : gender[1].getText();
	}
	private String getIsFun(){
		return isFun.isSelected() ? "Yes" : "No";
	}
	private void initKeyforName(){
		forName = new KeyAdapter() {
			public void keyTyped(KeyEvent e){
				char getChar = e.getKeyChar();
				if((getChar < 'A' || (getChar > 'Z' && getChar <'a') || getChar > 'z') && getChar != '\b'){
					e.consume();
					labels.get(2).setText("Letter Only");
				}else if(fields[0].getText().length() >= 20){
					e.consume();
					labels.get(2).setText("Too Long!");
				}else {
					labels.get(2).setText("");
				}
				
			}
		};
	}
	private void initKeyforAge(){
		forAge = new KeyAdapter() {
			public void keyTyped(KeyEvent e){
				char getChar = e.getKeyChar();
				if((getChar < '0' || getChar > '9') && getChar != '\b'){
					e.consume();
					labels.get(5).setText("Numbers Only");
				}else if(fields[1].getText().length() >= 3){
					e.consume();
					labels.get(5).setText("Too old!");
				}else {
					labels.get(5).setText("");
				}
				
			}
		};
	}
}
