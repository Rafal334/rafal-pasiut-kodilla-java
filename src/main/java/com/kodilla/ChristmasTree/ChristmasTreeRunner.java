package com.kodilla.ChristmasTree;

public class ChristmasTreeRunner {
    public static void main(String[] args)
    {
        ChristmasTree christmasTree = new ChristmasTree(10);
        christmasTree.generateTree();
        System.out.println("\n");
        christmasTree.generateCenteredTree();
    }
}
