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
    }));

    private Comparator comparator;

    GetWicketComparator(Comparator<WicketsDAO> classComparator){
        this.comparator=classComparator;
    }

    public Comparator getComparator() {
        return comparator;
    }
}
