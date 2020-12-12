
package spring.service.position;

import spring.model.Position;

public interface PositionService {
    public Position addPosition(Position position);
    public Position updatePosition(Position position);
    public boolean deletePosition(int id);
    public Position getPositionById(int id);
}