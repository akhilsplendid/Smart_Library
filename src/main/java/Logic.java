import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Logic {
	
	final String URI = "mongodb://localhost:27017";
	final String DB ="Smart_Library";
	String COLLECTION;
	MongoCollection<Document> collection;
	
//	public Logic() {
//		super();
//	}
	Logic(String collection)
	{
		this.COLLECTION = collection;
	}
	public Logic() {
		
	}
	public void getConnection()
	{
		try {
			MongoClientURI connection = new MongoClientURI(URI);
			@SuppressWarnings("resource")
			MongoClient mongo = new MongoClient(connection);
			MongoDatabase database = mongo.getDatabase(DB);
			 this.collection = database.getCollection(COLLECTION);
		}
		catch(Exception e)
		{
			this.collection=null;
		}
	}
	
	
public boolean insert(Values mb) 
  {
	System.out.println("HIII");
	getConnection();
	String FN = mb.getFN();
	String LN = mb.getLN();
	String RN = mb.getRN();
	String PN = mb.getPN();
	String EID = mb.getEID();
	String PS = mb.getPS();
	String im = mb.getImageFilename();
	System.out.println(EID);
	Document doc = new Document("First Name",FN).append("Last Name", LN).append("Roll No",RN).append("Phone Number", PN).append("EmailID",EID).append("PASSWORD",PS).append("Imagename", im);
	this.collection.insertOne(doc);
	
	return true;
   
}
public boolean check(Value mb) {
	System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
	String from = mb.getEID();
	String To = mb.getPS();
	//String meeting_Name = mb.getMeeting_Name();
	//double credit_Score = mb.getCredit_Score();
	@SuppressWarnings("resource")
	MongoClient mongoClient = new MongoClient("localhost",27017);
	@SuppressWarnings("deprecation")
	DB db = mongoClient.getDB("Smart_Library");
	DBCollection myCollection = db.getCollection("ADMIN");
    DBCursor cursor = myCollection.find();
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> lists = new ArrayList<String>();// Create an ArrayList object with a string data type
   while(cursor.hasNext())
	{
		cursor.next();
		list.add((String) cursor.curr().get("EmailID"));
		lists.add((String) cursor.curr().get("PASSWORD"));	
	}
	for(int i=0;i<list.size();i++)
	{
		if(list.get(i).contentEquals(from))
		{
			if(lists.get(i).contentEquals(To))
			{
				return true;
			}
		}
	}
	return false;
 }
public boolean checks(Value mb) {
	System.out.println("helooooooooooooooooooooooooooooooooooooooooooooooooooooo");
	System.out.println("Fathimaaaaaaaaaaaaaaaaa");
	String from = mb.getEID();
	String To = mb.getPS();
	//String meeting_Name = mb.getMeeting_Name();
	//double credit_Score = mb.getCredit_Score();
	@SuppressWarnings("resource")
	MongoClient mongoClient = new MongoClient("localhost",27017);
	@SuppressWarnings("deprecation")
	DB db = mongoClient.getDB("Smart_Library");
	DBCollection myCollection = db.getCollection("USER");
    DBCursor cursor = myCollection.find();
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> lists = new ArrayList<String>();// Create an ArrayList object with a string data type
   while(cursor.hasNext())
	{
		cursor.next();
		list.add((String) cursor.curr().get("EmailID"));
		lists.add((String) cursor.curr().get("PASSWORD"));	
	}
	for(int i=0;i<list.size();i++)
	{
		if(list.get(i).contentEquals(from))
		{
			if(lists.get(i).contentEquals(To))
			{
				return true;
			}
		}
	}
	return false;
 }

}
