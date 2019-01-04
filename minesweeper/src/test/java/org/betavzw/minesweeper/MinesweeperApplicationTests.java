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
		Set<Vakje> buren = Set.of(new Vakje(), new BomVakje(), new Vakje(), new Vakje(), new BomVakje());
		vakje.setBuren(buren);
		vakje.klik();
		int aantalBuren = vakje.getAantalBomBuren();
		assertEquals(2, aantalBuren);
	}

	@Test
	public void testVasteVeldGeneratorMetFoutePositie() {
		Set<Positie> posities = Set.of(new Positie(1, 1), new Positie(3, 1));
		exception.expect(IllegalArgumentException.class);
		VeldGenerator generator = new VastVeldGenerator(3, 3, posities);
	}

	@Test
	public void testVasteVeldGeneratorOpvragenBuitenDimensies() {
		Set<Positie> posities = Set.of(new Positie(1, 1), new Positie(2, 1));

		VeldGenerator generator = new VastVeldGenerator(3, 3, posities);
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Kolom 3 is groter dan 3");
		boolean isBom = generator.isBom(0, 3);
	}
	@Test
	public void testRijenEnKolommenVanSpeelbord() {
		Set<Positie> posities = Set.of(new Positie(0, 0));
		VeldGenerator generator = new VastVeldGenerator(3, 4, posities);
		Speelbord bord= new Speelbord(generator);
		int aantalRijen = bord.getAantalRijen();
		int aantalKolommen = bord.getAantalKolommen();
		assertEquals(3, aantalRijen);
		assertEquals(4, aantalKolommen);
	}

	@Test
	public void testBeginToestandBord() {
		Set<Positie> posities = Set.of(new Positie(0, 0));
		VeldGenerator generator = new VastVeldGenerator(3, 4, posities);
		Speelbord bord= new Speelbord(generator);
		BordToestandEnum toestand = bord.getToestand();
		assertEquals(BordToestandEnum.gestart, toestand);
	}
	
	@Test
	public void testBordVerloren() {
		Set<Positie> posities = Set.of(new Positie(1,2));
		VeldGenerator generator = new VastVeldGenerator(3, 4, posities);
		Speelbord bord= new Speelbord(generator);
		bord.klikVakje(1, 2);
		BordToestandEnum toestand = bord.getToestand();
		assertEquals(BordToestandEnum.verloren, toestand);
	}
}
