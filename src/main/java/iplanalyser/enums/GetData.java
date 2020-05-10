package iplanalyser.enums;

import iplanalyser.dao.RunDAO;

import java.util.Comparator;

import static java.util.Comparator.comparing;

public enum GetData {

    AVG(Comparator.comparingDouble(obj -> {
        return obj.avg;
    }));

    private Comparator<RunDAO> comparator;

    GetData(Comparator<RunDAO> comparator){
        this.comparator=comparator;
    }

    public Comparator<RunDAO> getComparator() {
        return comparator;
    }

}
