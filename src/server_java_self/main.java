package server_java_self;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Socket socket =null;
		ArrayList<messageItem> msgList = new ArrayList<messageItem>();
		
		
		System.out.print("\n server start :");
		
		ServerSocket serSocket = new ServerSocket(30000);
		
				
		// start sendmsg thread
		//new messageListListennerThread(msgList).start();
		
		// wait for clents to connet
		while (true)
		{
			socket = serSocket.accept() ;
			// start recvmsg thread
			new recvMsgThread(socket,msgList).start();
		}
		
	
	

	}

}
