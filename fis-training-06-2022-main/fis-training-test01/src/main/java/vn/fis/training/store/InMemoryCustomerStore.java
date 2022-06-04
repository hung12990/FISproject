package vn.fis.training.store;

import vn.fis.training.domain.Customer;
import vn.fis.training.exception.ApplicationException;

import java.util.*;

public final class InMemoryCustomerStore {
    /**
     *  Map dung de lu tru customer trong he thong
     */
    private final Map<String, Customer> mapCustomer = new HashMap<>();

    public Map<String, Customer> getMapCustomer() {
        return mapCustomer;
    }

    public InMemoryCustomerStore() {

    }

    /**
     * @param customer doi tuong customer (da duoc chuan hoa truoc do)
     * @return Customer: Doi tuong customer sau khi da duoc luu thanh cong vao he thong
     * @throws vn.fis.training.exception.ApplicationException tuong ung.
     */

    public Customer insertOrUpdate(Customer customer) throws ApplicationException {
        mapCustomer.put(customer.getId(),customer);
        return  customer;
    }

    /**
     * @return : tra ve toan bo danh sach customer trong he thong
     */
    public List<Customer> findAll() {
        //TODO: Implement method  dac ta
        Collection<Customer> values = mapCustomer.values();


        List<Customer> listOfValues = new ArrayList<Customer>(values);
        return listOfValues;
    }

    /**
     * @param id: Id cua customer muon delete
     */
    public void deleteById(String id) {
        mapCustomer.remove(id);
    }
}
