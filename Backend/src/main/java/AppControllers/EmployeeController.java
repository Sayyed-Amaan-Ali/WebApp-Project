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

import AppServices.EmployeeService;
import AppServices.TenantServices;
import ModelClasses.Employee;
import ModelClasses.tenant;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> employees=employeeService.findallEmployees();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}

	
	@PostMapping(value="/add")
	public ResponseEntity<Employee> AddEmployee(@RequestBody Employee newEmployee){
		return new ResponseEntity<>(employeeService.addEmployee(newEmployee),HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateTenant(@RequestBody Employee newEmployee){
		return new ResponseEntity<>(employeeService.addEmployee(newEmployee),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
