package in28minutes.data.spi;

import java.util.Arrays;
import java.util.List;

import in28minutes.api.TodoService;

public class TodoServiceStub implements TodoService {
	//Dynamic Condition
	//Service Definition
	

	public List<String> retrieveTodos(String user) {

		return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
	}

}
