package org.betavzw.minesweeper;

public class Vakje {
	private VakjeToestandEnum toestand;

	public Vakje() {
		toestand = VakjeToestandEnum.dicht;
	}
	public VakjeToestandEnum getToestand() {
		return toestand;
	}
	
}
