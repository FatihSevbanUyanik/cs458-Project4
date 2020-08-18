package com.example.coronatracking.application.model.request;

import javax.persistence.Column;

public class RequestTrack {

    private boolean fever;
    private boolean cough;
    private boolean chills;
    private boolean headAche;
    private boolean tiredness;
    private boolean runnyNose;
    private boolean chestPain;
    private boolean muscleAche;
    private boolean soreThroat;
    private boolean difficultBreathing;

    public RequestTrack() { }

    public RequestTrack(boolean fever, boolean cough, boolean chills, boolean headAche, boolean tiredness,
                        boolean runnyNose, boolean chestPain, boolean muscleAche, boolean soreThroat, boolean difficultBreathing) {
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

    public boolean isFever() {
        return fever;
    }

    public void setFever(boolean fever) {
        this.fever = fever;
    }

    public boolean isCough() {
        return cough;
    }

    public void setCough(boolean cough) {
        this.cough = cough;
    }

    public boolean isChills() {
        return chills;
    }

    public void setChills(boolean chills) {
        this.chills = chills;
    }

    public boolean isHeadAche() {
        return headAche;
    }

    public void setHeadAche(boolean headAche) {
        this.headAche = headAche;
    }

    public boolean isTiredness() {
        return tiredness;
    }

    public void setTiredness(boolean tiredness) {
        this.tiredness = tiredness;
    }

    public boolean isRunnyNose() {
        return runnyNose;
    }

    public void setRunnyNose(boolean runnyNose) {
        this.runnyNose = runnyNose;
    }

    public boolean isChestPain() {
        return chestPain;
    }

    public void setChestPain(boolean chestPain) {
        this.chestPain = chestPain;
    }

    public boolean isMuscleAche() {
        return muscleAche;
    }

    public void setMuscleAche(boolean muscleAche) {
        this.muscleAche = muscleAche;
    }

    public boolean isSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(boolean soreThroat) {
        this.soreThroat = soreThroat;
    }

    public boolean isDifficultBreathing() {
        return difficultBreathing;
    }

    public void setDifficultBreathing(boolean difficultBreathing) {
        this.difficultBreathing = difficultBreathing;
    }
}
