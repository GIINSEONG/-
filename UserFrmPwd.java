package Main;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserFrmPwd {

	private static JFrame frame;
	private JPasswordField txt_currentpwd;
	private JPasswordField txt_changepwd;
	private JPasswordField txt_changepwd2;
	private JButton changebtn;
	private JButton canclebtn;
	
	private data data = new data();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public UserFrmPwd() {
		
		Gui_UserFrmPwd();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void Gui_UserFrmPwd() {
		
		frame = new JFrame();
		frame.setTitle("�н����� ����");
		frame.setBounds(100, 100, 270, 210);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
		panel.setLayout(null);
		
		
		/* ��ư ����  */
		
		changebtn = new JButton("����");
		canclebtn = new JButton("���");
		
		changebtn.setBounds(38, 138, 75, 23);
		canclebtn.setBounds(125, 138, 75, 23);
		
		panel.add(changebtn);
		panel.add(canclebtn);
		
		
		/* �� ����  */
		
		JLabel currentlabel = new JLabel("���� �н�����");
		JLabel titlelabel = new JLabel("�н����� ����");
		JLabel changelabel = new JLabel("���� �н�����");
		JLabel checklabel = new JLabel("�н����� Ȯ��");
		
		currentlabel.setFont(new Font("����", Font.PLAIN, 12));
		titlelabel.setFont(new Font("����", Font.BOLD, 15));
		changelabel.setFont(new Font("����", Font.PLAIN, 12));
		checklabel.setFont(new Font("����", Font.PLAIN, 12));
		
		currentlabel.setBounds(24, 54, 89, 15);
		titlelabel.setBounds(76, 26, 101, 15);
		changelabel.setBounds(24, 79, 94, 15);
		checklabel.setBounds(24, 104, 94, 15);
		
		panel.add(currentlabel);
		panel.add(titlelabel);
		panel.add(changelabel);
		panel.add(checklabel);
		
		titlelabel.setHorizontalAlignment(SwingConstants.CENTER);


		/* �ؽ�Ʈ ���� */
		
		txt_currentpwd = new JPasswordField();
		txt_changepwd = new JPasswordField();
		txt_changepwd2 = new JPasswordField();
		
		txt_currentpwd.setEchoChar('*');
		txt_changepwd.setEchoChar('*');
		txt_changepwd2.setEchoChar('*');
		
		txt_currentpwd.setBounds(113, 51, 116, 21);
		txt_changepwd.setBounds(113, 76, 116, 21);
		txt_changepwd2.setBounds(113, 101, 116, 21);
		
		txt_currentpwd.setColumns(10);
		txt_changepwd.setColumns(10);
		txt_changepwd2.setColumns(10);
		
		panel.add(txt_currentpwd);
		panel.add(txt_changepwd);
		panel.add(txt_changepwd2);
	
		
		/* ������ ���� */
		
		changebtn.addActionListener(new MyActionListener());
		canclebtn.addActionListener(new MyActionListener());
	}
	
	class MyActionListener extends JFrame implements ActionListener{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@SuppressWarnings({ "deprecation", "static-access" })
		public void actionPerformed(ActionEvent btn_Source) {
			
			if(btn_Source.getSource()==changebtn){
				
				int yesno = JOptionPane.showConfirmDialog(null, "��й�ȣ�� �����Ͻðڽ��ϱ�?", "����Ȯ��", JOptionPane.YES_NO_OPTION);
				if(yesno == 0) {
					if(txt_currentpwd.getText().equals(data.getPASSWORD())){
						if(txt_changepwd.getText().equals(txt_changepwd2.getText())){
							System.out.println("�����º�й�ȣ�� " + txt_changepwd.getText());
							data.setPASSWORD(txt_changepwd.getText());
							data.UpdateData(2);
							JOptionPane.showMessageDialog(null, "��й�ȣ�� ����Ǿ����ϴ�.", "����Ϸ�", -1);
							UserFrmPwd.frame.dispose();
							
						} else {	
							
							JOptionPane.showMessageDialog(null, "������ ��й�ȣ�� ��ġ���� �ʽ��ϴ�.", "��й�ȣ ����", 0);
					
						}
					} else {
						
						JOptionPane.showMessageDialog(null, "���� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.", "��й�ȣ ����", 0);
						
					}
				}
			}
			
			if(btn_Source.getSource()==canclebtn){
				UserFrmPwd.frame.dispose();
			}
		}
	}
}
