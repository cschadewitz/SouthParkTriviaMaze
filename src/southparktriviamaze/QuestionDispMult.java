/*QuestionDisplayMult
 * Author: Olin L. Anderson
 * Revision: 1
 * Rev. Author:
 * Description: Displays a dialog box showing a question and 4 answers with associated buttons. when a button is pressed 
 * the String finalAnswer is set the the appropriate answer and the diablogs visibility is set to false.
 * 
 * A second method get answer can be called which will return the value of the finalAnswer String.
 */
package southparktriviamaze;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class QuestionDispMult extends JDialog {

	private String finalAnswer = "Not Good";
	private JTextPane questionTextField;
	//btnAnsA is the button for answer A 
	private JButton btnAnsA;
	private JButton btnAnsB;
	private JButton btnAnsC;
	private JButton btnAnsD;
	//lblAnsA is the label for button A
	private JLabel lblAnsA;
	private JLabel lblAnsB;
	private JLabel lblAnsC;
	private JLabel lblAnsD;


/*
 * Initializes a new QuestionDisplayMult diolog with question and answers set based on the parameters
 * Parameters:
 * String question is the String for the question to be displayed
 * String ans1 is the String for the Answer a to be displayed
 * String ans2 is the String for the Answer B to be displayed
 * String ans3 is the String for the Answer C to be displayed
 * String ans4 is the String for the Answer D to be displayed
 *
 *Note: the Code for generateing the dialog Box was originally produced by WindowBuilder in eclipse and was modifed by Olin L. Anderson 
 */
	public QuestionDispMult(String question, String ans1, String ans2, String ans3, String ans4) {
		getContentPane().setBackground(Color.GRAY);
		getContentPane().setForeground(Color.YELLOW);
		setBounds(100, 100, 450, 300);
		
		questionTextField = new JTextPane();
		questionTextField.setBackground(Color.GRAY);
		questionTextField.setForeground(Color.YELLOW);

		System.out.println(question.length());
		questionTextField.setText(question);
		questionTextField.setEditable(false);
		
		setUndecorated(true);
		int x = Math.max(0, (Toolkit.getDefaultToolkit().getScreenSize().width  - this.getSize().width));
		int y =(int) Math.max(0, (Toolkit.getDefaultToolkit().getScreenSize().height  - this.getSize().height)/1.5);
		
		setLocation(x, y);
		String[] answers = {ans1, ans2, ans3, ans4};
		String[] mixedAnswers = mix(answers);
		
		double num = Math.random();
		System.out.println(num);
		
		
		lblAnsA = new JLabel(mixedAnswers[0]);
		lblAnsA.setForeground(Color.YELLOW);
		lblAnsB = new JLabel(mixedAnswers[1]);
		lblAnsB.setForeground(Color.YELLOW);
		lblAnsC = new JLabel(mixedAnswers[2]);
		lblAnsC.setForeground(Color.YELLOW);
		lblAnsD = new JLabel(mixedAnswers[3]);
		lblAnsD.setForeground(Color.YELLOW);
		btnAnsA = new JButton("A");
		btnAnsA.setBackground(Color.GRAY);
		btnAnsA.setForeground(Color.YELLOW);
		/*sets the finalAnswer to the corresponding String and sets visibility to false
		 * Parameters:
		 * ActionListener ActionPerformed e activated when the button is pressed
		 * returns:
		 * void
		 */
		btnAnsA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finalAnswer = lblAnsA.getText();
				setVisible(false);
			}
		});
		
		btnAnsB = new JButton("B");
		btnAnsB.setBackground(Color.GRAY);
		btnAnsB.setForeground(Color.YELLOW);
		/*sets the finalAnswer to the corresponding String and sets visibility to false
		 * Parameters:
		 * ActionListener ActionPerformed e activated when the button is pressed
		 * returns:
		 * void
		 */
		btnAnsB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalAnswer = lblAnsB.getText();
				setVisible(false);
			}
		});
		
		btnAnsC = new JButton("C");
		btnAnsC.setBackground(Color.GRAY);
		btnAnsC.setForeground(Color.YELLOW);
		/*sets the finalAnswer to the corresponding String and sets visibility to false
		 * Parameters:
		 * ActionListener ActionPerformed e activated when the button is pressed
		 * returns:
		 * void
		 */
		btnAnsC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalAnswer = lblAnsC.getText();
				setVisible(false);
			}
		});
		
		btnAnsD = new JButton("D");
		btnAnsD.setBackground(Color.GRAY);
		btnAnsD.setForeground(Color.YELLOW);
		/*sets the finalAnswer to the corresponding String and sets visibility to false
		 * Parameters:
		 * ActionListener ActionPerformed e activated when the button is pressed
		 * returns:
		 * void
		 */
		btnAnsD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalAnswer = lblAnsD.getText();
				setVisible(false);
			}
		});
		
		
