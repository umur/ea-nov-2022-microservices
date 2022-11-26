package edu.miu.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;
import org.springframework.vault.core.VaultTemplate;

@Configuration
@Data
public class VaultConfig extends AbstractVaultConfiguration {

    @Value("${spring.cloud.vault.token}")
    private String token;

    @Value("${spring.cloud.vault.host:localhost}")
    private String host;

    @Value("${spring.cloud.vault.port:8082}")
    private int port;

    @Value("${spring.cloud.vault.scheme:http}")
    private String scheme;

    @Bean
    @Override
    public VaultEndpoint vaultEndpoint() {
        VaultEndpoint vaultEndpoint = VaultEndpoint.create(host, port);
        vaultEndpoint.setScheme(scheme);
        return vaultEndpoint;
    }

    @Bean
    @Override
    public ClientAuthentication clientAuthentication() {
        return new TokenAuthentication(token);
    }

    @Bean
    public VaultTemplate vaultTemplate() {
        return new VaultTemplate(vaultEndpoint(), clientAuthentication());
    }
}
