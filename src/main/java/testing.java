import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class testing {
	
	public static void main(String args[])
	{
		String d1="2022-04-01";//issue
		String d2="2022-05-15";//return
		String d3="2022-06-10";//submit
		int count=0;
		int j=1;
		//System.out.println(d);
		SimpleDateFormat availDate = new SimpleDateFormat("dd-MM-yyyy");
		  try {
			Date i = availDate.parse(d1);
			Date r = availDate.parse(d2);
			Date s = availDate.parse(d3);
			if(r.before(s))
			{
				System.out.println("Date 1 occurs after Date 2");
			}
		  else if(r.after(s)) {
		         System.out.println("Date 1 occurs before Date 2");
		         
		        
		         String di=d3;
		         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		         Calendar c = Calendar.getInstance();

		         c.setTime(sdf.parse(d2));
		        
		     
		         
		         while(d2.compareTo(d3)<0) {
		         c.add(Calendar.DATE,j); 
		         d2 = sdf.format(c.getTime()); 
		         System.out.println(d2);
		        count++;
		         }
		          
		         System.out.println(count);
		         
		         
		      } else if(r.equals(s)) {
		         System.out.println("Both dates are equal");
		      }
		} catch (ParseException e) {
			
			e.printStackTrace();
		}

	}

}
