import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class SMS {
	     public static void sendOTP(String number)
	    {
		try {
		System.out.println(number);
		String sendId="TXTIND";
		String language="english";
		String route="v3";
		System.out.println("prgm Satrted.........");
		String apikey="sXF3RaDkA4MT0Pl2x6vtJGVNncrdbIiQHLUw9KmWqu5SOojfBZ9zSUeWBru5VAFd7aC0hIZTqJYfjtHg";
		//Values mb= new Values();
		//String number=mb.getPhone_Number();
		String message="Your Scheduled meeting is Cancelled.Please contact TeamHead of the Office and make your meeting Re-Scheduled.Thank you!!";
		
		message = URLEncoder.encode(message,"UTF-8");
		
		String myURL="https://www.fast2sms.com/dev/bulkV2?authorization="+apikey+"&sender_id="+sendId+"&message="+message+"&language="+language+"&route="+route+"&numbers="+number;
		URL url = new URL(myURL);
		HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setRequestProperty("cache-control", "no-cache");
		System.out.println("wait....");
		int responseCode = con.getResponseCode();
		System.out.println("Response Code :"+responseCode);
		StringBuffer response = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		while(true)
		{
			String line = br.readLine();
			if(line==null)
			{
				break;
				
			}
			response.append(line);
		}
		System.out.println(response);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}	

}
