import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeTreeStudentTest {

	MorseCodeTree tree = new MorseCodeTree();

	@Before
	public void setUp() throws Exception {


	}

	@After
	public void tearDown() throws Exception {

		tree = null;
	}


	@Test
	public void testInsert() {

	tree.insert(".----", "1");

	String letterFetched = tree.fetch(".----");

	assertEquals("1", letterFetched);
	}

	@Test
	public void testGetRoot() {

	String root;

	root = tree.getRoot().getData();

	assertEquals("", root);

	}

	@Test
	public void testSetRoot() {

	String newRoot;
	assertEquals("", tree.getRoot().getData());

	}

	@Test
	public void testFetch() {

	String letterFetched;
	letterFetched = tree.fetch("-.");
	assertEquals("n", letterFetched);
	}
}
