package com.rubydev.basketcourtrgb;

/**
 * Created by Yogi Wisesa on 10/26/2017.
 */

public class Score {
    private int scoreA, scoreB;
    private String teamA, teamB, tanggal;

    public Score(int scoreA, int scoreB, String teamA, String teamB, String tanggal) {
        this.scoreA = scoreA;
        this.scoreB = scoreB;
        this.teamA = teamA;
        this.teamB = teamB;
        this.tanggal = tanggal;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getScoreA() {
        return scoreA;
    }

    public void setScoreA(int scoreA) {
        this.scoreA = scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }

    public void setScoreB(int scoreB) {
        this.scoreB = scoreB;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }
}
