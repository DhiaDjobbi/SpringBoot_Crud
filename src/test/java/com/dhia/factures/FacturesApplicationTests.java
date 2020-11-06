package com.dhia.factures;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.dhia.factures.entities.Facture;
import com.dhia.factures.entities.User;
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
	
	
	
	@Test
	public void testFindFactureByName()
	{
		List<Facture> facts = factureRepository.findByNomSociete("facture4");
		for (Facture f : facts)
		{
			System.out.println(f);
		}
	}	
	
	@Test
	public void testFindFactureByNameLike()
	{
		List<Facture> facts = factureRepository.findByNomSocieteContains("fact");
		for (Facture f : facts)
		{
			System.out.println(f);
		}
	}		
	
	
	@Test 
	public void testfindByNomMontant() 
	{ 
		List<Facture> facts = factureRepository.findByNomMontant("facture1", 400.0); 
		for (Facture f : facts) 
			{ 
				System.out.println(f); 
			} 		
	} 

	

	
	@Test 
	public void testfindByUser() 
	{ 
		User user = new User(); 
		user.setIdUser(1L);
		List<Facture> facts = factureRepository.findByUser(user); 
		for (Facture f : facts) 
			{ 
				System.out.println(f); 
			} 
	} 

	
	@Test 
	public void TestfindByUserIdUser() 
	{ 
		List<Facture> facts = factureRepository.findByUserIdUser(2L); 
		for (Facture f : facts) 
		{ 
			System.out.println(f); 
		} 
	} 

	
	@Test 
	public void testfindByOrderByNomProduitAsc() 
	{ 
		List<Facture> facts =  factureRepository.findByOrderByNomSocieteAsc(); 
		for (Facture f : facts) 
		{ 
			System.out.println(f); 
		} 
	}

	
	
	@Test 
	public void testTrierProduitsNomsPrix() 
	{ 
		List<Facture> facts = factureRepository.trierFacturesNomMontant(); 
		for (Facture f : facts) 
		{ 
			System.out.println(f); 
		} 
	} 

	
}



