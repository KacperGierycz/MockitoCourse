package in28minutes.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import in28minutes.api.TodoService;
import in28minutes.data.spi.TodoServiceStub;

public class TodoBuisenesImplMockTest {
	
	// What is mocking?
	// mocking is creating objects that simulates the behavior of real objects
	// Unlike stubs, mocks can be dynamically created from code - at runtime
	// Mocks offer more functionality then stubbing.
	// You can verify method calls and lot of other things.
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {
		
		TodoService toDoServiceMock = mock(TodoService.class);
		
		List<String> todos =Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		
		when(toDoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(toDoServiceMock);
		List<String> filteredTodos= todoBusinessImpl.retrieveTodosRelatedToSpting("Dummy");
		//System.out.println(filteredTodos.size());
		assertEquals(2,filteredTodos.size());
	}

}
