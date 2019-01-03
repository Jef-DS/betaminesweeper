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
	
	@Test
	public void testKlikVakje() {
		Vakje vakje = new Vakje();
		vakje.klik();
		VakjeToestandEnum toestand = vakje.getToestand();
		assertEquals(VakjeToestandEnum.open, toestand);
	}
	@Test
	public void testMarkeer() {
		Vakje vakje = new Vakje();
		vakje.markeer();
		VakjeToestandEnum toestand = vakje.getToestand();
		assertEquals(VakjeToestandEnum.gemarkeerd, toestand);
	}
	@Test
	public void testDubbelMarkeer() {
		Vakje vakje = new Vakje();
		vakje.markeer();
		vakje.markeer();
		VakjeToestandEnum toestand = vakje.getToestand();
		assertEquals(VakjeToestandEnum.dicht, toestand);
	}
	@Test
	public void testNietKlikkenOpMarkeer() {
		Vakje vakje = new Vakje();
		vakje.markeer();
		vakje.klik();
		VakjeToestandEnum toestand = vakje.getToestand();
		assertEquals(VakjeToestandEnum.gemarkeerd, toestand);
	}
	@Test
	public void testNietMarkerenIndienOpen() {
		Vakje vakje = new Vakje();
		vakje.klik();
		vakje.markeer();
		VakjeToestandEnum toestand = vakje.getToestand();
		assertEquals(VakjeToestandEnum.open, toestand);
	}
	@Test
	public void testKlikOpBomVakje() {
		Vakje vakje = new BomVakje();
		vakje.klik();
		VakjeToestandEnum toestand = vakje.getToestand();
		assertEquals(VakjeToestandEnum.ontploft, toestand);
	}
	

}

