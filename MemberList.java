package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Main.Login.MyActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MemberList extends JFrame implements MouseListener {

	private static final long serialVersionUID = 1L;
	
	private data data = new data();

	public static JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField txt_id;
	private JTextField txt_pwd;
	private JTextField txt_name;
	private JTextField txt_birthday;
	private JTextField txt_tel;
	private JTextField txt_email;
	private JTextField txt_memo;
	
	JTextField txt_search;
	JButton Searchbtn;
	DefaultTableModel model;
	
	Vector v;
	Vector cols;
	
	
	public static void main(String[] args) {
		new MemberList();
		 // sql();
	}

	
	public MemberList() {
		GUI_Table();
		jTableRefresh(); 
		v= data.getData();
		cols = getColumn();
		model = new DefaultTableModel(v, cols);
		table.setModel(model);
		
		txt_search = new JTextField();
		txt_search.setBounds(12, 10, 106, 21);
		frame.getContentPane().add(txt_search);
		txt_search.setColumns(10);
		
		Searchbtn = new JButton("검색");
		Searchbtn.setBounds(130, 9, 67, 23);
		frame.getContentPane().add(Searchbtn);
		Searchbtn.addActionListener(new MyActionListener()); 
		table.addMouseListener(this);
	}


	public Vector getColumn() { // 칼럼명
		Vector<String> col = new Vector();
		col.add("ID");
	//	col.add("PWD");
		col.add("NAME");
		col.add("BIRTHDAY");
		col.add("TEL");
		col.add("EMAIL");
		col.add("MEMO");
		return col;
	}
	
	
	public void jTableRefresh() { //테이블 갱신
		DefaultTableModel model = new DefaultTableModel(data.getData(), getColumn());
		table.setModel(model);
	}
	

	public void GUI_Table() {
		frame = new JFrame();
		frame.setTitle("회원목록");
		frame.setVisible(true);
		frame.setBounds(500, 100, 696, 402);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		
		/* -------------------텍스트 영역 * ------------------- */
		txt_id = new JTextField("");
		txt_birthday = new JTextField("");
		txt_email = new JTextField("");
		txt_name = new JTextField("");
		txt_pwd = new JTextField("");
		txt_memo = new JTextField("");
		txt_tel = new JTextField("");
		
		txt_id.setBounds(81, 41, 116, 21);
		txt_birthday.setBounds(81, 126, 116, 21);
		txt_email.setBounds(81, 182, 116, 21);
		txt_name.setBounds(81, 98, 116, 21);
		txt_pwd.setBounds(81, 70, 116, 21);
		txt_memo.setBounds(22, 241, 167, 102);
		txt_tel.setBounds(81, 154, 116, 21);
		
		txt_id.setColumns(10);
		txt_birthday.setColumns(10);
		txt_email.setColumns(10);
		txt_name.setColumns(10);
		txt_pwd.setColumns(10);
		txt_memo.setColumns(10);
		txt_tel.setColumns(10);
			
		txt_id.setEditable(false);
		txt_birthday.setEditable(false);
		txt_email.setEditable(false);
		txt_name.setEditable(false);
		txt_pwd.setEditable(false);
		txt_memo.setEditable(false);
		txt_tel.setEditable(false);

		frame.getContentPane().add(txt_id);
		frame.getContentPane().add(txt_birthday);
		frame.getContentPane().add(txt_email);
		frame.getContentPane().add(txt_name);
		frame.getContentPane().add(txt_pwd);
		frame.getContentPane().add(txt_memo);
		frame.getContentPane().add(txt_tel);
		
		
		/* ------------------- 라벨 영역 ------------------- */
		JLabel idlabel = new JLabel("ID");
		JLabel birthdaylabel = new JLabel("생년월일");
		JLabel emaillabel = new JLabel("E-mail");
		JLabel namelabel = new JLabel("이름");
		JLabel pwdlabel = new JLabel("PW");
		pwdlabel.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel memolabel = new JLabel("자기소개");
		JLabel tellabel = new JLabel("연락처");
		
		idlabel.setHorizontalAlignment(SwingConstants.CENTER);
		birthdaylabel.setHorizontalAlignment(SwingConstants.CENTER);
		emaillabel.setHorizontalAlignment(SwingConstants.CENTER);
		namelabel.setHorizontalAlignment(SwingConstants.CENTER);
		memolabel.setHorizontalAlignment(SwingConstants.CENTER);
		tellabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		idlabel.setBounds(12, 44, 57, 15);
		birthdaylabel.setBounds(12, 129, 57, 15);
		emaillabel.setBounds(12, 185, 57, 15);
		namelabel.setBounds(12, 101, 57, 15);
		pwdlabel.setBounds(12, 73, 57, 15);
		memolabel.setBounds(22, 213, 167, 15);
		tellabel.setBounds(12, 157, 57, 15);
		
		frame.getContentPane().add(idlabel);
		frame.getContentPane().add(birthdaylabel);
		frame.getContentPane().add(emaillabel);
		frame.getContentPane().add(namelabel);
		frame.getContentPane().add(pwdlabel);
		frame.getContentPane().add(memolabel);
		frame.getContentPane().add(tellabel);

		
		/* ------------------- 테이블 스크롤 영역 ------------------- */
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(209, 0, 471, 343);
		frame.getContentPane().add(scrollPane);

	}
	
	 public void mouseClicked(MouseEvent e) { 
		 
		 int  r = table.getSelectedRow();
		
		 txt_id.setText((String)table.getValueAt(r, 0));
	  // txt_pwd.setText((String)table.getValueAt(r, 1));
		 txt_name.setText((String)table.getValueAt(r, 1));
		 txt_birthday.setText((String)table.getValueAt(r, 2));
		 txt_tel.setText((String)table.getValueAt(r, 3));
		 txt_email.setText((String)table.getValueAt(r, 4));
		 txt_memo.setText((String)table.getValueAt(r, 5));
		 
	 }


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	class MyActionListener extends JFrame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == Searchbtn) {
				for(int se=0;se<v.size();se++){
					if(table.getValueAt(se, 0).equals(txt_search.getText())){
						
						 txt_id.setText((String)table.getValueAt(se, 0));
						 // txt_pwd.setText((String)table.getValueAt(r, 1));
						 txt_name.setText((String)table.getValueAt(se, 1));
						 txt_birthday.setText((String)table.getValueAt(se, 2));
						 txt_tel.setText((String)table.getValueAt(se, 3));
						 txt_email.setText((String)table.getValueAt(se, 4));
						 txt_memo.setText((String)table.getValueAt(se, 5));
						 
						break;
					} //End- if
				} //End- for
			} //End- Btn if
		} // End- actionperformed
	} // End- Class
	
} 
	


