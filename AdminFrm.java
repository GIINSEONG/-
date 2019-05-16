package backup;

import javax.swing.JFrame;

import Main.Login;
import Main.MemberList;
import Main.data;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminFrm {
	private data data;
	private Login login;
	private static JFrame admframe;
	JButton logoutbtn;
	JButton memberbtn;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public AdminFrm() {
		Gui_AdminFrm();
		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void Gui_AdminFrm() {
		admframe = new JFrame();
		admframe.setTitle("관리자 모드");
		admframe.setBounds(100, 100, 379, 397);
		admframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		admframe.getContentPane().setLayout(null);
		admframe.setVisible(true);
		
		memberbtn = new JButton("회원목록");
		memberbtn.addActionListener(new MyActionListener());
		memberbtn.setBounds(148, 326, 97, 23);
		admframe.getContentPane().add(memberbtn);
		
		logoutbtn = new JButton("로그아웃");
		logoutbtn.addActionListener(new MyActionListener());
		logoutbtn.setBounds(254, 326, 97, 23);
		admframe.getContentPane().add(logoutbtn);
	}
	
	class MyActionListener extends JFrame implements ActionListener{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent btn_Source) {
		
			if(btn_Source.getSource()==memberbtn){
				new MemberList();
			}
	
			if(btn_Source.getSource()==logoutbtn){
				
				data.Reset(1);
			//	admframe.setVisible(false);
				AdminFrm.admframe.dispose();
				MemberList.frame.dispose();
				new Login();
			}
		}
	}
}
