package in28minutes.business;

import java.util.ArrayList;
import java.util.List;

import in28minutes.api.TodoService;

//TodoBusinessImpl SUT
//TodoService Dependency
public class TodoBusinessImpl {
	
	private TodoService toDoService;

	public TodoBusinessImpl(TodoService toDoService) {

		this.toDoService = toDoService;
	}
	
	public List<String> retrieveTodosRelatedToSpting(String user){
		List<String> filteredTodos= new ArrayList<String>();
		List<String> todos= toDoService.retrieveTodos(user);
		for(String todo:todos) {
			if(todo.contains("Spring")){
			filteredTodos.add(todo);
			}
		}
		
		return filteredTodos;		
	}
	
	public void deleteTodoNotRelatedToToSpting(String user){

		List<String> todos= toDoService.retrieveTodos(user);
		for(String todo:todos) {
			if(!todo.contains("Spring")){
		toDoService.deleteTodo(todo);
			}
		}
		
		
		
	}

}
