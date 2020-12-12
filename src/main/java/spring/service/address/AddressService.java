package spring.service.address;

import spring.model.Address;

public interface AddressService {

    public Address add(Address address);
    public Address get(int id);
}
