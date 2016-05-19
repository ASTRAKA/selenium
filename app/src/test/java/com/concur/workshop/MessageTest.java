package com.concur.workshop;

import com.concur.workshop.categories.Api;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author AndrejS
 */
public class MessageTest {

    private static final Logger logger = LoggerFactory.getLogger(MessageTest.class);

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Category(Api.class)
    @Test
    public void testNicknamePositive() {
        logger.info("testNicknamePositive");
        String nickname = "foo";
        Message messageInstance = new Message(nickname, "bar");
        Assert.assertEquals("Test of nickname failed!", nickname, messageInstance.getNickname());

    }

    @Category(Api.class)
    @Test
    public void testNicknameNegative() {
        logger.info("testNicknameNegative");
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Argument can't be null or empty");
        Message message = new Message(null, "bar");
    }

    @Category(Api.class)
    @Test
    public void testTextPositive() {

        String message = "some message text";
        Message messageInstance = new Message("foo", message);
        Assert.assertEquals("Test of message failed!", message, messageInstance.getText());

    }

    @Test
    public void testTextNegative() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Argument can't be null or empty");
        Message message = new Message("foo", null);
    }
}
