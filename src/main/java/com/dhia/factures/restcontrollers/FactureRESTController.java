
package com.dhia.factures.restcontrollers;
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RestController;
import com.dhia.factures.entities.Facture;
import com.dhia.factures.services.FactureService; 

@RestController 
@RequestMapping("/api") 
@CrossOrigin 
public class FactureRESTController { 
	@Autowired 
	FactureService factureService; 
	@RequestMapping(method = RequestMethod.GET) 
	public List<Facture> getAllFactures() { 
		return factureService.getAllFactures(); 
	} 
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET) 
	public Facture getFactureById(@PathVariable("id") Long id) { 
		return factureService.getFacture(id); 
	}

	@RequestMapping(method = RequestMethod.POST) 
	public Facture createFacture(@RequestBody Facture facture) {
		return factureService.saveFacture(facture); 
	} 

	
	@RequestMapping(method = RequestMethod.PUT) 
	public Facture updateFacture(@RequestBody Facture facture) {
		return factureService.updateFacture(facture); 
	} 

	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE) 
	public void deleteFacture(@PathVariable("id") Long id) 
	{ 
		factureService.deleteFactureById(id); 
	} 

	@RequestMapping(value="/FactsUser/{idUser}",method = RequestMethod.GET) 
	public List<Facture> getFactureByUserId(@PathVariable("idUser") Long idUser) {
		return factureService.findByUserIdUser(idUser); 
	} 

	
	
}
