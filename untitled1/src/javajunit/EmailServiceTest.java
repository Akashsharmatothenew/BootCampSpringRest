package javajunit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by ttn on 1/3/21.
 */
class EmailServiceTest {
      EmailService emailService = new EmailService();
      Order order;

      EmailServiceTest(){

      }
      @Test
      void shouldBeInstanceOfEmailService(){
          assertThat(emailService,instanceOf(EmailService.class));
      }
      @parameterizedTest
      @valueSource(String = {"Runtime exception","Runtime","execption"})
       public void whenExceptionThorwnthenAssertionSucceds(String expectedMessage){
          Exception exception =assertThrows(RuntimeExecption.class,()->{
              emailService.sendEmail((javajunit)order);
          });
          String actualMessage = exception.getMessage();
          assertTrue(actualMessage.contains(expectedMessage));
    }
      @Test
      void isEmailSent(){
           String emailStatus = "Email sent Sucessesfully";
           assertTrue(emailService.sendEmail(Order order),emailStatus);
      }
}