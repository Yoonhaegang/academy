package controller;


import model.UserDTO;
import model.UserDAO;

public class UserController {
	
		private UserDTO dto = null;
		private UserDAO dao = new UserDAO();
		public boolean successLogin = false;
		
	
	//=============================== 회원가입==========================================================
		public String InsertCon(String id, String pw, String name, String nickName) {
			dto = new UserDTO(id, pw, name, nickName);
			int cnt = dao.insert(dto);
			
			if(cnt>0) {
				return "회원가입 성공";
			} else if (cnt == -1){
				return "이미 존재하는 ID입니다.";
			}
			else {
				return "회원가입 실패";
			}
			
		}
	//=================================================================================================

	// ===================================로그인==========================================================
		public boolean LoginCon(String id, String pw) {
			dto = new UserDTO(id, pw);
			boolean result = dao.logIn(dto);
			
			return successLogin = result;
		}
	//====================================================================================================
		//======================================-로그인이 되었다는 가정하에 진행되는 프로세스==================================================
		// 회원수정 - pw
		public String UpdateConPw(String pw) {
			int cnt = dao.updatePw(this.dto,pw);
				
			if(cnt>0) {
				return "정보수정 성공";
			}else {
				return "정보수정 실패";
			}
		}
		// 회원수정 - name
		public String UpdateConName(String name) {
			int cnt = dao.updateName(this.dto,name);
			
			if(cnt>0) {
				return "정보수정 성공";
			}else {
				return "정보수정 실패";
			}
		}
		// 회원수정 - nickName
		public String UpdateConNick(String nickName) {
			int cnt = dao.updateNickName(this.dto,nickName);
			
			if(cnt>0) {
				return "정보수정 성공";
			}else {
				return "정보수정 실패";
			}
		}
		//================================================================================================
		// =========================id에 따른 총합 랭킹을 출력하는 메소드 =========================================
		public String SelectCon(int choice) {
			//--------------전체조회(년도별 점수 총합 랭킹)-------------------------
			if(choice == 1) {
				return dao.allOut();
			}
			//--------------선택조회(ID조회를 본인 난이도별 최고점 및 최고점 달성 시간-------
			else if(choice == 2 ) {
				return dao.partId(dto);
			}
			//--------------선택조회(00년도 선택을 년도별 랭킹 종 출력)--------------------
			else if(choice == 3) {
				return dao.partYear("20");
			}
			//--------------선택조회(10년도 선택을 년도별 랭킹 종 출력)--------------------
			else if(choice == 4) {
				return dao.partYear("10");
			}
			//--------------선택조회(20년도 선택을 년도별 랭킹 종 출력)--------------------
			else if(choice == 5) {
				return dao.partYear("00");
			}else if(choice == 6) {
				return "랭킹 보기를 종료합니다.";
			}
			else {
				return "잘못된 접근입니다.";
			}
		}
		//------------------최고점 갱신하는 경우 점수 갱신하는 메소드-------------------------------------
		public void updateGrade(int grade, String year) {
			int beforeGrade = dao.partYearGrade(year,dto);
			if(beforeGrade <= grade) {
				switch (year) {
				case "00":
					dao.updateGrade00(dto,grade);
					break;
				case "10":
					dao.updateGrade10(dto,grade);
					break;
				case "20":
					dao.updateGrade20(dto,grade);					
					break;
				default:
					break;
				}
			}
		}
		//---------------------------------------------------------------------------------------
		//======================================= 회원탈퇴========================================================
		public String DeleteCon() {
			// dto = new MemberDTO(id); id 하나이기에 굳이 dto에서 가져올 필요없음
			boolean result = dao.deleteDB(this.dto);
			
			if(result) {
				return "회원탈퇴 성공";
			}else {
				return "회원탈퇴 실패";
			}
		}
		//=========================================================================================================
	
	//===============================================================================================================
	
	
}
