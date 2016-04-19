package com.goit.gojavaonline.tictactoe.view;

import com.goit.gojavaonline.tictactoe.exceptions.NegativeIntegerInputException;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by User on 19.04.2016.
 */
public class UserInputTest {

    UserInput userInput = new UserInput();

    @Test (expected = NegativeIntegerInputException.class)
    public void testGetMovingIndex() throws Exception {

        String input = "0";

        UserInput request = mock(UserInput.class);
        when(request.readInt(input)).thenReturn(0);

//        UserInteraction request = mock(UserInteraction.class);
//        when(request.ask("row")).thenReturn(input);

        userInput.getMovingIndex(input);


    }
}