package iplanalyser.model;

import com.opencsv.bean.CsvBindByName;

public class WicketClass {
    @CsvBindByName(column = "Ov")
    public Double over;

    @CsvBindByName(column = "5w")
    public Integer fiveWickets;

    @CsvBindByName(column = "4w")
    public Integer fourWickets;

    @CsvBindByName(column = "Avg")
    public Double bowlingAverage;

    @CsvBindByName(column = "PLAYER")
    public String player;

    @CsvBindByName(column = "SR")
    public Double bowlingStrikeRate;

    @CsvBindByName(column = "Econ")
    public Double economy;

    @CsvBindByName(column = "Wkts")
    public Integer wickets;
}
