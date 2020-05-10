package iplanalyser;

import iplanalyser.model.RunClass;
import iplanalyser.model.WicketClass;
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

    @Test
    public void testPasses_forGettingPlayerWithMax4sAnd6s(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] runArray = iplAnalyser.sortRun(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"six fours");
        Assert.assertEquals("Andre Russell",runArray[0].player);
    }

    @Test
    public void testPasses_forGettingPlayerWithMin4sAnd6s(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] runArray = iplAnalyser.sortRun(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"six fours");
        Assert.assertEquals("Shakib Al Hasan",runArray[runArray.length-1].player);
    }


    @Test
    public void testPasses_forGettingPlayer_OfBestStrikeRate_WithMax4sAnd6s(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] runArray = iplAnalyser.sortRun(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"strike rate with six and four");
        Assert.assertEquals("Andre Russell",runArray[0].player);
    }

    @Test
    public void testPasses_forGettingPlayer_OfWorstStrikeRate_WithMin4sAnd6s(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] runArray = iplAnalyser.sortRun(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"strike rate with six and four");
        Assert.assertEquals("Pawan Negi",runArray[runArray.length-1].player);
    }

    @Test
    public void testPasses_forGettingPlayer_OfBestStrikeRate_WithAverage(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] runArray = iplAnalyser.sortRun(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"avg sr");
        Assert.assertEquals("Ishant Sharma",runArray[0].player);
    }

    @Test
    public void testPasses_forGettingPlayer_OfWorstStrikeRate_WithAverage(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] runArray = iplAnalyser.sortRun(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"avg sr");
        Assert.assertEquals("Bhuvneshwar Kumar",runArray[runArray.length-1].player);
    }

    @Test
    public void testPasses_forGettingPlayer_WithMaxRuns(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] runArray = iplAnalyser.sortRun(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"runs");
        Assert.assertEquals("David Warner",runArray[0].player);
    }

    @Test
    public void testPasses_forGettingPlayer_WithMinRuns(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] runArray = iplAnalyser.sortRun(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"runs");
        Assert.assertEquals("Pawan Negi",runArray[runArray.length-1].player);
    }

    @Test
    public void testPasses_WhenReturnsCorrectCountForWicketCSV(){
        List list = iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        Assert.assertEquals(99,list.size());
    }


    @Test
    public void testPasses_ForGetting_WorstBowlingAverages(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        WicketClass[] wicketObjectArray = iplAnalyser.sortWicket(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"avg");
        Assert.assertEquals("Mandeep Singh",wicketObjectArray[0].player);

    }

    @Test
    public void testPasses_ForGetting_TopBowlingAverages(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        WicketClass[] wicketObjectArray = iplAnalyser.sortWicket(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"avg");
        Assert.assertEquals("Krishnappa Gowtham",wicketObjectArray[wicketObjectArray.length-1].player);

    }

    @Test
    public void testPasses_ForGetting_WorstBowlingStrikeRate(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        WicketClass[] wicketObjectArray = iplAnalyser.sortWicket(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"sr");
        Assert.assertEquals("Mandeep Singh",wicketObjectArray[0].player);

    }

    @Test
    public void testPasses_ForGetting_TopBowlingStrikeRate(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        WicketClass[] wicketObjectArray = iplAnalyser.sortWicket(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"sr");
        Assert.assertEquals("Krishnappa Gowtham",wicketObjectArray[wicketObjectArray.length-1].player);

    }


    @Test
    public void testPasses_ForGetting_BestBowlingEconomy(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        WicketClass[] wicketObjectArray = iplAnalyser.sortWicket(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"economy");
        Assert.assertEquals("Shivam Dube",wicketObjectArray[0].player);

    }

    @Test
    public void testPasses_ForGetting_WorstBowlingEconomy(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        WicketClass[] wicketObjectArray = iplAnalyser.sortWicket(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"economy");
        Assert.assertEquals("Ben Cutting",wicketObjectArray[wicketObjectArray.length-1].player);

    }

    @Test
    public void testPasses_ForGetting_BestStrikeRateWith4wAnd5w(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        WicketClass[] wicketObjectArray = iplAnalyser.sortWicket(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"sr four five");
        Assert.assertEquals("Yuzvendra Chahal",wicketObjectArray[0].player);

    }

    @Test
    public void testPasses_ForGetting_WorstStrikeRateWith4wAnd5w(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        WicketClass[] wicketObjectArray = iplAnalyser.sortWicket(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"sr four five");
        Assert.assertEquals("Liam Livingstone",wicketObjectArray[wicketObjectArray.length-1].player);

    }

    @Test
    public void testPasses_ForGetting_BestStrikeRateAndAverage(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        WicketClass[] wicketObjectArray = iplAnalyser.sortWicket(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"sr avg");
        Assert.assertEquals("Anukul Roy",wicketObjectArray[0].player);

    }

    @Test
    public void testPasses_ForGetting_WorstStrikeRateAndAverage(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        WicketClass[] wicketObjectArray = iplAnalyser.sortWicket(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"sr avg");
        Assert.assertEquals("Krishnappa Gowtham",wicketObjectArray[wicketObjectArray.length-1].player);

    }




}

