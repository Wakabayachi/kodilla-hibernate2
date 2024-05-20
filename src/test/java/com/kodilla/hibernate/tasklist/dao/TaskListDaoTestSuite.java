package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TaskListDaoTestSuite {

    @Autowired
    private com.kodilla.hibernate.tasklist.dao.TaskListDao taskListDao;

    @Test
    void testFindByListName() {
        // Given
        TaskList taskList = new TaskList("Test List", "Test Description");
        taskListDao.save(taskList);

        // When
        List<TaskList> readTaskLists = taskListDao.findByListName("Test List");

        // Then
        assertEquals(1, readTaskLists.size());
        assertEquals("Test List", readTaskLists.get(0).getListName());
        assertEquals("Test Description", readTaskLists.get(0).getDescription());

        // CleanUp
        taskListDao.deleteAll();
    }
}