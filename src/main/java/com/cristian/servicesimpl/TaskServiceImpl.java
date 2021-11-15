package com.cristian.servicesimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cristian.model.Task;
import com.cristian.repositories.TasksRepository;
import com.cristian.services.TaskService;
import com.cristian.utils.Utils;

@Service
public class TaskServiceImpl implements TaskService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskServiceImpl.class);
	
	@Autowired
	TasksRepository taskRepo;
    

    public List<Task> findAll() {
        return this.taskRepo.findAll();
    }
    
    public List<Task> findAllByUsername(String username) {
        return this.taskRepo.findAllByUsername(username);
    }


	@Override
	public Task addTask(String username, Task task) {
		String dateAndTime = Utils.getDateAndTime();
		List<Task> existingTasks =  this.taskRepo.findAllByUsername(username);
		//adding at the end of the list
		task.setId(existingTasks.size() + 1);
		task.setUsername(username);
		task.setLastUpdate(dateAndTime);
		task.setIsDone(false);
		return this.taskRepo.save(task);	
	}

	@Override
	public void removeTask(String username, Task task) {
		LOGGER.info("Removing task with id "+task.getId());
		this.taskRepo.deleteByUsernameAndId(task.getId(), username);
	}

}
