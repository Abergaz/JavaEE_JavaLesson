package ee.ejb.bean;

import javax.annotation.Resource;
import javax.ejb.*;

@Singleton
public class ExampleBean {
    @Resource
    SessionContext sessionContext;
    /**
     * или сразу заинжектить TimeService
     */
    @Resource
    TimerService timerService;

    public String getName() {
        // TimerService timerService = sessionContext.getTimerService();
        ScheduleExpression scheduleExpression = new ScheduleExpression();
        scheduleExpression.hour("*").minute("*").second("*");
        timerService.createCalendarTimer(scheduleExpression, new TimerConfig("in worked at every second with TimerService", false));

        return "Max ";
    }
    @Schedule(second = "*", minute = "*", hour = "*")
    private void printMessage1() {
        System.out.println("in worked at every second with @Schedule");
    }

    @Timeout
    public void printMessage2(Timer timer){
        System.out.println(timer.getInfo());
    }


}
