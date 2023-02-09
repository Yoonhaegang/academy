package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;


public class UserDAO {

	Connection conn = null;
	PreparedStatement prep = null;
	ResultSet rs = null;
	int cnt = 0;
	boolean result = false;
	Date utilDate = new Date();
	
	
	
	//------------------------------------ 회원가입 메소드--------------------------------------------------------------------
	public int insert(UserDTO dto) {

		connection();
		// String sql = "insert into member values('smart','1234','이영재',20)";
		String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?)";

		try {
			java.sql.Date date = new java.sql.Date(utilDate.getTime());
			
			prep = conn.prepareStatement(sql);
			// setString string에 존재하는 ? 를 대신하는 문자열 setString(int , String) -> int => index
			// 1부터 시작
			prep.setString(1, dto.getId());
			prep.setString(2, dto.getPw());
			prep.setString(3, dto.getNickName());
			prep.setString(4, dto.getName());
			prep.setDate(5, date); // 최고점 시간 : 00년대
			prep.setDate(6, date); // 최고점 시간 : 10년대
			prep.setDate(7, date); // 최고점 시간 : 20년대
			prep.setInt(8, 0); //최고점 점수 : 00년대 
			prep.setInt(9, 0); //최고점 점수 : 10년대
			prep.setInt(10, 0);//최고점 점수 : 20년대
		

			cnt = prep.executeUpdate();

		} catch(Exception e) {
			cnt = -1;
		}
		finally {
			disconnection();

		}
		return cnt;

	}
	//-------------------------------------------------------------------------------------------------------------------
	//로그인을 위한  메소드
	
	//---------------------------------------로그인 ------------------------------------------------------------------------
	public boolean logIn(UserDTO dto) {
		connection();
		String sql = "select * from member where id=? and pw=?";
		try {
			prep = conn.prepareStatement(sql);
			prep.setString(1, dto.getId());
			prep.setString(2, dto.getPw());
			//전송
			rs = prep.executeQuery();
			if(rs.next()) {
				result =true;
			} else {
				result =false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("데이터를 보낼 수 없습니다.");
		} finally {
			disconnection();
		}
		return result;
	}
	//--------------------------------------------------------------------------------------------------------------------
	
	
	//-----------------------------------------회원정보 수정----------------------------------------------------
	// ---------------------------------------- 비밀번호 변경 --------------------------------------------------
	public int updatePw(UserDTO dto , String pw) {
		connection();
		String sql = "update member set pw = ?  where id=? ";
		try {
			prep = conn.prepareStatement(sql);
			prep.setString(1,pw);
			prep.setString(2, dto.getId());
			//전송
			cnt = prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("데이터를 보낼 수 없습니다.");
		} finally {
			disconnection();
		}
		return cnt;
	}
	
	//-----------------------------------------------------------------------------------------------------------------------
	//------------------------------------이름 변경---------------------------------------------------------------------------
	public int updateName(UserDTO dto ,String name) {
		connection();
		String sql = "update member set name = ?  where id=? ";
		try {
			prep = conn.prepareStatement(sql);
			prep.setString(1,name);
			prep.setString(2, dto.getId());
			//전송
			cnt = prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("데이터를 보낼 수 없습니다.");
		} finally {
			disconnection();
		}
		return cnt;
	}
	// -----------------------------------------------------------------------------------------------------------------------
	//---------------------------------------닉네임 변경 ------------------------------------------------------------------------
	public int updateNickName(UserDTO dto ,String nickName) {
		connection();
		String sql = "update member set nick =?  where id=? ";
		try {
			prep = conn.prepareStatement(sql);
			prep.setString(1,nickName);
			prep.setString(2, dto.getId());
			//전송
			cnt = prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("데이터를 보낼 수 없습니다.");
		} finally {
			disconnection();
		}
		return cnt;
	}
	//-------------------------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------------------
	
	//------------------------------- 점수 갱신하기-------------------------------------------------------------------------------------
	// --------------------------------- 00년대 ---------------------------------------------------------------------------------------
	public int updateGrade00(UserDTO dto ,int grade) {
		connection();
		java.sql.Date date = new java.sql.Date(utilDate.getTime());
		System.out.println(date);
		
		String sql = "update member set  year00 = ?, top00 = ?  where id= ?";
		try {
			prep = conn.prepareStatement(sql);
			prep.setInt(1,grade);
			prep.setDate(2, date);
			prep.setString(3, dto.getId());
			//전송
			cnt = prep.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch bloc
			e.printStackTrace();
			System.out.println("데이터를 보낼 수 없습니다.");
		} finally {
			disconnection();
		}
		return cnt;

	}
	
	
	// ---------------------------------------10 년대 ----------------------------------------------------------------------
	public int updateGrade10(UserDTO dto ,int grade) {
		connection();
		java.sql.Date date = new java.sql.Date(utilDate.getTime());
		String sql = "update member set  year10 = ?, top10 = ?   where id=? ";
		try {
			prep = conn.prepareStatement(sql);
			prep.setInt(1,grade);
			prep.setDate(2, date);
			prep.setString(3, dto.getId());
			//전송
			cnt = prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("데이터를 보낼 수 없습니다.");
		} finally {
			disconnection();
		}
		return cnt;
	
	}
	
	//----------------------------------------20 년대-------------------------------------------------------------------
	public int updateGrade20(UserDTO dto ,int grade) {
		connection();
		java.sql.Date date = new java.sql.Date(utilDate.getTime());
		String sql = "update member set  year20 = ?, top20 = ?   where id=? ";
		try {
			prep = conn.prepareStatement(sql);
			prep.setInt(1,grade);
			prep.setDate(2, date);
			prep.setString(3, dto.getId());
			//전송
			cnt = prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("데이터를 보낼 수 없습니다.");
		} finally {
			disconnection();
		}
		return cnt;
	
	}
	//-------------------------------------------------------------------------------------------------------------------------------

	// 전체 출력  --- 년도 총합 랭킹 출력
	public String allOut(){
		connection();
		String sql = "select nick, year00+year10+year20 as Total_Rank from member order by Total_Rank desc";
		String str = "Rank\t\tNickName\t\tTotal Rank\n" ; 
		try {
			prep = conn.prepareStatement(sql);
			//전송
			int i = 1;
			rs = prep.executeQuery();
			while(rs.next()) {
//				str += "id : " + rs.getString(1) + " pw : " + rs.getString(2) +  " name : " + rs.getString(3) +  " age : " + rs.getInt(4) + "\n"; 
				//f 포맷팅 %d %s %f %o %x
//				str += String.format(i+". %s\t%d\n", rs.getString(3), (rs.getInt(8)+rs.getInt(9)+rs.getInt(10)));
				str += String.format(i+".%20s\t%20d\n",rs.getString(1), rs.getInt(2));
				i++;
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("데이터를 보낼 수 없습니다.");
		} finally {
			disconnection();
		}
		return str;
		
	}
	
	
	//----------------------------------------- 아이디를 찾아 자신의 각 점수와 얻은 시간을 출력 -----------------------------------------------------------------
	public String partId(UserDTO dto) {
		connection();
//		String sql = "select * from member where id= ' "+ dto.getId() + " '  and pw = '" + dto.getPw()+"'";
		String sql = "select nick , year00 , top00 , year10, top10 , year20 , top20 from member where id=?";
		try {
			prep = conn.prepareStatement(sql);
			prep.setString(1, dto.getId());
			//전송
			rs = prep.executeQuery();
			if(rs.next()) {
			
				//f 포맷팅 %d %s %f %o %x
				String str =  "ID : "  +String.format("%s\n하드모드 : %s\t%d\n노말모드 : %s\t%d\n이지모드 : %s\t%d\n", rs.getString(1), rs.getString(3),rs.getInt(2) ,rs.getString(5),rs.getInt(4), rs.getString(7),rs.getInt(6));
				return str;
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("데이터를 보낼 수 없습니다.");
		} finally {
			disconnection();
		}
		
		return "해당 id를 찾을 수 없습니다.";
		
	}
	//-------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//----------------------- 해당 아이디와 해당 년도의 점수를 찾는 메소드 ----------------------------------------------------------------
	public int partYearGrade(String year,UserDTO dto) {
		connection();
//		String sql = "select * from member where id= ' "+ dto.getId() + " '  and pw = '" + dto.getPw()+"'";
		String sql = "";
		int grade = 0;
		switch (year) {
		case "00":
			sql = "select year00  from member where  id = ?";
			
			break;
		case "10":
			sql = "select year10 from member where id = ?";
			
			break;
		case "20":
			sql = "select year20 from member where id = ?";
			
			break;

		default:
			break;
		}
		
		try {
			
			prep = conn.prepareStatement(sql);
			//전송
			prep.setString(1,dto.getId());
		
			rs = prep.executeQuery();
			
			if(rs.next()) {
				grade =rs.getInt(1);
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("데이터를 보낼 수 없습니다.2");
		} finally {
			disconnection();
		}
		
		return grade;
		
	}
	
	
	
	//----------------------------------------------------------------------------------------------------------------------------
	
	//------------------------------------------------------- 년도별 랭킹을 설정 ----------------------------------------------------------------------------------
	public String partYear(String year) {
		connection();
		int i = 1; 
//		String sql = "select * from member where id= ' "+ dto.getId() + " '  and pw = '" + dto.getPw()+"'";
		String sql = "";
		String str = "" ; 
		switch (year) {
		case "00":
			sql = "select nick , year00 , top00 from member  order by year00 desc";
			
			break;
		case "10":
			sql = "select nick , year10 , top10 from member  order by year10 desc";
			
			break;
		case "20":
			sql = "select nick , year20 , top20 from member  order by year20 desc";
			
			break;

		default:
			return "잘못된 접근입니다.";
			
		}
		try {
			prep = conn.prepareStatement(sql);
			//전송
			rs = prep.executeQuery();
			while(rs.next()) {
//				str += "id : " + rs.getString(1) + " pw : " + rs.getString(2) +  " name : " + rs.getString(3) +  " age : " + rs.getInt(4) + "\n"; 
				//f 포맷팅 %d %s %f %o %x
				str += String.format(i+". NickName : %20s\tGrade : %20d\t\tdate : %s %s\n", rs.getString(1), rs.getInt(2),rs.getDate(3),rs.getTime(3));
//				str += String.format(i+". %20s\t%20d\n", rs.getString(1), rs.getInt(2));
				i++;
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("데이터를 보낼 수 없습니다.");
		} finally {
			disconnection();
		}
		return str;
		
	}
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------회원탈퇴-------------------------------------------------------------------------------------------------------------------------------
	
	public boolean deleteDB(UserDTO dto) {
		
		connection();
		String sql = "delete from member where id =? and pw = ?";
		try {
			prep = conn.prepareStatement(sql);
			prep.setString(1, dto.getId());
			prep.setString(2, dto.getPw());
			
			int cnt = prep.executeUpdate();
			if(cnt > 0) {
				result = true ;
			} else {
				result =  false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("데이터를 보낼 수 없습니다.");
		} finally {
			disconnection();
		}
		
		return result;
		
	}
	
	
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	private void connection() {

		try {
			// jdbc연결

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 데이터베이스 연결
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String url = "jdbc:oracle:thin:@project-db-stu3.ddns.net:1525:xe";
			String db_id = "campus_b_0203_2";
			String db_pw = "smhrd2";
			conn = DriverManager.getConnection(url, db_id, db_pw);
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이브를 찾을 수 없습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("데이터베이스를 열 수 없습니다.");
		}
	}

	private void disconnection() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (prep != null) {
				prep.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
