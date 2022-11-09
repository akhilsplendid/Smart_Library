

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
@WebServlet("/book_entry")
public class book_entry extends HttpServlet {
	ArrayList<String> list1 = new ArrayList<>();
	DBCursor cursor;
	private static final long serialVersionUID = 1L;
    public book_entry() {
        super();
      
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        out.println("<html><head>");
		try {
			MongoClient mongo = new MongoClient( "localhost" , 27017 );
			 DB database = mongo.getDB("Smart_Library");
			 DBCollection myCollection = database.getCollection("BOOKS");
			DBCollection myCollection1 = database.getCollection("BOOKS1");
			this.cursor= myCollection.find();
		   		 
			 while(cursor.hasNext())
				{
					cursor.next();
					this.list1.add((String) cursor.curr().get("Book ID"));
				}
		String rn = request.getParameter("Roll Number");
		String bn = request.getParameter("Book Name");
		String bd = request.getParameter("Book ID");
		String id = request.getParameter("Issue Date");
		String rd = request.getParameter("Return Date");
		System.out.println("The book id is................"+bd);
		System.out.println("The list1 values are......."+list1);
		
		if(list1.contains(bd)) {
	
			 out.print("<script language=\"JavaScript\">");
			 out.println("alert('Duplicate Book ID')");
			 out.println("location='Admin.jsp';"); 
			 out.println("</script>");
		}
		else {
			BasicDBObject document = new BasicDBObject();
			document.put("Roll Number",rn);
			document.put("Book Name", bn);
			document.put("Book ID",bd);
			document.put("Issue Date", id);
			document.put("Return Date",rd);
		myCollection.insert(document);
		myCollection1.insert(document);
		out.print("<script language=\"JavaScript\">");
		 out.println("alert('Sucessfully Regisered')");
		 out.println("location='Admin.jsp';"); 
		 out.println("</script>");
	
		}

			
		
		list1.clear();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		out.println("</body>\r\n"
				+ "</html>");
		
	}

}
