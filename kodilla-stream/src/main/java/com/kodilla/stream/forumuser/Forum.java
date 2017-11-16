package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Forum {

    private List<ForumUser> userList;

    public Forum() {
        Random rand = new Random();
        String name;
        String path = "kodilla-stream/src/main/java/com/kodilla/stream/forumuser/RandomUserNames";
        FileLinesReader fileReader = new FileLinesReader(path);
        userList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            name = fileReader.getRandomName();
            userList.add(new ForumUser(i, name, getSexFromName(name), randomBirthday(), rand.nextInt(1000)));
        }
    }

    public List<ForumUser> userList() {
        return userList;
    }

    private LocalDate randomBirthday() {
        Random rand = new Random();
        int year, month, day;
        int daysInYear, randDayOfYear;
        year = LocalDate.now().getYear() - rand.nextInt(100);
        daysInYear = LocalDate.ofYearDay(year, 1).isLeapYear() ? 366 : 365;
        randDayOfYear = rand.nextInt(daysInYear) + 1;
        day = LocalDate.ofYearDay(year, randDayOfYear).getDayOfMonth();
        month = LocalDate.ofYearDay(year, randDayOfYear).getMonthValue();

        return LocalDate.of(year, month, day);
    }

    private char getSexFromName(String name) {
        if (name.substring(name.length() - 1, name.length()).equals("a")) {
            return 'F';
        } else {
            return 'M';
        }
    }
}
