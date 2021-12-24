import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailSenderTest {

    @Test
    void sendMail() {
        MailSender sender = new MailSender();

        User user1 = new User("Chejito", "fake@mail.com");

        assertEquals(sender.sendMail(user1), 1);
    }
}