package AppServices;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ModelClasses.tenant;
import Repo.TenantRepo;

@Service
@Transactional
public class TenantServices {
	private final TenantRepo tenantrepo;
	@Autowired
	public TenantServices(TenantRepo tenantrepo) {
		this.tenantrepo = tenantrepo;
	}
	
	@Scheduled(cron = "0 0 0 25 * ?")
	public void updateRentDueDate() {
		List<tenant> tenants = tenantrepo.findAll();
		for(tenant Tenant: tenants) {
			if(Tenant.getPaymentstatus().equals("PAID"))
			Tenant.setRentduedate(Tenant.getRentduedate().plusMonths(1));
			Tenant.setPaymentstatus("DUE");
			tenantrepo.save(Tenant);
		}
	}
	
	
	public List<tenant> findAllTenants(){
		return tenantrepo.findAll();
	}
	
	public tenant addTenant(tenant newTenant) {
		newTenant.setTenantid(UUID.randomUUID().toString());
		return tenantrepo.save(newTenant);
	}
	
	public void deleteTenant(Long id) {
		tenantrepo.deleteById(id);
	}
	
	public tenant updateTenant(tenant editTenant) {
		return tenantrepo.save(editTenant);
	}
	
}
