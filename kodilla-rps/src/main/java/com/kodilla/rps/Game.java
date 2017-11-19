package com.kodilla.rps;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private Integer wins;
    private Integer loses;
    private Integer maxCount;
    private Integer roundCount;
    private final ArrayList<Champion> champions;
    private GameMaster gameMaster;
    private boolean quitGame = false;

    public Game(Integer maxCount, ArrayList<Champion> champions) {
        wins = 0;
        loses = 0;
        roundCount = 1;
        this.maxCount = maxCount;
        this.champions = champions;
        gameMaster = new GameMaster();
    }

    public Game(Integer maxCount) {
        wins = 0;
        loses = 0;
        roundCount = 1;
        this.maxCount = maxCount;
        gameMaster = new GameMaster();
        champions = new ArrayList<>();
        champions.add(new Rock());
        champions.add(new Scissors());
        champions.add(new Paper());
        champions.add(new Spock());
        champions.add(new Lizard());
    }

    public void play() {
        init();
        while (!quitGame) {
            gameMaster.roundBegin(roundCount);
            round();
            if (isGameFinished()) {
                gameMaster.endGame(wins >= maxCount);
                gameMaster.newGame();
                if (!readUserInput().toLowerCase().equals("yes")) {
                    quitGame = true;
                } else {
                    init();
                }
            } else {
                gameMaster.endRound(wins, loses);
            }
        }
        gameMaster.exitingGame();

    }

    private void init() {
        wins = 0;
        loses = 0;
        roundCount = 1;
        gameMaster.startTheGame();
        gameMaster.help(champions);
    }

    private void round() {
        String input;
        boolean roundFinished = false;
        Champion playerChampion, computerChampion;
        int fightResult;
        while (!roundFinished) {
            gameMaster.chooseChampion();
            input = readUserInput();
            playerChampion = interpreteInput(input);
            if (playerChampion != null) {
                gameMaster.playerChampionSelected(playerChampion);
                computerChampion = randomChampion();
                gameMaster.computerChampionSelected(computerChampion);
                fightResult = fight(playerChampion, computerChampion);
                gameMaster.fightResult(fightResult, playerChampion, computerChampion);
                if (fightResult == 1) {
                    wins++;
                } else if (fightResult == 2) {
                    loses++;
                }
                roundFinished = true;
            } else {
                if (quitGame) {
                    roundFinished = true;
                }
            }
        }
        roundCount++;
    }

    private String readUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private Champion interpreteInput(String input) {
        final String lowercaseInput = input.toLowerCase();
        if (lowercaseInput.equals("help")) {
            gameMaster.help(champions);
        } else if (lowercaseInput.equals("exit")) {
            quitGame = true;
        } else if (champions.stream().map(champion -> champion.getName().toLowerCase()).anyMatch(name -> name.contains(lowercaseInput))) {
            return getChampion(input);
        } else {
            gameMaster.unnownInput();
        }
        return null;
    }

    private Champion getChampion(String name) {

        for (Champion champion : champions) {
            if (champion.getName().toLowerCase().equals(name.toLowerCase())) {
                return champion;
            }
        }
        return null;
    }

    private Champion randomChampion() {
        Random random = new Random();
        return champions.get(random.nextInt(champions.size()));
    }

    private int fight(Champion player, Champion computer) {
        if (player == computer) {
            return 0;   //tie
        } else if (player.getWins().containsKey(computer.getName())) {
            return 1;   //player wins
        } else {
            return 2;   //computer wins
        }
    }

    private boolean isGameFinished() {
        return wins >= maxCount || loses >= maxCount;
    }
}
