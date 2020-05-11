package iplanalyser.enums;

import iplanalyser.dao.RunDAO;

import java.util.Comparator;

public enum GetWicketComparator {
    AVG(Comparator.comparingDouble(obj->{
        return obj.bowlingAverage;
    })),
    SR(Comparator.comparingDouble(obj->{
        return obj.bowlingStrikeRate;
    })),
    ECONOMY(Comparator.comparingDouble(obj->{
        return obj.economy;
    })),
    SRFOURFIVE(Comparator.comparingDouble(obj->{
        if(obj.fourWickets!=0||obj.fiveWickets!=0)
            return ((obj.fiveWickets*5+obj.fourWickets*4)/obj.over*6);
        return 100;
    })),
    SRAVG(Comparator.comparingDouble(obj->{
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
