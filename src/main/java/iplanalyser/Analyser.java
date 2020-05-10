package iplanalyser;

import censusanalyser.opencsvbuilder.CSVBuilderFactory;
import censusanalyser.opencsvbuilder.ICSVBuilder;
import iplanalyser.enums.Type;

import java.util.HashMap;
import java.util.List;

public class Analyser {
    Class className, daoClass;
    HashMap<Class, List> hmap = new HashMap<>();

    public List getData(String filePath, String type) {
        className = Type.valueOf(type.toUpperCase()).getKlass();
        daoClass = Type.valueOf(type.toUpperCase()).getDaoClass();
        hmap.put(daoClass, LoadData.loadData(filePath, className));
        return this.hmap.get(daoClass);
    }

}