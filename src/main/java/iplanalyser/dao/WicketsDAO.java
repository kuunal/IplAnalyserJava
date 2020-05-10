package iplanalyser.dao;

import iplanalyser.model.WicketClass;

public class WicketsDAO  {


    public String player;
    public Double avg;
    public Double sr;
    public Double economy;
    public Integer fiveWickets;
    public Integer fourWickets;
    public Double over;
    public Integer wickets;

    public WicketsDAO(WicketClass object){
        this.avg=object.avg;
        this.over=object.over;
        this.player=object.player;
        this.sr=object.sr;
        this.economy =object.economy;
        this.fiveWickets=object.fiveWickets;
        this.fourWickets=object.fourWickets;
        this.wickets=object.wickets;
    }


}
