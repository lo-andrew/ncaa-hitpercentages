package com.ncaa.ncaa_hitpercentages.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="player_stats")
public class Player {
    @Id
    private Integer rank;
    private String name;
    private String team;

    @Column(name = "cl")
    private String collegeLevel;

    private String height;

    @Column(name = "s")
    private Integer sets;
    private Integer kills;
    private Integer errors;

    @Column(name = "totalattacks")
    private Integer totalAttacks;
    private Double pct;

    public Player() {
    }

    public Player(Integer rank, String name, String team, String collegeLevel, String height, Integer sets, Integer kills, Integer errors, Integer totalAttacks, Double pct) {
        this.rank = rank;
        this.name = name;
        this.team = team;
        this.collegeLevel = collegeLevel;
        this.height = height;
        this.sets = sets;
        this.kills = kills;
        this.errors = errors;
        this.totalAttacks = totalAttacks;
        this.pct = pct;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getCollegeLevel() {
        return collegeLevel;
    }

    public void setCollegeLevel(String collegeLevel) {
        this.collegeLevel = collegeLevel;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public Integer getKills() {
        return kills;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }

    public Integer getErrors() {
        return errors;
    }

    public void setErrors(Integer errors) {
        this.errors = errors;
    }

    public Integer getTotalAttacks() {
        return totalAttacks;
    }

    public void setTotalAttacks(Integer totalAttacks) {
        this.totalAttacks = totalAttacks;
    }

    public Double getPct() {
        return pct;
    }

    public void setPct(Double pct) {
        this.pct = pct;
    }
}
