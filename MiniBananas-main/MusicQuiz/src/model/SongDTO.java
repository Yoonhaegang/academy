package model;

public class SongDTO {

	private int num;
	private String title;
	private String singer;
	private String FilePath;
	
	
	public SongDTO(int num, String singer, String title, String FilePath){
		super();
		this.num = num;
		this.singer = singer;
		this.title = title;
		this.FilePath = FilePath;
	}
	
	public SongDTO(int num) {
		super();
		this.num = num;
	}

	
	public int getNum() {
		return num;
	}
	public String getTitle() {
		return title;
	}
	public String getSinger() {
		return singer;
	}
	public String getFilePath() {
		return FilePath;
	}
	
	
	
}
