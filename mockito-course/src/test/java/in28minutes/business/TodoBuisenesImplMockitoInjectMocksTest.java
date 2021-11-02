package in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import in28minutes.api.TodoService;
import in28minutes.data.spi.TodoServiceStub;

// no need to run with with a rule
//@RunWith(MockitoJUnitRunner.class)
public class TodoBuisenesImplMockitoInjectMocksTest {
	
	// What is mocking?
	// mocking is creating objects that simulates the behavior of real objects
	// Unlike stubs, mocks can be dynamically created from code - at runtime
	// Mocks offer more functionality then stubbing.
	// You can verify method calls and lot of other things.
	
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Mock
	TodoService toDoServiceMock;
	
	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;
	
	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;

	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {
		
		
		List<String> todos =Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		
		when(toDoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		
		List<String> filteredTodos= todoBusinessImpl.retrieveTodosRelatedToSpting("Dummy");
		//System.out.println(filteredTodos.size());
		assertEquals(2,filteredTodos.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingBDD() {
		
		//Given
		
		
		List<String> todos =Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		
		given(toDoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		
		//When
		List<String> filteredTodos= todoBusinessImpl.retrieveTodosRelatedToSpting("Dummy");
		//System.out.println(filteredTodos.size());

		//Then
		assertThat(filteredTodos.size(), is(2));
	}
	
	@Test
	public void testRetrieveTodosNotRelatedToSpring_usingBDD() {
		
		//Given
		
		
		List<String> todos =Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		
		given(toDoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		
		//When
		 todoBusinessImpl.deleteTodoNotRelatedToToSpting("Dummy");
		//System.out.println(filteredTodos.size());

		//Then
		 verify(toDoServiceMock, times(1)).deleteTodo("Learn to Dance");
		 then(toDoServiceMock).should().deleteTodo("Learn to Dance");
		
		 verify(toDoServiceMock,never()).deleteTodo("Learn Spring MVC");
		 then(toDoServiceMock).should(never()).deleteTodo("Learn Spring MVC");
		 
	}

	@Test
	public void testRetrieveTodosNotRelatedToSpring_usingBDD_argumentCapture() {
		
		//Declare Argument Captor
		
		//Define Argument captor on specific method call
		//Capture the argument
				
		//Given
		
		
		List<String> todos =Arrays.asList("Learn to Rock and Roll" , "Learn Spring MVC", "Learn Spring", "Learn to Dance");
		
		given(toDoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		
		//When
		 todoBusinessImpl.deleteTodoNotRelatedToToSpting("Dummy");
		//System.out.println(filteredTodos.size());

		//Then

		 then(toDoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());

	//	 assertThat(stringArgumentCaptor.getValue(),is("Learn to Dance"));
		 assertThat(stringArgumentCaptor.getAllValues().size(),is(2));
	}
	
}
