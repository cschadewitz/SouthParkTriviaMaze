//Olin L. Anderson
package southparktriviamaze;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuestionDispTF extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField questionTextField;
	private String finalAnswer = "Not Good";

	/**
	 * Create the dialog.
	 */
	public QuestionDispTF(String question) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			questionTextField = new JTextField();
			questionTextField.setColumns(10);
			questionTextField.setEditable(false);
			questionTextField.setText(question);
		}
		
		
		JButton btnTrue = new JButton("True");
		btnTrue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalAnswer = "true";
				setVisible(false);
			}
		});
		JButton btnFalse = new JButton("False");
		btnFalse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalAnswer = "false";
				setVisible(false);
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(questionTextField, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(btnFalse, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnTrue, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(5)
					.addComponent(questionTextField, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnTrue)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnFalse)
					.addContainerGap(122, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
	
	private void setEditable(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public String getAns()
	{
		return finalAnswer;
	}

}
