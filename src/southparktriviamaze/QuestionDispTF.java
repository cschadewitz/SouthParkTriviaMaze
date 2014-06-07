//Olin L. Anderson
package southparktriviamaze;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

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
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;

import javax.swing.border.LineBorder;
import javax.swing.ButtonGroup;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class QuestionDispTF extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField questionTextField;
	private String finalAnswer = "Not Good";
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnTrue = null;
	private JButton btnFalse = null;

	/**
	 * Create the dialog.
	 */
	public QuestionDispTF(String question) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		
		contentPanel.setBackground(Color.GRAY);
		
		contentPanel.setBorder(new LineBorder(Color.YELLOW));
		contentPanel.setLocation(800, 300);
		setUndecorated(true);
		
		
		
		
//		btnTrue.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent arg0) {
//				if(arg0.getKeyCode() == KeyEvent.VK_UP)
//				{
//					finalAnswer = "True";
//					btnTrue.setBorderPainted(true);
//					btnFalse.setBorderPainted(false);
//				}
//				if(arg0.getKeyCode() == KeyEvent.VK_DOWN)
//				{
//					
//					finalAnswer = "false)";
//					btnTrue.setBorderPainted(false);
//					btnFalse.setBorderPainted(true);
//				}
//				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
//				{
//					contentPanel.requestFocus(false);
//					contentPanel.setVisible(false);
//					//contentPanel.setFocusable(false);
//				}
//			}
//		});
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			questionTextField = new JTextField();
			questionTextField.setForeground(Color.YELLOW);
			questionTextField.setBackground(Color.GRAY);
			questionTextField.setColumns(10);
			questionTextField.setEditable(false);

			
			questionTextField.setText(question);

			
			
		}
		int x = Math.max(0, (Toolkit.getDefaultToolkit().getScreenSize().width  - this.getSize().width));
		int y =(int) Math.max(0, (Toolkit.getDefaultToolkit().getScreenSize().height  - this.getSize().height)/1.5);
		setLocation(x, y);
				
		/*final JButton */btnTrue = new JButton("True");
btnTrue.addKeyListener(new KeyAdapter() {
	@Override
	public void keyPressed(KeyEvent e) {
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
		//btnTrue.setBorderPainted(false);

		
//		btnTrue.addFocusListener(new FocusAdapter() {
//			@Override
//			public void focusGained(FocusEvent e) {
//				btnTrue.setBorderPainted(true);
//				
//				
//				
//			}
//			@Override
//			public void focusLost(FocusEvent e) {
//				btnTrue.setBorderPainted(false);
//			}
//			
//		});
		//btnTrue.requestFocusInWindow();
//		btnTrue.addFocusListener(new FocusAdapter() {
//			@Override
//			public void focusGained(FocusEvent arg0) {
//				contentPanel.addKeyListener(new KeyAdapter() {
//					@Override
//					public void keyPressed(KeyEvent e) {
//						if(e.getKeyCode() == (KeyEvent.VK_ENTER))
//						{
//							System.out.println("HELLO THERER");
//							finalAnswer = "True";
//							setVisible(false);
//						}
//					}
//				});
//				
//			}
//		});
		buttonGroup.add(btnTrue);
		btnTrue.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTrue.setForeground(Color.YELLOW);
		btnTrue.setBackground(Color.GRAY);
//		btnTrue.requestFocus();
		btnTrue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalAnswer = "True";
				setVisible(false);
			}
		});
		
		/*final JButton */btnFalse = new JButton("False");
btnFalse.addKeyListener(new KeyAdapter() {
	@Override
	public void keyPressed(KeyEvent e) {
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
//		btnFalse.addFocusListener(new FocusAdapter() {
//			@Override
//			public void focusGained(FocusEvent e) {
//				btnFalse.setBorderPainted(true);
//			}
//			@Override
//			public void focusLost(FocusEvent e) {
//				btnFalse.setBorderPainted(false);
//			}
//		});
		buttonGroup.add(btnFalse);
		btnFalse.setForeground(Color.YELLOW);
		btnFalse.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFalse.setBackground(Color.GRAY);
		btnFalse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		//btnTrue.requestFocusInWindow();
		pack();
//		contentPanel.getRootPane().setDefaultButton(btnTrue);
		btnTrue.requestFocus();
		//btnTrue.requestFocusInWindow();

		//contentPanel.requestFocusInWindow();

	}
	

	public String getAns()
	{
		return finalAnswer;
	}

}
