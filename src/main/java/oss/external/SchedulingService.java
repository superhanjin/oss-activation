
package oss.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="scheduling", url="${api.url.scheduling}", fallback=SchedulingServiceFallback.class)
public interface SchedulingService {

    @RequestMapping(method= RequestMethod.POST, path="/schedulings")
    public void initiateSchedule(@RequestBody Scheduling scheduling);

}