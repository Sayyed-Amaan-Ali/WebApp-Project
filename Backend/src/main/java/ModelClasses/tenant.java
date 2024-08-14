package ModelClasses;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class tenant implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false) //once set it cant be modified
	private Long id;	//primary key
	private String name;
	private String address;
	private String email;
	@Column(nullable = false)
	private String phone;
	private String password;
	private String profession;
	private String officename;
	private String officeaddress;
	private String roomno;
	private String roomtype; //2-4 seater
	private String facility;	//ac or non ac
	private String vehicleinformation;
	private LocalDate leasestartdate;
	private LocalDate rentduedate;
	private Long rentamount;
	private String paymentstatus;
	@Column(nullable = false, updatable = false)
	private String tenantid;
	
	public tenant() {
		// TODO Auto-generated constructor stub
	}

	public tenant(Long id, String name, String address, String email, String phone, String password, String profession,
			String officename, String officeaddress, String roomno, String roomtype, String facility,
			String vehicleinformation, LocalDate leasestartdate, LocalDate rentduedate, Long rentamount,
			String paymentstatus, String tenantid) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.profession = profession;
		this.officename = officename;
		this.officeaddress = officeaddress;
		this.roomno = roomno;
		this.roomtype = roomtype;
		this.facility = facility;
		this.vehicleinformation = vehicleinformation;
		this.leasestartdate = leasestartdate;
		this.rentduedate = rentduedate;
		this.rentamount = rentamount;
		this.paymentstatus = paymentstatus;
		this.tenantid = tenantid;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getOfficename() {
		return officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
	}

	public String getOfficeaddress() {
		return officeaddress;
	}

	public void setOfficeaddress(String officeaddress) {
		this.officeaddress = officeaddress;
	}

	public String getRoomno() {
		return roomno;
	}

	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	public String getVehicleinformation() {
		return vehicleinformation;
	}

	public void setVehicleinformation(String vehicleinformation) {
		this.vehicleinformation = vehicleinformation;
	}

	public LocalDate getLeasestartdate() {
		return leasestartdate;
	}

	public void setLeasestartdate(LocalDate leasestartdate) {
		this.leasestartdate = leasestartdate;
	}

	public LocalDate getRentduedate() {
		return rentduedate;
	}

	public void setRentduedate(LocalDate rentduedate) {
		this.rentduedate = rentduedate;
	}

	public Long getRentamount() {
		return rentamount;
	}

	public void setRentamount(Long rentamount) {
		this.rentamount = rentamount;
	}

	public String getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public String getTenantid() {
		return tenantid;
	}

	public void setTenantid(String tenantid) {
		this.tenantid = tenantid;
	}

	@PrePersist
	public void prePersist() {
		this.rentduedate=this.leasestartdate.plusMonths(1);
		this.paymentstatus="DUE";
	}
	
	
	@Override
	public String toString() {
		return "tenant [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", phone=" + phone
				+ ", password=" + password + ", profession=" + profession + ", officename=" + officename
				+ ", officeaddress=" + officeaddress + ", roomno=" + roomno + ", roomtype=" + roomtype + ", facility="
				+ facility + ", vehicleinformation=" + vehicleinformation + ", leasestartdate=" + leasestartdate
				+ ", rentduedate=" + rentduedate + ", rentamount=" + rentamount + ", paymentstatus=" + paymentstatus
				+ ", tenantid=" + tenantid + "]";
	}
	
	
	
	

	
	
	

}
