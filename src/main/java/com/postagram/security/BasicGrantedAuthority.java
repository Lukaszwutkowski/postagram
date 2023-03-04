package com.postagram.security;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.security.core.GrantedAuthority;
@JsonDeserialize(using = GrantedAuthorityDeserializer.class)
public class BasicGrantedAuthority implements GrantedAuthority {

    private String authority;

    public BasicGrantedAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
