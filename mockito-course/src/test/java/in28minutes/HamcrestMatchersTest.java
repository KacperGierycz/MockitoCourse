package in28minutes;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

import org.junit.Test;

public class HamcrestMatchersTest {

	@Test
	public void test() {
		List<Integer> scores = Arrays.asList(99,100,101,105);
		//scores has 4 items
		assertThat(scores, hasSize(4));
		assertThat(scores, hasItems(99,100,106));
	}

}
