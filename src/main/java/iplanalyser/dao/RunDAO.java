package iplanalyser.dao;


import iplanalyser.model.RunClass;
import iplanalyser.model.WicketClass;

public class RunDAO {
    public Double bowlingAverage;
    public Double bowlingStrikeRate;
    public Double battingAverage;
    public String player;
    public Double battingStrikeRate;
    public Integer six;
    public Integer four;
    public Integer run;
    public Double over;
    public Double economy;
    public Integer matches;
    public Integer fiveWickets;
    public Integer fourWickets;
    public Integer wickets;
    public RunDAO(RunClass obj){
        this.battingAverage =obj.battingAverage;
        this.player=obj.player;
        this.battingStrikeRate =obj.battingStrikeRate;
        this.four=obj.four;
        this.six=obj.six;
        this.run=obj.run;
        this.matches=obj.matches;
    }
    public RunDAO(WicketClass object){
        this.bowlingAverage=object.bowlingAverage;
        this.over=object.over;
        this.player=object.player;
        this.bowlingStrikeRate=object.bowlingStrikeRate;
        this.economy =object.economy;
        this.fiveWickets=object.fiveWickets;
        this.fourWickets=object.fourWickets;
        this.wickets=object.wickets;
    }


    public void setBowlingAverage(Double bowlingAverage) {
        this.bowlingAverage = bowlingAverage;
    }
}
