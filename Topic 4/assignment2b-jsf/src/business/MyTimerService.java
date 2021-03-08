package business;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.Timer;
import java.util.logging.Logger;
import javax.ejb.TimerService;
import javax.annotation.Resource;
import javax.ejb.Timeout;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;

@Stateless
public class MyTimerService {

	private static final Logger logger = Logger.getLogger("business.MyTimerService");
	@Resource
	private TimerService timerService;
	
    /**
     * Default constructor. 
     */
    public MyTimerService() {
        // TODO Auto-generated constructor stub
   
    }
	
	
	/*
	 * Set timer
	 */
	public void setTimer(long interval) {
		timerService.createTimer(interval, "My Timer");
	}
	
	/*
	 * Displays timeout message on timeout
	 */
	@Timeout
	public void programmicTimer(Timer timer) {
		logger.info("@STimeout has occured." + new java.util.Date());
	}
}