package com.dhia.factures;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dhia.factures.entities.Facture;
import com.dhia.factures.services.FactureService;

@SpringBootApplication
public class FacturesApplication implements CommandLineRunner {

	@Autowired
	FactureService factureService;
	public static void main(String[] args) {
		SpringApplication.run(FacturesApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	factureService.saveFacture(new Facture("facture4", 4600.0, new Date()));
	factureService.saveFacture(new Facture("facture5", 500.0, new Date()));
	factureService.saveFacture(new Facture("facture9", 58850.0, new Date()));
	factureService.saveFacture(new Facture("facture8", 58050.0, new Date()));
	}

}
