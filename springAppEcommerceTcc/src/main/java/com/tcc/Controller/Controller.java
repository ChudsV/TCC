package com.tcc.Controller;

import com.tcc.Service.StringService;
import jakarta.annotation.Resource;
import net.minidev.json.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Resource
    private StringService stringService;

    @GetMapping("/user")
    public String user() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && auth.getPrincipal() instanceof DefaultOidcUser) {
            JSONObject jsonObject = new JSONObject();
            String name = ((DefaultOidcUser) auth.getPrincipal()).getClaimAsString("name");
            //String roles = ((DefaultOidcUser) auth.getPrincipal()).getClaimAsMap("");
            jsonObject.put("name",name);
            //jsonObject.put()
            return stringService.convertToCamelCase(name);
        }
        return "Usuário Desconhecido";
    }


}

