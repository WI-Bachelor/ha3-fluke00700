package htw.berlin;

import htw.berlin.domain.FakeBurger;
import htw.berlin.service.BurgerBuilder;
import htw.berlin.service.FakeBurgerBuilder;
import htw.berlin.ui.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.AdditionalMatchers.*;
import static org.mockito.ArgumentMatchers.*;

import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

// testing approach inspired from https://stackoverflow.com/questions/6415728/junit-testing-with-simulated-user-input#answer-6416591
public class ChatbotUITest {

    @Test
    @DisplayName("text input loop should get a first input line")
    void canGetInput() {
        String initialQuestion = "Was moechtest du gerne bestellen?";
        UserInputWrapper input = mock(UserInputWrapper.class);
        when(input.ask(contains(initialQuestion))).thenReturn("Ich bin mir nicht sicher");
        when(input.ask(not(contains(initialQuestion)))).thenReturn("Auf Wiedersehen");

        InputParser parser = mock(InputParser.class);
        when(parser.countKeywords(anyString(), anySet())).thenReturn(Map.of(
                "Burger", 0,
                "Ciabatta", 0,
                "Rindfleisch", 0,
                "Falafel", 0,
                "Eisbergsalat", 0,
                "Rucolasalat", 0,
                "Tomate", 0,
                "Gurke", 0,
                "Ketchup", 0,
                "Mayo", 0
        ));

        ChatbotUI ui = new ChatbotUI(input, new FakeBurgerBuilder(), parser);

        assertEquals("Auf Wiedersehen", ui.launch());
    }

    @Test
    @DisplayName("helper method articleIdsFromOrder can get the correct article ids")
    void canGetArticleIds() {
        InputParser parser = mock(InputParser.class);
        when(parser.countKeywords(anyString(), anySet())).thenReturn(Map.of(
                "Burger", 1,
                "Ciabatta", 0,
                "Rindfleisch", 0,
                "Falafel", 0,
                "Eisbergsalat", 0,
                "Rucolasalat", 0,
                "Tomate", 1,
                "Gurke", 0,
                "Ketchup", 0,
                "Mayo", 0
        ));
        ChatbotUI ui = new ChatbotUI(null, null, parser);

        var expected = Arrays.asList(100, 700);
        var actual = ui.articleIdsFromOrder("Ich haette gerne einen Burger mit Tomate");
        assertEquals(expected, actual);
    }
}
