package org.betavzw.minesweeper;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MinesweeperApplicationTests {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
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
	
	@Test
	public void testGeenBurenOpvragenWanneerNietOpen() {
		Vakje vakje = new Vakje();
		exception.expect(IllegalStateException.class);
		int aantalBuren = vakje.getAantalBomBuren();
	}
	
	@Test
	public void testAantalBuren() {
		Vakje vakje = new Vakje();
		Set<Vakje> buren = Set.of(
				new Vakje(), new BomVakje(), new Vakje(),
				new Vakje(), new BomVakje()
				);
		vakje.setBuren(buren);
		vakje.klik();
		int aantalBuren = vakje.getAantalBomBuren();
		assertEquals(2, aantalBuren);
	}

}

