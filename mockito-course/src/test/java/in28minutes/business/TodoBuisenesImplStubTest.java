package in28minutes.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import in28minutes.api.TodoService;
import in28minutes.data.spi.TodoServiceStub;

public class TodoBuisenesImplStubTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_usingAStub() {
		TodoService toDoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(toDoServiceStub);
		List<String> filteredTodos= todoBusinessImpl.retrieveTodosRelatedToSpting("Dummy");
		assertEquals(2,filteredTodos.size());
	}

}
