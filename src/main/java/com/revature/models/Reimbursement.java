package com.revature.models;

import java.sql.Time;

public class Reimbursement {
    private int reimbID;
    private float reimbAmount;
    private String reimbDescription;
    private int reimbAuthor;
    private int reimbResolver;
    private int reimbStatusID;
    private int reimbTypeID;
    private String reimbStatus;
    private String reimbType;
    private Time reimbSubmitted;
    private Time reimbResovled

    public Reimbursement(int reimbID, float reimbAmount, String reimbDescription, int reimbAuthor, int reimbResolver, int reimbStatusID, int reimbTypeID, String reimbStatus, String reimbType, Time reimbSubmitted, Time reimbResovled) {
        this.reimbID = reimbID;
        this.reimbAmount = reimbAmount;
        this.reimbDescription = reimbDescription;
        this.reimbAuthor = reimbAuthor;
        this.reimbResolver = reimbResolver;
        this.reimbStatusID = reimbStatusID;
        this.reimbTypeID = reimbTypeID;
        this.reimbStatus = reimbStatus;
        this.reimbType = reimbType;
        this.reimbSubmitted = reimbSubmitted;
        this.reimbResovled = reimbResovled;
    }

    public Reimbursement(int reimbID) {
        this.reimbID = reimbID;
    }

    public int getReimbStatusID() {
        return reimbStatusID;
    }

    public void setReimbStatusID(int reimbStatusID) {
        this.reimbStatusID = reimbStatusID;
    }

    public int getReimbTypeID() {
        return reimbTypeID;
    }

    public void setReimbTypeID(int reimbTypeID) {
        this.reimbTypeID = reimbTypeID;
    }

    public String getReimbStatus() {
        return reimbStatus;
    }

    public void setReimbStatus(String reimbStatus) {
        this.reimbStatus = reimbStatus;
    }

    public String getReimbType() {
        return reimbType;
    }

    public void setReimbType(String reimbType) {
        this.reimbType = reimbType;
    }


}
