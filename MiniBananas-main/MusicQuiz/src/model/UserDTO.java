package model;

public class UserDTO {
	// field
	private String id, pw, name;
	private String nickName;

	// 로그인을 위한 생성자
	public UserDTO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	// 회원가입을 위한 생성자
	public UserDTO(String id, String pw, String name, String nickName) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.nickName = nickName;
	}
	public UserDTO(String id) {
		this.id = id;
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public String getNickName() {
		return nickName;
	}

}
