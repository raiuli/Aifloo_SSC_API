package se.ltu.pmc.aifloow.ssc;

import java.io.IOException;
import java.sql.Timestamp;



public class MainApp {

	public static void main(String[] args) {
		
		//IP address and URL to send data to SmartCity Control Center 
		String ipaddress="";
		String updateUrl="http://"+ipaddress+"/v1/updateContext";
		
		//Initialize variables
		int user_id=1;
		Timestamp timestamp= new Timestamp(System.currentTimeMillis());
		String location="A301223";
		int steps=20;
		double activity_std=2.5;
		
		//Initialize SmartCity Control Center API with the variables
		SSCAPI sscspi= new SSCAPI(user_id,timestamp,location,steps,activity_std);
		
		
		//Sending Update Request to SmartCity Control Center and getting response back
		HttpHandler httpHandler = new HttpHandler();
		String response="";
		try {
			response=httpHandler.sendrequest(updateUrl,sscspi.create_request());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("<-------------Response = "+response);

	}

}
