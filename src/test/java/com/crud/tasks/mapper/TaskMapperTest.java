package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskMapperTest {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void shouldMapToTask() {
        //given
        TaskDto taskDto = new TaskDto(1L, "test_title", "test_content");
        //when
        Task theTask = taskMapper.mapToTask(taskDto);
        //then
        assertEquals("test_title", theTask.getTitle());
        assertEquals("test_content", theTask.getContent());
    }
    @Test
    public void shouldMapToTaskDto() {
        //given
        Task task = new Task(1L, "test_title", "test_content");
        //when
        TaskDto theTaskDto = taskMapper.mapToTaskDto(task);
        //then
        assertEquals("test_title", theTaskDto.getTitle());
        assertEquals("test_content", theTaskDto.getContent());
    }
    @Test
    public void shouldMapToTaskDtoList() {
        //given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1L, "title1", "content1"));
        taskList.add(new Task(2L, "title2", "content2"));
        //when
        List<TaskDto> theList = taskMapper.mapToTaskDtoList(taskList);
        //then
        assertEquals("title1", theList.get(0).getTitle());
        assertEquals("content2", theList.get(1).getContent());
    }
}
