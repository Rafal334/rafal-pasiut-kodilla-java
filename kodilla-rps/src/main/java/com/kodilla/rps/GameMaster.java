package com.kodilla.rps;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GameMaster {

    public void startTheGame() {
        System.out.println("New game is starting now.");
    }

    public void help(ArrayList<Champion> champions) {
        System.out.println();
        System.out.print("Choose your champion by writing it`s name. Available champions: ");
        champions.stream().map(champion -> champion.getName()).forEach(name -> System.out.print(name + "  "));
        System.out.println("\nWrite \"help\" to show this message again.");
        System.out.println("Write \"restart\" to reset the win/loose count and start again.");
        System.out.println("Write \"exit\" to quit.");
        System.out.println();
    }

    public void roundBegin(int roundCount) {
        System.out.println("Round " + roundCount + ".");
    }

    public void unnownInput() {
        System.out.println("Unrecognized command. Type \"help\" for help");
    }

    public void chooseChampion() {
        System.out.println("Choose your champion");
    }

    public void playerChampionSelected(Champion champion) {
        System.out.println("You chose: " + champion.getName());
    }

    public void fightResult(int result, Champion player, Champion computer) {
        System.out.println();
        switch (result) {
            case 0:
                System.out.println("It`s a tie!");
                break;
            case 1:
                System.out.println(player.getName() + " " + player.getWins().get(computer.getName()) + " " + computer.getName() + "!");
                System.out.println("You win.");
                break;
            case 2:
                System.out.println(computer.getName() + " " + computer.getWins().get(player.getName()) + " " + player.getName() + "!");
                System.out.println("You loose.");
                break;
        }
        sleep(2);
        System.out.println();
    }

    public void computerChampionSelected(Champion champion) {
        System.out.print("Computer choose... ");
        sleepOneSecond();
        System.out.println(champion.getName());
        sleepOneSecond();
    }

    public void endGame(boolean result, String name) {
        if (result) {
            System.out.println("Congratulations " + name + "! You have won the game!");
        } else {
            System.out.println("Bad luck " + name + " ... You have lost the game.");
        }
    }

    public void exitingGame() {
        System.out.println("Exiting game...");
    }

    public void endRound(int wins, int loses) {
        System.out.print("Round has ended. ");
        if (wins > loses) {
            System.out.println("You`re wining: " + wins + " to " + loses);
        } else if (loses > wins) {
            System.out.println("You`re loosing: " + loses + " to " + wins);
        } else {
            System.out.println("Tie for now: " + loses + " to " + wins);
        }
    }

    public void newGame() {
        System.out.println("Do you want to play one more time? - hit YES if so. Anything else to quit.");
    }

    public void askForName() {
        System.out.println("Please enter your name.");
    }

    public void askForRoundCount() {
        System.out.println("To how many wins we play?");
    }

    private void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (java.lang.InterruptedException exception) {
            System.out.println("Sleep ERROR");
            //TODO exception handling
        }
    }

    private void sleepOneSecond() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (java.lang.InterruptedException exception) {
            System.out.println("Sleep ERROR");
            //TODO exception handling
        }
    }
}
