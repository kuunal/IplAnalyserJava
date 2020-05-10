package iplanalyser.enums;

import iplanalyser.dao.IPLDAO;

import java.util.Comparator;

import static java.util.Comparator.comparing;

public enum GetData {

    AVG(Comparator.comparingDouble(obj -> {
        return obj.avg;
    })),
    SR(Comparator.comparingDouble(obj->{
        return obj.sr;
    }));

    private Comparator comparator;

    GetData(Comparator<IPLDAO> comparator){
        this.comparator=comparator;
    }

    public Comparator getComparator() {
        return comparator;
    }
}
