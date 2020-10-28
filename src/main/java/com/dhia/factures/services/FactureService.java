package com.dhia.factures.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dhia.factures.entities.Facture;

public interface FactureService {
	Facture saveFacture(Facture f);
	Facture updateFacture(Facture f);
	void deleteFacture(Facture f);
	void deleteFactureById(Long id);
	Facture getFacture(Long id);
	List<Facture> getAllFactures();
	Page<Facture> getAllFacturesParPage(int page, int size);
}
