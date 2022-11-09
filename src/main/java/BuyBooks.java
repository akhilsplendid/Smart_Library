

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

@WebServlet("/BuyBooks")
public class BuyBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public BuyBooks() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MongoClient mongo = new MongoClient( "localhost" , 27017 );
		 MongoDatabase database = mongo.getDatabase("Smart_Library");
		 MongoCollection myCollection = database.getCollection("BUYB");
		
	   		 
	
	String bn = request.getParameter("Book Name");
	String bd = request.getParameter("Book ID");
	String sd = request.getParameter("Cost");
	
	
	
	Document doc = new Document("Book Name", bn).append("Book ID",bd).append("Cost", sd);
	
	myCollection.insertOne(doc);
	
	RequestDispatcher rd1 = request.getRequestDispatcher("Admin.jsp");
	rd1.forward(request,response);
	}

}
