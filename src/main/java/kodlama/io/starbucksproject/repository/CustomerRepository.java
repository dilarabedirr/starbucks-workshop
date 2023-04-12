package kodlama.io.starbucksproject.repository;

import kodlama.io.starbucksproject.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
