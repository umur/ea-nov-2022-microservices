package edu.miu.controller;

import edu.miu.model.Credential;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/vault")
@RestController
@RequiredArgsConstructor
public class VaultController {

    final VaultTemplate vaultTemplate;
    @GetMapping
    public Object readMessage(){
        VaultResponseSupport responseSupport = vaultTemplate.read("secret/data/myapp1?version=1");
        System.out.println(responseSupport.getData());
        return responseSupport.getData();
    }

    @PostMapping
    public String writeMessage(@RequestBody Credential credential) {
        JSONObject data = new JSONObject();
        data.put("data", new JSONObject(credential));
        vaultTemplate.write("secret/data/myapp1", data.toString());
        return "Send message successfully";
    }
}
