package com.goit.gojavaonline.tictactoe.view;

import com.goit.gojavaonline.tictactoe.exceptions.NegativeIntegerInputException;
import com.goit.gojavaonline.tictactoe.exceptions.TooFarFromRangeException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.annotation.Mock;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by SashaKulek on 19/04/2016.
 */


@RunWith(PowerMockRunner.class)
@PrepareForTest(UserInput.class)
public class UserInputTest {

    @Test(expected = TooFarFromRangeException.class)
    public void getMovingIndex() throws Exception {
        UserInput userInput = new UserInput();

        UserInteraction mockUI = mock(ConsoleUserInteraction.class);
        when(mockUI.ask("bigInt: ")).thenReturn("100");

        MemberModifier.field(UserInput.class, "userInteraction").set(userInput, mockUI);


        userInput.getMovingIndex("bigInt");

    }

}