package htw.berlin;

import htw.berlin.service.FakeBurgerBuilder;
import htw.berlin.ui.ChatbotUI;
import htw.berlin.ui.Menu;
import htw.berlin.ui.CommaAndWhitespaceSplittingInputParser;
import htw.berlin.ui.UserInputWrapper;

public class BurgerApplication {

    public static void main(String[] args) {
        var parser = new CommaAndWhitespaceSplittingInputParser();
        var builder = new FakeBurgerBuilder();
        var ui = new ChatbotUI(new UserInputWrapper(System.in, System.out), builder, parser);
        ui.launch();
    }
}
