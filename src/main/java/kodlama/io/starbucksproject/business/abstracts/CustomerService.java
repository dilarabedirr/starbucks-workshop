package kodlama.io.starbucksproject.business.abstracts;

import kodlama.io.starbucksproject.business.dto.requests.CreateCustomerRequest;
import kodlama.io.starbucksproject.business.dto.responses.CreateCustomerResponse;
import kodlama.io.starbucksproject.business.dto.responses.get.GetAllCustomersResponse;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface CustomerService {
    List<GetAllCustomersResponse> getAll();
    CreateCustomerResponse add(CreateCustomerRequest request);
}
