package org.betavzw.minesweeper;

public class BomVakje extends Vakje {
	@Override
	public void klik() {
		super.klik();
		if (getToestand() == VakjeToestandEnum.open) {
			toestand = VakjeToestandEnum.ontploft;
		}
	}
}
