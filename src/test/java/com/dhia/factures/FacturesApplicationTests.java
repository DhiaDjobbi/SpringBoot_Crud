package com.dhia.factures;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dhia.factures.entities.Facture;
import com.dhia.factures.repo.FactureRepository;

@SpringBootTest
class FacturesApplicationTests {
	
	@Autowired
	private FactureRepository factureRepository;
	
	
	@Test
	public void testCreateFacture() 
	{
		Facture fact= new Facture("S.T.E.G",210.500,new Date());
		factureRepository.save(fact);
	}

	
	@Test
	public void testFindFacture()
	{
		Facture f = factureRepository.findById(1L).get();
		System.out.println(f);
	}	
	
	@Test
	public void testUpdateFacture()
	{
		Facture f = factureRepository.findById(1L).get();
		f.setMontant(600.00);
		factureRepository.save(f);
	}
	
	@Test
	public void testDeleteFacture()
	{
		factureRepository.deleteById(1L);;
	}
	
	
	@Test
	public void testListerToutFactures()
	{
		List<Facture> facts = factureRepository.findAll();
		for (Facture f : facts)
			{
				System.out.println(f);
			}
	}
	
}
