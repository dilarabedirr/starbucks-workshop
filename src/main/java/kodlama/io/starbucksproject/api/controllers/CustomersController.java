package kodlama.io.starbucksproject.api.controllers;

import kodlama.io.starbucksproject.business.abstracts.CustomerService;
import kodlama.io.starbucksproject.business.dto.requests.CreateCustomerRequest;
import kodlama.io.starbucksproject.business.dto.responses.CreateCustomerResponse;
import kodlama.io.starbucksproject.business.dto.responses.get.GetAllCustomersResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomersController {
    private final CustomerService service;
    @GetMapping
    public List<GetAllCustomersResponse> getAll(){
        return service.getAll();
    }
    @PostMapping
    public CreateCustomerResponse add(@RequestBody CreateCustomerRequest request){
        return service.add(request);
    }
}
