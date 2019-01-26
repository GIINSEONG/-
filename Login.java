package Main;

/* Swing import */
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.*;

import backup.AdminFrm;


public class Login extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	
	Login main;
	MemberJoin memberjoin;
	data data = new data();
	
	// UserFrm userfrm = new UserFrm();
	private static JFrame login;
	private JTextField idtextField;
	private JPasswordField pwdField;
	private JButton loginbtn;
	private JButton joinbtn;
	
	
	public static void main(String[] args)  {
		new Login();
	}


	
	/* Login ���� */
	public Login() {
		
		GUI_Login();
	}

	
	private void GUI_Login() {
		login = new JFrame();
		login.setTitle("ȸ���������α׷�");
		login.setVisible(true);
		login.setBounds(100, 100, 301, 215);
		login.setLocationRelativeTo(null);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 283, 181);
		panel.setLayout(null);
		login.getContentPane().add(panel);

		
		/* ��ư ���� */
		
		joinbtn = new JButton("ȸ������");		
		loginbtn = new JButton("�α���");
		
		joinbtn.setFont(new Font("����", Font.PLAIN, 11));
		loginbtn.setFont(new Font("����", Font.PLAIN, 11));
		
		joinbtn.setBounds(153, 133, 85, 24);
		loginbtn.setBounds(56, 133, 85, 24);
		
		joinbtn.addActionListener(new MyActionListener()); 
		loginbtn.addActionListener(new MyActionListener());
				
		panel.add(joinbtn);
		panel.add(loginbtn);

	   /* ���̺� ���� */
			
		JLabel loginLabel = new JLabel("LOGIN");
		JLabel idlabel = new JLabel("���̵�");
		JLabel pwdlabel = new JLabel("��й�ȣ");
		
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idlabel.setHorizontalAlignment(SwingConstants.CENTER);
		pwdlabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		loginLabel.setBounds(90, 10, 102, 40);
		idlabel.setBounds(42, 61, 67, 20);
		pwdlabel.setBounds(42, 91, 67, 20);
		
		loginLabel.setFont(new Font("����", Font.BOLD, 20));
		idlabel.setFont(new Font("����", Font.PLAIN, 13));
		pwdlabel.setFont(new Font("����", Font.PLAIN, 13));
	
		panel.add(loginLabel);
		panel.add(idlabel);
		panel.add(pwdlabel);
		
		
		/* �ʵ念�� */
		
		pwdField = new JPasswordField();
		pwdField.setEchoChar('*');
		idtextField = new JTextField();
		
		pwdField.setToolTipText("�н����� �Է�");
		idtextField.setToolTipText("���̵� �Է�");
		
		pwdField.setBounds(111, 91, 116, 20);
		idtextField.setBounds(111, 62, 116, 20);
		
		pwdField.setFont(new Font("����", Font.PLAIN, 11));
		idtextField.setFont(new Font("����", Font.PLAIN, 11));

		idtextField.setColumns(10);
		
		panel.add(pwdField);
		panel.add(idtextField);
		
		pwdField.addKeyListener(new KeyAdapter());
		idtextField.addKeyListener(new KeyAdapter());

	}
	
	
	class KeyAdapter extends JFrame implements KeyListener{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void keyPressed(KeyEvent e){
			if(e.getKeyCode()==10){
				loginbtn.doClick();
			}
			if(e.getKeyCode()==27){
				System.exit(0);
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub		
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub		
		}
	}
	
	class  MyActionListener extends JFrame implements ActionListener{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@SuppressWarnings({ "static-access", "deprecation" })
		@Override
		public void actionPerformed(ActionEvent btn_Source) {
			
			if(btn_Source.getSource()==joinbtn)
			{
				new MemberJoin();
			}
			
				if(btn_Source.getSource()==loginbtn)
				{
				
					if(idtextField.getText().equals("") || pwdField.getText().equals("")) 
						{
					JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ�� �Է����ּ���.","Error",0);
						} 
				
						else {
							data.getData(idtextField.getText(),true);
					
							if(idtextField.getText().equals(data.getID())&& 
									Arrays.equals(pwdField. getPassword(),data.getPASSWORD().toCharArray())) 
								{
									Login.login.dispose();
									new UserFrm();
								}
					
						else {
							JOptionPane.showMessageDialog(null, "���̵� Ȥ�� ��й�ȣ�� �߸��Ǿ����ϴ�.","Error",0); // -1=NULL // 0=X // 1=�����Ķ�! // 2=������! // 3=�׸��ʷ�! 					
							}
				}		
			}
		}
	}
}

