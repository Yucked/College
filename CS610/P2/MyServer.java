import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;

public class MyServer {
	public static void main(String[] args)  throws IOException {
		Scanner scanner = new Scanner(System.in);
		try {			
			ServerSocket server = new ServerSocket(5000);
			Socket client = server.accept();

			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
			writer.println("Hello!!");

			String clientMsg = "";
			do {				
				clientMsg = reader.readLine();
				if (clientMsg.length() != 0) {
					System.out.println(clientMsg);
				}

				if (clientMsg.equalsIgnoreCase("bye")) {
					break;
				}

				System.out.print("Enter a line for the server: ");
				String message = scanner.nextLine();
				writer.println(message);
			} while (!clientMsg.equalsIgnoreCase("bye"));

			server.close();
			scanner.close();
		}
		catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		}
	}
}
