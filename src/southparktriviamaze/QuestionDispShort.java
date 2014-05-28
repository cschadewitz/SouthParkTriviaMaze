//Olin L. Anderson
//
package southparktriviamaze;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class QuestionDispShort extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String finalAnswer = "NOT GOOD";
	private JTextField questionTextField;
	private JTextField answerTextField;

	/**
	 * Create the dialog.
	 */
	public QuestionDispShort(String question) {
		setBounds(100, 100, 450, 300);
		setUndecorated(true);
		questionTextField = new JTextField();
		questionTextField.setColumns(10);
		questionTextField.setText(question);
		questionTextField.setEditable(false);
		answerTextField = new JTextField();
		answerTextField.setText("Answer Here");
		answerTextField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalAnswer = answerTextField.getText();
				setVisible(false);
			}
		});
		

		

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(questionTextField, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnSubmit))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(answerTextField, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(questionTextField, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
					.addComponent(answerTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSubmit)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}
	public String getAns()
	{
		return finalAnswer;
	}

}
