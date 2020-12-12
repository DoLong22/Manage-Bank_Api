package spring.service.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.model.Address;
import spring.repository.AddressRepository;

@Service
public class AddressServiceIml implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address add(Address address) {

        Address addressAdded = addressRepository.save(address);
        return addressAdded;
    }

    @Override
    public Address get(int id) {
        Address address = addressRepository.getOne(id);
        return address;
    }
}
