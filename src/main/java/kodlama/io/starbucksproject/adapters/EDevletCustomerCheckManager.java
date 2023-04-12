package kodlama.io.starbucksproject.adapters;

import kodlama.io.starbucksproject.business.abstracts.CustomerCheckService;
import kodlama.io.starbucksproject.entities.Customer;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EDevletCustomerCheckManager implements CustomerCheckService {
    List<Customer> customers;

    public EDevletCustomerCheckManager() {
        customers = new ArrayList<>();
        customers.add(new Customer(1, "Dilara", "Bedir", LocalDate.of(1997, 5, 13), "11"));
        customers.add(new Customer(2, "Büşra", "Çiftlik", LocalDate.of(1996, 1, 2), "22"));
        customers.add(new Customer(3, "Emre", "Alkan", LocalDate.of(1999, 7, 20), "33"));

    }

    @Override
    public void customerCheck(Customer customer) {
        boolean result = false;
        for (Customer c : customers) {
            if (c.getFirstName().equals(customer.getFirstName()) &&
                    c.getLastName().equals(customer.getLastName()) &&
                    c.getDateOfBirth().isEqual(customer.getDateOfBirth()) &&
                    c.getNationalIdentity().equals(customer.getNationalIdentity())) {
                result = true;
            }
        }
        if (!result) {
            throw new RuntimeException("hatalı bilgi");
        }
    }
}
