/*QuestiondisplayShort
 * Author: Olin L. Anderson
 * Revision: 1
 * Rev. Author:
 * Description: displays a dialog with a question and a field for writing the answer, once the answer has been submitted the visibility f the dialog is set to false
 * the getAns method is called and returns the String finalAnswer which was set when the submit button was pressed.
 */
//
package southparktriviamaze;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JButton;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.Color;
import java.awt.Font;

public class QuestionDispShort extends JDialog 
{
	private JTextField answerTextField;
	private static final long serialVersionUID = 1L;
	private String finalAnswer = "Wrong Answer";
	private JTextField questionTextField;
	

	/*Initializes the QuestionDisplayShort class with the String Question set as the displayed question
	 * parameters:
	 * String question is the question which will be displayed to the user
	 * 
	 */
	public QuestionDispShort(String question)
	{
		getContentPane().setForeground(Color.YELLOW);
		getContentPane().setBackground(Color.GRAY);

		setBounds(100, 100, 450, 300);
		setUndecorated(true);
		questionTextField = new JTextField();
		questionTextField.setForeground(Color.YELLOW);
		questionTextField.setBackground(Color.GRAY);
		questionTextField.setColumns(10);
		questionTextField.setText(question);
		questionTextField.setEditable(false);
		answerTextField = new JTextField();
		answerTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		answerTextField.setBackground(Color.GRAY);
		answerTextField.setForeground(Color.YELLOW);
/* 
 * sets the finalAnswer tring to the user input and sets the visibility of the dialog to false
 * parameters:
 * KeyEvent arg0 a KeyEvent integer representing which key was pressed
 * returns
 * void
 * throws 
 */
		answerTextField.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent arg0)
			{
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
				{
					finalAnswer = answerTextField.getText();
					setVisible(false);
				}
			}
		});
		answerTextField.setColumns(10);
		int x = Math.max(0, (Toolkit.getDefaultToolkit().getScreenSize().width  - this.getSize().width));
		int y = (int) Math.max(0, (Toolkit.getDefaultToolkit().getScreenSize().height  - this.getSize().height)/1.5);
		setLocation(x, y);
		
		answerTextField.requestFocus();
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSubmit.setBackground(Color.GRAY);
		btnSubmit.setForeground(Color.YELLOW);
		/*
		 * if the button is pressed the finalAnswer String is set to the userinPut and the visibility is set to fase
		 * parameters:
		 * ActionListener ActionEvent e the button being clicked
		 *	returns 
		 *	void
		 */
		btnSubmit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				finalAnswer = answerTextField.getText();
				setVisible(false);
			}
		});
		
		JLabel lblAnswerHere = new JLabel("Answer Here:");
		lblAnswerHere.setForeground(Color.YELLOW);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(questionTextField, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(btnSubmit)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAnswerHere))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(answerTextField, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(questionTextField, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
					.addComponent(lblAnswerHere)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(answerTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSubmit)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		pack();
		answerTextField.requestFocusInWindow();
		
		/*returns the finalAnswer string in the class
		 * Parameters:
		 * none
		 * Returns:
		 * String finalAnswer the users answer to the question displayed in the dialog box
		 * throws:
		 * 
		 */
	}
	public String getAns()
	{
		return finalAnswer;
	}
}