//===================================================================
		/*when the btnAnsA has focus it sets the finalAnswer to the corresponding String and set visibility to false
		 * Parameters:
		 * KeyEvent e an integer representing the key pressed
		 * returns 
		 * Void
		 * 
		 */
		btnAnsA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_DOWN)
				{
					btnAnsB.requestFocus();
					btnAnsB.setBorderPainted(true);
					btnAnsA.setBorderPainted(false);
				}
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					finalAnswer = lblAnsA.getText();
					setVisible(false);
				}
			}
		});
		/*when the btnAnsB has focus it sets the finalAnswer to the corresponding String and set visibility to false
		 * Parameters:
		 * KeyEvent e an integer representing the key pressed
		 * returns 
		 * Void
		 * 
		 */
		btnAnsB.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_DOWN)
				{
					btnAnsC.requestFocus();
					btnAnsC.setBorderPainted(true);
					btnAnsB.setBorderPainted(false);
				}
				if(e.getKeyCode() == KeyEvent.VK_UP)
				{
					btnAnsA.requestFocus();
					btnAnsA.setBorderPainted(true);
					btnAnsB.setBorderPainted(false);
				}
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					finalAnswer = lblAnsB.getText();
					setVisible(false);
				}
			}
		});
		/*when the btnAnsC has focus it sets the finalAnswer to the corresponding String and set visibility to false
		 * Parameters:
		 * KeyEvent e an integer representing the key pressed
		 * returns 
		 * Void
		 * 
		 */
		btnAnsC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_DOWN)
				{
					btnAnsD.requestFocus();
					btnAnsD.setBorderPainted(true);
					btnAnsC.setBorderPainted(false);
				}
				if(e.getKeyCode() == KeyEvent.VK_UP)
				{
					btnAnsB.requestFocus();
					btnAnsB.setBorderPainted(true);
					btnAnsC.setBorderPainted(false);
				}
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					finalAnswer = lblAnsC.getText();
					setVisible(false);
				}
			}
		});
		/*when the btnAnsD has focus it sets the finalAnswer to the corresponding String and set visibility to false
		 * Parameters:
		 * KeyEvent e an integer representing the key pressed
		 * returns 
		 * Void
		 * 
		 */
		btnAnsD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_UP)
				{
					btnAnsC.requestFocus();
					btnAnsC.setBorderPainted(true);
					btnAnsD.setBorderPainted(false);
				}
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					finalAnswer = lblAnsD.getText();
					setVisible(false);
				}
			}
		});
//====================================================================
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(questionTextField, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAnsD)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAnsD))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAnsC)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAnsC))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAnsB)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAnsB))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAnsA)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAnsA)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(questionTextField, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAnsA)
						.addComponent(lblAnsA))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAnsB)
						.addComponent(lblAnsB))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAnsC)
						.addComponent(lblAnsC))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAnsD)
						.addComponent(lblAnsD))
					.addContainerGap(121, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		pack();
		btnAnsA.requestFocusInWindow();
		
		btnAnsB.setBorderPainted(false);
		btnAnsC.setBorderPainted(false);
		btnAnsD.setBorderPainted(false);
		
	}
	/*returns the String finalAnswer
	 * Parameters:
	 * none
	 * return String for the finalAnswer
	 * throws:
	 */
	public String getAns()
	{
		return finalAnswer;
	}

	/*mixes the String in the String array parameter and returns a mixed Sting array
	 * Parameters:
	 * String[] org is the original order of the incoming strings
	 * returns:
	 *String[] mixed a string array with the incoming strings orders mixed.
	 */
private String[] mix(String[] org)
{


Random generator = new Random(); 
int ran = generator.nextInt(4);
String[] mixed= new String[4];
int[] nums = new int[4];
nums[0] = generator.nextInt(4);
nums[1] = nums[0];
nums[2] = nums[0];
nums[3] = nums[0];
while(nums[0] == nums[1])
{
	nums[1] = generator.nextInt(4);
}
while(nums[0] == nums[2] || nums[1] == nums[2])
{
	nums[2] = generator.nextInt(4);
}
while(nums[0] == nums[3] || nums[1] == nums[3] || nums[2] == nums[3])
{
	nums[3] = generator.nextInt(4);
}

for(int i=0; i<mixed.length; i++)
{
	mixed[i] = org[nums[i]];
}

return mixed;
}
}
