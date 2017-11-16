package com.kodilla.stream.forumuser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileLinesReader {

    private List<String> lines;

    public FileLinesReader(String filePath) {
        try {
            lines = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {   // TODO exception handling
            lines = new ArrayList<>();
            System.out.println("File: " + filePath + " NOT FOUND");
        }
    }

    public String getRandomName() {
        Random rand = new Random();
        if (lines.isEmpty()) {
            return "Unnown";
        }
        return lines.get(rand.nextInt(lines.size())).trim();
    }
}
