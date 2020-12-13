
package spring.service.position;

import spring.model.Employee;
import spring.model.Position;

import java.util.List;

public interface PositionService {
    public Position addPosition(Position position);
    public Position updatePosition(Position position);
    public boolean deletePosition(int id);
    public Position getPositionById(int id);
}