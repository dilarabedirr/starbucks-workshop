package kodlama.io.starbucksproject.business.concretes;

import kodlama.io.starbucksproject.business.abstracts.CustomerCheckService;
import kodlama.io.starbucksproject.business.abstracts.CustomerService;
import kodlama.io.starbucksproject.business.dto.requests.CreateCustomerRequest;
import kodlama.io.starbucksproject.business.dto.responses.CreateCustomerResponse;
import kodlama.io.starbucksproject.business.dto.responses.get.GetAllCustomersResponse;
import kodlama.io.starbucksproject.entities.Customer;
import kodlama.io.starbucksproject.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository repository;
    private final ModelMapper mapper;
    private final CustomerCheckService customerCheckService;

    @Override
    public List<GetAllCustomersResponse> getAll() {
        List<Customer> customers=repository.findAll();
        List<GetAllCustomersResponse> responses=customers.stream()
                .map(customer -> mapper.map(customer,GetAllCustomersResponse.class)).toList();
        return responses;
    }

    @Override
    public CreateCustomerResponse add(CreateCustomerRequest request) {
        Customer customer=mapper.map(request,Customer.class);
        customer.setId(0);
        customerCheckService.customerCheck(customer);
        repository.save(customer);
        CreateCustomerResponse response=mapper.map(customer,CreateCustomerResponse.class);
        return response;
    }
}
