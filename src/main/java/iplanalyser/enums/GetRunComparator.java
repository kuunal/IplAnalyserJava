package iplanalyser.enums;

import iplanalyser.dao.RunDAO;

import java.util.Comparator;

import static java.util.Comparator.comparing;

public enum GetRunComparator {

    AVG(Comparator.comparingDouble(obj -> {
        return obj.avg;
    })),
    SR(Comparator.comparingDouble(obj->{
        return obj.sr;
    })),
    SIXFOURS(Comparator.comparing(obj->{
        return obj.six+obj.four;
    })),
    STRIKERATEWITHSIXANDFOUR(Comparator.comparingDouble(obj->
            ((obj.four*4 + obj.six*6)/obj.matches)
    )),
    AVGSR(Comparator.comparingDouble(obj->{
        return obj.avg+obj.sr;
    })),
    RUNS(Comparator.comparing(obj->{
        return obj.run;
    }));


    private Comparator comparator;

    GetRunComparator(Comparator<RunDAO> comparator){
        this.comparator=comparator;
    }

    public Comparator getComparator() {
        return comparator;
    }
}
