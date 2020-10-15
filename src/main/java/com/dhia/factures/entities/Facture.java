package com.dhia.factures.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Facture {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idFacture;
	private String nomSociete;
	private Double Montant;
	private Date dateExpiration;
	
	
	
	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture + ", nomSociete=" + nomSociete + ", Montant=" + Montant
				+ ", dateExpiration=" + dateExpiration + "]";
	}

	public Facture(String nomSociete, Double montant, Date dateExpiration) {
		super();
		this.nomSociete = nomSociete;
		Montant = montant;
		this.dateExpiration = dateExpiration;
	}
	
	public Facture() {
		super();
	}
	
	public Long getIdFacture() {
		return idFacture;
	}

	public String getNomSociete() {
		return nomSociete;
	}
	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}
	public Double getMontant() {
		return Montant;
	}
	public void setMontant(Double montant) {
		Montant = montant;
	}
	public Date getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	
	

}
