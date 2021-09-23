package eureka.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class ServiceRegistrationAndDiscoveryClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistrationAndDiscoveryClientApplication.class, args);
    }
}

@RestController
class ServiceInstanceRestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        /*
         * Check here http://localhost:8080/service-instances/unknown while replacing unknown with the service names
         * registered in Eureka - Check your spring.application.name property.
         */
        return this.discoveryClient.getInstances(applicationName);
    }

    @RequestMapping("/service-instances/")
    public List<String> getServices() {
        /*
         * Check here http://localhost:8080/service-instances/unknown while replacing unknown with the service names
         * registered in Eureka - Check your spring.application.name property.
         */
        return this.discoveryClient.getServices();
    }
}