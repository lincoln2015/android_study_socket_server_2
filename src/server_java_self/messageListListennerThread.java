package server_java_self;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class messageListListennerThread extends Thread {
	private ArrayList<messageItem> msgList;

	public messageListListennerThread(ArrayList<messageItem> msgList) {
		// TODO Auto-generated constructor stub
		
		// init mesglist 
		this.msgList = msgList;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
		messageItem msgItem = null;
		
		// listen the msglist updte , send msg to client when msglist size > 0
		
		while (!msgList.isEmpty())
		{
			msgItem = msgList.get(0);
		
			try {
				OutputStream  ou = msgItem.getSocket().getOutputStream();
				ou.write(msgItem.getDate().getBytes());
				ou.flush();
				
				ou.close();
				
				msgItem.getSocket().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	

	

}
