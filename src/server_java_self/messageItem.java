package server_java_self;

import java.net.Socket;

public class messageItem {
	public messageItem() {
		
	}

	private int port;
	private String  ipFrom;
	private String ipTo;
	private String date;
	
	Socket socket;
	
	
	public String getDate()
	{
		return date;
	}
	
	public Socket getSocket()
	{
		return socket;
	}
	
	
	public  void setDate(String data)
	{
		this.date = data;
	}
	
	public void setSocket(Socket socket)
	{
		this.socket = socket;
	}
	

}
