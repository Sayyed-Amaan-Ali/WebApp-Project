package AppControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import AppServices.TenantServices;
import ModelClasses.tenant;

@RestController
@RequestMapping("/tenant")
public class TenantController {
	private final TenantServices tenantServices;
	
	@Autowired
	public TenantController(TenantServices tenantServices) {
		this.tenantServices=tenantServices;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<tenant>> getAllTenant(){
		List<tenant> tenants = tenantServices.findAllTenants();
		return new ResponseEntity<>(tenants,HttpStatus.OK);
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<tenant> AddTenant(@RequestBody tenant newTenant){
		return new ResponseEntity<>(tenantServices.addTenant(newTenant),HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<tenant> updateTenant(@RequestBody tenant newTenant){
		return new ResponseEntity<>(tenantServices.addTenant(newTenant),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<tenant> deleteTenant(@PathVariable Long id){
		tenantServices.deleteTenant(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
