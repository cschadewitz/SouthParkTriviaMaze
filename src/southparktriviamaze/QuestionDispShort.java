//Olin L. Anderson
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

public class QuestionDispShort extends JDialog {
	/**
	 * 
	 */
	private JTextField answerTextField;
	private static final long serialVersionUID = 1L;
	private String finalAnswer = "Wrong Answer";
	private JTextField questionTextField;
	

	/**
	 * Create the dialog.
	 */
	public QuestionDispShort(String question) {
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
//		answerTextField.addFocusListener(new FocusAdapter() {
//			@Override
//			public void focusGained(FocusEvent arg0) {
//				answerTextField.requestFocus();
//			}
//		});
		answerTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
				{
					finalAnswer = answerTextField.getText();
					setVisible(false);
				}
			}
		});
		answerTextField.setColumns(10);
		int x = Math.max(0, (Toolkit.getDefaultToolkit().getScreenSize().width  - this.getSize().width));
		int y =(int) Math.max(0, (Toolkit.getDefaultToolkit().getScreenSize().height  - this.getSize().height)/1.5);
		setLocation(x, y);
		
		answerTextField.requestFocus();
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSubmit.setBackground(Color.GRAY);
		btnSubmit.setForeground(Color.YELLOW);
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
		
	}
	public String getAns()
	{
		return finalAnswer;
	}
}
