package AppServices;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ModelClasses.Employee;
import ModelClasses.tenant;
import Repo.EmployeeRepo;

@Service
@Transactional
public class EmployeeService {

	private final EmployeeRepo employeeRepo;
	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo=employeeRepo;
	}
	
	@Scheduled(cron = "0 0 0 25 * ?")
	public void updateSalaryDueDate() {
		List<Employee> employees = employeeRepo.findAll();
		for(Employee employee: employees) {
			if(employee.getSalaryStatus().equals("PAID"))
			employee.setSalaryduedate((employee.getSalaryduedate().plusMonths(1)));
			employee.setSalaryStatus("DUE");
			employeeRepo.save(employee);
		}
	}
	
	
	public List<Employee> findallEmployees() {
		return employeeRepo.findAll();
	}
	
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeid(UUID.randomUUID().toString());
		employee.setLeavebalance("0");
		employee.setSalaryStatus("Paid");
		employee.setSalaryduedate(employee.getDateofhireDate().plusMonths(1));
		return employeeRepo.save(employee);
	}
	
	public void deleteEmployee(Long id) {
		employeeRepo.deleteById(id);
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	
	
	
	
}
