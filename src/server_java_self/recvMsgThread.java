package server_java_self;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;

public class recvMsgThread extends Thread {
	private Socket socket;
	ArrayList<messageItem> msgList;

	public recvMsgThread() {
		// TODO Auto-generated constructor stub
		// init the interface for server to recv msg from 
	}

	public recvMsgThread(Socket socket,ArrayList<messageItem> msgList) {
		// super(arg0);
		// TODO Auto-generated constructor stub
		this.socket = socket;
		this.msgList = msgList;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// super.run();
		byte[] buffer = null;
		int len;
		String data = null;
		
		
		// recv msg from the give interface and push into the msglist
		try {
			InputStream in =socket.getInputStream();
			
			BufferedInputStream buf = new BufferedInputStream(in); 
			messageItem msgItem = new messageItem();
			msgItem.setSocket(socket);
			
			while ((len =buf.read(buffer, 0,1024)) != -1)
			{
				data =  data + new String(buffer);
			}
			msgItem.setDate(data);
			
			msgList.add(msgItem);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	
}
