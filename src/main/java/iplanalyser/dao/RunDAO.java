package iplanalyser.dao;


import iplanalyser.model.RunClass;

public class RunDAO {
    public Double avg;
    public String player;
    public Double sr;
    public Integer six;
    public Integer four;
    public Integer run;
    public Double over;
    public Double economy;
    public Integer matches;
    public Integer fiveWickets;
    public Integer fourWickets;
    public RunDAO(RunClass obj){
        this.avg=obj.avg;
        this.player=obj.player;
        this.sr=obj.sr;
        this.four=obj.four;
        this.six=obj.six;
        this.run=obj.run;
        this.matches=obj.matches;
    }



}
