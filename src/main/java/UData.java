

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@WebServlet("/UData")
public class UData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final String URI = "mongodb://localhost:27017";
	 DBCursor cursor;
	 DBCollection myCollection3;
		DBCursor cursores;
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2= new ArrayList<>();
		ArrayList<String> list3= new ArrayList<>();
		ArrayList<String> list4= new ArrayList<>();
		ArrayList<String> list5= new ArrayList<>();
		ArrayList<String> list6= new ArrayList<>();
		ArrayList<String> list7= new ArrayList<>();
        
    public UData() {
        super();
    }

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();  
		
        response.setContentType("text/html");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>");
        out.println("Smart Library");
        out.println("</title>");
        out.println("<link rel =icon href = SL.jpg type = image/x-icon>");
      
		out.print("<style>");
		out.println("h1{\r\n"
				+ "font-size:30px;\r\n"
				+ "padding:7px;\r\n"
				+ "border-radius:40px 0px 0px 40px;\r\n"
				+ "margin-top:10px;\r\n"
				+ "color:White;\r\n"
				+ "text-align:center;\r\n"
				+ "background:rgba(0,0,0,0.7);\r\n"
				+ "\r\n"
				+ "}");
		out.println("table {\r\n"
        		+ "  font-family: arial, sans-serif;\r\n"
        		+"font-size: 20px;\r\n"
        		+ "  border-collapse: collapse;\r\n"
        		+ "background:rgba(0,0,0,0.7);\r\n"
        		+ "  width: 100%;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "td, th {\r\n"
        		+ "  border: 2px solid #dddddd;\r\n"
        		+ "  text-align: left;\r\n"
        		+ "  padding: 8px;\r\n"
        		+"color:Black;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "tr:nth-child(even) {\r\n"
        		+ "  background:transparent;\r\n"
        		+ "}\r\n");
        		out.println("</style>");
		out.print("</head>");
		out.println("<body>");
		  out.println("<br>");
			
		out.println("<a href=\"Admin.jsp\">Back</a></li>");
		out.println("<h1>User Details</h1>");
		out.println("<table>"
				+ "  <tr>\r\n"
				+ "    <th>Roll No</th>\r\n"
				+ "    <th> Name</th>\r\n"
				+ "    <th>Phone Number</th>\r\n"
				+ "		<th>Email ID</th>\r\n "
				+ "		<th>LateFee</th>\r\n "
				+ " </tr>");
		getConnection();
		result();
		getConnectionss();
		resultes();
		for(int i=0;i<list5.size();i++) {
		    for(int j=0;j<list1.size();j++) {
			if(list5.get(i).contentEquals(list1.get(j))) {
				
				out.println("<tr><td>" +list5.get(i)+ "</td><td>" +list3.get(i)+" "+list4.get(i)  + "</td><td>"+ list6.get(i) + "</td><td>" + list7.get(i)+ "</td><td>"+list2.get(j)+"</td></tr>");
				
			}
//			else
//				out.println("<tr><td>" +list5.get(i)+ "</td><td>" +list3.get(i)+" "+list4.get(i)  + "</td><td>"+ list6.get(i) + "</td><td>" + list7.get(i)+ "</td><td>"+0+"</td></tr>");
			
		}
		}
		
		
		list1.clear();
		list2.clear();
		list3.clear();
		list4.clear();
		list5.clear();
		list6.clear();
		list7.clear();
	}
	public void getConnection()
	{
		try {
			MongoClientURI connection = new MongoClientURI(URI);
			@SuppressWarnings("resource")
			MongoClient mongo = new MongoClient(connection);
			@SuppressWarnings("deprecation")
			DB db = mongo.getDB("Smart_Library");
			DBCollection myCollection1 = db.getCollection("USER");
		    this.cursor= myCollection1.find();
		   
		    		 
		}
		catch(Exception e)
		{
			this.cursor=null;
			
		}	

}
	public void getConnectionss()
	{
		try {
			MongoClientURI connection = new MongoClientURI(URI);
			@SuppressWarnings("resource")
			MongoClient mongo = new MongoClient(connection);
			@SuppressWarnings("deprecation")
			DB db = mongo.getDB("Smart_Library");
			 myCollection3 =  db.getCollection("BOOKR");
		    this.cursores=  myCollection3.find();
		    		 
		}
		catch(Exception e)
		{
			this.cursores=null;
			
			
		}
	}
	public void resultes()
	{
		 while(cursores.hasNext())
			{
				cursores.next();
				this.list1.add((String) cursores.curr().get("Roll Number"));
				this.list2.add((String)cursores.curr().get("LateFee"));
				
				
			}
		    System.out.println("hiii");
	}
	
	public void result()
	{
		 while(cursor.hasNext())
	       {
		    cursor.next();
		    this.list3.add((String) cursor.curr().get("First Name"));			    
		    this.list4.add((String) cursor.curr().get("Last Name"));
		    this.list5.add((String) cursor.curr().get("Roll No"));
		    this.list6.add((String) cursor.curr().get("Phone Number"));
		    this.list7.add((String) cursor.curr().get("EmailID"));
				
				
			}
		    System.out.println("hiii");
	}
}
