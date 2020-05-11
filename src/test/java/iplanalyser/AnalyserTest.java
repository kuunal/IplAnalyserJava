package iplanalyser;

import iplanalyser.enums.GetRunComparator;
import iplanalyser.enums.GetWicketComparator;
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
    public void givenCSVFile_WhenCorrect_ReturnsCorrectCount(){
        List list = iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        Assert.assertEquals(100,list.size());
    }

    //UC1
    @Test
    public void givenCSVFile_WhenCorrect_ReturnsTopAverageBatsman(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] runArray = iplAnalyser.sortRun(IPL_2019_FACTSHEET_MOST_RUNS_CSV,GetRunComparator.BATTING_AVERAGE);
        Assert.assertEquals("MS Dhoni",runArray[0].player);
    }

    @Test
    public void givenCSVFile_WhenCorrect_ReturnsWorstAverageBatsman(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] runArray = iplAnalyser.sortRun(IPL_2019_FACTSHEET_MOST_RUNS_CSV,GetRunComparator.BATTING_AVERAGE);
        Assert.assertEquals("Alzarri Joseph",runArray[runArray.length-1].player);
    }

    //UC2
    @Test
    public void givenCSVFile_WhenCorrect_ReturnsPlayerWithBestStrikeRate(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] runArray = iplAnalyser.sortRun(IPL_2019_FACTSHEET_MOST_RUNS_CSV,GetRunComparator.BATTING_STRIKE_RATE);
        Assert.assertEquals("Ishant Sharma",runArray[0].player);
    }

    @Test
    public void givenCSVFile_WhenCorrect_ReturnsPlayer_WithWorstStrikeRate(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] runArray = iplAnalyser.sortRun(IPL_2019_FACTSHEET_MOST_RUNS_CSV,GetRunComparator.BATTING_STRIKE_RATE);
        Assert.assertEquals("Bhuvneshwar Kumar",runArray[runArray.length-1].player);
    }

    //UC3
    @Test
    public void givenCSVFile_WhenCorrect_ReturnsPlayer_WithMax4sAnd6s(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] runArray = iplAnalyser.sortRun(IPL_2019_FACTSHEET_MOST_RUNS_CSV,GetRunComparator.TOTAL_SIX_FOURS);
        Assert.assertEquals("Andre Russell",runArray[0].player);
    }

    @Test
    public void givenCSVFile_WhenCorrect_ReturnsPlayer_WithMin4sAnd6s(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] runArray = iplAnalyser.sortRun(IPL_2019_FACTSHEET_MOST_RUNS_CSV,GetRunComparator.TOTAL_SIX_FOURS);
        Assert.assertEquals("Shakib Al Hasan",runArray[runArray.length-1].player);
    }

