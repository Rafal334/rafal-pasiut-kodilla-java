package com.kodilla.patterns2.observer.homework;

import org.junit.Assert;
import org.junit.Test;

public class TasksRepositoryTestSuite {

    @Test
    public void testUpdate() {
        //Given
        Student John = new Student("John");
        Student Tom = new Student("Tom");
        Student Sara = new Student("Sara");
        Student Lena = new Student("Lena");

        TasksRepository JohnsRepository = new TasksRepository(John);
        TasksRepository TomsRepository = new TasksRepository(Tom);
        TasksRepository SarasRepository = new TasksRepository(Sara);
        TasksRepository LenasRepository = new TasksRepository(Lena);

        Mentor Harry = new Mentor("Harry");
        Mentor Jim = new Mentor("Jim");

        JohnsRepository.registerObserver(Harry);
        TomsRepository.registerObserver(Jim);
        SarasRepository.registerObserver(Harry);
        LenasRepository.registerObserver(Jim);

        //When
        JohnsRepository.addTask(new Task("Hibernate"));
        TomsRepository.addTask(new Task("Hibernate"));
        JohnsRepository.addTask(new Task("Spring"));
        SarasRepository.addTask(new Task("Patterns"));
        LenasRepository.addTask(new Task("REST"));

        //Then
        Assert.assertEquals(3, (int) Harry.getTotalTasksToCheck());
        Assert.assertEquals(2, (int) Jim.getTotalTasksToCheck());

    }
}
