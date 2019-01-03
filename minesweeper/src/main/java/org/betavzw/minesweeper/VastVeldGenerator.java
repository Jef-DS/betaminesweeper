package org.betavzw.minesweeper;

import java.util.Set;

public class VastVeldGenerator extends VeldGenerator{

	public VastVeldGenerator(int rijen, int kolommen, Set<Positie> posities) {
		this.rijen = rijen;
		this.kolommen = kolommen;
		for(Positie p: posities) {
			if (p.getX() >= rijen || p.getY() >= kolommen) throw new IllegalArgumentException();
		}
		this.posities.addAll(posities);
		
	}

}
