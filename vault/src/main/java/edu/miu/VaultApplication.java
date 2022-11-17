package edu.miu;

import edu.miu.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

@SpringBootApplication
public class VaultApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(VaultApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        VaultTemplate vaultTemplate = new VaultTemplate(new VaultEndpoint(),
                new TokenAuthentication("12332112-1234-4321-5678-987654321123"));
        VaultResponseSupport<User> response = vaultTemplate.read("secret/my-vault-app", User.class);
        System.out.println(response);
    }
}