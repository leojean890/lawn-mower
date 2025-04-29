import com.solent.model.Lawn;
import com.solent.service.InstructionsHandler;

public class Main {
    public static void main(String[] args) {
        InstructionsHandler instructionsHandler = new InstructionsHandler();
        System.out.println(instructionsHandler.executeAllInstructions(args[0]));
    }
}