package miu.edu.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class VaultConfiguration {
    //@Value("${spring.datasource.username}")
   @Value("${kv.test}")
    private String dbUserName;
    //@Value("${spring.datasource.password}")
//   @Value("${Two}")
//    private String dbPassword;
}
