package com.example.coronatracking.application.model.request;

import javax.persistence.Column;

public class RequestTrack {

    private Boolean fever;
    private Boolean cough;
    private Boolean chills;
    private Boolean headAche;
    private Boolean tiredness;
    private Boolean runnyNose;
    private Boolean chestPain;
    private Boolean muscleAche;
    private Boolean soreThroat;
    private Boolean difficultBreathing;

    public RequestTrack() { }

    public RequestTrack(Boolean fever, Boolean cough, Boolean chills, Boolean headAche, Boolean tiredness,
                        Boolean runnyNose, Boolean chestPain, Boolean muscleAche, Boolean soreThroat, Boolean difficultBreathing) {
        this.fever = fever;
        this.cough = cough;
        this.chills = chills;
        this.headAche = headAche;
        this.tiredness = tiredness;
        this.runnyNose = runnyNose;
        this.chestPain = chestPain;
        this.muscleAche = muscleAche;
        this.soreThroat = soreThroat;
        this.difficultBreathing = difficultBreathing;
    }

    public Boolean isFever() {
        return fever;
    }

    public void setFever(Boolean fever) {
        this.fever = fever;
    }

    public Boolean isCough() {
        return cough;
    }

    public void setCough(Boolean cough) {
        this.cough = cough;
    }

    public Boolean isChills() {
        return chills;
    }

    public void setChills(Boolean chills) {
        this.chills = chills;
    }

    public Boolean isHeadAche() {
        return headAche;
    }

    public void setHeadAche(Boolean headAche) {
        this.headAche = headAche;
    }

    public Boolean isTiredness() {
        return tiredness;
    }

    public void setTiredness(Boolean tiredness) {
        this.tiredness = tiredness;
    }

    public Boolean isRunnyNose() {
        return runnyNose;
    }

    public void setRunnyNose(Boolean runnyNose) {
        this.runnyNose = runnyNose;
    }

    public Boolean isChestPain() {
        return chestPain;
    }

    public void setChestPain(Boolean chestPain) {
        this.chestPain = chestPain;
    }

    public Boolean isMuscleAche() {
        return muscleAche;
    }

    public void setMuscleAche(Boolean muscleAche) {
        this.muscleAche = muscleAche;
    }

    public Boolean isSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(Boolean soreThroat) {
        this.soreThroat = soreThroat;
    }

    public Boolean isDifficultBreathing() {
        return difficultBreathing;
    }

    public void setDifficultBreathing(Boolean difficultBreathing) {
        this.difficultBreathing = difficultBreathing;
    }
}
