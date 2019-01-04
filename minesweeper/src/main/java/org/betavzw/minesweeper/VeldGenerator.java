package org.betavzw.minesweeper;

import java.util.HashSet;
import java.util.Set;

public abstract class VeldGenerator {
	private int rijen;
	private int kolommen;
	protected Set<Positie> posities = new HashSet<>();
	
	public VeldGenerator(int rijen, int kolommen) {
		this.rijen = rijen;
		this.kolommen = kolommen;
	}
	public int getAantalRijen() {
		return rijen;
	}


	public int getAantalKolommen() {
		return kolommen;
	}


	public boolean isBom(int rij, int kolom) {
		if (rij >= getAantalRijen()) throw new IllegalArgumentException(String.format("Rij %d is groter dan %d",  rij, getAantalRijen()));
		if (kolom >= getAantalKolommen()) throw new IllegalArgumentException(String.format("Kolom %d is groter dan %d",  kolom, getAantalKolommen()));
		Positie plaats = new Positie(rij, kolom);
		return posities.contains(plaats);
	}
}
