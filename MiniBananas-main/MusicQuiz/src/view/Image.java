package view;

public class Image {
	Color color = new Color();
	public void musicQuiz() {
		try {
			System.out.print(color.getFONT_YELLOW());
			System.out.println("___  ___                _          _____           _  ");   
            Thread.sleep(300);
            System.out.println("|  \\/  |               (_)        |  _  |         (_)   "); 
            Thread.sleep(300);
            System.out.println("| .  . |  _   _   ___   _    ___  | | | |  _   _   _   ____");
            Thread.sleep(300);
            System.out.println("| |\\/| | | | | | / __| | |  / __| | | | | | | | | | | |_  /");
            Thread.sleep(300);
            System.out.println("| |  | | | |_| | \\__ \\ | | | (__  \\ \\/' / | |_| | | |  / / ");
            Thread.sleep(300);
            System.out.println("\\_|  |_/  \\__,_| |___/ |_|  \\___|  \\_/\\_\\  \\__,_| |_| /___|");
            System.out.print(color.getRESET());
            Thread.sleep(300);
		} catch (InterruptedException e) {
			System.out.println(e);

		}
	}
	
	public void easyMode() {
		try {
			System.out.print(color.getFONT_GREEN());
			System.out.println(" _____    ___    _____  __   __    ___  ___  _____  ______   _____");
			Thread.sleep(300);
			System.out.println("|  ___|  / _ \\  /  ___| \\ \\ / /    |  \\/  | |  _  | |  _  \\ |  ___|");
			Thread.sleep(300);
			System.out.println("| |__   / /_\\ \\ \\ `--.   \\ V /     | .  . | | | | | | | | | | |__ ");
			Thread.sleep(300);
			System.out.println("|  __|  |  _  |  `--. \\   \\ /      | |\\/| | | | | | | | | | |  __| ");
			Thread.sleep(300);
			System.out.println("| |___  | | | | /\\__/ /   | |      | |  | | \\ \\_/ / | |/ /  | |__");
			Thread.sleep(300);
			System.out.println("\\____/  \\_| |_/ \\____/    \\_/      \\_|  |_/  \\___/  |___/   \\____/ ");
			System.out.print(color.getRESET());
			Thread.sleep(300);
		} catch (InterruptedException e) {
			System.out.println(e);

		}
	}

	public void normalMode() {
		try {
			System.out.print(color.getFONT_GREEN());
			System.out.println("  _   _   _____  ______  ___  ___   ___    _         ___  ___  _____  ______   _____ ");
			Thread.sleep(300);
			System.out.println(
					" | \\ | | |  _  | | ___ \\ |  \\/  |  / _ \\  | |        |  \\/  | |  _  | |  _  \\ |  ___|");
			Thread.sleep(300);
			System.out
					.println(" |  \\| | | | | | | |_/ / | .  . | / /_\\ \\ | |        | .  . | | | | | | | | | | |__ ");
			Thread.sleep(300);
			System.out
					.println(" | . ` | | | | | |    /  | |\\/| | |  _  | | |        | |\\/| | | | | | | | | | |  __| ");
			Thread.sleep(300);
			System.out.println(
					" | |\\  | \\ \\_/ / | |\\ \\  | |  | | | | | | | |____    | |  | | \\ \\_/ / | |/ /  | |___ ");
			Thread.sleep(300);
			System.out.println(
					" \\_| \\_/  \\___/  \\_| \\_| \\_|  |_/ \\_| |_/ \\_____/    \\_|  |_/  \\___/  |___/   \\____/ ");
			System.out.print(color.getRESET());
			Thread.sleep(300);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

	public void hardMode() {
		try {
			System.out.print(color.getFONT_RED());
			System.out.println("   _      ___   ______  ______     ___  ___  _____  ______   _____ ");
			Thread.sleep(300);
			System.out.println("| | | |  / _ \\  | ___ \\ |  _  \\    |  \\/  | |  _  | |  _  \\ |  ___|");
			Thread.sleep(300);
			System.out.println("| |_| | / /_\\ \\ | |_/ / | | | |    | .  . | | | | | | | | | | |__  ");
			Thread.sleep(300);
			System.out.println("|  _  | |  _  | |    /  | | | |    | |\\/| | | | | | | | | | |  __| ");
			Thread.sleep(300);
			System.out.println("| | | | | | | | | |\\ \\  | |/ /     | |  | | \\ \\_/ / | |/ /  | |___ ");
			Thread.sleep(300);
			System.out.println("\\_| |_/ \\_| |_/ \\_| \\_| |___/      \\_|  |_/  \\___/  |___/   \\____/ ");
			Thread.sleep(300);
			System.out.print(color.getRESET());
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
	
	public void ranking() {
		try {
			System.out.print(color.getFONT_YELLOW());
			System.out.println("______     ___     _   _    _   __   _____    _   _    _____ ");
    		Thread.sleep(300);
    		System.out.println("| ___ \\   / _ \\   | \\ | |  | | / /  |_   _|  | \\ | |  |  __ \\");
    		Thread.sleep(300);
    		System.out.println("| |_/ /  / /_\\ \\  |  \\| |  | |/ /     | |    |  \\| |  | |  \\/");
    		Thread.sleep(300);
    		System.out.println("|    /   |  _  |  | . ` |  |    \\     | |    | . ` |  | | __ ");
    		Thread.sleep(300);
    		System.out.println("| |\\ \\   | | | |  | |\\  |  | |\\  \\   _| |_   | |\\  |  | |_\\ \\");
    		Thread.sleep(300);
    		System.out.println("\\_| \\_|  \\_| |_/  \\_| \\_/  \\_| \\_/   \\___/   \\_| \\_/   \\____/");
    		Thread.sleep(300);
    		System.out.print(color.getRESET());
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

}
