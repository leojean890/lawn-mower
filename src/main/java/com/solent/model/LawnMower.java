package com.solent.model;

public class LawnMower {
    private Position position;
    private Direction direction;
    private String instructions;

    public LawnMower(Position position, Direction direction, String instructions) {
        this.position = position;
        this.direction = direction;
        this.instructions = instructions;
    }

    public void rotateLeft() {
        this.direction = direction.rotateLeft();
    }

    public void rotateRight() {
        this.direction = direction.rotateRight();
    }

    public void executeInstructions(Lawn lawn) {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'G' -> rotateLeft();
                case 'D' -> rotateRight();
                case 'A' -> moveForward(lawn);
                default -> throw new IllegalArgumentException("Commande invalide : " + instruction);
            }
        }
    }

    public void moveForward(Lawn lawn) {
        Position newPosition = position.move(direction);
        if (lawn.isInside(newPosition)) {
            this.position = newPosition;
        }
    }

    public Position getPosition() { return position; }

    public Direction getDirection() { return direction; }
}
