package com.fer_mendoza.journal.models;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "entries")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private User user;

    @Column
    private Date dateTime;

    @Column(nullable = true)
    private Feeling feeling;

    @Column(nullable = true)
    private String feelingDescribed;

    @Column(nullable = true)
    private String iCan;

    @Column(nullable = true)
    private String topProjectToday;

    @Column(nullable = true)
    private String projectDescription;

    @Column(nullable = true)
    private String smallAction;

    @Column(nullable = true)
    private String otherThoughts;

    @Column(nullable = true)
    private String gratefulFor;

    @Column(nullable = true)
    private Date stopAt;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String brainDump;

    public Entry() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Feeling getFeeling() {
        return feeling;
    }

    public void setFeeling(Feeling feeling) {
        this.feeling = feeling;
    }

    public String getFeelingDescribed() {
        return feelingDescribed;
    }

    public void setFeelingDescribed(String feelingDescribed) {
        this.feelingDescribed = feelingDescribed;
    }

    public String getiCan() {
        return iCan;
    }

    public void setiCan(String iCan) {
        this.iCan = iCan;
    }

    public String getTopProjectToday() {
        return topProjectToday;
    }

    public void setTopProjectToday(String topProjectToday) {
        this.topProjectToday = topProjectToday;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getSmallAction() {
        return smallAction;
    }

    public void setSmallAction(String smallAction) {
        this.smallAction = smallAction;
    }

    public String getOtherThoughts() {
        return otherThoughts;
    }

    public void setOtherThoughts(String otherThoughts) {
        this.otherThoughts = otherThoughts;
    }

    public String getGratefulFor() {
        return gratefulFor;
    }

    public void setGratefulFor(String gratefulFor) {
        this.gratefulFor = gratefulFor;
    }

    public Date getStopAt() {
        return stopAt;
    }

    public void setStopAt(Date stopAt) {
        this.stopAt = stopAt;
    }

    public String getBrainDump() {
        return brainDump;
    }

    public void setBrainDump(String brainDump) {
        this.brainDump = brainDump;
    }
}
