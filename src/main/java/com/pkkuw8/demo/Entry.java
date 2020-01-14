package com.pkkuw8.demo;

public class Entry {

    String fullName;
    String institute;
    String vCard;

    public Entry(String fullName, String institute, String vCard){
        this.fullName = fullName;
        this.institute = institute;
        this.vCard = vCard;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getvCard() {
        return vCard;
    }

    public void setvCard(String vCard) {
        this.vCard = vCard;
    }

}
