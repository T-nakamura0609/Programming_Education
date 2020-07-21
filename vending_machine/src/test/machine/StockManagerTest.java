package test.machine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.machine.StockManagerImpl;

class StockManagerTest {

	private static StockManagerImpl target;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		target = new StockManagerImpl();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetGoodsList() {
		fail("まだ実装されていません");
	}

	@Test
	void testGetGoods() {
		fail("まだ実装されていません");
	}

}
