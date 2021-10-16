package com.revature.models;

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

    public Reimbursement(int reimbID, float reimbAmount, String reimbDescription, int reimbAuthor, int reimbResolver, int reimbStatusID, int reimbTypeID, String reimbStatus, String reimbType) {
        this.reimbID = reimbID;
        this.reimbAmount = reimbAmount;
        this.reimbDescription = reimbDescription;
        this.reimbAuthor = reimbAuthor;
        this.reimbResolver = reimbResolver;
        this.reimbStatusID = reimbStatusID;
        this.reimbTypeID = reimbTypeID;
        this.reimbStatus = reimbStatus;
        this.reimbType = reimbType;
    }

    public int getReimbID() {
        return reimbID;
    }

    public void setReimbID(int reimbID) {
        this.reimbID = reimbID;
    }

    public float getReimbAmount() {
        return reimbAmount;
    }

    public void setReimbAmount(float reimbAmount) {
        this.reimbAmount = reimbAmount;
    }

    public String getReimbDescription() {
        return reimbDescription;
    }

    public void setReimbDescription(String reimbDescription) {
        this.reimbDescription = reimbDescription;
    }

    public int getReimbAuthor() {
        return reimbAuthor;
    }

    public void setReimbAuthor(int reimbAuthor) {
        this.reimbAuthor = reimbAuthor;
    }

    public int getReimbResolver() {
        return reimbResolver;
    }

    public void setReimbResolver(int reimbResolver) {
        this.reimbResolver = reimbResolver;
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
