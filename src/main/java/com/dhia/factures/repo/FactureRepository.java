package com.dhia.factures.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhia.factures.entities.Facture;

public interface FactureRepository extends JpaRepository<Facture, Long> {

}
