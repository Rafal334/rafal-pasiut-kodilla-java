package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TaskFactoryTestSuite {

    private static TaskFactory taskFactory;

    @BeforeClass
    public static void beforeClass() {
        taskFactory = new TaskFactory();
    }

    @Test
    public void testDrivingTask() {
        //Given
        //When
        Task task = taskFactory.makeTask(TaskFactory.DRIVING_TASK);

        //Then
        Assert.assertEquals("Driving task", task.getTaskName());
        Assert.assertFalse(task.isTaskExecuted());
        task.executeTask();
        Assert.assertTrue(task.isTaskExecuted());
    }

    @Test
    public void testPaintingTask() {
        //Given
        //When
        Task task = taskFactory.makeTask(TaskFactory.PAINTING_TASK);

        //Then
        Assert.assertEquals("Painting task", task.getTaskName());
        Assert.assertFalse(task.isTaskExecuted());
        task.executeTask();
        Assert.assertTrue(task.isTaskExecuted());
    }

    @Test
    public void testShoppingTask() {
        //Given
        //When
        Task task = taskFactory.makeTask(TaskFactory.SHOPPING_TASK);

        //Then
        Assert.assertEquals("Shopping task", task.getTaskName());
        Assert.assertFalse(task.isTaskExecuted());
        task.executeTask();
        Assert.assertTrue(task.isTaskExecuted());
    }
}
