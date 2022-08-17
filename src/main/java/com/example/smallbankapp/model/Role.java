package com.example.smallbankapp.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    admin, client;

    @Override
    public String getAuthority() {
        return name();
    }
}
