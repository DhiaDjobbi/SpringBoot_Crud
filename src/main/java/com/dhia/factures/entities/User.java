package com.dhia.factures.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idUser;
	private String fullName;
	private String userEmail;
	
	@OneToMany (mappedBy ="user")
	private List<Facture> factures;
	
	
}
