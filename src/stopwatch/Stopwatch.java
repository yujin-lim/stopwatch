package stopwatch;

public class Stopwatch {

	private Stopwatch() {}
	
	private static Stopwatch instance = new Stopwatch();
	
	public static Stopwatch getInstance() {
		return instance;
	}
	
	public void run() {
		//멀티스레딩 기능
		//1. 타이머
		Thread timer = new Thread(new Timer());
		timer.start();
		
		//2. 입력
		Thread input = new Thread(new InputManager());
		input.start();
	}
	
	private void printMenu() {
		System.err.println("[q] STOP");
		System.err.println("[h] HOLD");
		System.err.println("[*] RERUN");
	}
	
}
