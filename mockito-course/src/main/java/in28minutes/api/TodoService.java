package in28minutes.api;

import java.util.List;

//Create TodoServiceStub
// Test TodoBuisenesImpl using TodoServiceStub
public interface TodoService {
public List<String> retrieveTodos(String user);
public void deleteTodo(String todo);
	
}
