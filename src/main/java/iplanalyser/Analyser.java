    package iplanalyser;

import censusanalyser.opencsvbuilder.CSVBuilderFactory;
import censusanalyser.opencsvbuilder.ICSVBuilder;
import censusanalyser.opencsvbuilder.ISortBuilder;
import com.google.gson.Gson;
import iplanalyser.dao.RunDAO;
import iplanalyser.enums.GetRunComparator;
import iplanalyser.enums.GetWicketComparator;
import iplanalyser.enums.Type;
import iplanalyser.model.RunClass;
import iplanalyser.model.WicketClass;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Analyser {
    Class className;
    HashMap<String, List<RunDAO>> hmap = new HashMap<>();

    public String getFileName(String filePath){
        return new File(filePath).getName();
    }

    public List getData(String filePath, String type) {
        String fileName=getFileName(filePath);
        className = Type.valueOf(type.toUpperCase()).getKlass();
        hmap.put(fileName, LoadData.loadData(filePath, className));
        return this.hmap.get(fileName);
    }

    public RunClass[] sortRun(String filePath,GetRunComparator type) {
        return sortRunClass(type.getComparator(),getFileName(filePath));
    }

    public RunClass[] sortRunClass(Comparator comparator,String fileName){
        ISortBuilder builder = CSVBuilderFactory.getSortBuilder();
        return new Gson().fromJson(builder.sortData(comparator,hmap.get(fileName)),RunClass[].class);
    }

    public WicketClass[] sortWicket(String filePath, GetWicketComparator type){
        ISortBuilder builder = CSVBuilderFactory.getSortBuilder();
        String sortedString = builder.sortData(type.getComparator(),hmap.get(getFileName(filePath)));
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

    RunClass[] merge(String fileName1, GetRunComparator type, String fileName2){
        String key1 = getFileName(fileName1);
        String key2 = getFileName(fileName2);
        for(int i = 0 ; i < hmap.get(key1).size();i++){
            for(int j = 0 ; j < hmap.get(key2).size();j++){
                if(hmap.get(key1).get(i).player.equals(hmap.get(key2).get(j).player)) {
                    hmap.get(key1).get(i).setBowlingAverage(hmap.get(key2).get(j).bowlingAverage);
                    hmap.get(key1).get(i).setWickets(hmap.get(key2).get(j).wickets);
                    break;
                }
                if(j==hmap.get(key2).size()-1) {
                    hmap.get(key1).get(i).setBowlingAverage(0.0);
                    hmap.get(key1).get(i).setWickets(0);
                }
            }
        }
        ISortBuilder builder = CSVBuilderFactory.getSortBuilder();
        String sortedString = builder.sortData(type.getComparator(), hmap.get(key1));
        return new Gson().fromJson(sortedString,RunClass[].class);

    }
}
