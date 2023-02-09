package view;

import java.util.Scanner;

import controller.SongController;
import controller.UserController;
import model.UserDAO;
import model.UserDTO;
import view.Color;

public class Main {
	static void clearConsole() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
	}

	public static void main(String[] args) {
		boolean check1 = true;
		boolean loop1 = true;
		boolean loop2 = true;
		Scanner sc = new Scanner(System.in);
		UserController userController = new UserController();

		Color color = new Color();
		Image image = new Image();
//        System.out.println(color.getFONT_BLACK() + "안녕하세요 !!!" + color.getRESET());
		image.musicQuiz();
		System.out.println();
		String inputId = null;
		int choice = 0;

		while (loop1) {
			// 회원가입과
			// 로그인-----------------------------------------------------------------------------------------------------------
			System.out.println();
			System.out.println("[1]회원 가입 [2]로그인 [3]회원 탈퇴");
			System.out.print("번호를 입력해주세요 >> ");
			choice = sc.nextInt();
			if (choice == 1) {
				// 회원가입
				System.out.println();
				System.out.print("사용할 아이디 : ");
				inputId = sc.next();
				System.out.print("사용할 비밀번호 : ");
				String inputPw = sc.next();
				System.out.print("이름 : ");
				String inputName = sc.next();
				System.out.print("사용할 닉네임 : ");
				String inputNickname = sc.next();
				System.out.println(userController.InsertCon(inputId, inputPw, inputName, inputNickname));
				System.out.println();
				clearConsole();
				continue;
			} else if (choice == 2) {
				// 로그인
				System.out.println();
				System.out.print("아이디를 입력해주세요 : ");

				inputId = sc.next();
				System.out.print("비밀번호를 입력해주세요 : ");
				String inputPw = sc.next();
				userController.LoginCon(inputId, inputPw);
				if (userController.LoginCon(inputId, inputPw)) {
					System.out.println("로그인 성공");
					loop2 = true;
				} else {
					System.out.println("로그인 실패");
					continue;
				}
				clearConsole();
			} else if (choice == 3) {
				System.out.println();
				System.out.print("탈퇴할 아이디를 입력해주세요 : ");
				inputId = sc.next();
				System.out.print("탈퇴할 비밀번호를 입력해주세요 : ");
				String inputPw = sc.next();

				if (userController.LoginCon(inputId, inputPw)) {
					userController.DeleteCon();
					System.out.println("회원 탈퇴 성공");
				} else {
					System.out.println("ID를 찾을 수 없습니다.");
				}
				System.out.println();
				clearConsole();
				continue;

			} else {
				System.out.println(color.getFONT_RED() + "잘못 입력하셨습니다" + color.getRESET() + " 다시 입력해주세요");
				System.out.println();
				continue;
			}

			while (loop2) {
				SongController musicPlayer00 = new SongController(
						"C:\\Users\\user\\git\\MiniBananas\\MusicQuiz\\src\\music\\song00to09\\song00to09.txt");
				SongController musicPlayer10 = new SongController(
						"C:\\Users\\user\\git\\MiniBananas\\MusicQuiz\\src\\music\\song10to19\\song10to19.txt");
				SongController musicPlayer20 = new SongController(
						"C:\\Users\\user\\git\\MiniBananas\\MusicQuiz\\src\\music\\song20to23\\song20to23.txt");
				if (userController.successLogin == true) { // 로그인 성공일 때만 실행
					System.out.println();
					System.out.print("[1]회원 정보 수정 [2]게임 시작 [3]게임 설명 >> ");
					choice = sc.nextInt();
					if (choice == 1) {
						System.out.println();
						System.out.print("[1]비밀번호 변경 [2]이름 변경 [3]닉네임 변경");
						choice = sc.nextInt();
						System.out.println();
						if (choice == 1) {
							System.out.print("변경할 비밀번호를 누르세요 ");
							String changePw = sc.next();
							System.out.println(userController.UpdateConPw(changePw));
						} else if (choice == 2) {
							System.out.print("변경할 이름을 입력하세요");
							String changeName = sc.next();
							userController.UpdateConName(changeName);

						} else if (choice == 3) {
							System.out.print("변경할 닉네임을 입력하세요");
							String changeNick = sc.next();
							userController.UpdateConNick(changeNick);
						} else {
							continue;
						}
					} else if (choice == 3) { // 게임설명
						System.out.println();
						System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
						System.out.println("1. 문제는 난이도 별로 4문제씩 출제됩니다.");
						System.out.println("2. 각 문제별로 3번의 기회가 주어집니다.");
						System.out.println("3. 노래는 10초간 재생됩니다.");
						System.out.println("4. 3번안에 정답을 맞히거나 기회를 모두 소진하면 다음 노래로 넘어갑니다.");
						System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
					} else if (choice == 2) { // 게임시작

						// 난이도
						// 설정-----------------------------------------------------------------------------------------------------------
						System.out.println();
						System.out.println("난이도를 선택해주세요");
						System.out.print("[1]EASY [2]NORMAL [3]HARD >>");
						choice = sc.nextInt();
						String year = null;
						int grade = 0;
						int count = 0;
						if (choice == 1) { // 연도 2020
							image.easyMode();
							System.out.println();
							while (count < 4) {
								musicPlayer20.play();
								year = "20";
								grade += musicPlayer20.checkAnswer();
								count++;
							}

						} else if (choice == 2) { // 2010
							image.normalMode();
							System.out.println();
							while (count < 4) {
								musicPlayer10.play();
								year = "10";
								grade += musicPlayer10.checkAnswer() * 2;
								count++;
							}

						} else if (choice == 3) { // 2000
							image.hardMode();
							System.out.println();
							while (count < 4) {
								musicPlayer00.play();
								year = "00";
								grade += musicPlayer00.checkAnswer() * 3;
								count++;
							}

						} else {
							System.out.println(color.getFONT_RED() + "잘못 입력하셨습니다" + color.getRESET() + " 다시 입력해주세요");
							continue;
						}

						// 접수집계 및
						System.out.println();
						System.out.println("총 점수는 : " + grade + "입니다.");
						System.out.println();
						System.out.println(
								"★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★당신이 플레이한 난이도 랭킹★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
						userController.updateGrade(grade, year);
						System.out.println(userController.SelectCon(choice + 2));
						System.out.println(
								"★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
						// 랭킹-----------------------------------------------------------------------------------------------------------
						while (true) {
							System.out.println();
							System.out.println("조회할 랭킹을 선택해주세요");
							System.out.print("[1]전체 랭킹 [2]내 점수 보기 [3]이지모드 랭킹 [4]노말모드 랭킹 [5]하드모드 랭킹 [6]랭킹 보기 종료 >>");
							choice = sc.nextInt();
							if (choice == 6) {
								break;
							}
							image.ranking();
							System.out.println();
							System.out.println(
									"★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★ R A N K I N G ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
							System.out.println(userController.SelectCon(choice));
							System.out.println(
									"★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
						}
						// ----------------------------------------------------------------------------------------------------------------
						System.out.println();
						System.out.println("다음 메뉴 중 선택해 주세요.");
						System.out.print("[1]메인 메뉴 [2]로그아웃 [3]게임 종료 >>");
						choice = sc.nextInt();
						if (choice == 1) {

						} else if (choice == 2) {
							System.out.println("");
							loop2 = false;
						} else if (choice == 3) {
							System.out.println("게임을 종료합니다.");
							loop1 = false;
							loop2 = false;
						} else {
							System.out.println("메인 메뉴로 돌아갑니다.");
							continue;
						}

					}
				}
			}

		}

	}

}
