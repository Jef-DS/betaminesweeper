package org.betavzw.minesweeper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MinesweeperApplicationTests {

	@Test
	public void testBeginToestandVakje() {
		Vakje vakje = new Vakje();
		VakjeToestandEnum beginToestand = vakje.getToestand();
		assertEquals(VakjeToestandEnum.dicht, beginToestand);
	}

}

