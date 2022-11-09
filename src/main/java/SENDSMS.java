import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class SENDSMS implements Runnable {

	
	public void run() {
		String rd,rn,rn1,r1,bn2, id1,rd1,ID;
		 DBCursor cursors1;
		 DBCursor cursor;
		 ArrayList<String> list6= new ArrayList<>();
		 ArrayList<String> list7= new ArrayList<>();
		ArrayList<String> list17= new ArrayList<>();
		ArrayList<String> list18= new ArrayList<>();
		ArrayList<String> list19= new ArrayList<>();
		ArrayList<String> list20= new ArrayList<>();
		ArrayList<String> list21= new ArrayList<>();
		
		try {
			MongoClient mongo = new MongoClient( "localhost" , 27017 );
			DB db = mongo.getDB("Smart_Library");
			DBCollection myCollection4 = db.getCollection("BOOKS1");
		    cursors1= myCollection4.find();
		    		 
		}
		catch(Exception e)
		{
			cursors1=null;
			
			
		}

		try {
			MongoClient connection = new MongoClient("localhost" , 27017);
			DB db = connection.getDB("Smart_Library");
			DBCollection myCollection1 = db.getCollection("USER");
		   cursor= myCollection1.find();
		   
		    		 
		}
		catch(Exception e)
		{
			cursor=null;
			
		}	
		
		 while(cursors1.hasNext())
			{
				cursors1.next();
				list17.add((String) cursors1.curr().get("Roll Number"));
				list20.add((String) cursors1.curr().get("Return Date"));
			}
		 while(cursor.hasNext())
			{
				cursor.next();
				
				list6.add((String) cursor.curr().get("Phone Number"));	
				list7.add((String) cursor.curr().get("Roll No"));
				
				
				
			}
		    
		    if((list17.size())!=0) {
				for(int j=0;j<list17.size();j++) {
								rn=list17.get(j);//roll no from user
								rd=list20.get(j);//return date
								 if((list6.size())!=0) {
									 
									 for(int m=0;m<list6.size();m++) {
										 rn1=list6.get(m);// phone number
											rd1=list7.get(m);//roll no from books
					
										   
									 if(rn.contentEquals(rd1)) { 
										 String d1=rd;
										 System.out.println(d1);
										 LocalDate today = LocalDate.now();
										 LocalDate pastDate = LocalDate.parse(d1);
										 LocalDate yesterday = pastDate.minusDays(1);
										 LocalDate yesterday2 = pastDate.minusDays(2);
										 LocalDate actualday = pastDate.minusDays(0);
										 System.out.println(yesterday);
										 System.out.println(yesterday);
										 
										 if(today.isEqual(yesterday2))
										 { 
											 try {
												 
												 String f="0";
													String number=rn1;
													System.out.println("The number is....................."+number);
													String sendId="FTWSMS";
													String language="english";
													String route="q";
													System.out.println("prgm Satrted.........");
													String apikey="iGCzQiqXLN8sEfjoNt6khClA1ti3OosT29KLy5LZZlJ6591Sm5H5n7E4V322";
													//Values mb= new Values();
													//String number=mb.getPhone_Number();
													String message="Your deadline for submitting the book is approaching .Please return the book or else get it renewed within 2 days";
													
													message = URLEncoder.encode(message,"UTF-8");
													String myURL = " https://www.fast2sms.com/dev/bulkV2?authorization="+apikey+"&route="+route+"&message="+message+"&language="+language+"&flash="+f+"&numbers="+number;
													 //https://www.fast2sms.com/dev/bulkV2?authorization=iGCzQiqXLN8sEfjoNt6khClA1ti3OosT29KLy5LZZlJ6591Sm5H5n7E4V322&route=v3&sender_id=FTWSMS&message=&language=english&flash=0&numbers=
													//String myURL = " https://www.fast2sms.com/dev/bulkV2?authorization="+apikey+"&route="+route+"&sender_id="+sendId+"&message="+message+"&language="+language+"&flash="+f+"&numbers="+number;
													//String myURL="https://www.fast2sms.com/dev/bulkV2?authorization="+apikey+"&sender_id="+sendId+"&message="+message+"&language="+language+"&route="+route+"&numbers="+number;
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
	/////********************************************1days*************************************************	
										 else if(today.isEqual(yesterday))
										 { 
											 try {
												 	String f="0";
													String number=rn1;
													String sendId="FTWSMS";
													String language="english";
													String route="q";
													System.out.println("prgm Satrted.........");
													String apikey="iGCzQiqXLN8sEfjoNt6khClA1ti3OosT29KLy5LZZlJ6591Sm5H5n7E4V322";
													//Values mb= new Values();
													//String number=mb.getPhone_Number();
													String message="There is only one day left for submitting the book. Return the book or else get it renewed.";
													
													message = URLEncoder.encode(message,"UTF-8");
													String myURL = " https://www.fast2sms.com/dev/bulkV2?authorization="+apikey+"&route="+route+"&message="+message+"&language="+language+"&flash="+f+"&numbers="+number;
													//String myURL = " https://www.fast2sms.com/dev/bulkV2?authorization="+apikey+"&route="+route+"&sender_id="+sendId+"&message="+message+"&language="+language+"&flash="+f+"&numbers="+number;
													//String myURL="https://www.fast2sms.com/dev/bulkV2?authorization="+apikey+"&sender_id="+sendId+"&message="+message+"&language="+language+"&route="+route+"&numbers="+number;
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
										 
										 
										 
									
   /////********************************************actual day*********************************************
										 
										 else if(today.isEqual(actualday))
										 { 
											 try {
												 System.out.println("The actual day ....................");
												 System.out.println("is........"+actualday);
												 String f="0";
													String number=rn1;
													//String sendId="FTWSMS";
													String language="english";
													String route="q";
													System.out.println("prgm Satrted.........");
													String apikey="iGCzQiqXLN8sEfjoNt6khClA1ti3OosT29KLy5LZZlJ6591Sm5H5n7E4V322";
													//iGCzQiqXLN8sEfjoNt6khClA1ti3OosT29KLy5LZZlJ6591Sm5H5n7E4V322
													//Values mb= new Values();
													//String number=mb.getPhone_Number();
													String message="Today is the last day for submission of the book. Return the book or else get it renewed.If not ,fine of Re.1 will be charged until you return the book.";
													
													message = URLEncoder.encode(message,"UTF-8");
													String myURL = " https://www.fast2sms.com/dev/bulkV2?authorization="+apikey+"&route="+route+"&message="+message+"&language="+language+"&flash="+f+"&numbers="+number;
													//String myURL="https://www.fast2sms.com/dev/bulkV2?authorization="+apikey+"&sender_id="+sendId+"&message="+message+"&language="+language+"&route="+route+"&numbers="+number;
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
	//***********************************************************************************************
										 
										 
										 
									 }
								 	}
								 }
						}
				}
		    }

	}


