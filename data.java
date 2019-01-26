package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class data {

	static int AUTHORITY ;
	static String ID ;
	static String PASSWORD ;
	static String NAME ;
	static String BIRTHDAY ;
	static String TEL;
	static String EMAIL;
	static String MEMO;
	
	Connection conn = null;
	Statement stmt = null;  // sql -> java
	PreparedStatement pstmt = null; // java -> sql
	String query = ""; // pstmt 보조 SQL 문
	ResultSet rs = null;  // stmt 보조

	
	public void sqlsetting(){
		String url = "jdbc:mysql://localhost:3306/java?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8"; 
		/* TimeZone VER 5.* 이상 설정 "?Timezone=UTC" */
		 
		 String strUser = "root";
		 String strPassword = "1234";
		 
		 try
		{
			Class.forName ("com.mysql.cj.jdbc.Driver");
			System.out.println("DB 연결완료");

		} catch (ClassNotFoundException f) {
			System.out.println("JDBC 드라이버 로드 오류");
		} 
		
		 
		try
		{
		conn = DriverManager.getConnection(url, strUser, strPassword);
		System.out.println("Connection 완료");
		stmt = conn.createStatement();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SQL 실행 오류"); 
		}
		
	}
	
	
	
	
	public void setData(String oID, String oPASSWORD, String oName, String oBirthday, 
			 String oTel,  String oEmail , String  oMemo) throws SQLException{
		
		sqlsetting();
		
		try{

			query = "insert into member values (?,?,?,?,?,?,?,?)";
			
			  pstmt = conn.prepareStatement(query);
			  pstmt.setInt(1, 1);
			  pstmt.setString(2, oID);
			  pstmt.setString(3, oPASSWORD);
			  pstmt.setString(4, oName);
			  pstmt.setString(5, oBirthday);
			  pstmt.setString(6, oTel);
			  pstmt.setString(7, oEmail);
			  pstmt.setString(8, oMemo);
			  
			if(pstmt.executeUpdate() > 0){
				System.out.println("전송완료");
			}
			else
			{
				System.out.println("실패");
			}
			
			} catch (SQLException e2){
				e2.printStackTrace();
			}
			
			pstmt.close();
	}
	
	
	
	public void UpdateData(int data1_pwd2) {
		//data1_pwd2 => 1이면 data를 저장 / 2면 패스워드를 저장
		sqlsetting();
		
		if(data1_pwd2==1)
		{
			System.out.println("정보수정완료");

			query = "update member set name = ?, birthday = ?, tel = ?, email =?, memo = ? where  id = ? ";
			
			try{		
				pstmt = conn.prepareStatement(query);
		 		pstmt.setString(1, NAME);
		 		pstmt.setString(2, BIRTHDAY);
		 		pstmt.setString(3, TEL);
		 		pstmt.setString(4, EMAIL);
		 		pstmt.setString(5, MEMO);
		 		pstmt.setString(6, ID);
		 		pstmt.executeUpdate();
				
			} catch (SQLException p) {
				p.printStackTrace();
			}
		} else {
		
			System.out.println("비번수정완료");
			query = "update member set password = ? where id = ?";
			
		 
		 	try{	
		 		pstmt = conn.prepareStatement(query);
				pstmt.setString(1, PASSWORD);
				pstmt.setString(2, ID);	
				pstmt.executeUpdate();
		 		
		 	} catch (SQLException e){
				e.printStackTrace();
			}
		 	
		}
		
	}
	
	
	public void delData(String oID) throws SQLException{
		
		sqlsetting();
		
	query = "delete from member where id=\'" + oID + "\'";
	
	try	{
		 stmt.executeUpdate(query);
	
	}	catch (SQLException e3) {
		e3.printStackTrace();
		System.out.println("DELETE FAIL");
	}
}


	public Vector getData() {
		
		Vector data = new Vector();
		
		sqlsetting();
		
		query = "select * from member";
		
	try {
		pstmt = conn.prepareStatement(query);
		rs = pstmt.executeQuery();
		
		while(rs.next()){
			
			ID = rs.getString("id");
		//	PASSWORD = rs.getString("password");
			NAME = rs.getString("name");
			BIRTHDAY = rs.getString("birthday");
			TEL = rs.getString("tel");
			EMAIL = rs.getString("email");
			MEMO = rs.getString("memo");
			
			Vector row = new Vector();
			row.add(ID);
			//row.add(PASSWORD);
			row.add(NAME);
			row.add(BIRTHDAY);
			row.add(TEL);
			row.add(EMAIL);
			row.add(MEMO);
			
			data.add(row);
		}
		rs.close();
		stmt.close();
		
	} catch (SQLException e4){
		e4.printStackTrace();
	}
	  return data;
	}

	public void getData(String iid, boolean check){
		
		sqlsetting();
		query = "select * from member where id=\'" + iid +"\'";
	
		
	try {
		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
		
		if(check == true){
			
		
		while(rs.next()){
			
			AUTHORITY = rs.getInt("authority");
			ID = rs.getString("id");
			PASSWORD = rs.getString("password");
			NAME = rs.getString("name");
			BIRTHDAY = rs.getString("birthday");
			TEL= rs.getString("tel");
			EMAIL = rs.getString("email");
			MEMO = rs.getString("memo");
		}
		} else {

		while(rs.next()){
			ID = rs.getString("id");
		}
		}
		rs.close();
		stmt.close();
		
	} catch (SQLException e3){
		e3.printStackTrace();
		System.out.println("ID FAIL");
	}
}
	/* ------------------- * ------------------- */
	
	public Vector search(String iid) {
	
		Vector data = new Vector();
		
		sqlsetting();
		
		query = "select * from member where id = \'"+ iid + "\'";
		
	try {
		pstmt = conn.prepareStatement(query);
		rs = pstmt.executeQuery();
		
		while(rs.next()){
			
			Vector row = new Vector();
			
			row.add(rs.getString("id"));
			row.add(rs.getString("pwd"));
			row.add(rs.getString("name"));
			row.add(rs.getString("birthday"));
			row.add(rs.getString("tel"));
			row.add(rs.getString("email"));
			row.add(rs.getString("memo"));
			
			data.add(row);
	
//			System.out.println(id + " / " + password  + " / " + name  + " / " );
		}
		rs.close();
		stmt.close();
		
	} catch (SQLException e4){
		e4.printStackTrace();
	}
	  return data;
	}

	/* -------------------데이터 get set * ------------------- */
	
	public static int getAUTHORITY() {
		return AUTHORITY;
	}

	public static void setAUTHORITY(int aUTHORITY) {
		AUTHORITY = aUTHORITY;
	}
	public static String getTel() {
		return TEL;
	}
	
	public void setTel(String tel) {
		TEL = tel;
	}
	public static String getMemo() {
		return MEMO;
	}

	public void setMemo(String mEMO) {
		MEMO = mEMO;
	}
	public static String getEmail() {
		return EMAIL;
	}
	public void setEmail(String email) {
		EMAIL = email;
	}
	public static String getID() {
		return ID;
	}
	public static void setID(String iD) {
		ID = iD;
	}
	public  static String getPASSWORD() {
		return PASSWORD;
	}
	public static void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public static String getName() {
		return NAME;
	}
	public void setName(String name) {
		NAME = name;
	}
	public static String getBirthday() {
		return BIRTHDAY;
	}
	public void setBirthday(String birthday) {
		BIRTHDAY = birthday;
	}
	

	// 탈퇴 및 로그아웃 시 메모리를 초기화
	
	public static void Reset(int x){
		if(x==1)
		{
			ID = "";
			PASSWORD = "";
			TEL = "";
			BIRTHDAY = "";
			MEMO = "";
			NAME ="";
			EMAIL ="";
		}
		
	}
}
	
	
