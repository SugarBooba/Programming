package src.classes;

import src.abs.Creature;
import src.abs.Location;
import src.abs.Positioned;
import src.abs.Thing;
import src.interfaces.Descriptable;

public class House extends Location {

    private String material;
    private Door door;

    public House(Point pos, String name, Point pos2, String material) {
        super(pos, name, pos2);
        this.material = material;
        this.door = new Door(this.getPosition(), null ,"Door");
    }

    public String describe() {
        return "Локация " + this.getName();
    }

    public boolean checkConsist(Positioned obj) {
        boolean diapasonX = (this.getPosition2().getX() >= obj.getPosition().getX())
                && (obj.getPosition().getX() >= this.getPosition().getX());

        boolean diapasonY = (this.getPosition2().getY() >= obj.getPosition().getY())
                && (obj.getPosition().getY() >= this.getPosition().getY());

        return diapasonX && diapasonY;
    }

    public String getMaterial() {
        return material;
    }

    public Door getDoor() {
        return door;
    }

    class Door extends Thing implements Descriptable {
        // public Door() {}

        public Door(Point pos, Creature owner, String name) {
            super(pos, owner, name);
            //TODO Auto-generated constructor stub
        }

        @Override
        public String describe() {
            return "изготовлено из материала " + material;
        }

        public String getMaterial() {
            return material;
        }
    }

}
