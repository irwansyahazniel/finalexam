package id.web.skyforce.bank.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@Column(name="id_number", nullable=false)
	private Long idNumber;
	
	@Column(name = "first_name", length = 50, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", length = 50, nullable = false)
	private String lastName;
	
	@Column(name = "birth_date", length = 50, nullable = false)
	private Date birthDate;
	
	@Column(name = "gender", length = 1, nullable = false)
	private Character gender;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", unique = true)
//	private Set<Address> address = new HashSet<>();
	private Address address;
	
	@OneToMany
	@JoinColumn(name = "customer_id")
	private Set<Account> accounts;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Long getId() {
		return idNumber;
	}

	public void setId(Long idNumber) {
		this.idNumber = idNumber;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public Long getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(Long idNumber) {
		this.idNumber = idNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

//	public Set<Address> getAddress() {
//		return address;
//	}
//
//	public void setAddress(Set<Address> address) {
//		this.address = address;
//	}
	
	
	
}
