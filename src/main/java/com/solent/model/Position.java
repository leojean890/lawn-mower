package com.solent.model;

public record Position(int x, int y) {
    public Position move(Direction direction) {
        return switch (direction) {
            case N -> new Position(x, y + 1);
            case S -> new Position(x, y - 1);
            case E  -> new Position(x + 1, y);
            case W  -> new Position(x - 1, y);
        };
    }
}
