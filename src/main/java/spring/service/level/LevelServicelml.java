package spring.service.level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import spring.model.Level;
import spring.model.Person;
import spring.repository.LevelRepository;

import java.util.List;

@Service
public class LevelServicelml implements LevelService{
    @Autowired
    private LevelRepository levelRepository;

    @Override
    public Level addLevel(Level level) {
        return this.levelRepository.save((level));
    }

    public Level updateLevel(Level level) {
        Level exitsLevel = this.levelRepository.findById(level.getId()).orElse(null);
        if(exitsLevel != null){
            exitsLevel = levelRepository.saveAndFlush(level);
        }
        return  exitsLevel;
    }

    public boolean deleteLevel(int id) {
        boolean isDeleted = false;
        Level level = this.levelRepository.findById(id).orElse(null);
        if(level != null ){
            this.levelRepository.deleteById(id);
            isDeleted = true;
        }
        return isDeleted;
    }

    public List<Level> getAllLevel(int page) {
        List<Level> list = this.levelRepository.findAll(PageRequest.of(page, 20)).getContent();
        return list;
    }

    public Level getLevelById(int id) {
        Level level = this.levelRepository.findById(id).orElse(null);
        return level;
    }
}
