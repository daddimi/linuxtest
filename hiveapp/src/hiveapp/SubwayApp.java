package hiveapp;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class SubwayApp {
	String url;
	
	public SubwayApp() {
		
	}
	public void getData() {
		for(int i=1;i<100;i++) {
			Random r1 = new Random();
			int line = r1.nextInt(9)+1;
		
			Random r2 = new Random();
			int passenger = r2.nextInt(300);
			
			SubwayPassenger sp = new SubwayPassenger("metro", line, passenger);
			
			try {
				sendData(sp);
				System.out.println(line+"호선"+","+"승객"+passenger+"명 탑승");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void sendData(SubwayPassenger sp) throws Exception {
			url = "http://192.168.111.130/hive/subwaypassenger.mc";
			url += "?id="+sp.getId()+"&line="+sp.getLine()+"&passenger="+sp.getPassenger();
			
			URL curl = new URL(url);
				HttpURLConnection con = 
				(HttpURLConnection)curl.openConnection();
			try{
				con.getInputStream();
				con.setReadTimeout(5000);
				con.setRequestMethod("POST");
			} catch(Exception e) {
			} finally {
				con.disconnect();
			}
	}
	public static void main(String[] args) {
		SubwayApp app = new SubwayApp();
		app.getData();
	}

}
