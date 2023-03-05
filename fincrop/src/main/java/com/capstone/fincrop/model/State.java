package com.capstone.fincrop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "states")
public class State {

    @Id
    @Column(name = "stateID")
    private String stateId;

    @Column(name = "stateName")
    private String stateName;

    @Column(name = "countryID")
    private String countryId;

    public State() {
    }

    public State(String stateId, String stateName, String countryId) {
        this.stateId = stateId;
        this.stateName = stateName;
        this.countryId = countryId;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }
}
