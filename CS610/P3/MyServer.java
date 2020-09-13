import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;

public final class MyServer extends Thread{
	private final int port;

	public MyServer(int port){
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
					}catch(Exception exception){
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
		ServerSocket server = new ServerSocket(port);
			
		Socket client = server.accept();
		InputStreamReader inputStream = new InputStreamReader(client.getInputStream());
		BufferedReader reader = new BufferedReader(inputStream);
		PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
		
		do {
			String msg = reader.readLine();
			if (msg == null){
				Thread.sleep(100);
				continue;
			}

			writer.println(Integer.valueOf(msg) + 2);
			client.close();
			server.close();
			break;
		}while(client.isConnected());
	}
}
