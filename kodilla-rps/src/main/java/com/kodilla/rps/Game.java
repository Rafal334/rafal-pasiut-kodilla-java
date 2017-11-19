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
    private boolean restartGame = false;
    private String playerName;

    public Game(ArrayList<Champion> champions) {
        wins = 0;
        loses = 0;
        roundCount = 1;
        maxCount = 3;
        this.champions = champions;
        gameMaster = new GameMaster();
    }

    public Game() {
        wins = 0;
        loses = 0;
        roundCount = 1;
        maxCount = 3;
        gameMaster = new GameMaster();
        champions = new ArrayList<>();
        champions.add(new Rock());
        champions.add(new Scissors());
        champions.add(new Paper());
        champions.add(new Spock());
        champions.add(new Lizard());
    }

    public void play() {
        enterPlayerName();
        init();
        while (!quitGame) {
            if (restartGame) {
                init();
                restartGame = false;
            }
            gameMaster.roundBegin(roundCount);
            round();
            if (isGameFinished()) {
                gameMaster.endGame(wins >= maxCount, playerName);
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
        enterNumberOfRoundToWin();
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
                } else if (restartGame) {
                    roundFinished = true;
                    restartGame = true;
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
            if (confirmAction("quit the game")) {
                quitGame = true;
            }
        } else if (lowercaseInput.equals("restart")) {
            if (confirmAction("restart the game")) {
                restartGame = true;
            }
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

    private boolean confirmAction(String action) {
        System.out.println("Do you really want to " + action + "?. Write yes or no.");
        while (true) {
            String answer = readUserInput();
            if (answer.toLowerCase().equals("yes")) {
                return true;
            } else if (answer.toLowerCase().equals("no")) {
                return false;
            } else {
                System.out.println("Wrong answer. Write yes or no.");
            }
        }
    }

    private void enterPlayerName() {
        boolean nameNotValid = true;
        while (nameNotValid) {
            gameMaster.askForName();
            String input = readUserInput();
            if (!input.isEmpty()) {
                playerName = input;
                nameNotValid = false;
            } else {
                System.out.println("Name cannot be empty.");
            }
        }
    }

    private void enterNumberOfRoundToWin() {
        boolean roundCountNotValid = true;
        while (roundCountNotValid) {
            gameMaster.askForRoundCount();
            String input = readUserInput();
            int roundCount;
            try {
                roundCount = Integer.parseInt(input);
                if (roundCount > 0) {
                    maxCount = roundCount;
                    roundCountNotValid = false;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Wrong number. Number must be greater than zero integer.");
            }
        }
    }
}
