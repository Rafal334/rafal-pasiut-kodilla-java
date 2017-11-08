package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;

public class CollectionTestSuite {

    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }
    @After
    public void after(){
        System.out.println("Test Case: end");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList(){
        //Given
        ArrayList<Integer> emptyList = new ArrayList<Integer>();

        //When
        System.out.println("Empty list test.");
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        ArrayList<Integer> result = exterminator.exterminate(emptyList);

        //Then
        Assert.assertEquals(emptyList,result);
    }
    @Test
    public void testOddNumbersExterminatorNullList(){
        //Given
        ArrayList<Integer> nullList = null;
        ArrayList<Integer> emptyList = new ArrayList<Integer>();

        //When
        System.out.println("Null list test.");
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        ArrayList<Integer> result = exterminator.exterminate(nullList);

        //Then
        Assert.assertEquals(emptyList,result);
    }
    @Test
    public void testOddNumbersExterminatorNormalList (){
        //Given
        ArrayList<Integer> checkList = new ArrayList<Integer>();
        ArrayList<Integer> evenList = new ArrayList<Integer>();
        for(int i=0;i<100;i++){
            checkList.add(i);
            if(i%2==0){
                evenList.add(i);
            }
        }

        //When
        System.out.println("Normal list test.");
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        ArrayList<Integer> result = exterminator.exterminate(checkList);

        //Then
        Assert.assertEquals(evenList,result);
    }
}
