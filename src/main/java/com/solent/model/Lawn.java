package com.solent.model;

import java.util.List;

public class Lawn {
    private final int largestAvailableXCoordinate;
    private final int largestAvailableYCoordinate;
    private final List<LawnMower> lawnMowers;

    public Lawn(int largestAvailableXCoordinate, int largestAvailableYCoordinate, List<LawnMower> lawnMowers) {
        this.largestAvailableXCoordinate = largestAvailableXCoordinate;
        this.largestAvailableYCoordinate = largestAvailableYCoordinate;
        this.lawnMowers = lawnMowers;
    }

    public boolean isInside(Position position) {
        return position.x() >= 0 && position.x() <= largestAvailableXCoordinate
                && position.y() >= 0 && position.y() <= largestAvailableYCoordinate;
    }

    public String executeAllInstructions(){
        StringBuilder output = new StringBuilder();
        lawnMowers.forEach(mower -> mower.executeInstructions(this, output));
        return output.toString().trim();
    }
}
