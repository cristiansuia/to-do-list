package com.cristian.services;

import java.util.List;

import com.cristian.model.Task;

public interface TaskService {
	
	public List<Task> findAll();
	
	public List<Task> findAllByUsername(String username);
	
	public Task addTask(String username, Task task);
	
	public void removeTask(String username, Task task);

}
