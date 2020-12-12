package spring.service.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.model.Person;
import spring.model.Position;
import spring.repository.PositionRepository;

@Service
public class PositionServicelml implements PositionService{
    @Autowired
    private PositionRepository positionRepository;

    @Override
    public Position addPosition(Position position){
        return this.positionRepository.save((position));
    }

    @Override
    public Position updatePosition(Position position){
        Position pos = this.positionRepository.findById(position.getId()).orElse(null);
        if(pos != null){
            pos = positionRepository.saveAndFlush(position);
        }
        return pos;
    }

    @Override
    public boolean deletePosition(int id) {
        boolean isDeleted = false;
        Position pos = this.positionRepository.findById(id).orElse(null);
        if(pos != null ){
            this.positionRepository.deleteById(id);
            isDeleted = true;
        }
        return isDeleted;
    }

    @Override
    public Position getPositionById(int id) {
        Position pos = this.positionRepository.findById(id).orElse(null);
        return pos;
    }
}