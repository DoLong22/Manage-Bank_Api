package spring.service.registing;

import spring.model.Customer;
import spring.model.Registing;

import java.util.List;

public interface RegistingService {

    public Registing createRegisting(Registing registing);

    public boolean deleteRegisting(int id);

    public Registing updateRegisting(Registing registing);

    public List<Registing> getAllRegisting(int page);

    public Registing getRegistingById(int id);

}
