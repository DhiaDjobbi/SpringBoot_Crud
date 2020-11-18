package com.dhia.factures.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dhia.factures.entities.Facture;
import com.dhia.factures.entities.User;


@RepositoryRestResource(path = "rest") 
public interface FactureRepository extends JpaRepository<Facture, Long> {
	
	List<Facture> findByNomSociete(String nom); 
	List<Facture> findByNomSocieteContains(String nom); 
	
	/* @Query("select f from Facture f where f.nomSociete like %?1 and f.Montant > ?2") 
	List<Facture> findByNomMontant (String nom, Double montant); */
	
	@Query("select f from Facture f where f.nomSociete like %:nom and f.Montant > :montant") 
	List<Facture> findByNomMontant (@Param("nom") String nom,@Param("montant") Double montant); 
	
	@Query("select f from Facture f where f.user = ?1") 
	List<Facture> findByUser (User User); 
	
	List<Facture> findByUserIdUser(Long id); 
	
	List<Facture> findByOrderByNomSocieteAsc();
	
	@Query("select f from Facture f order by f.nomSociete ASC, f.Montant DESC")
	List<Facture> trierFacturesNomMontant ();
	
}
