package org.betavzw.minesweeper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MinesweeperApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MinesweeperApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Dag allemaal");
	}

}

