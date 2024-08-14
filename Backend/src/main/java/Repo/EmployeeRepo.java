package Repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import ModelClasses.Employee;

@Repository
public interface EmployeeRepo extends JpaRepositoryImplementation<Employee, Long>{

}
