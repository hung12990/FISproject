package vn.fis.training.service;

import vn.fis.training.domain.Customer;
import vn.fis.training.exception.CustomerNotFoundException;
import vn.fis.training.exception.DuplicateCustomerException;
import vn.fis.training.exception.InvalidCustomerException;
import vn.fis.training.store.InMemoryCustomerStore;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SimpleCustomerService implements CustomerService{

    private InMemoryCustomerStore customerStore;

    @Override
    public Customer findById(String id) throws    IllegalArgumentException,CustomerNotFoundException {

            if(id==null || id.isEmpty())     throw new IllegalArgumentException();
        Customer customer= customerStore.getMapCustomer().get(id);

            Optional<Customer> optional = Optional.ofNullable(customer);
            if(optional.isPresent()) throw new CustomerNotFoundException("customer k tim thay");

        return  customer;
    }

    @Override
    public Customer createCustomer(Customer customer) throws InvalidCustomerException, DuplicateCustomerException {

try {
    customer.getId();
    customer.getBirthDay();
    customer.getCreateDateTime();
    customer.getName();
    customer.getStatus();
    customer.getMobile();
}catch (Exception e){
    throw new InvalidCustomerException("loi dinh dang");
}

        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
        Optional<Customer> optional = Optional.ofNullable(customer);
        if(optional.isPresent()) throw new CustomerNotFoundException("customer k tim thay");
       Customer existedCust=this.findById(customer.getId());
       customerStore.insertOrUpdate(customer);
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        return null;
    }

    @Override
    public void deleteCustomerById(String id) throws  CustomerNotFoundException{
        Customer customer= customerStore.getMapCustomer().get(id);

        Optional<Customer> optional = Optional.ofNullable(customer);
        if(optional.isPresent()) throw new CustomerNotFoundException("customer k tim thay");
customerStore.deleteById(id);
        //TODO: Implement method tho dung dac ta cua CustomerService interface
    }

    @Override
    public List<Customer> findAllOrderByNameAsc() {
        //TODO: Implement method tho dung dac ta cua CustomerService interface

        return customerStore.findAll().stream().sorted(Comparator.comparing(Customer::getName)).collect(Collectors.toList());

    }

    @Override
    public List<Customer> findAllOrderByNameLimit(int limit) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        return customerStore.findAll().stream().sorted(Comparator.comparing(Customer::getName)).limit(limit).collect(Collectors.toList());


    }

    @Override
    public List<Customer> findAllCustomerByNameLikeOrderByNameAsc(String custName, String limit) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface

        return null;
    }

    @Override
    public List<SummaryCustomerByAgeDTO> summaryCustomerByAgeOrderByAgeDesc() {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        return null;
    }

}
