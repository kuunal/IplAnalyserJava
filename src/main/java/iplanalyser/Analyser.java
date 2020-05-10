package iplanalyser;

import censusanalyser.opencsvbuilder.CSVBuilderFactory;
import censusanalyser.opencsvbuilder.ICSVBuilder;
import censusanalyser.opencsvbuilder.ISortBuilder;
import com.google.gson.Gson;
import iplanalyser.enums.GetData;
import iplanalyser.enums.Type;
import iplanalyser.model.RunClass;

import java.io.File;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Analyser {
    Class className, daoClass;
    HashMap<String, List> hmap = new HashMap<>();

    public String getFileName(String filePath){
        return new File(filePath).getName();
    }

    public List getData(String filePath, String type) {
        String fileName=getFileName(filePath);
        className = Type.valueOf(type.toUpperCase()).getKlass();
        hmap.put(fileName, LoadData.loadData(filePath, className));
        return this.hmap.get(fileName);
    }


    public RunClass[] sortRunCSV(String filePath,String type) {
        String fileName=getFileName(filePath);
        Comparator comparator= GetData.valueOf(type.trim().toUpperCase()).getComparator();
        ISortBuilder builder = CSVBuilderFactory.getSortBuilder();
        return new Gson().fromJson(builder.sortData(comparator,hmap.get(fileName)),RunClass[].class);
    }
}