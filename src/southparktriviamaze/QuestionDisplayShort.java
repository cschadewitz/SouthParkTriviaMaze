package southparktriviamaze;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.concurrent.CountDownLatch;

public class QuestionDisplayShort extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField answerField;
	private JTextField questionField;
	private JButton btnSubmit;
	private static String answer = null;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					QuestionDisplayShort frame = new QuestionDisplayShort();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public QuestionDisplayShort(String questionString, final CountDownLatch latch) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		
		answerField = new JTextField();
		answerField.setColumns(10);
		
		btnSubmit = new JButton("Submit Answer");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				answer = answerField.getText();
				latch.countDown();
			}
		});
		
		questionField = new JTextField();
		questionField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSubmit)
						.addComponent(answerField, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
						.addComponent(questionField, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		questionField.setText(questionString);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(questionField, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
					.addComponent(answerField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSubmit)
					.addGap(13))
		);
		contentPane.setLayout(gl_contentPane);
	}
	public String getans()
	{
//		while(answer == null);
		String temp = answer;
//		answer = null;
//		return temp;
//		btnSubmit.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				answer = answerField.getText();
//				//String temp = answer;
//				//answer = null;
//
//			}
//		});
		//while(answer == null);
		
		
		//temp = answer;
		answer = null;
		return temp;
	}
	
	}
