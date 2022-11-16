package src.classes;

import src.abs.Location;
import src.abs.Positioned;
import src.interfaces.Runnable;

public class Pit extends Location implements Runnable {
    public Pit(Point pos, String name, Point pos2) {
        super(pos, name, pos2);
    }

    public String describe() {
        return "Локация " + this.getName();
    }

    public boolean checkConsist(Positioned obj) {

        boolean diapasonX = (this.getPosition2().x >= obj.getPosition().x)
                && (obj.getPosition().x >= this.getPosition().x);
        boolean diapasonY = (this.getPosition2().y >= obj.getPosition().y)
                && (obj.getPosition().y >= this.getPosition().y);
        boolean diapasonZ = (this.getPosition2().z >= obj.getPosition().z)
                && (obj.getPosition().z >= this.getPosition().z);

        return diapasonX && diapasonY && diapasonZ;
    }

    @Override
    public void run(int x, int y) {
        Point newPos = new Point(pos.x + x, pos.y + y, pos.z);
        pos = newPos;
    }

}