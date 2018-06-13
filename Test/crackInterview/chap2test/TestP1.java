package crackInterview.chap2test;

import crackInterview.chap2.*;
import org.junit.*;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by changmin on 2018. 6. 12..
 */
public class TestP1 {
    @Test
    public void test_HashTableCheck(){
        int[] input = new int[]{1,2,3,3,3,4,5,5,5,5,5,6,7,8,9,9,9,9,9,10};
        int[] output = new int[]{1,2,3,4,5,6,7,8,9,10};
        List<Integer> inputList = new LinkedList<Integer>();
        for(int value : input){
            inputList.add(value);
        }
        List<Integer> outputTestList = new LinkedList<>();
        for(int value : output){
            outputTestList.add(value);
        }

        assertEquals(new P1().removeDuplication(inputList), outputTestList);
    }

    @Test
    public void test_NoHashTableCheck(){
        int[] input = new int[]{1,2,3,3,3,4,5,5,5,5,5,6,7,8,9,9,9,9,9,10};
        int[] output = new int[]{1,2,3,4,5,6,7,8,9,10};
        List<Integer> inputList = new LinkedList<Integer>();
        for(int value : input){
            inputList.add(value);
        }
        List<Integer> outputTestList = new LinkedList<>();
        for(int value : output){
            outputTestList.add(value);
        }

        assertEquals(new P1().removeDuplication2(inputList), outputTestList);
    }


}
