package iplanalyser.enums;

import iplanalyser.dao.WicketsDAO;
import iplanalyser.model.WicketClass;

import java.util.Comparator;

public enum GetWicketComparator {
    AVG(Comparator.comparingDouble(obj->{
        return obj.avg;
    })),
    SR(Comparator.comparingDouble(obj->{
        return obj.sr;
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
        if(obj.sr!=0&&obj.avg!=0)
            return obj.sr+obj.avg;
        return 100;
    }));

    private Comparator comparator;

    GetWicketComparator(Comparator<WicketsDAO> classComparator){
        this.comparator=classComparator;
    }

    public Comparator getComparator() {
        return comparator;
    }
}
