package com.solent.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InstructionsHandlerTest {
    private static String FOLDER_PREFIX = "src\\test\\resources\\";

    @Test
    void should_execute_instructions_correctly() {
        InstructionsHandler instructionsHandler = new InstructionsHandler();
        var actual = instructionsHandler.executeAllInstructions(FOLDER_PREFIX + "good_input.txt");
        assertThat(actual).isEqualTo(getExpectedOutput());
    }

    @Test
    void should_ignore_instructions_which_would_make_lawn_mower_go_out() {
        InstructionsHandler instructionsHandler = new InstructionsHandler();
        var actual = instructionsHandler.executeAllInstructions(FOLDER_PREFIX + "input_going_out.txt");
        assertThat(actual).isEqualTo(getExpectedUnchangedState());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "malformed_input_missing_line.txt","malformed_input_numberFormat.txt","malformed_input_too_short_line.txt"})
    void should_throw_exception(String input) {
        InstructionsHandler instructionsHandler = new InstructionsHandler();

        assertThrows(IllegalArgumentException.class, ()
                -> instructionsHandler.executeAllInstructions(FOLDER_PREFIX + input));
    }

    private static String getExpectedOutput() {
        return "1 3 N 5 1 E";
    }

    private static String getExpectedUnchangedState() {
        return "0 0 S 0 5 N 5 0 E 0 5 W";
    }
}