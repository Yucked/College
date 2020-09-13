import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		try {
			Socket client = new Socket("0.0.0.0", 5000);

			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
			
			String message = "";
			do {
				String serverMsg = reader.readLine();
				if (serverMsg.length() != 0 ) {
					System.out.println(serverMsg);
				}

				System.out.print("Enter a line or bye to quit for the client: ");
				message = scanner.nextLine();
				writer.println(message);
			}while(!message.equalsIgnoreCase("bye"));

			scanner.close();
			client.close();
		}
		catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		}
	}
}
