package com.sapient.service;

import java.util.ArrayList;
import java.util.List;

import com.sapient.dao.TodoDAO;
import com.sapient.pojo.Todo;

public class TodoDAOServiceImpl implements TodoDAOService {

	private TodoDAO instanceObject;

	public TodoDAOServiceImpl() {
		instanceObject = TodoDAO.instance;
	}

	public int getTodoCount() {
		return instanceObject.getModel().size();
	}

	public void addTodo(Todo todo) {

		instanceObject.getModel().put(todo.getName(), todo);
	}

	public List<Todo> getAllTodo() {

		List<Todo> todoList = new ArrayList<Todo>();

		for (String key : instanceObject.getModel().keySet()) {
			todoList.add(instanceObject.getModel().get(key));
		}
		return todoList;
	}

	public Todo getTodo(String id) {
		return instanceObject.getModel().get(id);		
	}

	public void deleteTodo(String id) {

		instanceObject.getModel().remove(id);
	}

	public void addAll(List<Todo> todoList) {
		for(Todo todo : todoList)
		{
			addTodo(todo);
		}
		
	}

}
