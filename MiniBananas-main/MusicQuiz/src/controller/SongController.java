package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javazoom.jl.player.MP3Player;
import model.SongDTO;

public class SongController {
	Random rd = new Random();
	private int n = 0;
	private SongDTO dto = null;
	private ArrayList<SongDTO> songList = new ArrayList<SongDTO>();

	private MP3Player mp3 = new MP3Player();

	int[] arr =	makeRandomArray(4);
	
	public int[] makeRandomArray(int a) {
		int[] arr = new int[a];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(a);
			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					i--;
				}
			}
		}
		return arr;
	}

	public SongController(String infoFilePath) {
		File infoFile = new File(infoFilePath);
		try {
			Scanner sc = new Scanner(infoFile);

			while (sc.hasNext()) {
				String songInfo = sc.nextLine();
				String[] arr = songInfo.split(",");
				SongDTO dto = new SongDTO(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3]);
				songList.add(dto);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일 경로를 확인하세요.");
			e.printStackTrace();
		}

		// -------------재생/멈춤
	}

	public SongDTO play() {
		SongDTO m = songList.get(arr[n]);
		playMusic(m);
		return m;
	}

	public void stop() {
		if (mp3.isPlaying()) {
			mp3.stop();
		}
	}
	// ----------점수

	public int checkAnswer() {
		int point = 0;
		int cnt = 3;

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println();
			System.out.print("노래 제목을 입력해주세요 >> ");
			String answer = sc.nextLine();
			answer = answer.trim().replaceAll(" ", "");
			String str = songList.get(arr[n]).getTitle();
			str = str.trim().replaceAll(" ", "");
			if (str.equals(answer)) {
				point += 5 + cnt;
				System.out.println();
				System.out.println("정답입니다!!");
				System.out.println("◆◆◆"+songList.get(arr[n]).getSinger()+"의 '"+songList.get(arr[n]).getTitle()+"'입니다.◆◆◆");
				System.out.println();
				stop();
				if(n<=2) {
					n++;
				}
				break;
			} else {
				System.out.println();
				System.out.println("땡 틀렸습니다~");
				
				cnt--;
				if (cnt == 0) {
					System.out.println();
					System.out.println("기회를 모두 소진하셨습니다!");
					System.out.println("◆◆◆정답은 "+songList.get(arr[n]).getSinger()+"의 '"+songList.get(arr[n]).getTitle()+"'입니다.◆◆◆");
					System.out.println();
					stop();
					if(n<=2) {
						n++;
					}
					break;
				}
				continue;
			}

		}
		return point;

	}

	// -------------정답, 노래 정보 불러오기

	public String getSongInfo() {

		songList.get(n).getTitle();
		return songList.get(n).getTitle() + songList.get(n).getSinger();

	}

	private void playMusic(SongDTO m) {
		if (mp3.isPlaying()) {
			mp3.stop();
		}
		mp3.play(m.getFilePath()); // 음원경로
	}

}
