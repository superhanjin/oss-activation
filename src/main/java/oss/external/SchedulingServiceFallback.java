package oss.external;

import org.springframework.stereotype.Component;

@Component
public class SchedulingServiceFallback implements SchedulingService {

    @Override
    public void initiateSchedule(Scheduling scheduling) {
        System.out.println("SchedulingServiceFallback.initiateSchedule() is called under the situation of Circuit Break !!!");
    }
}
