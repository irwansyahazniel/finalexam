

import id.web.skyforce.bank.model.Account;
import id.web.skyforce.bank.model.Address;
import id.web.skyforce.bank.model.Customer;
import id.web.skyforce.bank.model.CustomerStatus;
import id.web.skyforce.bank.util.HibernateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestTransaction {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setId(1234_5678L);
		customer.setGender('M');
		customer.setFirstName("Linus");
		customer.setLastName("Torvalds");
		
		Address address = new Address();
		address.setStreet("Silicon Valley No. 13");
		address.setCity("San Francisco");
		address.setPostalCode("94027");
		
		Date parsingDate = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			parsingDate = formatter.parse("28-12-1969");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		customer.setBirthDate(parsingDate);
		customer.setAddress(address);
		
		Account account01 = new Account();
		account01.setNumber("XYZ123");
		account01.setBalance(40_000_000_000L);
		account01.setStatus(CustomerStatus.ACTIVE);
		account01.setCustomer(customer);
		
		Account account02 = new Account();
		account02.setNumber("XYZ456");
		account02.setBalance(20_000_000L);
		account02.setStatus(CustomerStatus.INACTIVE);
		
		session.save(account01);
		session.save(account02);
		session.save(customer);
		
		transaction.commit();
		session.close();
		
	}

}
