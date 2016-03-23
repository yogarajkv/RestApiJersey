package com.sapient.service;

import java.util.List;

import com.sapient.pojo.Todo;

public interface TodoDAOService {

	int getTodoCount();

	void addTodo(Todo todo);
	
	void addAll(List<Todo> todoList);

	List<Todo> getAllTodo();
	
	Todo getTodo(String id);
	
	void deleteTodo(String id);
}
