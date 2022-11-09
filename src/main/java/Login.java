

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public Login() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String EID = request.getParameter("EmailID");
		String PS = request.getParameter("PASSWORD");
		System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiilnlxclncjlcjxc");
		//final String URI = "mongodb://localhost:27017";
		//String db=request.getParameter("Usertype");
		
		//String db1="ADMIN";
		Automaticfunction a = new Automaticfunction();
		a.action();
		AutomatedFn1 a1 = new AutomatedFn1();
		a1.action();
		PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        out.println("<html><head>");
		
			//Values mb = new Values(FN,LN,RN,EID,PS);
		Logic lc = new Logic();
		System.out.println("hiiiii");
		Value mb = new Value(EID,PS);
				try { 
					
				  if(lc.checks(mb))
				   {
					  System.out.println("Hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii..........");
					 RequestDispatcher rd = request.getRequestDispatcher("Student");
						rd.forward(request,response);
				   }
			
			
				  else if(lc.check(mb))
				   {
					 RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
						rd.forward(request,response);
				   }
				 else
				 {
					 out.print("<script language=\"JavaScript\">");
					 out.println("alert('Invalid Email id or Password')");
					 out.println("location='Login.jsp';"); 
					 out.println("</script>");
				 }
				}catch(Exception e)
				{
					e.printStackTrace();
				}

			
		
		out.println("</body>\r\n"
				+ "</html>");

	
	}

}
