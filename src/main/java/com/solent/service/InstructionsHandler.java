package com.solent.service;

import com.solent.model.Direction;
import com.solent.model.Lawn;
import com.solent.model.LawnMower;
import com.solent.model.Position;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InstructionsHandler {
    public String executeAllInstructions(String inputFile){
        Lawn lawn = parseInstructions(inputFile);
        lawn.executeAllInstructions();
        return lawn.returnAllPositions();
    }

    public Lawn parseInstructions(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            String[] dimensions = line.trim().split("\\s+");
            int width = Integer.parseInt(dimensions[0]);
            int height = Integer.parseInt(dimensions[1]);
            List<LawnMower> mowers = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] positionParts = line.trim().split("\\s+");
                int x = Integer.parseInt(positionParts[0]);
                int y = Integer.parseInt(positionParts[1]);
                String orientation = positionParts[2];
                String instructionsLine = reader.readLine();
                LawnMower mower = new LawnMower(new Position(x, y), Direction.valueOf(orientation), instructionsLine.trim());
                mowers.add(mower);
            }
            return new Lawn(width, height, mowers);

        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
            throw new RuntimeException(e);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException | NullPointerException e) {
            throw new IllegalArgumentException("Fichier vide ou mal formé", e);
        }
    }
}
