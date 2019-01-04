package org.betavzw.minesweeper;

import java.util.Random;

public class RandomVeldGenerator extends VeldGenerator {
	public RandomVeldGenerator(int rijen, int kolommen, int aantalBommen) {
		this.rijen = rijen;
		this.kolommen = kolommen;
		Random rnd = new Random();
		while(posities.size() < aantalBommen){
			int rij = rnd.nextInt(rijen);
			int kolom = rnd.nextInt(kolommen);
			Positie pos = new Positie(rij, kolom);
			posities.add(pos);
		}
	}
}
