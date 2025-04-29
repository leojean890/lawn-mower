package main.com.solent.model;

import java.util.List;

public class Lawn {
    private final int width;
    private final int height;
    private final List<LawnMower> lawnMowers;

    public Lawn(int width, int height, List<LawnMower> lawnMowers) {
        this.width = width;
        this.height = height;
        this.lawnMowers = lawnMowers;
    }

    public boolean isInside(Position position) {
        return position.x() >= 0 && position.x() <= width &&
                position.y() >= 0 && position.y() <= height;
    }

    public void executeAllInstructions(){
        lawnMowers.forEach(mower -> mower.executeInstructions(this));
    }

    // TODO remove this
    public List<LawnMower> getLawnMowers() { return lawnMowers; }
}
