package com.solent.service;

import com.solent.model.Direction;
import com.solent.model.Lawn;
import com.solent.model.LawnMower;
import com.solent.model.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class InstructionsHandlerTest {
    private static String FOLDER_PREFIX = "src\\test\\resources\\";
    @Test
    void should_execute_instructions_correctly() {
        InstructionsHandler instructionsHandler = new InstructionsHandler();

        Lawn lawn = instructionsHandler.parseInstructions(FOLDER_PREFIX + "good_input.txt");
        instructionsHandler.executeAllInstructions(lawn);

        assertThat(getExpected()).usingRecursiveComparison().isEqualTo(lawn);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "malformed_input_missing_line.txt","malformed_input_numberFormat.txt","malformed_input_too_short_line.txt"})
    void should_throw_exception(String input) {
        InstructionsHandler instructionsHandler = new InstructionsHandler();

        assertThrows(IllegalArgumentException.class, ()
                -> instructionsHandler.parseInstructions(FOLDER_PREFIX + input));
    }

    private static Lawn getExpected() {
        Position startPosition = new Position(1, 3);
        LawnMower mower1 = new LawnMower(startPosition, Direction.N, "GAGAGAGAA");

        Position startPosition2 = new Position(5, 1);
        LawnMower mower2 = new LawnMower(startPosition2, Direction.E, "AADAADADDA");

        return new Lawn(5, 5, List.of(mower1, mower2));
    }
}