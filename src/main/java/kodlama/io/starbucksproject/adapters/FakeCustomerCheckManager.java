package kodlama.io.starbucksproject.adapters;

import kodlama.io.starbucksproject.business.abstracts.CustomerCheckService;
import kodlama.io.starbucksproject.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.Random;

//@Service
public class FakeCustomerCheckManager implements CustomerCheckService {
    @Override
    public void customerCheck(Customer customer) {
        boolean isCheckSuccessful=new Random().nextBoolean();
        if (!isCheckSuccessful){
            throw new RuntimeException("kişi bilgileri gerçek değil");
        }
    }
}
