package com.worldmanager.megamind.api.models.tenants;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Embeddable;

@Document
@Embeddable
public class T2Settings {

    private Boolean active = false;
    private String rto;

    public Boolean getActive() {
        return active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }

    public String getRto() {
        return rto;
    }

    public void setRto(final String rto) {
        this.rto = rto;
    }
}
