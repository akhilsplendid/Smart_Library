import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.model.Filters;
//import com.mongodb.client.model.Updates;

@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
 DBCursor cursor;
 DBCollection myCollection1;
 final String URI = "mongodb://localhost:27017";
 ArrayList<String> list1 = new ArrayList<>();
	ArrayList<String> list2= new ArrayList<>();
	ArrayList<String> list3= new ArrayList<>();
	ArrayList<String> list4= new ArrayList<>();
	ArrayList<String> list5= new ArrayList<>();
	ArrayList<String> list6= new ArrayList<>();
	ArrayList<String> list7= new ArrayList<>();
    public Edit() {
        super();
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rn = request.getParameter("Roll Number");
		String pn = request.getParameter("Phone Number");
		String Em = request.getParameter("Email ID");
		String pw = request.getParameter("password");
		PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        out.println("<html><head>");
		
		try {
			MongoClientURI connection = new MongoClientURI(URI);
			@SuppressWarnings("resource")
			MongoClient mongo = new MongoClient(connection);
			@SuppressWarnings("deprecation")
			DB db = mongo.getDB("Smart_Library");
		 myCollection1 = db.getCollection("USER");
		    this.cursor= myCollection1.find();
		   
		    		 
		}
		catch(Exception e)
		{
			this.cursor=null;
			
		}	
		
		 while(cursor.hasNext())
			{
				cursor.next();
				this.list1.add((String) cursor.curr().get("First Name"));
				this.list2.add((String) cursor.curr().get("Last Name"));
				this.list3.add((String) cursor.curr().get("Roll No"));
				this.list4.add((String) cursor.curr().get("EmailID"));
				this.list5.add((String) cursor.curr().get("Phone Number"));	
				this.list6.add((String) cursor.curr().get("PASSWORD"));
				this.list7.add((String)cursor.curr().get("Imagename"));
				
				
			}
		 

		 for(int i=0;i<list3.size();i++) {
			 if(list3.get(i).contentEquals(rn) && list6.get(i).contentEquals(pw)) {
				 BasicDBObject searchQuery = new BasicDBObject("Roll No",list3.get(i));
				 BasicDBObject updateFields = new BasicDBObject();
				 updateFields.append("Phone Number",pn);
				 updateFields.append("EmailID",Em);
				 BasicDBObject setQuery = new BasicDBObject();
				 setQuery.append("$set", updateFields);
				 myCollection1.update(searchQuery, setQuery);
				 RequestDispatcher rd1 = request.getRequestDispatcher("Login.jsp");
					rd1.forward(request,response);
		 }
			 else
			 {
				 if(list6.get(i)!=pw) {
				 out.print("<script language=\"JavaScript\">");
				 out.println("alert('Invalid Email id or Password');");
				 //out.println("return false;");
				 out.println("</script>");
				 }
			 }
		 }
		
			out.println("</body>\r\n"
					+ "</html>");
	}
	

}
