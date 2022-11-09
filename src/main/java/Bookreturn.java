

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@WebServlet("/Bookreturn")
public class Bookreturn extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Bookreturn() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		MongoClient mongo = new MongoClient( "localhost" , 27017 );
		 MongoDatabase database = mongo.getDatabase("Smart_Library");
		 MongoCollection myCollection = database.getCollection("BOOKR");
		
	   		 
	
	String rn = request.getParameter("Roll Number");
	String bn = request.getParameter("Book Name");
	String bd = request.getParameter("Book ID");
	String sd = request.getParameter("Submit Date");
	
	System.out.println(rn);
	
	Document doc = new Document("Roll Number",rn).append("Book Name", bn).append("Book ID",bd).append("Submit Date", sd).append("LateFee", "chinna");
	
	myCollection.insertOne(doc);
	
	RequestDispatcher rd1 = request.getRequestDispatcher("Admin.jsp");
	rd1.forward(request,response);
		
	}

}
