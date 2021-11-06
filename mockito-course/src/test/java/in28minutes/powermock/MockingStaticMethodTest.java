package in28minutes.powermock;

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

import com.in28minutes.powermock.SystemUnderTest;
import com.in28minutes.powermock.UtilityClass;
import com.in28minutes.powermock.Dependency;

import in28minutes.api.TodoService;
import in28minutes.data.spi.TodoServiceStub;

// no need to run with with a rule
//@RunWith(MockitoJUnitRunner.class)
@RunWith(PowerMockRunner)
public class MockingStaticMethodTest {
	
	// What is mocking?
	// mocking is creating objects that simulates the behavior of real objects
	// Unlike stubs, mocks can be dynamically created from code - at runtime
	// Mocks offer more functionality then stubbing.
	// You can verify method calls and lot of other things.
	
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Mock
	Dependency dependency;
	
	@InjectMocks
	SystemUnderTest systemUnderTest;
	
	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;

	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {
		
		
		List<Integer> stats=Arrays.asList(1,2,3);
		
		when(dependency.retrieveAllStats()).thenReturn(stats);
		when(UtilityClass.staticMethod(6)).thenReturn(150);
		
		
		systemUnderTest.methodCallingAStaticMethod();
		
		
	}
	
	
}