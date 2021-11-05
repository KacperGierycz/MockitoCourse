package in28minutes.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpyTest {

	@Test
	public void test() {
		List arrayListMock= mock(ArrayList.class);
		List arrayListSpy= spy(ArrayList.class);
		
		assertEquals(0,arrayListSpy.size());
		arrayListSpy.add("Dummy");
		assertEquals(1,arrayListSpy.size());
		arrayListSpy.remove("Dummy");
		assertEquals(0,arrayListSpy.size());
		stub(arrayListSpy.size()).toReturn(5);
		assertEquals(5,arrayListSpy.size());
		verify(arrayListSpy).add("Dummy");
		verify(arrayListSpy,never()).clear();
		
		//mocks retyrn default value
		stub(arrayListMock.size()).toReturn(5); 
		assertEquals(5, arrayListMock.size());
		
	}

}
