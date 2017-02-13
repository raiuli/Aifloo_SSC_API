package se.ltu.pmc.aifloow.ssc;

import java.sql.Timestamp;

public class SSCAPI {
	int user_id;
	Timestamp timestamp;
	String location;
	int steps;
	double activity_std;
	String updateRequest_1="";
	public SSCAPI(int user_id, Timestamp timestamp, String location, int steps, double activity_std) {
		super();
		this.user_id = user_id;
		this.timestamp = timestamp;
		this.location = location;
		this.steps = steps;
		this.activity_std = activity_std;
		
	}
	
	public String create_request(){
		
		updateRequest_1="{"
				+"\"contextElements\": ["
				+ "{\"type\": \"Gateway\",\"isPattern\": \"false\",\"id\": \"Aiiflow_testGW01\","
				+"\"attributes\": ["
	                +"{\"name\": \"User_id\", \"type\": \"integer\", \"value\": \""+user_id+"\"},"
	                +"{\"name\": \"timestamp\", \"type\": \"ISO8601\",\"value\": \""+timestamp+"\"},"
	                +"{\"name\": \"location\",\"type\": \"string\",\"value\": \""+location+"\"},"
	                +"{\"name\": \"steps\",\"type\": \"integer\",\"value\": \""+steps+"\"},"
	                +"{ \"name\": \"activity_std\",\"type\": \"float\",\"value\": \""+activity_std+"\" }"
	           +" ]}],"     
	           +"\"updateAction\": \"APPEND\"} ";
		return updateRequest_1;
	}
}
