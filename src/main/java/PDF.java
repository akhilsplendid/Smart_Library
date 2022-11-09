

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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

/**
 * Servlet implementation class PDF
 */
@MultipartConfig
@WebServlet("/PDF")
public class PDF extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PDF() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part file = request.getPart("pdf_file");
		System.out.println(file);
		String imageFileName = file.getSubmittedFileName();
		System.out.println(imageFileName);
		
		 try {
   		  MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
             
             /* Connect to DATABASE */
             //If in case database doesn't exists, it will be created at runtime
             DB db = mongoClient.getDB("Smart_Library");
                          
             /* Get the COLLECTION (TABLE) */
             //If in case collection (Table) doesn't exists, it will be created at runtime
             DBCollection dbCollection = db.getCollection("PDF");
   
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
            
             String c=imageFileName;
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
             FileOutputStream outputImage = new FileOutputStream("C:/Users/admin/Library/src/main/webapp/PDF/"+imageFileName);
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
