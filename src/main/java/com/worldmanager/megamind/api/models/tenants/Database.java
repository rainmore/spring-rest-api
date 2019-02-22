package com.worldmanager.megamind.api.models.tenants;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Embeddable;

@Document
@Embeddable
public class Database {

    private String user;
    private String pass;
    private String name;

    public String getUser() {
        return user;
    }

    public void setUser(final String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(final String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
