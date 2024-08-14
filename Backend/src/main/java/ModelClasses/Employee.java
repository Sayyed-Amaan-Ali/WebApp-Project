package ModelClasses;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false) //once set it cant be modified
	private Long id;	//primary key
	private String name;
	private String address;
	private String gender;
	private String email;
	@Column(nullable = false)
	private String phone;
	private LocalDate dobDate;
	private LocalDate dateofhireDate;
	private String jobtype;
	private String workshift;
	private String leavebalance;
	private String jobtitle;
	private String department;
	private String salary;
	private LocalDate salaryduedate;
	private String salaryStatus;
	private String performanceReview;
	
	@Column(nullable = false, updatable = false)
	private String employeeid;

	
	
	public Employee(){
		
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public LocalDate getDobDate() {
		return dobDate;
	}



	public void setDobDate(LocalDate dobDate) {
		this.dobDate = dobDate;
	}



	public LocalDate getDateofhireDate() {
		return dateofhireDate;
	}



	public void setDateofhireDate(LocalDate dateofhireDate) {
		this.dateofhireDate = dateofhireDate;
	}



	public String getJobtype() {
		return jobtype;
	}



	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}



	public String getWorkshift() {
		return workshift;
	}



	public void setWorkshift(String workshift) {
		this.workshift = workshift;
	}



	public String getLeavebalance() {
		return leavebalance;
	}



	public void setLeavebalance(String leavebalance) {
		this.leavebalance = leavebalance;
	}



	public String getJobtitle() {
		return jobtitle;
	}



	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public String getSalary() {
		return salary;
	}



	public void setSalary(String salary) {
		this.salary = salary;
	}



	public LocalDate getSalaryduedate() {
		return salaryduedate;
	}



	public void setSalaryduedate(LocalDate salaryduedate) {
		this.salaryduedate = salaryduedate;
	}



	public String getSalaryStatus() {
		return salaryStatus;
	}



	public void setSalaryStatus(String salaryStatus) {
		this.salaryStatus = salaryStatus;
	}



	public String getPerformanceReview() {
		return performanceReview;
	}



	public void setPerformanceReview(String performanceReview) {
		this.performanceReview = performanceReview;
	}



	public String getEmployeeid() {
		return employeeid;
	}



	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", gender=" + gender + ", email="
				+ email + ", phone=" + phone + ", dobDate=" + dobDate + ", dateofhireDate=" + dateofhireDate
				+ ", jobtype=" + jobtype + ", workshift=" + workshift + ", leavebalance=" + leavebalance + ", jobtitle="
				+ jobtitle + ", department=" + department + ", salary=" + salary + ", salaryduedate=" + salaryduedate
				+ ", salaryStatus=" + salaryStatus + ", performanceReview=" + performanceReview + ", employeeid="
				+ employeeid + "]";
	}
	
}






