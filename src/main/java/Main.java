import com.solent.model.Lawn;
import com.solent.service.InstructionsHandler;

public class Main {
    public static void main(String[] args) {
        InstructionsHandler instructionsHandler = new InstructionsHandler();

        Lawn lawn = instructionsHandler.parseInstructions("src\\main\\resources\\input.txt");
        instructionsHandler.executeAllInstructions(lawn);
        // TODO think about better main, par exemple fichier input en argument

        lawn.printAllPositions();
    }
}