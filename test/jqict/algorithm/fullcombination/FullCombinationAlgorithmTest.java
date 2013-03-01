package jqict.algorithm.fullcombination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jqict.core.Algorithm;
import jqict.core.CombinationTable;
import jqict.core.Dimension;
import jqict.core.DimensionTable;
import junit.framework.TestCase;

import org.junit.Test;

public class FullCombinationAlgorithmTest extends TestCase {

        @Test
        public void test0() {
                Algorithm target = new FullCombinationAlgorithm();

                List<Dimension> dimensions = new ArrayList<Dimension>();
                dimensions.add(new Dimension(1L, "hoge1", Arrays
                                .asList(new String[] { "T", "F" })));

                CombinationTable ct = target.generate(new DimensionTable(
                                dimensions), -1);
                String ret = "[";
                ret += "[{id:1,name:hoge1,value:T}],";
                ret += "[{id:1,name:hoge1,value:F}]";
                ret += "]";

                assertEquals(ret, ct.toString());

        }

        @Test
        public void test1() {
                Algorithm target = new FullCombinationAlgorithm();

                List<Dimension> dimensions = new ArrayList<Dimension>();
                dimensions.add(new Dimension(1L, "hoge1", Arrays
                                .asList(new String[] { "T", "F" })));
                dimensions.add(new Dimension(2L, "hoge2", Arrays
                                .asList(new String[] { "0", "1" })));

                CombinationTable ct = target.generate(new DimensionTable(
                                dimensions), -1);

                String ret = "[";
                ret += "[{id:1,name:hoge1,value:T},{id:2,name:hoge2,value:0}],";
                ret += "[{id:1,name:hoge1,value:T},{id:2,name:hoge2,value:1}],";
                ret += "[{id:1,name:hoge1,value:F},{id:2,name:hoge2,value:0}],";
                ret += "[{id:1,name:hoge1,value:F},{id:2,name:hoge2,value:1}]";
                ret += "]";

                assertEquals(ret, ct.toString());

        }

        @Test
        public void test2() {
                Algorithm target = new FullCombinationAlgorithm();

                List<Dimension> dimensions = new ArrayList<Dimension>();
                dimensions.add(new Dimension(3L, "hoge1", Arrays
                                .asList(new String[] { "T" })));
                dimensions.add(new Dimension(4L, "hoge2", Arrays
                                .asList(new String[] { "0", "1" })));

                CombinationTable ct = target.generate(new DimensionTable(
                                dimensions), -1);

                String ret = "[";
                ret += "[{id:3,name:hoge1,value:T},{id:4,name:hoge2,value:0}],";
                ret += "[{id:3,name:hoge1,value:T},{id:4,name:hoge2,value:1}]";
                ret += "]";

                assertEquals(ret, ct.toString());
        }

        @Test
        public void test3() {
                Algorithm target = new FullCombinationAlgorithm();

                List<Dimension> dimensions = new ArrayList<Dimension>();
                dimensions.add(new Dimension(1L, "hoge1", Arrays
                                .asList(new String[] { "T", "F" })));
                dimensions.add(new Dimension(2L, "hoge2", Arrays
                                .asList(new String[] { "0" })));

                CombinationTable ct = target.generate(new DimensionTable(
                                dimensions), -1);
                String ret = "[";
                ret += "[{id:1,name:hoge1,value:T},{id:2,name:hoge2,value:0}],";
                ret += "[{id:1,name:hoge1,value:F},{id:2,name:hoge2,value:0}]";
                ret += "]";

                assertEquals(ret, ct.toString());
        }

        @Test
        public void test4() {
                Algorithm target = new FullCombinationAlgorithm();

                List<Dimension> dimensions = new ArrayList<Dimension>();
                dimensions.add(new Dimension(1L, "hoge1", Arrays
                                .asList(new String[] { "T", "F" })));
                dimensions.add(new Dimension(2L, "hoge2", Arrays
                                .asList(new String[] { "0", "1", "2" })));

                CombinationTable ct = target.generate(new DimensionTable(
                                dimensions), -1);
                String ret = "[";
                ret += "[{id:1,name:hoge1,value:T},{id:2,name:hoge2,value:0}],";
                ret += "[{id:1,name:hoge1,value:T},{id:2,name:hoge2,value:1}],";
                ret += "[{id:1,name:hoge1,value:T},{id:2,name:hoge2,value:2}],";
                ret += "[{id:1,name:hoge1,value:F},{id:2,name:hoge2,value:0}],";
                ret += "[{id:1,name:hoge1,value:F},{id:2,name:hoge2,value:1}],";
                ret += "[{id:1,name:hoge1,value:F},{id:2,name:hoge2,value:2}]";
                ret += "]";

                assertEquals(ret, ct.toString());

        }

        @Test
        public void test5() {
                Algorithm target = new FullCombinationAlgorithm();

                List<Dimension> dimensions = new ArrayList<Dimension>();
                dimensions.add(new Dimension(1L, "hoge1", Arrays
                                .asList(new String[] { "T", "F", "G" })));
                dimensions.add(new Dimension(2L, "hoge2", Arrays
                                .asList(new String[] { "0", "1" })));

                CombinationTable ct = target.generate(new DimensionTable(
                                dimensions), 0);
                
                String ret = "[]";

                assertEquals(ret, ct.toString());

        }
        
        @Test
        public void test6() {
                Algorithm target = new FullCombinationAlgorithm();

                List<Dimension> dimensions = new ArrayList<Dimension>();
                dimensions.add(new Dimension(1L, "hoge1", Arrays
                                .asList(new String[] { "T", "F", "G" })));
                dimensions.add(new Dimension(2L, "hoge2", Arrays
                                .asList(new String[] { "0", "1" })));

                CombinationTable ct = target.generate(new DimensionTable(
                                dimensions), 5);
                
                String ret = "[";
                ret += "[{id:1,name:hoge1,value:T},{id:2,name:hoge2,value:0}],";
                ret += "[{id:1,name:hoge1,value:T},{id:2,name:hoge2,value:1}],";
                ret += "[{id:1,name:hoge1,value:F},{id:2,name:hoge2,value:0}],";
                ret += "[{id:1,name:hoge1,value:F},{id:2,name:hoge2,value:1}],";
                ret += "[{id:1,name:hoge1,value:G},{id:2,name:hoge2,value:0}]";
                //ret += "[{name:hoge1,value:G},{name:hoge2,value:1},],";
                ret += "]";

                assertEquals(ret, ct.toString());

        }

}