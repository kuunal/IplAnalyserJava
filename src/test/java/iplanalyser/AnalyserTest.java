package iplanalyser;

import iplanalyser.model.RunClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AnalyserTest {
    Analyser iplAnalyser;
    static final String IPL_2019_FACTSHEET_MOST_RUNS_CSV ="./src/test/resources/IPL2019FactsheetMostRuns.csv";
    static final String IPL_2019_FACTSHEET_MOST_WKTS_CSV ="./src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Before
    public void init(){
        iplAnalyser = new Analyser();
    }

    @Test
    public void testPasses_WhenReturnsCorrectCount(){
        List list = iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        Assert.assertEquals(100,list.size());
    }

    @Test
    public void testPasses_ForGettingTopAverageBatsman(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] runArray = iplAnalyser.sortRun(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"avg");
        Assert.assertEquals("MS Dhoni",runArray[0].player);
    }

    @Test
    public void testPasses_ForGettingWorstAverageBatsman(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] runArray = iplAnalyser.sortRun(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"avg");
        Assert.assertEquals("Alzarri Joseph",runArray[runArray.length-1].player);
    }

    @Test
    public void testPasses_forGettingPlayerWithBestStrikeRate(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] runArray = iplAnalyser.sortRun(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"sr");
        Assert.assertEquals("Ishant Sharma",runArray[0].player);
    }

    @Test
    public void testPasses_forGettingPlayerWithWorstStrikeRate(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] runArray = iplAnalyser.sortRun(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"sr");
        Assert.assertEquals("Bhuvneshwar Kumar",runArray[runArray.length-1].player);
    }





}

