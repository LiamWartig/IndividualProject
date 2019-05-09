package controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import model.Task;
import repository.TaskRepository;

@RestController
@RequestMapping("/api/project/")
public class TaskController {
	
	@Autowired
	private TaskRepository taskrepository;
	
	@RequestMapping(value="tasks",method=RequestMethod.GET)
	public List<Task> list(){
		return taskrepository.findAll();
	}

	@RequestMapping(value = "tasks/{id}", method = RequestMethod.DELETE)
    public Task delete(@PathVariable Integer id){
        Task existingTask = taskrepository.findOne(id);
        taskrepository.delete(existingTask);
        return existingTask;
    }

	@RequestMapping(value = "tasks/{id}", method = RequestMethod.PUT)
    public Task update(@PathVariable Integer id, @RequestBody Task task){
        Task existingTask = taskrepository.findOne(id);
        BeanUtils.copyProperties(task, existingTask);
        return taskrepository.saveAndFlush(task);
    }
	
	@RequestMapping(value = "tasks", method = RequestMethod.POST)
    public Task create(@RequestBody Task task){
        return taskrepository.saveAndFlush(task);
    }

}
