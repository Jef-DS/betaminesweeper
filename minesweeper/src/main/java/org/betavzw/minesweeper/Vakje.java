package org.betavzw.minesweeper;

public class Vakje {
	protected VakjeToestandEnum toestand;

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

}
