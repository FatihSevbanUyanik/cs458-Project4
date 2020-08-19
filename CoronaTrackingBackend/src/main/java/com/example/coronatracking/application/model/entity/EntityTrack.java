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
    private Boolean fever;
    @Column(name = "cough", nullable = false)
    private Boolean cough;
    @Column(name = "chills", nullable = false)
    private Boolean chills;
    @Column(name = "headAche", nullable = false)
    private Boolean headAche;
    @Column(name = "tiredness", nullable = false)
    private Boolean tiredness;
    @Column(name = "runnyNose", nullable = false)
    private Boolean runnyNose;
    @Column(name = "chestPain", nullable = false)
    private Boolean chestPain;
    @Column(name = "muscleAche", nullable = false)
    private Boolean muscleAche;
    @Column(name = "soreThroat", nullable = false)
    private Boolean soreThroat;
    @Column(name = "difficultBreathing", nullable = false)
    private Boolean difficultBreathing;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "symptomCount", nullable = false)
    private Integer symptomCount;
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
