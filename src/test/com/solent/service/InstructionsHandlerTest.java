package test.com.solent.service;

import main.com.solent.model.Direction;
import main.com.solent.model.Lawn;
import main.com.solent.model.LawnMower;
import main.com.solent.model.Position;
import main.com.solent.service.InstructionsHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
//import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class InstructionsHandlerTest {
    private static String FOLDER_PREFIX = "src\\test\\resources\\";
    @Test
    void should_execute_instructions_correctly() {
        InstructionsHandler instructionsHandler = new InstructionsHandler();

        Lawn lawn = instructionsHandler.parseInstructions(FOLDER_PREFIX +"good_input.txt");
        instructionsHandler.executeAllInstructions(lawn);

        //TODO use recursive comparison en ajoutant assertj, equals et hashcode

        var expected = getExpected();

        System.out.println("Tondeuse 1 : " + lawn.getLawnMowers().get(0).getPosition() + " " + lawn.getLawnMowers().get(0).getDirection());
        System.out.println("Tondeuse 2 : " + lawn.getLawnMowers().get(1).getPosition() + " " + lawn.getLawnMowers().get(1).getDirection());
        assertEquals(lawn.getLawnMowers().get(0).getPosition().x(), expected.get(0).getPosition().x());
        assertEquals(lawn.getLawnMowers().get(0).getPosition().y(), expected.get(0).getPosition().y());
        assertEquals(lawn.getLawnMowers().get(0).getDirection(), expected.get(0).getDirection());
        assertEquals(lawn.getLawnMowers().get(1).getPosition().x(), expected.get(1).getPosition().x());
        assertEquals(lawn.getLawnMowers().get(1).getPosition().y(), expected.get(1).getPosition().y());
        assertEquals(lawn.getLawnMowers().get(1).getDirection(), expected.get(1).getDirection());
        //assertEquals(getExpected(), lawn.getLawnMowers());
    }

    @ParameterizedTest
    @ValueSource(strings = {"malformed_input_missing_line.txt","malformed_input_numberFormat.txt","malformed_input_too_short_line.txt"})
    void should_throw_exception(String input) {
        InstructionsHandler instructionsHandler = new InstructionsHandler();

        assertThrows(IllegalArgumentException.class, () -> instructionsHandler.parseInstructions(FOLDER_PREFIX +input));
    }

    private static List<LawnMower> getExpected() {
        Position startPosition = new Position(1, 3);
        LawnMower mower1 = new LawnMower(startPosition, Direction.N, "GAGAGAGAA");

        Position startPosition2 = new Position(5, 1);
        LawnMower mower2 = new LawnMower(startPosition2, Direction.E, "AADAADADDA");

        return List.of(mower1, mower2);
    }
}