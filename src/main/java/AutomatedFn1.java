import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AutomatedFn1 {
public void action() {
		
		ScheduledExecutorService sc = Executors.newScheduledThreadPool(1);
		jython s = new jython();
		sc.schedule(s,1 ,TimeUnit.SECONDS);
		sc.shutdown();
		}

}
