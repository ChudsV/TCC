package com.tcc.Controller;

import com.tcc.Service.StringService;
import jakarta.annotation.Resource;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Resource
    private StringService stringService;

    @GetMapping("/user")
    public JSONObject user() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && auth.getPrincipal() instanceof DefaultOidcUser) {
            JSONObject jsonUser = new JSONObject();
            String name = ((DefaultOidcUser) auth.getPrincipal()).getClaimAsString("name");
            List<String> rolesArray = ((DefaultOidcUser) auth.getPrincipal()).getClaimAsStringList("roles");
            JSONArray roles = null;
            if(rolesArray!=null) {
                roles = new JSONArray();
                roles.addAll(rolesArray);
            }
            jsonUser.put("name",stringService.convertToCamelCase(name));
            jsonUser.put("roles",roles);
            jsonUser.put("token",((DefaultOidcUser) auth.getPrincipal()).getIdToken().getTokenValue());
            return jsonUser;
        }
        return null;
    }
}


