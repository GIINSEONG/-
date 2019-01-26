package Main;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;


import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.event.*;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class MemberJoin {

	private static JFrame MemberJoinFrame;
	private JTextField txt_name;
	private JTextField txt_id;
	private JPasswordField txt_pwd;
	private JTextField txt_tel1;
	private JTextField txt_tel2;
	private JTextField txt_tel3;
	private JTextField txt_year;
	private JTextField txt_month;
	private JTextField txt_day;
	private JTextField txt_email;
	private JTextArea txt_memo;
	private JButton joinbtn;
	private JButton canclebtn;
	private JButton checkbtn;
	private data data = new data();
	/**0
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
	}
	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public MemberJoin() {

		GUI_MemberJoin();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	public void GUI_MemberJoin() {
	

		MemberJoinFrame = new JFrame();
		MemberJoinFrame.setTitle("ȸ������");
		MemberJoinFrame.setVisible(true);
		MemberJoinFrame.setBounds(100, 100, 315, 420);
		MemberJoinFrame.setLocationRelativeTo(null);
		MemberJoinFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MemberJoinFrame.getContentPane().setLayout(null);
		/* ------------------------------------------ Panel ---------------------------------- */
		JPanel panel = new JPanel();
		JPanel phonepanel = new JPanel();
		JPanel birthpanel = new JPanel();
		
		panel.setBounds(0, 0, 299, 381);
		phonepanel.setBounds(81, 181, 206, 32);
		birthpanel.setBounds(81, 146, 206, 32);
		
		MemberJoinFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		phonepanel.setLayout(new FlowLayout(FlowLayout.LEFT, 8, 5));
		birthpanel.setLayout(new FlowLayout(FlowLayout.LEFT, 8, 5));
		
		/* ------------------------------------------ label ---------------------------------- */
		/* ���̺� ����  */
		
		JLabel titlelabel = new JLabel("ȸ������");
		JLabel namelabel = new JLabel("�̸� :");
		JLabel idlabel = new JLabel("���̵� :");
		JLabel pwdlabel = new JLabel("�н����� :");
		JLabel phonelabel = new JLabel("����ó :");
		JLabel emaillabel = new JLabel("�̸��� :");
		JLabel introlabel = new JLabel("�ڱ�Ұ� :");
		JLabel birthdaylabel = new JLabel("������� :");
		
		
		JLabel label1 = new JLabel("-");
		JLabel label2 = new JLabel("-");
		JLabel label_1 = new JLabel("/");
		JLabel label_2 = new JLabel("/");
		
		titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		titlelabel.setFont(new Font("����", Font.BOLD, 15));
		namelabel.setFont(new Font("����", Font.PLAIN, 12));
		idlabel.setFont(new Font("����", Font.PLAIN, 12));
		pwdlabel.setFont(new Font("����", Font.PLAIN, 12));
		phonelabel.setFont(new Font("����", Font.PLAIN, 12));
		emaillabel.setFont(new Font("����", Font.PLAIN, 12));
		introlabel.setFont(new Font("����", Font.PLAIN, 12));
		birthdaylabel.setFont(new Font("����", Font.PLAIN, 12));
		
		titlelabel.setBounds(112, 10, 75, 35);
		namelabel.setBounds(38, 118, 41, 25);
		idlabel.setBounds(22, 45, 57, 25);
		pwdlabel.setBounds(12, 82, 67, 25);
		phonelabel.setBounds(22, 188, 57, 25);
		emaillabel.setBounds(22, 223, 57, 25);
		introlabel.setBounds(12, 258, 67, 25);
		birthdaylabel.setBounds(12, 153, 67, 25);

		panel.add(titlelabel);		
		panel.add(namelabel);
		panel.add(idlabel);
		panel.add(pwdlabel);
		panel.add(phonelabel);
		panel.add(emaillabel);
		panel.add(introlabel);
		panel.add(birthdaylabel);
		
		// Panel �� 2�� Panel
		panel.add(phonepanel);		
		panel.add(birthpanel);
		
		/* ------------------------------------------ field ----------------------------------*/
		/* �ʵ� ����  */
		
		txt_name = new JTextField("");
		txt_id = new JTextField("");
		txt_pwd = new JPasswordField("");
		txt_tel1 = new JTextField();
		txt_tel2 = new JTextField();
		txt_tel3 = new JTextField();
		txt_year = new JTextField();
		txt_month = new JTextField();
		txt_day = new JTextField();
		txt_email = new JTextField();
		
		
		txt_name.setBounds(81, 120, 206, 21);
		txt_id.setBounds(81, 47, 110, 21);
		txt_pwd.setBounds(81, 83, 206, 23);
		txt_email.setBounds(81, 223, 206, 21);
		

		txt_name.setColumns(10);
		txt_id.setColumns(10);
		txt_tel1.setColumns(3);
		txt_tel2.setColumns(4);
		txt_tel3.setColumns(4);
		txt_month.setColumns(2);
		txt_year.setColumns(4);
		txt_day.setColumns(2);
		txt_email.setColumns(10);
		
		panel.add(txt_name);
		panel.add(txt_id);
		panel.add(txt_pwd);
		panel.add(txt_email);
		
		phonepanel.add(txt_tel1);
		phonepanel.add(label2);
		phonepanel.add(txt_tel2);
		phonepanel.add(label1);
		phonepanel.add(txt_tel3);
		
		birthpanel.add(txt_year);
		birthpanel.add(label_1);
		birthpanel.add(txt_month);
		birthpanel.add(label_2);
		birthpanel.add(txt_day);
		

		/* ------------------------------------------ ScrollPane + TextArea ----------------------------------*/
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(81, 254, 206, 81);
		panel.add(scrollPane);
		txt_memo = new JTextArea();
		scrollPane.setViewportView(txt_memo);
		

		/* ------------------------------------------ btn ----------------------------------*/
		/* btn ���� */
		
		joinbtn = new JButton("����");
		joinbtn.setEnabled(false);
		canclebtn = new JButton("���");

		joinbtn.setBounds(91, 348, 60, 23);
		canclebtn.setBounds(163, 348, 60, 23);
	
		panel.add(joinbtn);
		panel.add(canclebtn);
		
		checkbtn = new JButton("�ߺ�Ȯ��");
		checkbtn.setFont(new Font("����", Font.PLAIN, 11));
		checkbtn.setBounds(203, 46, 84, 23);
		panel.add(checkbtn);
		
			
		/* btn Actionlistener ���� */
		
		canclebtn.addActionListener(new MyActionListener());
		joinbtn.addActionListener(new MyActionListener());
		checkbtn.addActionListener(new MyActionListener());
		
		
		/* txt Keylistener ���� */
		
		txt_email.addKeyListener(new KeyAdapter());
		txt_id.addKeyListener(new KeyAdapter());
		txt_pwd.addKeyListener(new KeyAdapter());
		txt_name.addKeyListener(new KeyAdapter());
		txt_tel1.addKeyListener(new KeyAdapter());
		txt_tel2.addKeyListener(new KeyAdapter());
		txt_tel3.addKeyListener(new KeyAdapter());
		txt_year.addKeyListener(new KeyAdapter());
		txt_month.addKeyListener(new KeyAdapter());
		txt_day.addKeyListener(new KeyAdapter());
		txt_memo.addKeyListener(new KeyAdapter());
	
		
		txt_id.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				joinbtn.setEnabled(false);
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				joinbtn.setEnabled(false);
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				joinbtn.setEnabled(false);
			}
		});

	}
	
	
	
	
	class KeyAdapter extends JFrame implements KeyListener{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void keyPressed(KeyEvent e){
			if(e.getKeyCode()==10){
				joinbtn.doClick();
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
	
	class MyActionListener extends JFrame implements ActionListener{
		
		private static final long serialVersionUID = 1L;
		
		@SuppressWarnings({ "deprecation", "static-access" }) // PWD�� TXT���� �������� ������ �����ϴ� �ɼ�
		
		public void actionPerformed(ActionEvent btn_Source) {
				
				if(btn_Source.getSource()==joinbtn){
					
						if(txt_id.getText().equals("") || txt_pwd.getText().equals("") || txt_name.getText().equals("")){
							
							JOptionPane.showMessageDialog(null, "�ʼ� �Է¶��� ����ֽ��ϴ�.","�Է¿���",0);
							
						}
						else {
							
							try {
						
								String Birthday = txt_year.getText() + "/" + txt_month.getText() + "/" + txt_day.getText();
								String Tel =txt_tel1.getText() + "-" + txt_tel2.getText() + "-" + txt_tel3.getText();
								String Id = txt_id.getText();
								String Name = txt_name.getText();
								data.setData(Id,  txt_pwd.getText(),  Name , Birthday , Tel , txt_email.getText(), txt_memo.getText());						
								JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ�Ǿ����ϴ�.","���ԿϷ�",-1);
								
							} catch (SQLException e) {
								
								JOptionPane.showMessageDialog(null, "","�Է¿���",0);
								e.printStackTrace();
								
							}				
					
							MemberJoin.MemberJoinFrame.dispose();
						}
				}
				
				if(btn_Source.getSource()==checkbtn){
					data.getData(txt_id.getText(),false);
					if(txt_id.getText().equals(data.getID()) || txt_id.getText().equals("")){
						joinbtn.setEnabled(false);
						JOptionPane.showMessageDialog(null, "���̵� �ߺ��Ǿ����ϴ�.","�ߺ�����",0);
					}
					else
					{	
						JOptionPane.showMessageDialog(null, "���̵� ����ϽǼ� �ֽ��ϴ�.","��밡��",-1);
						joinbtn.setEnabled(true);	
					}

				}
				
				
				if(btn_Source.getSource()==canclebtn){
					
					MemberJoin.MemberJoinFrame.dispose();

				}
		}		
	}
}

