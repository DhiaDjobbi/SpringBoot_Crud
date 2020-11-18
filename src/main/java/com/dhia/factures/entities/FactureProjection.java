package com.dhia.factures.entities;

import org.springframework.data.rest.core.config.Projection;


	
@Projection(name = "nomSociete", types = { Facture.class }) 
	public interface FactureProjection { 
		public String getNomSociete(); 
} 

	
