package hiveapp;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class App {
	String url;
	
	public App() {
		
	}
	public void getData() {
		for(int i=1;i<100;i++) {
			Random r = new Random();
			double speed = r.nextInt(200);
			
			CarStatus cstatus = new CarStatus("car01", speed, 24, 90, 1500);
			
			try {
				sendData(cstatus);
				System.out.println("Send Data .... "+speed);
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
	public void sendData(CarStatus cstatus) throws Exception {
			url = "http://127.0.0.1/hive/carstatus.mc";
			url += "?id="+cstatus.getId()+"&speed="+cstatus.getSpeed()+"&temp="+cstatus.getTemp()+
						"&oiltemp="+cstatus.getOiltemp()+"&rpm="+cstatus.getRpm();
				
			System.out.println(url);
			
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
		App app = new App();
		app.getData();
	}

}
