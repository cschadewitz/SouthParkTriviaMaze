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
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuestionDisplayMult extends JFrame {

	private JPanel contentPane;
	private JTextField textQuestionField;
	private JLabel lblAnsA;
	private JLabel lblAnsB;
	private JLabel lblAnsC;
	private JLabel lblAnsD;
	private static String answer;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					QuestionDisplayMult frame = new QuestionDisplayMult();
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
	public QuestionDisplayMult(String question, String answer1, String answer2, String answer3, String answer4) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setResizable(false);
		this.setUndecorated(true);
		
		this.setFocusable(true);
		this.setFocusableWindowState(true);
		
		
		textQuestionField = new JTextField();
		textQuestionField.setColumns(10);
		
		textQuestionField.setText(question);
		
		JButton btnChoiceA = new JButton("A");
		btnChoiceA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer = lblAnsA.getText();
			}
		});
		
		JButton btnChoiceB = new JButton("B");
		btnChoiceB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer = lblAnsB.getText();
			}
		});
		
		JButton btnChoiceC = new JButton("C");
		btnChoiceC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer = lblAnsC.getText();
			}
		});
		
		JButton btnChoiceD = new JButton("D");
		btnChoiceD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer = lblAnsD.getText();
			}
		});
		
		lblAnsA = new JLabel(answer1);
		
		lblAnsB = new JLabel(answer2);
		
		lblAnsC = new JLabel(answer3);
		
		lblAnsD = new JLabel(answer4);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textQuestionField, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnChoiceA)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAnsA))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnChoiceB)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAnsB))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnChoiceC)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAnsC))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnChoiceD)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAnsD)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(textQuestionField, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnChoiceA)
						.addComponent(lblAnsA))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnChoiceB)
						.addComponent(lblAnsB))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnChoiceC)
						.addComponent(lblAnsC))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnChoiceD)
						.addComponent(lblAnsD))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public static String getans(){
	while(answer == null);
	
	return answer;
	}
	
	public static void ansReset()
	{
		answer = null;
	}
	}

