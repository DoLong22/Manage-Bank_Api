package spring.service.registing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import spring.model.Customer;
import spring.model.Position;
import spring.model.Registing;
import spring.repository.RegistingRepository;

import java.util.List;

@Service
public class RegistingServiceIml implements RegistingService{

    @Autowired
    RegistingRepository registingRepository;

    @Override
    public Registing createRegisting(Registing registing) {
        return this.registingRepository.save(registing);
    }

    @Override
    public boolean deleteRegisting(int id) {
        boolean isDeleted = false;
        Registing registing = this.registingRepository.findById(id).orElse(null);
        if(registing != null ){
            this.registingRepository.deleteById(id);
            isDeleted = true;
        }
        return isDeleted;
    }

    @Override
    public Registing updateRegisting(Registing registing) {
        Registing reg = this.registingRepository.findById(registing.getId()).orElse(null);
        if(reg != null){
            reg = registingRepository.saveAndFlush(registing);
        }
        return reg;
    }

    @Override
    public List<Registing> getAllRegisting(int page) {
        List<Registing> listRegisting = this.registingRepository.findAll(PageRequest.of(page, 20)).getContent();
        return listRegisting ;
    }

    @Override
    public Registing getRegistingById(int id) {
        Registing registing = this.registingRepository.findById(id).orElse(null);
        return registing;
    }
}
