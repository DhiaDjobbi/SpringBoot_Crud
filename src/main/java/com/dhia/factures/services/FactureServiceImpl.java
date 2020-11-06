package com.dhia.factures.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dhia.factures.entities.Facture;
import com.dhia.factures.entities.User;
import com.dhia.factures.repo.FactureRepository;



@Service
public class FactureServiceImpl implements FactureService {

	@Autowired
	FactureRepository factureRepository;
	
	
	@Override
	public Facture saveFacture(Facture f) {
		return factureRepository.save(f);
	}

	@Override
	public Facture updateFacture(Facture f) {
		return factureRepository.save(f);
	}

	@Override
	public void deleteFacture(Facture f) {
		factureRepository.delete(f);
		
	}

	@Override
	public void deleteFactureById(Long id) {
		factureRepository.deleteById(id);
	}

	@Override
	public Facture getFacture(Long id) {
		return factureRepository.findById(id).get();
	}

	@Override
	public List<Facture> getAllFactures() {
		return factureRepository.findAll();	
	}
	
	
	@Override
	public Page<Facture> getAllFacturesParPage(int page, int size) {
	return factureRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Facture> findByNomSociete(String nom) {
		return factureRepository.findByNomSociete(nom); 

	}

	@Override
	public List<Facture> findByNomSocieteContains(String nom) {
		return factureRepository.findByNomSocieteContains(nom); 
	}

	@Override
	public List<Facture> findByNomMontant(String nom, Double Montant) {
		return factureRepository.findByNomMontant(nom,Montant); 

	}

	@Override
	public List<Facture> findByUser(User user) {
		return factureRepository.findByUser(user); 
	}

	@Override
	public List<Facture> findByUserIdUser(Long id) {
		return factureRepository.findByUserIdUser(id); 

	}

	@Override
	public List<Facture> findByOrderByNomSocieteAsc() {
		return factureRepository.findByOrderByNomSocieteAsc(); 

	}

	@Override
	public List<Facture> trierFacturesNomMontant() {
		return factureRepository.findByOrderByNomSocieteAsc(); 
	}

}
