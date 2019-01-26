package Main;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UserFrm extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // 객체직렬화를 위한 인터페이스 구현 / 

	private data data = new data(); 
	private Login login;
	public JTextField txt_id;
	private JTextField txt_pwd;
	public JTextField txt_name;
	public JTextField txt_birthday;
	public JTextField txt_tel;
	public JTextField txt_email;
	public JTextField txt_memo;
	JButton changebtn;
	JButton pwdchangebtn;
	JButton logoutbtn;
	JButton memlistbtn;
	private JFrame UserFrm;
	JPanel panel;
	private JButton delbtn;
	public UserFrm(){
		Gui_UserFrm();
	}
	/**
	 * Create the application.
	 * @return 
	 */
	@SuppressWarnings("static-access")
	
	public void Gui_UserFrm() {
		
		UserFrm = new JFrame();
		UserFrm.setTitle("회원정보");
		UserFrm.setVisible(true);
		UserFrm.setBounds(100, 100, 450, 312);
		UserFrm.setLocationRelativeTo(null);
		UserFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UserFrm.getContentPane().setLayout(null);

		
		panel = new JPanel();
		panel.setBounds(12, 10, 410, 187);
		UserFrm.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		/* -------------------라벨 영역 * ------------------- */
		JLabel idlabel = new JLabel("ID");
		JLabel pwdlabel = new JLabel("PW");
		JLabel namelabel = new JLabel("이름");
		JLabel birthdaylabel = new JLabel("생년월일");
		JLabel tellabel = new JLabel("연락처");
		JLabel emaillabel = new JLabel("E-mail");
		JLabel memolabel = new JLabel("자기소개");
				
		idlabel.setHorizontalAlignment(SwingConstants.CENTER);
		pwdlabel.setHorizontalAlignment(SwingConstants.CENTER);
		namelabel.setHorizontalAlignment(SwingConstants.CENTER);
		birthdaylabel.setHorizontalAlignment(SwingConstants.CENTER);
		tellabel.setHorizontalAlignment(SwingConstants.CENTER);
		emaillabel.setHorizontalAlignment(SwingConstants.CENTER);
		memolabel.setHorizontalAlignment(SwingConstants.CENTER);
			
		idlabel.setBounds(12, 10, 57, 15);
		pwdlabel.setBounds(12, 38, 57, 15);
		namelabel.setBounds(12, 66, 57, 15);
		birthdaylabel.setBounds(12, 94, 57, 15);
		tellabel.setBounds(12, 122, 57, 15);
		emaillabel.setBounds(12, 150, 57, 15);
		memolabel.setBounds(209, 38, 167, 15);
			
		panel.add(idlabel);
		panel.add(pwdlabel);
		panel.add(namelabel);
		panel.add(birthdaylabel);
		panel.add(tellabel);
		panel.add(emaillabel);
		panel.add(memolabel);
		
		
		/* -------------------텍스트 영역 * ------------------- */
		txt_id = new JTextField(data.getID());
		txt_pwd = new JTextField(data.getPASSWORD());
		txt_name = new JTextField(data.getName());
		txt_birthday = new JTextField(data.getBirthday());
		txt_tel = new JTextField(data.getTel());
		txt_email = new JTextField(data.getEmail());
		txt_memo = new JTextField(data.getMemo());
		
		txt_id.setEditable(false);
		txt_pwd.setEditable(false);
		
		txt_id.setColumns(10);
		txt_pwd.setColumns(10);
		txt_name.setColumns(10);
		txt_birthday.setColumns(10);
		txt_tel.setColumns(10);
		txt_email.setColumns(10);
		txt_memo.setColumns(10);
		
		txt_id.setBounds(81, 7, 116, 21);
		txt_pwd.setBounds(81, 35, 116, 21);
		txt_name.setBounds(81, 63, 116, 21);
		txt_birthday.setBounds(81, 91, 116, 21);
		txt_tel.setBounds(81, 119, 116, 21);
		txt_email.setBounds(81, 147, 116, 21);
		txt_memo.setBounds(209, 66, 167, 102);
		
		panel.add(txt_id);
		panel.add(txt_pwd);
		panel.add(txt_name);
		panel.add(txt_birthday);
		panel.add(txt_tel);
		panel.add(txt_email);
		panel.add(txt_memo);
		
		
		/* -------------------버튼 영역 * ------------------- */
		logoutbtn = new JButton("로그아웃");
		changebtn = new JButton("수정");
		pwdchangebtn = new JButton("패스워드변경");
		delbtn = new JButton("탈퇴");
		memlistbtn = new JButton("회원목록");
		memlistbtn.setVisible(false);
		
		logoutbtn.setBounds(225, 208, 119, 23);
		changebtn.setBounds(356, 208, 66, 23);
		pwdchangebtn.setBounds(225, 241, 119, 23);
		delbtn.setBounds(356, 241, 66, 23);
		memlistbtn.setBounds(12, 241, 97, 23);
		
		UserFrm.getContentPane().add(logoutbtn);
		UserFrm.getContentPane().add(changebtn);
		UserFrm.getContentPane().add(pwdchangebtn);
		UserFrm.getContentPane().add(delbtn);
		UserFrm.getContentPane().add(memlistbtn);
		
		/* Btn ActionListener */
		delbtn.addActionListener(new MyActionListener());
		pwdchangebtn.addActionListener(new MyActionListener());
		changebtn.addActionListener(new MyActionListener());
		logoutbtn.addActionListener(new MyActionListener());
		memlistbtn.addActionListener(new MyActionListener());
		
		if(data.getAUTHORITY() == 0) {
			memlistbtn.setVisible(true);
		}

	}
	
	
	class MyActionListener extends JFrame implements ActionListener{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@SuppressWarnings("static-access")
		public void actionPerformed(ActionEvent btn_Source) {
		
		
			if(btn_Source.getSource()==changebtn){

				int yesok = JOptionPane.showConfirmDialog(null, "수정하시겠슨니까?", "수정확인", JOptionPane.YES_NO_OPTION);
				
				if(yesok == 0) {
					data.setName(txt_name.getText());
					data.setBirthday(txt_birthday.getText());
					data.setTel(txt_tel.getText());
					data.setEmail(txt_email.getText());
					data.setMemo(txt_memo.getText());
					data.UpdateData(1);
					JOptionPane.showMessageDialog(null, "수정되었습니다.", "완료", -1);
				
				} else {
					JOptionPane.showMessageDialog(null, "수정을 취소하였습니다.", "취소", 0);	
				}
			}
	
			if(btn_Source.getSource()==pwdchangebtn){
				new UserFrmPwd();
			}
			
			if(btn_Source.getSource()==delbtn){
				try {
					data.delData(data.getID());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				data.Reset(1);
				JOptionPane.showMessageDialog(null, "탈퇴되었습니다.", "탈퇴", -1);
				UserFrm.setVisible(false);
				new Login();
			}
			
			
			if(btn_Source.getSource()==logoutbtn){
				data.Reset(1);
				UserFrm.dispose();
				new Login();
			}
			
			if(btn_Source.getSource() == memlistbtn) {
				new MemberList();
			}
		}
	}
}
