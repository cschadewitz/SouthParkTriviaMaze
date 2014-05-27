package southparktriviamaze;

//import java.awt.BorderLayout;
//import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuestionDisplayTF extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnTrue;
	private JButton btnFalse;
	private static String answer = null;


	/**
	 * Create the frame.
	 */
	public QuestionDisplayTF(String question) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 150);
		contentPane = new JPanel();
		//contentPane.setResizable(false);
		//contentPane.setUndecorated(true);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//setResizeable(false);
		//contentPane.setResizable(false);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setEditable(false);
		textField.setText(question);
		
		btnTrue = new JButton("True");
		btnTrue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer = "TRUE";
			}
		});
		
		btnFalse = new JButton("False");
		btnFalse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer = "FALSE";
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnTrue, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(btnFalse, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addComponent(textField, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTrue)
						.addComponent(btnFalse))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public static String getAns()
	{
		while(answer == null);
		//System.out.println("HELLO THERE");
		return answer;
	}

	public static void ansReset()
	{
		answer = null;
	}
	}


