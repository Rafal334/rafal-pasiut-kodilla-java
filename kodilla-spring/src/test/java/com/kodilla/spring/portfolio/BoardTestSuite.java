package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {

    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        board.addTaskDoneList("Done task");
        board.addTaskInProgressList("In progress task");
        board.addTasktoDoList("To do task");

        //Then
        Assert.assertEquals("Done task", board.getDoneList().getTasks().get(0));
        Assert.assertEquals("In progress task", board.getInProgressList().getTasks().get(0));
        Assert.assertEquals("To do task", board.getToDoList().getTasks().get(0));

    }
}
