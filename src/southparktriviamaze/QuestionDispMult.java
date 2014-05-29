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
import java.util.Random;

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
	public QuestionDispMult(String question, String ans1, String ans2, String ans3, String ans4) {
		setBounds(100, 100, 450, 300);
		
		questionTextField = new JTextField();
		questionTextField.setColumns(10);
		questionTextField.setText(question);
		questionTextField.setEditable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		String[] answers = {ans1, ans2, ans3, ans4};
		String[] mixedAnswers = mix(answers);
		
		double num = Math.random();
		System.out.println(num);
		
		
		lblAnsA = new JLabel(mixedAnswers[0]);
		
		lblAnsB = new JLabel(mixedAnswers[1]);
		
		lblAnsC = new JLabel(mixedAnswers[2]);
		
		lblAnsD = new JLabel(mixedAnswers[3]);
		
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
