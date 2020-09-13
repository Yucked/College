import java.io.*;

public class MyServerMain {
	public static void main(String[] args)  throws IOException {
		int ip = 16790;
		for (int i = 0; i < 10; i++) {
			new MyServer(ip++).start();
		}
	}
}
