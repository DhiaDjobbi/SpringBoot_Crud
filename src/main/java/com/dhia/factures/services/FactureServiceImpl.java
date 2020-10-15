package com.dhia.factures.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhia.factures.entities.Facture;
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

}
