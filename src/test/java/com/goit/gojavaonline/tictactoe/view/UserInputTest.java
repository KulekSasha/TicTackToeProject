package com.goit.gojavaonline.tictactoe.view;

import com.goit.gojavaonline.tictactoe.exceptions.NegativeIntegerInputException;
import com.goit.gojavaonline.tictactoe.exceptions.TooFarFromRangeException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.*;


/**
 * Created by SashaKulek on 19/04/2016.
 */


@RunWith(PowerMockRunner.class)
@PrepareForTest(UserInput.class)
public class UserInputTest {

    private static UserInput userInput;

    @Before
    public void setUp() throws Exception {
        userInput = new UserInput();

    }

    @Test(expected = TooFarFromRangeException.class)
    public void getMovingIndexPassBigInt() throws Exception {

        String input = "100";

        UserInteraction mockUI = mock(ConsoleUserInteraction.class);
        when(mockUI.ask("bigInt: ")).thenReturn(input);

        MemberModifier.field(UserInput.class, "userInteraction").set(userInput, mockUI);

        userInput.getMovingIndex("bigInt");

    }

    @Test(expected = NegativeIntegerInputException.class)
    public void getMovingIndexPassNegativeInt() throws Exception {

        String input = "0";

        UserInteraction mockUI = mock(ConsoleUserInteraction.class);
        when(mockUI.ask("negativeInt: ")).thenReturn(input);

        MemberModifier.field(UserInput.class, "userInteraction").set(userInput, mockUI);

        userInput.getMovingIndex("negativeInt");

    }
}