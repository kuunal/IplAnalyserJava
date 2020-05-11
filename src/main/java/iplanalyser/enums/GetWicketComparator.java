package iplanalyser.enums;

import iplanalyser.dao.RunDAO;

import java.util.Comparator;

public enum GetWicketComparator {
    BOWLING_AVERAGE(Comparator.comparingDouble(obj->{
        if(obj.bowlingStrikeRate!=0)
        return obj.bowlingAverage;
        return 100.0;
    })),
    BOWLING_STRIKE_RATE(Comparator.comparingDouble(obj->{
        if(obj.bowlingStrikeRate!=0)
        return obj.bowlingStrikeRate;
        return 100.0;
    })),
    ECONOMY(Comparator.comparingDouble(obj->{
        if(obj.economy!=0)
            return obj.economy;
        return 100.0;
    })),
    STRIKE_RATE_WITH_FOUR_AND_FIVE_WICKETS(Comparator.comparingDouble(obj->{
            return obj.over*6/(obj.fiveWickets*5+obj.fourWickets*4);
    })),
    STRIKE_RATE_WITH_AVERAGE(Comparator.comparingDouble(obj->{
        if(obj.bowlingAverage!=0&&obj.bowlingStrikeRate!=0)
            return obj.bowlingAverage+obj.bowlingStrikeRate;
        return 100;
    })),
    WICKETS(Comparator.comparing(obj->{
        return obj.wickets;
    }));

    private Comparator comparator;

    GetWicketComparator(Comparator<RunDAO> classComparator){
        this.comparator=classComparator;
    }

    public Comparator getComparator() {
        return comparator;
    }
}
