package com.example.coronatracking.application.model.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tracks")
public class EntityTrack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fever", nullable = false)
    private boolean fever;
    @Column(name = "cough", nullable = false)
    private boolean cough;
    @Column(name = "chills", nullable = false)
    private boolean chills;
    @Column(name = "headAche", nullable = false)
    private boolean headAche;
    @Column(name = "tiredness", nullable = false)
    private boolean tiredness;
    @Column(name = "runnyNose", nullable = false)
    private boolean runnyNose;
    @Column(name = "chestPain", nullable = false)
    private boolean chestPain;
    @Column(name = "muscleAche", nullable = false)
    private boolean muscleAche;
    @Column(name = "soreThroat", nullable = false)
    private boolean soreThroat;
    @Column(name = "difficultBreathing", nullable = false)
    private boolean difficultBreathing;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "symptomCount", nullable = false)
    private int symptomCount;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "creator_id")
    private EntityUser creator;

    public EntityTrack() { }

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

    public EntityUser getCreator() {
        return creator;
    }

    public void setCreator(EntityUser creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "EntityTrack{" +
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
                '}';
    }
}