//uc4
    @Test
    public void givenCSVFile_WhenCorrect_Returns_BestStrikeRate_WithMax4sAnd6s(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] runArray = iplAnalyser.sortRun(IPL_2019_FACTSHEET_MOST_RUNS_CSV,GetRunComparator.STRIKE_RATE_WITH_SIX_AND_FOUR);
        Assert.assertEquals("Andre Russell",runArray[0].player);
    }

    @Test
    public void givenCSVFile_WhenCorrect_ReturnsWorstStrikeRate_WithMin4sAnd6s(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] runArray = iplAnalyser.sortRun(IPL_2019_FACTSHEET_MOST_RUNS_CSV,GetRunComparator.STRIKE_RATE_WITH_SIX_AND_FOUR);
        Assert.assertEquals("Pawan Negi",runArray[runArray.length-1].player);
    }

    //uc5
    @Test
    public void givenCSVFile_WhenCorrect_ReturnsPlayer_OfBestStrikeRate_WithAverage(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] runArray = iplAnalyser.sortRun(IPL_2019_FACTSHEET_MOST_RUNS_CSV,GetRunComparator.TOTAL_AVERAGE_WITH_STRIKE_RATE);
        Assert.assertEquals("Andre Russell",runArray[0].player);
    }

    @Test
    public void givenCSVFile_WhenCorrect_ReturnsPlayer_OfWorstStrikeRate_WithAverage(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] runArray = iplAnalyser.sortRun(IPL_2019_FACTSHEET_MOST_RUNS_CSV,GetRunComparator.TOTAL_AVERAGE_WITH_STRIKE_RATE);
        Assert.assertEquals("Alzarri Joseph",runArray[runArray.length-1].player);
    }

    //uc6
    @Test
    public void givenCSVFile_WhenCorrect_ReturnsPlayer_WithMaxRuns(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] runArray = iplAnalyser.sortRun(IPL_2019_FACTSHEET_MOST_RUNS_CSV,GetRunComparator.TOTAL_RUNS);
        Assert.assertEquals("David Warner",runArray[0].player);
    }

    @Test
    public void givenCSVFile_WhenCorrect_ReturnsPlayer_WithMinRuns(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] runArray = iplAnalyser.sortRun(IPL_2019_FACTSHEET_MOST_RUNS_CSV,GetRunComparator.TOTAL_RUNS);
        Assert.assertEquals("Pawan Negi",runArray[runArray.length-1].player);
    }

    @Test
    public void givenCSVFile_WhenCorrect_ReturnsCorrectCountForWicketCSV(){
        List list = iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        Assert.assertEquals(99,list.size());
    }

    //UC7
    @Test
    public void givenCSVFile_WhenCorrect_ReturnsPlayerWith_WorstBowlingAverages(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        WicketClass[] wicketObjectArray = iplAnalyser.sortWicket(IPL_2019_FACTSHEET_MOST_WKTS_CSV, GetWicketComparator.BOWLING_AVERAGE);
        Assert.assertEquals("Krishnappa Gowtham",wicketObjectArray[wicketObjectArray.length-1].player);

    }

    @Test
    public void givenCSVFile_WhenCorrect_ReturnsPlayerWith_TopBowlingAverages(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        WicketClass[] wicketObjectArray = iplAnalyser.sortWicket(IPL_2019_FACTSHEET_MOST_WKTS_CSV,GetWicketComparator.BOWLING_AVERAGE);
        Assert.assertEquals("Anukul Roy",wicketObjectArray[0].player);

    }

    //uc8
    @Test
    public void givenCSVFile_WhenCorrect_ReturnsPlayerWith_WorstBowlingStrikeRate(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        WicketClass[] wicketObjectArray = iplAnalyser.sortWicket(IPL_2019_FACTSHEET_MOST_WKTS_CSV,GetWicketComparator.BOWLING_STRIKE_RATE);
        Assert.assertEquals("Krishnappa Gowtham ",wicketObjectArray[wicketObjectArray.length-1].player);

    }

    @Test
    public void givenCSVFile_WhenCorrect_ReturnsPlayerWith_TopBowlingStrikeRate(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        WicketClass[] wicketObjectArray = iplAnalyser.sortWicket(IPL_2019_FACTSHEET_MOST_WKTS_CSV,GetWicketComparator.BOWLING_STRIKE_RATE);
        Assert.assertEquals("Alzarri Joseph",wicketObjectArray[0].player);

    }

    //uc9
    @Test
    public void givenCSVFile_WhenCorrect_ReturnsPlayerWith_BestBowlingEconomy(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        WicketClass[] wicketObjectArray = iplAnalyser.sortWicket(IPL_2019_FACTSHEET_MOST_WKTS_CSV,GetWicketComparator.ECONOMY);
        Assert.assertEquals("Shivam Dube",wicketObjectArray[0].player);

    }

    @Test
    public void givenCSVFile_WhenCorrect_ReturnsPlayerWith_WorstBowlingEconomy(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        WicketClass[] wicketObjectArray = iplAnalyser.sortWicket(IPL_2019_FACTSHEET_MOST_WKTS_CSV,GetWicketComparator.ECONOMY);
        Assert.assertEquals("Ben Cutting",wicketObjectArray[wicketObjectArray.length-1].player);

    }

    //uc10
    @Test
    public void givenCSVFile_WhenCorrect_ReturnsPlayerWith_BestStrikeRateWith4wAnd5w(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        WicketClass[] wicketObjectArray = iplAnalyser.sortWicket(IPL_2019_FACTSHEET_MOST_WKTS_CSV,GetWicketComparator.STRIKE_RATE_WITH_FOUR_AND_FIVE_WICKETS);
        Assert.assertEquals("Alzarri Joseph",wicketObjectArray[0].player);

    }

    @Test
    public void givenCSVFile_WhenCorrect_ReturnsPlayerWith_WorstStrikeRateWith4wAnd5w(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        WicketClass[] wicketObjectArray = iplAnalyser.sortWicket(IPL_2019_FACTSHEET_MOST_WKTS_CSV,GetWicketComparator.STRIKE_RATE_WITH_FOUR_AND_FIVE_WICKETS);
        Assert.assertEquals("Liam Livingstone",wicketObjectArray[wicketObjectArray.length-1].player);

    }

    //uc11
    @Test
    public void givenCSVFile_WhenCorrect_ReturnsPlayerWith_BestStrikeRateAndAverage(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        WicketClass[] wicketObjectArray = iplAnalyser.sortWicket(IPL_2019_FACTSHEET_MOST_WKTS_CSV,GetWicketComparator.STRIKE_RATE_WITH_AVERAGE);
        Assert.assertEquals("Anukul Roy",wicketObjectArray[0].player);

    }

    @Test
    public void givenCSVFile_WhenCorrect_ReturnsPlayerWith_WorstStrikeRateAndAverage(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        WicketClass[] wicketObjectArray = iplAnalyser.sortWicket(IPL_2019_FACTSHEET_MOST_WKTS_CSV,GetWicketComparator.STRIKE_RATE_WITH_AVERAGE);
        Assert.assertEquals("Krishnappa Gowtham",wicketObjectArray[wicketObjectArray.length-1].player);

    }


    //uc12
    @Test
    public void givenCSVFile_WhenCorrect_ReturnsPlayerWith_MaxWickets(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        WicketClass[] wicketObjectArray = iplAnalyser.sortWicket(IPL_2019_FACTSHEET_MOST_WKTS_CSV,GetWicketComparator.WICKETS);
        Assert.assertEquals("Imran Tahir",wicketObjectArray[wicketObjectArray.length-1].player);

    }
    //uc13

    @Test
    public void  givenCSVFile_WhenCorrect_ReturnsPlayerWith_BestAverage_InBatingAndBowling(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        RunClass[] obj = iplAnalyser.merge(IPL_2019_FACTSHEET_MOST_RUNS_CSV, GetRunComparator.MOST_BATTING_AND_BOWLING_AVERAGE,IPL_2019_FACTSHEET_MOST_WKTS_CSV);
        Assert.assertEquals("Andre Russell",obj[0].player);
    }

    @Test
    public void givenCSVFile_ReturnsPlayerWithWorstAverage_InBattingAndBowling(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        RunClass[] obj = iplAnalyser.merge(IPL_2019_FACTSHEET_MOST_RUNS_CSV, GetRunComparator.MOST_BATTING_AND_BOWLING_AVERAGE,IPL_2019_FACTSHEET_MOST_WKTS_CSV);
        Assert.assertEquals("Krishnappa Gowtham",obj[obj.length-1].player);
    }

    //uc14
    @Test
    public void  givenCSVFile_WhenCorrect_PlayerWithMostRunsAndWicket(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        RunClass[] obj = iplAnalyser.merge(IPL_2019_FACTSHEET_MOST_RUNS_CSV, GetRunComparator.MOST_RUNS_AND_WICKET,IPL_2019_FACTSHEET_MOST_WKTS_CSV);
        Assert.assertEquals("Andre Russell",obj[0].player);
    }

    @Test
    public void  givenCSVFile_WhenCorrect_ReturnsPlayerWithLeastRunsAndWicket(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        RunClass[] obj = iplAnalyser.merge(IPL_2019_FACTSHEET_MOST_RUNS_CSV, GetRunComparator.MOST_RUNS_AND_WICKET,IPL_2019_FACTSHEET_MOST_WKTS_CSV);
        Assert.assertEquals("Sarfaraz Khan",obj[obj.length-1].player);
    }
}

