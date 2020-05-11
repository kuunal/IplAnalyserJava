package iplanalyser;

import censusanalyser.opencsvbuilder.CSVBuilderFactory;
import censusanalyser.opencsvbuilder.ICSVBuilder;
import iplanalyser.dao.RunDAO;
import iplanalyser.model.RunClass;
import iplanalyser.model.WicketClass;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class LoadData {
    public static <E> ArrayList loadData(String filePath, Class className) {
        try(Reader reader = Files.newBufferedReader(Paths.get(filePath));){
            ArrayList arr = new ArrayList<>();
            ICSVBuilder builder = CSVBuilderFactory.getBuilder();
            Iterator<E> censusCSVIterator = builder.getCSVFileIterator(reader,className);
            Iterable<E> censusIterable = ()-> censusCSVIterator;
            StreamSupport.stream(censusIterable.spliterator(),false)
                    .forEach(csvObject -> {
                        if(className.equals(RunClass.class))
                            arr.add(new RunDAO((RunClass) csvObject));
                        else
                            arr.add(new RunDAO((WicketClass)csvObject));
                    });
            return arr;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
