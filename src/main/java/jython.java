import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

public class jython implements Runnable {
	public  void run() {

	    try {
	    	String s=null;
	    	System.out.println("MLLLLLLLLLLLLLLLLLLLLLLLLLLLLLl");
	    	Process p = Runtime.getRuntime().exec("python C:\\Users\\admin\\Library\\src\\main\\python\\db.py 1 2");
	    	BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
	    	while((s=in.readLine())!=null)
	    	{
	    		System.out.println(s);
	    	}
	    }
	    catch(IOException ie)
	    {
	    	ie.printStackTrace();
	    }
	}

}
