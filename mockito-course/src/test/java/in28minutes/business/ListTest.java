package in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void letsMockListSizeMethod() {
		// Given - setup
		List mockList= mock(List.class);
		
		// When - actual method calls
		when(mockList.size()).thenReturn(2);
		
		//Then - asserts
		assertEquals(2,mockList.size());
		
	}
	
	@Test
	public void letsMockListSize_WithMultipleValues() {
		
		List mockList= mock(List.class);
		when(mockList.size()).thenReturn(2).thenReturn(3);
		assertEquals(2,mockList.size());
		assertEquals(2,mockList.size());
		
	}
	
	@Test
	public void letsMockListGet() {
		
		List mockList= mock(List.class);
		//Argument matcher
		when(mockList.get(anyInt())).thenReturn("in28minutes");
		assertEquals("in28minutes",mockList.get(0));
		assertEquals("in28minutes",mockList.get(1));
		
	}
	
	@Test
	public void letsMockListGetNull() {
		
		List mockList= mock(List.class);
		//Argument matcher
		//when(mockList.get(anyInt()));
		assertEquals(null,mockList.get(0));
	//	assertEquals("in28minutes",mockList.get(1));
		
	}
	
	 
	@Test//(expected = RuntimeException.class)
	public void letsMockList_throwException() {
		
		List mockList= mock(List.class);
		//Argument matcher
		when(mockList.get(anyInt())).thenThrow(new RuntimeException("Something"));
		mockList.get(1);
		
	}
	
	@Test//(expected = RuntimeException.class)
	public void letsMockList_mixingUp() {
		
		List mockList= mock(List.class);
		//Argument matcher
		when(mockList.subList(anyInt(),5)).thenThrow(new RuntimeException("Something"));
		mockList.get(0);
		
	}
	
	@Test
	public void letsMockListGet_usingBDD() {
		//Given
		List<String> mockList= mock(List.class);
		when(mockList.get(anyInt())).thenReturn("in28minutes");
		
		//When
		String firstElement=mockList.get(0);
		
		//Then
		assertThat(firstElement, is("in28minutes"));		
	}
	
	
	
	
	
	
}
