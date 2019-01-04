package org.betavzw.minesweeper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
		for(int rij=0; rij<this.aantalRijen;rij++) {
			for(int kolom=0;kolom<this.aantalKolommen;kolom++) {	
		       Set<Vakje> buren = new HashSet<Vakje>()	;
		       int minRij = Math.max(rij -1, 0);
		       int maxRij = Math.min( rij + 2, aantalRijen);
		       int minKolom = Math.max(kolom -1, 0);
		       int maxKolom = Math.min(kolom + 2, aantalKolommen);
		       for(int i= minRij; i< maxRij;i++) {
		    	   for(int j = minKolom; j < maxKolom; j++) {
		    		   if (i == rij && j == kolom) continue;
		    		   buren.add(vakjes[i][j]);
		    	   }
		       }
		       vakjes[rij][kolom].setBuren(buren);
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
		vakjes[rij][kolom].klik();
		if(vakjes[rij][kolom].getToestand() == VakjeToestandEnum.ontploft) {
			toestand = BordToestandEnum.verloren;
		}
	}
	public UIVakjeToestandEnum getToestandVakje(int rij, int kolom) {
		switch(vakjes[rij][kolom].getToestand()) {
		case dicht:
			return UIVakjeToestandEnum.nietgeklikt;

		case gemarkeerd:
			return UIVakjeToestandEnum.gemarkeerd;
		case ontploft:
			return UIVakjeToestandEnum.mijn;
		case open:
			return UIVakjeToestandEnum.values()[3 + vakjes[rij][kolom].getAantalBomBuren()];
		
		}
		throw new IllegalStateException("Onbekende toestand " + vakjes[rij][kolom].getToestand());
	}
	public BordToestandEnum getToestand() {
		return toestand;
	}
}
