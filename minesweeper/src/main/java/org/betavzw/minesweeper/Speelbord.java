package org.betavzw.minesweeper;

public class Speelbord {
	private int aantalRijen;
	private int aantalKolommen;
	private BordToestandEnum toestand;
	private Vakje[][] vakjes;
	public Speelbord(VeldGenerator gen) {
		this.aantalRijen = gen.getAantalRijen();
		this.aantalKolommen = gen.getAantalKolommen();
		this.toestand = BordToestandEnum.gestart;
		vakjes = new Vakje[this.aantalRijen][this.aantalKolommen];
		for(int rij=0; rij<this.aantalRijen;rij++) {
			for(int kolom=0;kolom<this.aantalKolommen;kolom++) {
				if (gen.isBom(rij, kolom)) {
					vakjes[rij][kolom] = new BomVakje();
				}else {
					vakjes[rij][kolom] = new Vakje();
				}
			}
		}
	}
	public int getAantalRijen() {
		return aantalRijen;
	}
	public int getAantalKolommen() {
		return aantalKolommen;
	}
	public void klikVakje(int rij, int kolom) {
		if(vakjes[rij][kolom].getClass().equals(BomVakje.class)) {
			toestand = BordToestandEnum.verloren;
		}
	}
	public BordToestandEnum getToestand() {
		return toestand;
	}
}
