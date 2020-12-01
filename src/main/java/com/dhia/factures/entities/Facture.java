package com.dhia.factures.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

@Entity
public class Facture { 
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idFacture;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nomSociete;
	
	@NotNull
	@Min(value = 10)
	@Max(value = 10000)
	private Double Montant;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	@NotNull
	private Date dateExpiration;
	
	@ManyToOne
	private User user;
	
	
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
