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
    })),
    SIXFOURS(Comparator.comparing(obj->{
        return obj.six+obj.four;
    })),
    STRIKERATEWITHSIXANDFOUR(Comparator.comparingDouble(obj->
            ((obj.four*4 + obj.six*6)/obj.matches)
    )),
    AVGSR(Comparator.comparingDouble(obj->{
        return obj.avg+obj.sr;
    }));

    private Comparator comparator;

    GetData(Comparator<IPLDAO> comparator){
        this.comparator=comparator;
    }

    public Comparator getComparator() {
        return comparator;
    }
}
