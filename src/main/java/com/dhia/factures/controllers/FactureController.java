package com.dhia.factures.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dhia.factures.entities.Facture;
import com.dhia.factures.services.FactureService;


@Controller
public class FactureController {
	@Autowired
	
	FactureService factureService;
	@RequestMapping("/new")
	public String showCreate()
	{
		return "createFacture";
	}
	
	
	@RequestMapping("/saveFacture")
	public String saveFacture(@ModelAttribute("produit") Facture facture,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
		{
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			Date dateCreation = dateformat.parse(String.valueOf(date));
			facture.setDateExpiration(dateCreation);
			Facture saveFacture = factureService.saveFacture(facture);
			String msg ="Facture enregistré avec Id "+saveFacture.getIdFacture();
			modelMap.addAttribute("msg", msg);
			return "createFacture";
		}
	
	
	@RequestMapping("/")
	public String listeFacture(ModelMap modelMap)
	{
		List<Facture> facts = factureService.getAllFactures();
		modelMap.addAttribute("facts", facts);
		return "indexFactures";
	}
	
	@RequestMapping("/delete")
	public String supprimerFacture(@RequestParam("id") Long id,ModelMap modelMap)
	{
		factureService.deleteFactureById(id);
		List<Facture> facts = factureService.getAllFactures();
		modelMap.addAttribute("facts", facts);
		return "indexFactures";
	}	
	
	
	@RequestMapping("/edit")
	public String editFacture(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Facture f= factureService.getFacture(id);
		modelMap.addAttribute("fact", f);
		return "editFacture";
	}
	
	
	
	@RequestMapping("/updateProduit")
	public String updateProduit(@ModelAttribute("produit") Facture facture,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException
	{
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateExpiration = dateformat.parse(String.valueOf(date));
		facture.setDateExpiration(dateExpiration);
		factureService.updateFacture(facture);
		List<Facture> facts = factureService.getAllFactures();
		modelMap.addAttribute("facts", facts);
		return "indexFactures";
		}
	
	
	
	
}



