

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
@MultipartConfig
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Register() {
        super();
    
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String EID = request.getParameter("EmailID");
		String PS = request.getParameter("PASSWORD");
		String FN = request.getParameter("First Name");
		String LN = request.getParameter("Last Name");
		String RN = request.getParameter("Roll No");
		String PN = request.getParameter("Phone Number");
		Part file = request.getPart("Image");
		//String imgs = request.getParameter("Image");
		String imageFileName = file.getSubmittedFileName();
		System.out.println("the image name is ...................................."+imageFileName);
		//System.out.println("the imagesssss name is ...................................."+imgs);
		//String imageFileName = EID+".jpg";
		
	////////////////////////////////////////////////////////////////////////////	
		
		
		  try {
    		  MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
              
              /* Connect to DATABASE */
              //If in case database doesn't exists, it will be created at runtime
              DB db = mongoClient.getDB("Smart_Library");
                           
              /* Get the COLLECTION (TABLE) */
              //If in case collection (Table) doesn't exists, it will be created at runtime
              DBCollection dbCollection = db.getCollection("Images");
    
              /* Step 1- Create imageFile */
              byte[] imageBytes = LoadImage("C:/Users/admin/Desktop/"+imageFileName);
    
              /* Step 2- create gridFS object */
              System.out.println("Step 2- create gridFS object");
              GridFS gridFS = new GridFS(db);
    
              /* Step 3- Create GridFSInputFile object from imageFile */
              System.out.println("Step 3- Create GridFSInputFile object from imageFile");
              GridFSInputFile gridFSInputFile = gridFS.createFile(imageBytes);
    
              /* Step 4- Set name for image in MongoDB */
              System.out.println("Step 4- Set name for image in MongoDB");
              //String c="DemoImage.jpg";
             
              String c=RN;
                gridFSInputFile.setFilename(imageFileName);
               gridFSInputFile.setId(c);
    
             /** Step 5- Save image in collection in MongoDB */
              System.out.println("\nStep 5- Save image in collection in MongoDB");
              gridFSInputFile.save();
    
    
             /** Step 6- Display Image document stored in collection in MongoDB */
              System.out.println("\nStep 6- Display Image document stored in collection in MongoDB");
              DBCursor cursor = gridFS.getFileList();
              while (cursor.hasNext()) {
                     System.out.println(cursor.next());
              }
    
             /** Step 7- Retrieve image from collection in MongoDB */
              System.out.println("\nStep 7- Retrieve image from collection in MongoDB");
              //List<GridFSDBFile> imageForOutput = gridFS.find("DemoImag.jpg");
              
              GridFSDBFile outs = gridFS.findOne( new BasicDBObject(  "_id", c ) );
    
             /** Step 8- Save retrieved image into local hard disk drive E:\drive*/
              System.out.println("\nStep 8- Save retrieved image into local drive (E: drive) ");
              FileOutputStream outputImage = new FileOutputStream("C:/Users/admin/Library/src/main/webapp/Images/"+imageFileName);
              //imageForOutput.get(0).writeTo("C:/Users/admin/Library/Images/DemoImag.jpg");
              outs.writeTo( outputImage );
            //  long path=outs.writeTo( outputImage );
		       // out.println("<img SRC=\"<%=path%>\" >");
              outputImage.close();
    
              System.out.println("retrieved image saved in E:/tiperImageDOWNLOADEDfromMongoDB.jpg");
    
    		  }
    		  catch(Exception e)
    		  {
    			  e.printStackTrace();
    		  }	
		
		////////////////////////////////////////////////////////////////////////////////////////////////
//		System.out.println("Imagefilename is : "+imageFileName);
//		String uploadpath = "C:/Users/admin/Library/src/main/webapp/"+imageFileName;
//		System.out.println("path is"+uploadpath);
//		try {
//			FileOutputStream fos = new FileOutputStream(uploadpath);
//			InputStream is = file.getInputStream();
//			System.out.println("Entered");
//			byte[] data = new byte[is.available()];
//			is.read(data);
//			fos.write(data);
//			fos.close();
//			
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
		String c="USER";
			//Values mb = new Values(FN,LN,RN,EID,PS);
		Logic lc = new Logic(c);
		if(lc.COLLECTION.equalsIgnoreCase("USER"))
		{
			
			Values mb = new Values(FN,LN,RN,PN,EID,PS,imageFileName);
			try
			{
				 if(lc.insert(mb))
				   {
					RequestDispatcher rd = request.getRequestDispatcher("NewFile.jsp");
					rd.forward(request,response);
				   }
				
				
			}catch(Exception e)
				{
					if(lc.insert(mb))
					   {
						RequestDispatcher rd = request.getRequestDispatcher("NewFile.jsp");
						rd.forward(request,response);
					   }

					
				}

		}

	}
	 public static byte[] LoadImage(String filePath) throws Exception {
		    File file = new File(filePath);
		    int size = (int)file.length();
		    byte[] buffer = new byte[size];
		    FileInputStream in = new FileInputStream(file);
		    in.read(buffer);
		    in.close();
		    return buffer;
		}

}
