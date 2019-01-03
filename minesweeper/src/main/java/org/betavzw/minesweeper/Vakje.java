package org.betavzw.minesweeper;

import java.util.Collection;

public class Vakje {
	protected VakjeToestandEnum toestand;
	private Collection<Vakje> buren;

	public Vakje() {
		toestand = VakjeToestandEnum.dicht;
	}

	public VakjeToestandEnum getToestand() {
		return toestand;
	}

	public void klik() {
		if (toestand != VakjeToestandEnum.gemarkeerd) {
			toestand = VakjeToestandEnum.open;
		}
	}

	public void markeer() {
		if (toestand == VakjeToestandEnum.gemarkeerd) {
			toestand = VakjeToestandEnum.dicht;
		} else if (toestand == VakjeToestandEnum.dicht) {
			toestand = VakjeToestandEnum.gemarkeerd;
		}
	}
	public void setBuren(Collection<Vakje> buren) {
		this.buren = buren;
	}
	public int getAantalBomBuren() throws IllegalStateException{
		if (toestand != VakjeToestandEnum.open)
			throw new IllegalStateException("Vakje is niet open");
		return (int) this.buren.stream()
				.filter(v -> v.getClass().equals(BomVakje.class) ).count();
	}

}
