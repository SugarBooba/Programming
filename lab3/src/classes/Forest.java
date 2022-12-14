package src.classes;

import java.util.Random;

import src.abs.Location;
import src.abs.Positioned;
import src.interfaces.Descriptable;

public class Forest extends Location {
    // private Tree[] trees;
    

    public Forest(Point pos, String name, Point pos2) {
        super(pos, name, pos2);
        // Random random = new Random();
        // this.trees = new Tree[random.nextInt(100)];
        // for (int i = 0; i < this.trees.length; i++) {
        // this.trees[i] = new Tree(random.nextInt(20));
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

    public class Tree {
        private int height;
        private Point position;

        public Tree(int height) {
            this.height = height;

            Random random = new Random();
            this.position = new Point(
                    random.nextInt(getPosition2().getX() - getPosition().getX()) + getPosition().getX(),
                    random.nextInt(getPosition2().getY() - getPosition().getY()) + getPosition().getY(),
                    random.nextInt(getPosition2().getZ() - getPosition().getZ()) + getPosition().getZ());
        }

        public void getCoordinates() {
            System.out.println("Дерево находится на координатах: " + this.position.getX() + "," + this.position.getY()
                    + "," + this.position.getZ());
        }

        @Override
        public String toString() {
            return "высота этого дерева " + height;
        }
    }
}
