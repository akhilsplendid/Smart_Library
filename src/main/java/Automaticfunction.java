
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class Automaticfunction {

		public void action() {
		
		ScheduledExecutorService sc = Executors.newScheduledThreadPool(1);
		SENDSMS s = new SENDSMS();
		sc.schedule(s,1 ,TimeUnit.SECONDS);
		sc.shutdown();
		}

}
