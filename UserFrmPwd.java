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
		frame.setTitle("패스워드 변경");
		frame.setBounds(100, 100, 270, 210);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
		panel.setLayout(null);
		
		
		/* 버튼 영역  */
		
		changebtn = new JButton("변경");
		canclebtn = new JButton("취소");
		
		changebtn.setBounds(38, 138, 75, 23);
		canclebtn.setBounds(125, 138, 75, 23);
		
		panel.add(changebtn);
		panel.add(canclebtn);
		
		
		/* 라벨 영역  */
		
		JLabel currentlabel = new JLabel("현재 패스워드");
		JLabel titlelabel = new JLabel("패스워드 변경");
		JLabel changelabel = new JLabel("변경 패스워드");
		JLabel checklabel = new JLabel("패스워드 확인");
		
		currentlabel.setFont(new Font("굴림", Font.PLAIN, 12));
		titlelabel.setFont(new Font("굴림", Font.BOLD, 15));
		changelabel.setFont(new Font("굴림", Font.PLAIN, 12));
		checklabel.setFont(new Font("굴림", Font.PLAIN, 12));
		
		currentlabel.setBounds(24, 54, 89, 15);
		titlelabel.setBounds(76, 26, 101, 15);
		changelabel.setBounds(24, 79, 94, 15);
		checklabel.setBounds(24, 104, 94, 15);
		
		panel.add(currentlabel);
		panel.add(titlelabel);
		panel.add(changelabel);
		panel.add(checklabel);
		
		titlelabel.setHorizontalAlignment(SwingConstants.CENTER);


		/* 텍스트 영역 */
		
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
	
		
		/* 리스너 영역 */
		
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
				
				int yesno = JOptionPane.showConfirmDialog(null, "비밀번호를 변경하시겠슨니까?", "변경확인", JOptionPane.YES_NO_OPTION);
				if(yesno == 0) {
					if(txt_currentpwd.getText().equals(data.getPASSWORD())){
						if(txt_changepwd.getText().equals(txt_changepwd2.getText())){
							System.out.println("가져온비밀번호는 " + txt_changepwd.getText());
							data.setPASSWORD(txt_changepwd.getText());
							data.UpdateData(2);
							JOptionPane.showMessageDialog(null, "비밀번호가 변경되었습니다.", "변경완료", -1);
							UserFrmPwd.frame.dispose();
							
						} else {	
							
							JOptionPane.showMessageDialog(null, "변경할 비밀번호가 일치하지 않습니다.", "비밀번호 오류", 0);
					
						}
					} else {
						
						JOptionPane.showMessageDialog(null, "현재 비밀번호와 일치하지 않습니다.", "비밀번호 오류", 0);
						
					}
				}
			}
			
			if(btn_Source.getSource()==canclebtn){
				UserFrmPwd.frame.dispose();
			}
		}
	}
}
