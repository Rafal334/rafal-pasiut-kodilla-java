package com.kodilla.ChristmasTree;

public class ChristmasTree {
    private int levels;

    public ChristmasTree(int levels) {
        this.levels = levels;
    }

    public void generateTree() {

        String line = "";
        int stars;

        for(int i=1;i<=levels;i++) {
            line = "";
            stars = i*2-1;
            for(int j=0; j<stars; j++) {
                line+="*";
            }
            System.out.println(line);
        }
    }

    public void generateCenteredTree() {

        int maxStars = levels*2-1;
        String line;
        int starsCounter;
        int stars;
        String spaces;
        int spacesNumber;

        for(int i=1;i<=levels;i++) {
            line = "";
            stars = i*2-1;

            for(starsCounter=0; starsCounter<stars; starsCounter++) {
                line+="*";
            }

            spaces = "";
            spacesNumber = (maxStars - starsCounter+1)/2;

            for(int j=0;j<spacesNumber;j++) {
                spaces +=" ";
            }

            line = spaces + line + spaces;
            System.out.println(line);
        }
    }
}
