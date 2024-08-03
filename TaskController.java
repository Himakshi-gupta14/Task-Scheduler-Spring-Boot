package com.Himakshi.gupta.Learn.scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskSchedulerService taskSchedulerService;

    @PostMapping("/create")
    public void api_singleTask(@RequestParam String taskName) throws InterruptedException {
        taskSchedulerService.createTask(taskName);
    }

    @PostMapping("/createBatch")
    public void api_multipleTasks(@RequestBody String[] taskNames) throws InterruptedException {
        taskSchedulerService.createTasks(taskNames);
    }
}
