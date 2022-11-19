package com.dailycodebuffer.user.vault;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("battadb")
public class Credentials {
    private String username;
    private String password;
}
