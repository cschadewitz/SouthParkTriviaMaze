//Olin L. Anderson
package southparktriviamaze;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuestionDispMult extends JDialog {

	private String finalAnswer = "Not Good";
	private JTextField questionTextField;
	private JLabel lblAnsA;
	private JLabel lblAnsB;
	private JLabel lblAnsC;
	private JLabel lblAnsD;


	/**
	 * Create the dialog.
	 */
	public QuestionDispMult(String question, String answer1, String answer2, String answer3, String answer4) {
		setBounds(100, 100, 450, 300);
		
		questionTextField = new JTextField();
		questionTextField.setColumns(10);
		questionTextField.setText(question);
		questionTextField.setEditable(false);
		setUndecorated(true);
		
		lblAnsA = new JLabel(answer1);
		
		lblAnsB = new JLabel(answer2);
		
		lblAnsC = new JLabel(answer3);
		
		lblAnsD = new JLabel(answer4);
		
		JButton btnAnsA = new JButton("A");
		btnAnsA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finalAnswer = lblAnsA.getText();
				setVisible(false);
			}
		});
		
		JButton btnAnsB = new JButton("B");
		btnAnsB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalAnswer = lblAnsB.getText();
				setVisible(false);
			}
		});
		
		JButton btnAnsC = new JButton("C");
		btnAnsC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalAnswer = lblAnsC.getText();
				setVisible(false);
			}
		});
		
		JButton btnAnsD = new JButton("D");
		btnAnsD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalAnswer = lblAnsD.getText();
				setVisible(false);
			}
		});
		

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
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
							.addComponent(lblAnsA))
						.addComponent(questionTextField, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(questionTextField, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
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
					.addContainerGap(85, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	public String getAns()
	{
		return finalAnswer;
	}

}
