package iplanalyser;

import censusanalyser.opencsvbuilder.CSVBuilderFactory;
import censusanalyser.opencsvbuilder.ISortBuilder;
import com.google.gson.Gson;
import iplanalyser.enums.GetRunComparator;
import iplanalyser.enums.GetWicketComparator;
import iplanalyser.enums.Type;
import iplanalyser.model.RunClass;
import iplanalyser.model.WicketClass;

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

    public RunClass[] sortRun(String filePath,String type) {
        return sortRunClass(GetRunComparator.valueOf(type.toUpperCase().replace(" ","")).getComparator(),getFileName(filePath));
    }

    public RunClass[] sortRunClass(Comparator comparator,String fileName){
        ISortBuilder builder = CSVBuilderFactory.getSortBuilder();
        return new Gson().fromJson(builder.sortData(comparator,hmap.get(fileName)),RunClass[].class);
    }

    public WicketClass[] sortWicket(String filePath, String type){
        ISortBuilder builder = CSVBuilderFactory.getSortBuilder();
        String sortedString = builder.sortData(GetWicketComparator.valueOf(type.toUpperCase().replace(" ","")).getComparator(),hmap.get(getFileName(filePath)));
        return reverse(new Gson().fromJson(sortedString,WicketClass[].class));

    }

    private WicketClass[] reverse(WicketClass[] wicketArray) {
        for(int startIndex=0,endIndex=wicketArray.length-1;startIndex<endIndex;startIndex++,endIndex--){
            WicketClass temp = wicketArray[startIndex];
            wicketArray[startIndex]=wicketArray[endIndex];
            wicketArray[endIndex]=temp;
        }
        return wicketArray;
    }

}