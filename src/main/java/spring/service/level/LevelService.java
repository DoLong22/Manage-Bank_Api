package spring.service.level;

import spring.model.Level;
import spring.model.Person;

import java.util.List;

public interface LevelService {
    public Level addLevel(Level level);

    public Level updateLevel(Level level);

    public boolean deleteLevel(int id);

    public List<Level> getAllLevel(int page);

    public Level getLevelById(int id);

    //public Person findByCardNumber(String cardNumer);
}
