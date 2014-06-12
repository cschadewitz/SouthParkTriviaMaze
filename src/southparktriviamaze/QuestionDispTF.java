/*Question DisplayTF
 //* Author: Olin L. Anderson
 //* Revision: 1
 //* Rev. Author:
 //* Description: displays a dialog box with a question and two buttons one true and one false. after a buton has been pressed the String finaAnswer
 //* is set to the buton which was pressed and the visibility of the dialog box is set to false. if the getAns method is called the finalAnswer string
// * is returned.
 */
package southparktriviamaze;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ButtonGroup;
public class QuestionDispTF extends JDialog
{
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextPane questionTextField;
	private String finalAnswer = "Not Good";
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnTrue = null;
	private JButton btnFalse = null;

/*
// * Initializes QuestonDispTF with the parameter String question
// * parameters:
// * String question the Question which will be displayed to the screen in the dialog box
// * returns:
// * none
// * throws:
 * 
 */
	public QuestionDispTF(String question) 
	{
		setBounds(100, 100, 400, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.GRAY);	
		contentPanel.setLocation(800, 300);
		setUndecorated(true);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			questionTextField = new JTextPane();
			questionTextField.setForeground(Color.YELLOW);
			questionTextField.setBackground(Color.GRAY);
			questionTextField.setEditable(false);
			questionTextField.setText(question);
		}
		int x = Math.max(0, (Toolkit.getDefaultToolkit().getScreenSize().width  - this.getSize().width));
		int y =(int) Math.max(0, (Toolkit.getDefaultToolkit().getScreenSize().height  - this.getSize().height)/1.5);
		setLocation(x, y);		
		btnTrue = new JButton("True");
		
//		/* changes the focus in the dialog box or sets the finalAnswer Sting to 
//		 * true of false and sets visibility of dialog to false
//		 * parameters:
//		 * KeyEvent e the integer code for which key was pressed
//		 * returns
//		 * none
//		 * throws:

btnTrue.addKeyListener(new KeyAdapter()
{
	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
		btnFalse.requestFocusInWindow();
		btnFalse.setBorderPainted(true);
		btnTrue.setBorderPainted(false);
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			finalAnswer = "True";
			setVisible(false);
			
		}
	}
});
		buttonGroup.add(btnTrue);
		btnTrue.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTrue.setForeground(Color.YELLOW);
		btnTrue.setBackground(Color.GRAY);
		/*
//		 * sets the visibility of the dialog to false when button is pressed and the finalAnswerString to false
//		 * parameters:
///		 * ActionEvent e when the button is pressed
//		 * returns 
//		 * void
		 * 
		 */
		btnTrue.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				finalAnswer = "True";
				setVisible(false);
			}
		});
		
		btnFalse = new JButton("False");
		
		/* changes the focus in the dialog box or sets the finalAnswer Sting to 
//		 * true of false and sets visibility of dialog to false
//		 * parameters:
//		 * KeyEvent e the integer code for which key was pressed
//		 * returns
//		 * none
//		 * throws:
		 * 
		 */
btnFalse.addKeyListener(new KeyAdapter() 
{
	@Override
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
		btnTrue.requestFocusInWindow();
		btnFalse.setBorderPainted(false);
		btnTrue.setBorderPainted(true);
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			
			finalAnswer = "false";
			setVisible(false);
		}
	}
});
		btnFalse.setBorderPainted(false);
		buttonGroup.add(btnFalse);
		btnFalse.setForeground(Color.YELLOW);
		btnFalse.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFalse.setBackground(Color.GRAY);
		/*
//		 * sets the visibility of the dialog to false when button is pressed and the finalAnswerString to false
//		 * parameters:
//		 * ActionEvent e when the button is pressed
//		 * returns 
//		 * void
		 * 
		 */
		btnFalse.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				finalAnswer = "False";
				setVisible(false);
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(questionTextField, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(btnFalse, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnTrue, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(5)
					.addComponent(questionTextField, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnTrue)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnFalse)
					.addContainerGap(158, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		pack();
		btnTrue.requestFocus();
	}
	
	/*
//	 * returns the finalAnswer String 
//	 * parameters:
//	 * none
//	 * returns:
//	 * String finalAnswer the users answer to the question
	 */
	public String getAns()
	{
		return finalAnswer;
	}

}
