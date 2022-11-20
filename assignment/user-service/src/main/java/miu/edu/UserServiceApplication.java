package miu.edu;

import miu.edu.configuration.VaultConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@SpringBootApplication
public class UserServiceApplication {

    private static Logger log = LoggerFactory.getLogger(VaultConfiguration.class);

    public static void main(String[] args) {
       ConfigurableApplicationContext context = SpringApplication.run(UserServiceApplication.class,args);
       VaultConfiguration vaultConfiguration = context.getBean(VaultConfiguration.class);
       log.info("Login " + vaultConfiguration.getDbUserName());
      // log.info("Login " + vaultConfiguration.getDbPassword());
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }


}
