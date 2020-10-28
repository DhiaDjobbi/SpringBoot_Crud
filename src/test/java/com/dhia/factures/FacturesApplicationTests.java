package com.dhia.factures;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.dhia.factures.entities.Facture;
import com.dhia.factures.repo.FactureRepository;
import com.dhia.factures.services.FactureService;

@SpringBootTest
class FacturesApplicationTests {
	
	@Autowired
	private FactureRepository factureRepository;
	
	@Autowired
	private FactureService factureService;
	
	@Test
	public void testCreateFacture() 
	{
		Facture fact= new Facture("S.T.E.G5",6610.500,new Date());
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
	public void testFindByNomProduitContains()
	{
		Page<Facture> facts = factureService.getAllFacturesParPage(0,2);
		System.out.println(facts.getSize());
		System.out.println(facts.getTotalElements());
		System.out.println(facts.getTotalPages());
		facts.getContent().forEach(f -> {System.out.println(f.toString());
		}
	);
		/*ou bien
		for (Facture p : facts)
		{
		System.out.println(p);
		} */
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
