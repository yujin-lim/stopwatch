package stopwatch;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;

public class Timer implements Runnable{

	private boolean isRun = true;

	private int sec;

	private StringBuffer buffer = new StringBuffer();

	private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

	@Override
	public void run() {
		while (isRun) {

			if (InputManager.getInput().equals("q"))
				isRun = false;

			else if (InputManager.getInput().equals("h")) {
				buffer.setLength(0);
				buffer.append(sdf.format(System.currentTimeMillis()));
				buffer.append(String.format(" {%3d}\n", ++sec));

				try {
					writer.append(buffer);
					writer.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}

			buffer.setLength(0);
			buffer.append(String.format(">>>%d분%d초 소요됨", sec / 60, sec % 60));
			try {
				writer.append(buffer);
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
