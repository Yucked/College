import java.io.*;

public class MyClientMain {
	public static void main(String[] args) throws IOException {
		int ip = 16790;
		System.out.println("Enter 10 integers");
		for (int i = 0; i < 10; i++){
			new MyClient(ip++).start();
		}
	}
}
