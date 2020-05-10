package iplanalyser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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

}

