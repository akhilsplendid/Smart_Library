

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

/**
 * Servlet implementation class User1
 */
//@WebServlet("/User1")
@WebServlet(urlPatterns = {"/User1"})
public class User1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final String URI = "mongodb://localhost:27017";
	DBCursor cursor;
	DBCursor cursors;
	DBCursor cursors1;
	DBCollection myCollection3;
	DBCursor cursores;
	MongoCollection<Document> collection;
	int count=0;
	int k=1;
	String r1,bn2, id1,rd1,ID;
	ArrayList<String> list1 = new ArrayList<>();
	ArrayList<String> list2= new ArrayList<>();
	ArrayList<String> list3= new ArrayList<>();
	ArrayList<String> list4= new ArrayList<>();
	ArrayList<String> list5= new ArrayList<>();
	ArrayList<String> list6= new ArrayList<>();
	ArrayList<String> list7= new ArrayList<>();
	ArrayList<String> list8= new ArrayList<>();
	ArrayList<String> list9= new ArrayList<>();
	ArrayList<String> list10= new ArrayList<>();
	ArrayList<String> list11= new ArrayList<>();
	ArrayList<String> list12= new ArrayList<>();
	ArrayList<String> list13= new ArrayList<>();
	ArrayList<String> list14= new ArrayList<>();
	ArrayList<String> list15= new ArrayList<>();
	ArrayList<String> list16= new ArrayList<>();
	ArrayList<String> list17= new ArrayList<>();
	ArrayList<String> list18= new ArrayList<>();
	ArrayList<String> list19= new ArrayList<>();
	ArrayList<String> list20= new ArrayList<>();
	ArrayList<String> list21= new ArrayList<>();
	ArrayList<String> list22= new ArrayList<>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User1() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String EID = request.getParameter("EmailID");
		String PS = request.getParameter("PASSWORD");
		
		//String RN = null;
		
		//System.out.println(RN);
		PrintWriter out = response.getWriter();  
        response.setContentType("text/html");
        //response.setContentType("image/jpeg");<!doctype html>
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>");
        out.println("Smart Library");
        out.println("</title>");
        out.println("<link rel =icon href = SL.jpg type = image/x-icon>");
        out.println("<style>");
        out.println(":root{\r\n"
        		+ "    --yellow:#f9ca24;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "*{\r\n"
        		+ "    font-family: 'Nunito', sans-serif;\r\n"
        		+ "    margin:0; padding:0;\r\n"
        		+ "    box-sizing: border-box;\r\n"
        		+ "    text-decoration: none;\r\n"
        		+ "    outline: none; border:none;\r\n"
        	
        		+ "    transition: all .2s linear;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "*::selection{\r\n"
        		+ "    background:var(--yellow);\r\n"
        		+ "    color:#333;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "html{\r\n"
        		+ "    font-size: 62.5%;\r\n"
        		+ "    overflow-x: hidden;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "html::-webkit-scrollbar{\r\n"
        		+ "    width:1.4rem;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "html::-webkit-scrollbar-track{\r\n"
        		+ "    background:#222;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "html::-webkit-scrollbar-thumb{\r\n"
        		+ "    background:var(--yellow);\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "body{\r\n"
        		+ "    background:#111;\r\n"
        		+ "    overflow-x: hidden;\r\n"
        		+ "    padding-left: 35rem;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "section{\r\n"
        		+ "    min-height: 100vh;\r\n"
        		+ "    padding:1rem;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".btn{\r\n"
        		+ "    padding:.7rem 3rem;\r\n"
        		+ "    background:#333;\r\n"
        		+ "    color:#fff;\r\n"
        		+ "    cursor: pointer;\r\n"
        		+ "    margin-top: 1rem;\r\n"
        		+ "    font-size: 2rem;\r\n"
        		+ "    border-radius: 5rem;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".btn i{\r\n"
        		+ "    padding:0 .5rem;\r\n"
        		+ "    font-size: 1.8rem;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".btn:hover{\r\n"
        		+ "    background:var(--yellow);\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".heading{\r\n"
        		+ "    text-align: center;\r\n"
        		+ "    margin:0 6rem;\r\n"
        		+ "    font-size: 4rem;\r\n"
        		+ "    padding:1rem;\r\n"
        		+ "    border-bottom: .1rem solid #fff4;\r\n"
        		+ "    color:#fff;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".heading span{\r\n"
        		+ "    color:var(--yellow);\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "header{\r\n"
        		+ "    position: fixed;\r\n"
        		+ "    top:0; left:0;\r\n"
        		+ "    z-index: 1000;\r\n"
        		+ "    height:100%;\r\n"
        		+ "    width:35rem;\r\n"
        		+ "    background:#1a1a1a;\r\n"
        		+ "    display: flex;\r\n"
        		+ "    align-items: center;\r\n"
        		+ "    justify-content: center;\r\n"
        		+ "    flex-flow: column;\r\n"
        		+ "    text-align: center;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "header .user img{\r\n"
        		+ "    height:17rem;\r\n"
        		+ "    width:17rem;\r\n"
        		+ "    border-radius: 50%;\r\n"
        		+ "    object-fit: cover;\r\n"
        		+ "    margin-bottom: 1rem;\r\n"
        		+ "    border:.7rem solid var(--yellow);\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "header .user .name{\r\n"
        		+ "    font-size: 3.5rem;\r\n"
        		+ "    color:#fff;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "header .user .post{\r\n"
        		+ "    font-size: 2rem;\r\n"
        		+ "    color:#eee;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "header .navbar{\r\n"
        		+ "    width:100%;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "header .navbar ul{\r\n"
        		+ "    list-style: none;\r\n"
        		+ "    padding:1rem 3rem;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "\r\n"
        		+ "header .navbar ul li a{\r\n"
        		+ "    display: block;\r\n"
        		+ "    padding:1rem;\r\n"
        		+ "    margin:1.5rem 0;\r\n"
        		+ "    background:#333;\r\n"
        		+ "    color:#fff;\r\n"
        		+ "    font-size: 2rem;\r\n"
        		+ "    border-radius: 5rem;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "header .navbar ul li a:hover{\r\n"
        		+ "    background:var(--yellow);\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "#menu{\r\n"
        		+ "    position: fixed;\r\n"
        		+ "    top:2rem; right:2rem;\r\n"
        		+ "    background:#333;\r\n"
        		+ "    color:#fff;\r\n"
        		+ "    cursor: pointer;\r\n"
        		+ "    font-size: 2.5rem;\r\n"
        		+ "    padding:1rem 1.5rem;\r\n"
        		+ "    z-index: 1000;\r\n"
        		+ "    display: none;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".home{\r\n"
        		+ "    display: flex;\r\n"
        		+ "    justify-content: center;\r\n"
        		+ "    flex-flow: column;\r\n"
        		+ "    padding:0 15rem;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".home h3{\r\n"
        		+ "    font-size: 2.5rem;\r\n"
        		+ "    color:#fff;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".home h1{\r\n"
        		+ "    font-size:5rem;\r\n"
        		+ "    color:#fff;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".home h1 span{\r\n"
        		+ "    color:var(--yellow);\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".home p{\r\n"
        		+ "    font-size:2rem;\r\n"
        		+ "    color:#eee;\r\n"
        		+ "    padding: 1rem 0;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".about .row{\r\n"
        		+ "    display: flex;\r\n"
        		+ "    align-items: center;\r\n"
        		+ "    justify-content: center;\r\n"
        		+ "    flex-wrap: wrap;\r\n"
        		+ "    padding:1rem 0;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".about .row .info{\r\n"
        		+ "    flex:1 1 48rem;\r\n"
        		+ "    padding:2rem 1rem;\r\n"
        		+ "    padding-left: 6rem;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".about .row .info h3{\r\n"
        		+ "    font-size: 2rem;\r\n"
        		+ "    color:var(--yellow);\r\n"
        		+ "    padding:1rem 0;\r\n"
        		+ "    font-weight: normal;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".about .row .info h3 span{\r\n"
        		+ "    color:#eee;\r\n"
        		+ "    padding:0 .5rem;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".about .row .counter{\r\n"
        		+ "    flex:1 1 48rem;\r\n"
        		+ "    display: flex;\r\n"
        		+ "    justify-content: center;\r\n"
        		+ "    flex-wrap: wrap;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".about .row .counter .box{\r\n"
        		+ "    width:20rem;\r\n"
        		+ "    background:#222;\r\n"
        		+ "    text-align: center;\r\n"
        		+ "    padding: 2rem;\r\n"
        		+ "    margin:2rem;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".about .row .counter .box span{\r\n"
        		+ "    font-size: 4rem;\r\n"
        		+ "    color:var(--yellow);\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".about .row .counter .box h3{\r\n"
        		+ "    font-size: 2rem;\r\n"
        		+ "    color:#fff;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".Book Report .box-container{\r\n"
        		+ "    display: flex;\r\n"
        		+ "    align-items: center;\r\n"
        		+ "    justify-content: space-between;\r\n"
        		+ "    flex-wrap: wrap;\r\n"
        		+ "    padding:1rem 0;\r\n"
        		+ "    padding-left: 3rem;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".Book Report .box-container .box{\r\n"
        		+ "    width:27rem;\r\n"
        		+ "    margin:4rem 1rem;\r\n"
        		+ "    padding-left: 4rem;\r\n"
        		+ "    border-left: .2rem solid #fff;\r\n"
        		+ "    position: relative;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".Book Report .box-container .box span{\r\n"
        		+ "    font-size: 1.3rem;\r\n"
        		+ "    background:#222;\r\n"
        		+ "    color:#fff;\r\n"
        		+ "    border-radius: 5rem;\r\n"
        		+ "    padding:.5rem 2.5rem;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".Book Report .box-container .box h3{\r\n"
        		+ "    font-size: 2rem;\r\n"
        		+ "    color:#fff;\r\n"
        		+ "    padding-top: 1.5rem;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".Book Report .box-container .box p{\r\n"
        		+ "    font-size: 1.4rem;\r\n"
        		+ "    color:#eee;\r\n"
        		+ "    padding: 1rem 0;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".Book Report .box-container .box i{\r\n"
        		+ "    position: absolute;\r\n"
        		+ "    top:-1.5rem; left:-2.5rem;\r\n"
        		+ "    height:5rem;\r\n"
        		+ "    width: 5rem;\r\n"
        		+ "    border-radius: 50%;\r\n"
        		+ "    line-height: 5rem;\r\n"
        		+ "    text-align: center;\r\n"
        		+ "    font-size: 2rem;\r\n"
        		+ "    color:#fff;\r\n"
        		+ "    background:var(--yellow);\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".portfolio .box-container{\r\n"
        		+ "    display: flex;\r\n"
        		+ "    align-items: center;\r\n"
        		+ "    justify-content: center;\r\n"
        		+ "    flex-wrap: wrap;\r\n"
        		+ "    padding:2rem 0;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".portfolio .box-container .box{\r\n"
        		+ "    height: 20rem;\r\n"
        		+ "    width:26rem;\r\n"
        		+ "    border-radius: 1rem;\r\n"
        		+ "    margin:2rem;\r\n"
        		+ "    overflow: hidden;\r\n"
        		+ "    cursor: pointer;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".portfolio .box-container .box img{\r\n"
        		+ "    height:100%;\r\n"
        		+ "    width:100%;\r\n"
        		+ "    object-fit: cover;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".portfolio .box-container .box:hover img{\r\n"
        		+ "    transform: scale(1.2);\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".contact .row{\r\n"
        		+ "    display: flex;\r\n"
        		+ "    align-items: center;\r\n"
        		+ "    justify-content: center;\r\n"
        		+ "    flex-wrap: wrap;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".contact .row .content{\r\n"
        		+ "    flex:1 1 30rem;\r\n"
        		+ "    padding:4rem;\r\n"
        		+ "    padding-bottom: 0;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".contact .row form{\r\n"
        		+ "    flex:1 1 45rem;\r\n"
        		+ "    padding:2rem;\r\n"
        		+ "    margin:2rem;\r\n"
        		+ "    margin-bottom: 4rem;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".contact .row form .box{\r\n"
        		+ "    padding:1.5rem;\r\n"
        		+ "    margin:1rem 0;\r\n"
        		+ "    background:#3333;\r\n"
        		+ "    color:#fff;\r\n"
        		+ "    text-transform: none;\r\n"
        		+ "    font-size: 1.7rem;\r\n"
        		+ "    width:100%;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".contact .row form .box::placeholder{\r\n"
        		+ "    text-transform: capitalize;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".contact .row form .message{\r\n"
        		+ "    height: 15rem;\r\n"
        		+ "    resize: none;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".contact .row .content .title{\r\n"
        		+ "    text-transform: uppercase;\r\n"
        		+ "    color:#fff;\r\n"
        		+ "    font-size: 3rem;\r\n"
        		+ "    padding-bottom: 2rem;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".contact .row .content .info h3{\r\n"
        		+ "    display: flex;\r\n"
        		+ "    align-items: center;\r\n"
        		+ "    font-size: 2rem;\r\n"
        		+ "    color:#eee;\r\n"
        		+ "    padding:1rem 0;\r\n"
        		+ "    font-weight: normal;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".contact .row .content .info h3 i{\r\n"
        		+ "    padding-right: 1rem;\r\n"
        		+ "    color:var(--yellow);\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".top{\r\n"
        		+ "    position: fixed;\r\n"
        		+ "    bottom:7.5rem; right: 2rem;\r\n"
        		+ "    z-index: 100;\r\n"
        		+ "    display: none;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "/* media queries  */\r\n"
        		+ "\r\n"
        		+ "@media (max-width:1200px){\r\n"
        		+ "\r\n"
        		+ "    html{\r\n"
        		+ "        font-size: 55%;\r\n"
        		+ "    }\r\n"
        		+ "\r\n"
        		+ "    .home{\r\n"
        		+ "        padding:1rem 4rem;\r\n"
        		+ "    }\r\n"
        		+ "\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "@media (max-width:991px){\r\n"
        		+ "\r\n"
        		+ "   header{\r\n"
        		+ "       left:-120%;\r\n"
        		+ "   }\r\n"
        		+ "\r\n"
        		+ "   #menu{\r\n"
        		+ "       display: block;\r\n"
        		+ "   }\r\n"
        		+ "\r\n"
        		+ "   header.toggle{\r\n"
        		+ "    left:0%;\r\n"
        		+ "   }\r\n"
        		+ "\r\n"
        		+ "   body{\r\n"
        		+ "       padding:0;\r\n"
        		+ "   }\r\n"
        		+ "\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "@media (max-width:768px){\r\n"
        		+ "\r\n"
        		+ "    html{\r\n"
        		+ "        font-size: 50%;\r\n"
        		+ "    }\r\n"
        		+ " \r\n"
        		+ " }\r\n"
        		+ "\r\n"
        		+ "@media (max-width:400px){\r\n"
        		+ "\r\n"
        		+ "    header{\r\n"
        		+ "        width: 100vw;\r\n"
        		+ "    }\r\n"
        		+ "\r\n"
        		+ "    .heading{\r\n"
        		+ "        margin:0 3rem;\r\n"
        		+ "    }\r\n"
        		+ "\r\n"
        		+ "    .about .row .counter .box{\r\n"
        		+ "        width: 100%;\r\n"
        		+ "    }\r\n"
        		+ " \r\n"
        		+ "    .Book Report .box-container .box{\r\n"
        		+ "        width:100%;\r\n"
        		+ "    }\r\n"
        		+ "\r\n"
        		+ "    .portfolio .box-container .box{\r\n"
        		+ "        width:100%;\r\n"
        		+ "    }\r\n"
        		+ "\r\n"
        		+ "    .contact .row form{\r\n"
        		+ "        margin:3rem 0;\r\n"
        		+ "    }\r\n"
        		+ "\r\n"
        		+ " }");
     ///////////////////////////////////////////////////////////////////////////////
        
        out.println(".popup{\r\n"
        		+ "    height: 100vh;\r\n"
        		+ "    width: 100%;\r\n"
        		+ "    position: fixed;\r\n"
        		+ "    top: 0;\r\n"
        		+ "    left: 0;\r\n"
        		+ "    background-color: rgba(192,192,192,0.3);\r\n"
        		+ "    z-index: 99999;\r\n"
        		+ "    opacity: 0;\r\n"
        		+ "    visibility: hidden;\r\n"
        		+ "    transition: all .3s;\r\n"
        		+ "     backdrop-filter: blur(10px);\r\n"
        		+ "     }\r\n"
        		+ " \r\n"
        		+ "   \r\n"
        		+ "@supports (-webkit-backdrop-filter: blur(10px)) or (backdrop-filter: blur(10px)) {\r\n"
        		+ "      .popup .popup1\r\n"
        		+ "      {\r\n"
        		+ "        -webkit-backdrop-filter: blur(80px);\r\n"
        		+ "        backdrop-filter: blur(10px);\r\n"
        		+ "        background-color: rgba(0,0,0,0.65); } }\r\n"
        		+ "    .popup__content {\r\n"
        		+ "      width: 350px;\r\n"
        		+ "      padding: 20px;\r\n"
        		+ "      border-radius: 4px;\r\n"
        		+ "      background:hsl(290,60%,70%);\r\n"
        		+ "      border: 1px solid rgba(255, 255, 255, 0.18);\r\n"
        		+ "      position: absolute;\r\n"
        		+ "      top: 50%;\r\n"
        		+ "      left: 50%;\r\n"
        		+ "      transform: translate(-50%, -50%);\r\n"
        		+ "      box-shadow: 0 2rem 4rem rgba(0, 0, 0, 0.2);\r\n"
        		+ "      display: table;\r\n"
        		+ "      overflow: hidden;\r\n"
        		+ "      opacity: 0;\r\n"
        		+ "      transform: translate(-50%, -50%) scale(0.25);\r\n"
        		+ "      transition: all .5s .2s; \r\n"
        		+ "      background-color: #747873;}\r\n"
        		+ "\r\n"
        		+ "    .popup:target {\r\n"
        		+ "      opacity: 1;\r\n"
        		+ "      visibility: visible; }\r\n"
        		+ "    .popup:target .popup__content {\r\n"
        		+ "      opacity: 1;\r\n"
        		+ "      transform: translate(-50%, -50%) scale(1); }\r\n"
        		+ "      \r\n"
        		+ "    \r\n"
        		+ "      \r\n"
        		+ "    .popup__close:link, .popup__close:visited {\r\n"
        		+ "      color: #000;\r\n"
        		+ "      position: absolute;\r\n"
        		+ "      top: 2.5rem;\r\n"
        		+ "      right: 2.5rem;\r\n"
        		+ "      font-size: 3rem;\r\n"
        		+ "      text-decoration: none;\r\n"
        		+ "      display: inline-block;\r\n"
        		+ "      transition: all .2s;\r\n"
        		+ "      line-height: 1; }\r\n"
        		+ "    .popup__close:hover {\r\n"
        		+ "      color: #fff; }");
        out.println("label{\r\n"
        		+ "        display: block;\r\n"
        		+ "        color: black;\r\n"
        		+ "        font-size: 18px;\r\n"
        		+ "        margin-top: 10px;\r\n"
        		+ "    }\r\n"
        		+ "    \r\n"
        		+ "    input{\r\n"
        		+ "        display: block;\r\n"
        		+ "        width: 90%;\r\n"
        		+ "        background: transparent;\r\n"
        		+ "        border: none;\r\n"
        		+ "        outline: none;\r\n"
        		+ "        border-bottom: 1px solid white;\r\n"
        		+ "        padding: 10px;\r\n"
        		+ "        color: white;\r\n"
        		+ "    }\r\n"
        		+ "    ");
        out.println(" button{\r\n"
        		+ "        display: block;\r\n"
        		+ "        width: 35%;\r\n"
        		+ "        padding: 8px;\r\n"
        		+ "        border: none;\r\n"
        		+ "        outline: none;\r\n"
        		+ "        background: linear-gradient(to right, #b90800, \r\n"
        		+ "        #20002c);\r\n"
        		+ "       \r\n"
        		+ "        font-size: 18px;\r\n"
        		+ "        cursor: pointer;\r\n"
        		+ "        margin-top: 20px;\r\n"
        		+ "         color:#e2e2e2\r\n"
        		+ "    \r\n"
        		+ "    }");
        
        
        
        
        
        
        ///////////////////////////////////////////////////////////////////////
        		out.println("table {\r\n"
        		+ "  font-family: arial, sans-serif;\r\n"
        		+"font-size: 20px;\r\n"
        		+ "  border-collapse: collapse;\r\n"
        		+ "  width: 100%;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "td, th {\r\n"
        		+ "  border: 2px solid #dddddd;\r\n"
        		+ "  text-align: left;\r\n"
        		+ "  padding: 8px;\r\n"
        		+"color:white;\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "tr:nth-child(even) {\r\n"
        		+ "  background:transparent;\r\n"
        		+ "}\r\n");
        		out.println("</style>");
        		out.println("<header>\r\n"
        		+ "\r\n"
        		+ "    <div class=\"user\">\r\n");
        		
        		
        		
        getConnection();
	    		 
	     result(); 
	    
        for(int i=0;i<list4.size();i++)
		{
			if(list4.get(i).contentEquals(EID))
			{
				if(list5.get(i).contentEquals(PS))
				{
					 String n = list1.get(i);			    
				        String nm = list2.get(i);
				       // String r=list3.get(i);
				        //String im=list11.get(i);
				        String userName = list4.get(i);
				        String imgname = list11.get(i);
				        //String imgPath="Images/"+userName+".jpg";
				        String imgPath="Images/"+imgname;
				        System.out.println("Hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiilooooooooooo is "+imgPath);
				        out.println("<img src="+imgPath+">");
				        out.println("<h3 class=\"name\">"+n+" "+nm+"</h3>");
				        
        out.println(" <nav class=\"navbar\">\r\n"
        		+ "        <ul>\r\n"
        		+ "            <li><a href=\"#home\">Home</a></li>\r\n"
        		+ "            <li><a href=\"#Book Report\">Book Log</a></li>\r\n"
        		+ "            <li><a href=\"#Late Fee\">Late fee</a></li>\r\n"
        		+ "            <li><a href=\"http://127.0.0.1:5000\">Syllabus Analogy</a></li>\r\n"
        		+ "            <li><a href=\"http://localhost:2000/getRecommendations\">Search</a></li>\r\n"
        		+"             <li><a href=\"Start.jsp\" onclick=\"myFunction()\">Logout</a></li>"
        		+ "        </ul>\r\n"
        		+ "    </nav>");
        out.println("</header>");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////      
        out.println("<div id=\"menu\" class=\"fas fa-bars\"></div>\r\n"
        		+ "\r\n"
        		+ "<!-- home section starts  -->\r\n"
        		+ "\r\n"
        		+ "<section class=\"home\" id=\"home\">\r\n"
        		+ "\r\n"
        		+ "    <h3>Hi "+n+" "+nm+" !</h3>\r\n"
        		+ "    <h1>Welcome to <span>Smart Library</span></h1>\r\n"
        		+ "    <p>        -an easier way\r\n"
        		+ "    </p>\r\n"
        		+ "    <a href=\"#about\"><button class=\"btn\">About me <i class=\"fas fa-user\"></i></button></a>\r\n"
        		+ "\r\n"
        		+ "</section>\r\n"
        		+ "\r\n"
        		+ "<!-- home section ends -->\r\n"
        		+ "\r\n"
        		+ "<!-- about section starts  -->\r\n"
        		+ "\r\n");
        
  				}
  			}
  		}
        		out.println("<section class=\"about\" id=\"about\">\r\n"
        		+ "\r\n"
        		+ "<h1 class=\"heading\"> <span>About</span> me </h1>\r\n"
        		+ "\r\n"
        		+ "<div class=\"row\">\r\n"
        		+ "\r\n"
        		+ "    <div class=\"info\">\r\n");

    for(int i=0;i<list4.size();i++)
	{
		if(list4.get(i).contentEquals(EID))
		{
			if(list5.get(i).contentEquals(PS))
			{
				 String n1 = list1.get(i);			    
			        String nm1 = list2.get(i);
			        String rn1=list3.get(i);
			        String e1=list4.get(i);
			        //String ps=list5.get(i);
			        String pn=list6.get(i);
			        out.println("<h3> <span> Name : </span>"+n1+" "+nm1+" </h3>");
			        out.println("<h3> <span> Roll No : </span>" + rn1+"</h3>");
			        out.println("<h3> <span> Phone Number : </span>"+pn+"</h3>");
			        out.println("<h3> <span> EmailID : </span>"+e1+"</h3>");
			       
			 
			        
			}
		}
	}
        		out.println( "    <a href=\"#popup0\"><button class=\"btn\">Edit <i class=\"fas fa-user\"></i></button></a>\r\n");
        		out.println("<div class=\"popup\" id=\"popup0\">\r\n"
        				+ "    <div class=\"popup__content\">\r\n"
        				+ "        \r\n"
        				+ "        \r\n"
        				+ "            <a href=\"#section-tours\" class=\"popup__close\">×</a>\r\n"
        				+ "        <form name=\"Edit\" action=\"Edit\" onsubmit=\"return myFunction1()\" method = \"post\">\r\n"
        				+ "            <h4>Confirm Your Roll Number to Edit Your Details</h4>\r\n"
        				+ "            <label>Roll Number</label>\r\n"
        				+ "            <input type=\"text\" name=\"Roll Number\">\r\n"
        				+ "            <label>Password</label>\r\n"
        				+ "            <input type=\"password\" name=\"password\">\r\n"
        				+ "            <br>\r\n"
        				+ "            <h1>Edit</h1>\r\n"
        				+ "            <label>Phone Number</label>\r\n"
        				+ "            <input type=\"text\" name=\"Phone Number\">\r\n"
        				+ "            <label>Email ID</label>\r\n"
        				+ "            <input type=\"text\" id=\"Email ID\" name=\"Email ID\">\r\n"
        				+ "           <h3><button type=\"submit\" value=\"Submit\" class=\"btn btn-info\">Submit</button></h3>\r\n"
        				+ "            <h2>After Submit Re-Login</h2>\r\n"
        				+ "    </form></div>\r\n"
        				+ "</div>");
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		out.println("</div>\r\n"
        		+ "\r\n"
        		+ "    <div class=\"counter\">\r\n"
        		+ "\r\n"
        		+ "    </div>\r\n"
        		+ "\r\n"
        		+ "</div>\r\n"
        		+ "\r\n"
        		+ "</section>\r\n"
        		+ "\r\n"
        		+ "<!-- about section ends -->\r\n"
        		+ "\r\n"
        		+ "<!-- education section starts  -->\r\n"
        		+ "\r\n");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        		out.println("<section class=\"Book Report\" id=\"Book Report\">");
        		out.println("<h1 class=\"heading\"> <span>Book</span> Log </h1>");
        		out.println("<br>");
        		out.println("<br>");
        		out.println("<br>");
        		out.println("<table>"
    					+ "  <tr>\r\n"
    					+ "    <th>Roll No</th>\r\n"
    					+ "    <th>Book Name</th>\r\n"
    					+ "    <th>Issue Date</th>\r\n"
    					+ "<th>Return Date</th>\\r\\n "
    					+ " </tr>");
        		getConnections();
        		results();
        		 for(int i=0;i<list4.size();i++)
        			{
        				if(list4.get(i).contentEquals(EID))
        				{
        					if(list5.get(i).contentEquals(PS))
        					{
        						
        						String RN=list3.get(i);
        						System.out.println(RN);
        						
        						
        						if((list7.size())!=0) {
        								for(int j=0;j<list7.size();j++) {
        										if(list7.get(j).contentEquals(RN)) {
        												String r = list7.get(j);			    
        												String bn = list8.get(j);
        												String id=list9.get(j);
        												String rd=list10.get(j);
        					        out.println("<tr><td>" + r + "</td><td>" + bn + "</td><td>"+ id + "</td><td>" + rd + "</td></tr>"); 
        					        
        					       
        					        
        					}
        					}
        						}
        					
        				}
        			}
        			}
      			      out.println("</table>");  
        		out.println("</section>");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////       		
        		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        		out.println("<!-- contact section starts  -->\r\n"
        		+ "\r\n"
        		+ "<section class=\"contact\" id=\"Late Fee\">\r\n"
        		+ "\r\n"
        		+ "<h1 class=\"heading\"> <span>Late Fee</span></h1>\r\n");
        		out.println("<br>");
        		out.println("<br>");
        		out.println("<table>"
    					+ "  <tr>\r\n"
    					+ "    <th>Book Name</th>\r\n"
    					+ "    <th>Submit Date</th>\r\n"
    					+ "    <th>Book ID</th>\r\n"
    					+"     <th>Late Fee</th>\r\n"
    					+ " </tr>");
        		getConnectionss();
        		resultes();
        		getConnections1();
        		results1();
        		
        		 for(int i=0;i<list4.size();i++)
        			{
        			   System.out.println(list4.size());
        			   System.out.println(list5);
        			   System.out.println(EID);
        				if(list4.get(i).contentEquals(EID))
        				{ 
        					System.out.println("hiii");
        					if(list5.get(i).contentEquals(PS))
        					{
        						
        						String RN=list3.get(i);
        						System.out.println(RN);
        						
        						if((list17.size())!=0) {
    								for(int j=0;j<list17.size();j++) {
    										if(list17.get(j).contentEquals(RN)) {
    												 r1= list17.get(j);			    
    												 bn2 = list18.get(j);
    												 id1=list19.get(j);
    												rd1=list20.get(j);
    												ID = list21.get(j);
    												System.out.println("Fffffffffffffffffff"+ID);
    									
    									
    												//************************
    							if((list13.size())!=0) {
    								for(int m=0;m<list13.size();m++) {
    				    					if(list13.get(m).contentEquals(RN) && list16.get(m).contentEquals(ID)) {
    				    						System.out.println("mmmmmmmmmm"+ID);
    				    						//String r2 = list13.get(m);			    
												String bn = list14.get(m);
												String id=list16.get(m);
												String s1=list15.get(m);
												String lf=list22.get(m);
												String c1="chinna";
												System.out.println("fffffffffffffffffffff"+id);
    				    						for(int l=0;l<list16.size();l++) {
    				    							System.out.println(list16.size());
    				    							if(list16.get(l).contentEquals(ID) && list22.get(l).contentEquals(c1)) {

    				    				    					
    					        			
   //************************************************************************************************************************     												
        												System.out.println("enterd");
        											//if(c1=="chinna") {
        												SimpleDateFormat availDate = new SimpleDateFormat("dd-MM-yyyy");
        												  try {
        													  System.out.println("d1 IS "+rd1);
        													  System.out.println("d2 IS "+s1);
        													//Date i = availDate.parse(d1);
        													Date r = availDate.parse(rd1);
        													Date s = availDate.parse(s1);
        													System.out.println("Date1"+r);
        													System.out.println("Date2"+s);
        													if(r.after(s))
        													{
        														System.out.println("Date 1 occurs after Date 2");
        														System.out.println("Both dates are equal");
       												         BasicDBObject searchQuery = new BasicDBObject("Book ID",list16.get(l));
       														 BasicDBObject updateFields = new BasicDBObject();
       														 updateFields.append("LateFee","0");
       														 BasicDBObject setQuery = new BasicDBObject();
       														 setQuery.append("$set", updateFields);
       														 myCollection3.update(searchQuery, setQuery);
        													}
        												  else if(r.before(s)) {
        												         System.out.println("Date 1 occurs before Date 2");
        												         
        												        
        												        // String di=s1;
        												         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        												         Calendar c = Calendar.getInstance();

        												         c.setTime(sdf.parse(rd1));
        												        
        												     
        												         
        												         while(rd1.compareTo(s1)<0) {
        												         c.add(Calendar.DATE,k); 
        												         rd1 = sdf.format(c.getTime()); 
        												         System.out.println(rd1);
        												        count++;
        												         }
       												         String s11=String.valueOf(count);
//       												             BasicDBObject query = new BasicDBObject();
//        												         query.put("LateFee","chinna"); // (1)
//
//        												         BasicDBObject newDocument = new BasicDBObject();
//        												         newDocument.put("LateFee", s11); // (2)
//
//        												         BasicDBObject updateObject = new BasicDBObject();
//        												         updateObject.put("$set", newDocument); // (3)
//
//        												         myCollection3.update(query, updateObject);
        												         
        												         ////////////////////////////////////
        												         
        												         BasicDBObject searchQuery = new BasicDBObject("Book ID",list16.get(l));
        														 BasicDBObject updateFields = new BasicDBObject();
        														 updateFields.append("LateFee",s11);
        														 BasicDBObject setQuery = new BasicDBObject();
        														 setQuery.append("$set", updateFields);
        														 myCollection3.update(searchQuery, setQuery);
        												         
        												         //////////////////////////////////////
        												         
        												      } else if(r.equals(s)) {
        												         System.out.println("Both dates are equal");
        												         BasicDBObject searchQuery = new BasicDBObject("Book ID",list16.get(l));
        														 BasicDBObject updateFields = new BasicDBObject();
        														 updateFields.append("LateFee","0");
        														 BasicDBObject setQuery = new BasicDBObject();
        														 setQuery.append("$set", updateFields);
        														 myCollection3.update(searchQuery, setQuery);
        												      }
        												} catch (ParseException e) {
        													
        													e.printStackTrace();
        												}
        														
    				    							//}	
    				    						}
        												
    					       }		
    				    
        												
 //***********************************************************************************************************************   												
        					         
        					        out.println("<tr><td>" + bn + "</td><td>" + s1 + "</td><td>"+ id + "</td><td>" +lf + "</td></tr>");   
        					        count=0;
        					        for(int k=0;k<list12.size();k++) {
        					        if(list12.get(k).contentEquals(ID)) {
        					            connect();
        					        	this.collection.deleteOne(Filters.eq("Book ID",ID));
        					        	}
    				    					}
    				    					}
    								}
        						}
    	
    								
    							
        					}
        						}
        					}
    							}
        					
        					
        				list1.clear();
    			        list2.clear();
    			        list3.clear();
    			        list4.clear();
    			        list5.clear();
    			        list6.clear();
    			        list7.clear();
    			        list8.clear();
    			        list9.clear();
    			        list10.clear();
    			        list11.clear();
    			        list12.clear();
    			        list13.clear();
    			        list14.clear();
    			        list15.clear();
    			        list16.clear();
    			        list17.clear();
    			        list18.clear();
    			        list19.clear();
    			        list20.clear();
    			        list21.clear();
    			        list22.clear();
    						}
	}
        			
        		 
			       
			        
			        out.println("</table>");  
        		
        		out.println("</section>\r\n"
        		+ "\r\n"
        		+ "<!-- contact section ends -->\r\n"
        		+ "\r\n"
        		+ "\r\n");
        		
        		System.out.println("welcomeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+list12);
        		
        		out.println("<script src=\"http://code.jquery.com/jquery-3.3.1.min.js\" integrity=\"sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=\" crossorigin=\"anonymous\"></script>");
        	out.println("<script>\r\n"
        			+ "        function goPython(){\r\n"
        			+ "            $.ajax({\r\n"
        			+ "              url: \"test.py\",\r\n"
        			+ "             context: document.body\r\n"
        			+ "            }).done(function() {\r\n"
        			+ "             alert('finished python script');;\r\n"
        			+ "            });\r\n"
        			+ "        }\r\n"
        			+ "    </script>");	
        		
        		
        		out.println("<script type=\"text/javascript\">\r\n"
        				+ "\r\n"
        				+ "function myFunction() {\r\n"
        				+ "	if (confirm(\"Are you Sure to logout!\")==false) {\r\n"
        				+ "		\r\n"
        				+ "		event.preventDefault();\r\n"
        				+ "	  }\r\n"
        				+ "	}\r\n"
        				+ "\r\n"
        				+ "\r\n"
        				+ "</script>\r\n"
        				+ "");
        		out.println("<!-- scroll top button  -->\r\n"
        		+ "\r\n"
        		+ "<a href=\"#home\" class=\"top\">\r\n"
        		+ "    <img src=\"images/scroll-top-img.png\" alt=\"\">\r\n"
        		+ "</a>\r\n"
        		+ "\r\n"
        		+ "\r\n"
        		+ "\r\n"
        		+ "\r\n"
        		+ "\r\n");
        	out.println("<script>\r\n"
        			+ "function myFunction1() {\r\n"
        			+ "let a = document.forms[\"Edit\"][\"Roll Number\"].value;\r\n"
        			+ "if (a == \"\") {\r\n"
        			+ "	    alert(\"Rollno must be filled out\");\r\n"
        			+ "	    return false;\r\n"
        			+ "	  }\r\n"
        			+ "	  let b = document.forms[\"Edit\"][\"Phone Number\"].value;\r\n"
        			+ "	  if (b == \"\") {\r\n"
        			+ "	    alert(\"Phone Number must be filled out\");\r\n"
        			+ "	    return false;\r\n"
        			+ "	  }\r\n"
        			+ "	  var email = document.getElementById('Email ID');\r\n"
        			+ "var filter = /^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$/;\r\n"
        			+ "\r\n"
        			+ "	    if (!filter.test(email.value)) {\r\n"
        			+ "	    alert('Please provide a valid email address');\r\n"
        			+ "	    email.focus;\r\n"
        			+ "	    return false;\r\n"
        			+ "	    }\r\n"
        			+ "\r\n"
        			+ "		}\r\n"
        			+ "</script>\r\n"
        			+ "");
        out.println("</body>");
        out.println("</html");
            
        
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
public void getConnections()
		{
			try {
				MongoClientURI connection = new MongoClientURI(URI);
				@SuppressWarnings("resource")
				MongoClient mongo = new MongoClient(connection);
				@SuppressWarnings("deprecation")
				DB db = mongo.getDB("Smart_Library");
				DBCollection myCollection2 = db.getCollection("BOOKS");
			    this.cursors= myCollection2.find();
			    		 
			}
			catch(Exception e)
			{
				this.cursors=null;
				
				
			}
	}
public void result()
{
	 while(cursor.hasNext())
		{
			cursor.next();
			this.list1.add((String) cursor.curr().get("First Name"));
			this.list2.add((String) cursor.curr().get("Last Name"));
			this.list3.add((String) cursor.curr().get("Roll No"));
			this.list4.add((String) cursor.curr().get("EmailID"));
			this.list6.add((String) cursor.curr().get("Phone Number"));	
			this.list5.add((String) cursor.curr().get("PASSWORD"));
			this.list11.add((String)cursor.curr().get("Imagename"));
			
			
		}
	    System.out.println("hiii");
}
public void results()
{
	 while(cursors.hasNext())
		{
			cursors.next();
			this.list7.add((String) cursors.curr().get("Roll Number"));
			this.list8.add((String) cursors.curr().get("Book Name"));
			this.list9.add((String) cursors.curr().get("Issue Date"));
			this.list10.add((String) cursors.curr().get("Return Date"));
			
			this.list12.add((String)cursors.curr().get("Book ID"));
			
			
		}
	    System.out.println("hiii");
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
			this.list13.add((String) cursores.curr().get("Roll Number"));
			this.list14.add((String) cursores.curr().get("Book Name"));
			
			this.list15.add((String) cursores.curr().get("Submit Date"));
			
			this.list16.add((String)cursores.curr().get("Book ID"));
			this.list22.add((String)cursores.curr().get("LateFee"));
			
			
		}
	    System.out.println("hiii");
}

public void connect()
{
	@SuppressWarnings("resource")
	MongoClient mongo = new MongoClient( "localhost" , 27017 );
    
    MongoDatabase database = mongo.getDatabase("Smart_Library");
   
    this.collection = database.getCollection("BOOKS");
    
    
}

public void getConnections1()
{
	try {
		MongoClientURI connection = new MongoClientURI(URI);
		@SuppressWarnings("resource")
		MongoClient mongo = new MongoClient(connection);
		@SuppressWarnings("deprecation")
		DB db = mongo.getDB("Smart_Library");
		DBCollection myCollection4 = db.getCollection("BOOKS1");
	    this.cursors1= myCollection4.find();
	    		 
	}
	catch(Exception e)
	{
		this.cursors1=null;
		
		
	}
}
public void results1()
{
	 while(cursors1.hasNext())
		{
			cursors1.next();
			this.list17.add((String) cursors1.curr().get("Roll Number"));
			this.list18.add((String) cursors1.curr().get("Book Name"));
			this.list19.add((String) cursors1.curr().get("Issue Date"));
			this.list20.add((String) cursors1.curr().get("Return Date"));
			
			this.list21.add((String)cursors1.curr().get("Book ID"));
			
			
		}
	    System.out.println("hiii");
}

}
