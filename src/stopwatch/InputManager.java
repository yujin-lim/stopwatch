package stopwatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputManager implements Runnable {

	private boolean isRun = true;
	
	private StringBuffer buffer = new StringBuffer();
	
	private BufferedReader reader = new  BufferedReader(new InputStreamReader(System.in));
	
	
	private static String input = "";
	
	public static String getInput() {
		return input;
	}
	
	@Override
	public void run() {
		
		while(isRun) {
			try {
				buffer.setLength(0);
				buffer.append(reader.readLine());
				
				input = buffer.toString();
				
				if(input .equals("q"))
					isRun = false;
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}

