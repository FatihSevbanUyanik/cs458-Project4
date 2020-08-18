package com.example.coronatracking.application.model.response;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class ResponseTrack {

    private Long id;
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
    private String status;
    private int symptomCount;
    private LocalDateTime createdAt;

    public ResponseTrack() { }

    public ResponseTrack(Long id, boolean fever, boolean cough, boolean chills, boolean headAche, boolean tiredness,
                         boolean runnyNose, boolean chestPain, boolean muscleAche, boolean soreThroat,
                         boolean difficultBreathing, String status, int symptomCount, LocalDateTime createdAt) {
        this.id = id;
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
        this.status = status;
        this.symptomCount = symptomCount;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSymptomCount() {
        return symptomCount;
    }

    public void setSymptomCount(int symptomCount) {
        this.symptomCount = symptomCount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "ResponseTracks{" +
                "id=" + id +
                ", fever=" + fever +
                ", cough=" + cough +
                ", chills=" + chills +
                ", headAche=" + headAche +
                ", tiredness=" + tiredness +
                ", runnyNose=" + runnyNose +
                ", chestPain=" + chestPain +
                ", muscleAche=" + muscleAche +
                ", soreThroat=" + soreThroat +
                ", difficultBreathing=" + difficultBreathing +
                ", status='" + status + '\'' +
                ", symptomCount=" + symptomCount +
                ", createdAt=" + createdAt +
                '}';
    }
}
