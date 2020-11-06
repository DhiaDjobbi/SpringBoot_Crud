package com.dhia.factures.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dhia.factures.entities.Facture;
import com.dhia.factures.entities.User;

public interface FactureService {
	Facture saveFacture(Facture f);
	Facture updateFacture(Facture f);
	void deleteFacture(Facture f);
	void deleteFactureById(Long id);
	Facture getFacture(Long id);
	List<Facture> getAllFactures();
	Page<Facture> getAllFacturesParPage(int page, int size);
	
	
	
	List<Facture> findByNomSociete(String nom); 
	List<Facture> findByNomSocieteContains(String nom); 
	List<Facture> findByNomMontant (String nom, Double Montant); 
	List<Facture> findByUser (User User); 
	List<Facture> findByUserIdUser(Long id); 
	List<Facture> findByOrderByNomSocieteAsc();
	List<Facture> trierFacturesNomMontant ();

	
	
}
