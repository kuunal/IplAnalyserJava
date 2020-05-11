package iplanalyser.enums;

import iplanalyser.dao.RunDAO;

import java.util.Comparator;

import static java.util.Comparator.comparing;

public enum GetRunComparator {

    BATTING_AVERAGE(Comparator.comparingDouble(obj -> {
        return obj.battingAverage;
    })),
    BATTING_STRIKE_RATE(Comparator.comparingDouble(obj->{
        return obj.battingStrikeRate;
    })),
    TOTAL_SIX_FOURS(Comparator.comparing(obj->{
        return obj.six+obj.four;
    })),
    STRIKE_RATE_WITH_SIX_AND_FOUR(Comparator.comparingDouble(obj->
            ((obj.four*4 + obj.six*6)/obj.matches)
    )),
    TOTAL_AVERAGE_WITH_STRIKE_RATE(Comparator.comparingDouble(obj->{
        if(obj.battingAverage!=0&&obj.battingStrikeRate!=0)
            return obj.battingAverage + obj.battingStrikeRate;
        return 0;
    })),
    TOTAL_RUNS(Comparator.comparing(obj->{
        return obj.run;
    })),
    MOST_BATTING_AND_BOWLING_AVERAGE(Comparator.comparing(obj->{
        if(obj.battingAverage!=0&&obj.bowlingAverage!=0)
            return obj.battingAverage-obj.bowlingAverage;
        return 0.0;
    })),
    MOST_RUNS_AND_WICKET(Comparator.comparing(obj->{
        if(obj.wickets!=0&&obj.run!=0)
            return obj.wickets+obj.run;
        return 0;
    }));

    private Comparator comparator;

    GetRunComparator(Comparator<RunDAO> comparator){
        this.comparator=comparator;
    }

    public Comparator getComparator() {
        return comparator;
    }
}
