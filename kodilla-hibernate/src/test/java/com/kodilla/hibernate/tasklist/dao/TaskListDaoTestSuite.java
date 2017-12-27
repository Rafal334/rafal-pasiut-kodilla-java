package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void testFindByListName() {
        //Given
        TaskList taskList = new TaskList("TestList", "Sample description");

        //When
        taskListDao.save(taskList);

        //Then
        List<TaskList> taskListList = taskListDao.findByListName("TestList");
        Assert.assertEquals(1, taskListList.size());
        Assert.assertEquals(taskList.getId(), taskListList.get(0).getId());

        //Cleanup
        taskListDao.delete(taskListList.get(0).getId());
    }
}
