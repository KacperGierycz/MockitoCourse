package in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingBDD() {
		
		//Given
		
		TodoService toDoServiceMock = mock(TodoService.class);
		
		List<String> todos =Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		
		given(toDoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(toDoServiceMock);
		
		//When
		List<String> filteredTodos= todoBusinessImpl.retrieveTodosRelatedToSpting("Dummy");
		//System.out.println(filteredTodos.size());

		//Then
		assertThat(filteredTodos.size(), is(2));
	}
	
	@Test
	public void testRetrieveTodosNotRelatedToSpring_usingBDD() {
		
		//Given
		
		TodoService toDoServiceMock = mock(TodoService.class);
		
		List<String> todos =Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		
		given(toDoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(toDoServiceMock);
		
		//When
		 todoBusinessImpl.deleteTodoNotRelatedToToSpting("Dummy");
		//System.out.println(filteredTodos.size());

		//Then
		 verify(toDoServiceMock, times(1)).deleteTodo("Learn to Dance");
		 verify(toDoServiceMock,never()).deleteTodo("Learn Spring MVC");
	}

}
