import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public final class MyClient extends Thread{
	private final int port;

	public MyClient(int port){
		this.port = port;
	}

	@Override
	public final void start(){
		try {			
			Thread thread = new Thread(new Runnable(){
				@Override
				public void run(){
					try {	
						handleSocket();
					}
					catch(Exception exception){
						System.out.println(exception);
					}
				}
			});

			thread.start();
		}catch(Exception exception){
			System.out.println(exception);
		}		
	}

	private final void handleSocket() throws Exception{
		Socket client = new Socket("0.0.0.0", port);
		Scanner scanner = new Scanner(System.in);
		
		InputStreamReader inputStream = new InputStreamReader(client.getInputStream());
		BufferedReader reader = new BufferedReader(inputStream);
		PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
				
		do {
			String input = scanner.nextLine();
			writer.println(input);

			String msg = reader.readLine();
			if (msg == null){
				Thread.sleep(100);
				continue;
			}

			System.out.printf("%s + 2 is: %s\n", input, msg);
			client.close();
			break;
		}while(client.isConnected());

		scanner.close();
	}
}