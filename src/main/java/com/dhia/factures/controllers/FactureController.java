package com.dhia.factures.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
	public String showCreate(ModelMap modelMap)
	{
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("facture", new Facture());
		return "formFacture";
	}
	
	@RequestMapping("/edit")
	public String editFacture(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Facture f= factureService.getFacture(id);
		System.out.println(f.getIdFacture());
		System.out.println(f.getNomSociete());
		
		modelMap.addAttribute("facture", f);
		modelMap.addAttribute("mode", "edit");

		return "formFacture";
	}
	
	
	
	@RequestMapping("/saveFacture")
	public String saveFacture(@Valid Facture facture,BindingResult bindingResult)
	{
		
		System.out.println("11111112222211111");
		System.out.println(facture.getIdFacture());


		if (bindingResult.hasErrors()) {
			return "formFacture";
		}
		factureService.saveFacture(facture);
		return "formFacture";
	}
	
	
	
	@RequestMapping("/index")
	public String listeFacture(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
		Page<Facture> facts = factureService.getAllFacturesParPage(page, size);
		modelMap.addAttribute("facts", facts);
		modelMap.addAttribute("produits", facts);
		modelMap.addAttribute("pages", new int[facts.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "indexFactures";
	}
	
	@RequestMapping("/delete")
	public String supprimerFacture(@RequestParam("id") Long id,ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
		
		factureService.deleteFactureById(id);
		Page<Facture> facts = factureService.getAllFacturesParPage(page,
		size);
		modelMap.addAttribute("facts", facts);
		modelMap.addAttribute("pages", new int[facts.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);

		return "indexFactures";
	}	
	
	

	
	
	
	@RequestMapping("/updateFacture")
	public String updateFacture(@ModelAttribute("produit") Facture facture,
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



