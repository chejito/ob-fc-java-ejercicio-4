import com.sparkpost.Client;
import com.sparkpost.exception.SparkPostException;
import com.sparkpost.transport.IRestConnection;

public class MailSender {

    public int sendMail(User user) {
        String API_KEY = System.getenv("SPARK");
        Client client = new Client(API_KEY, IRestConnection.SPC_EU_ENDPOINT);

        String sender = System.getenv("SPARK_MAIL");
        String username = user.getUsername();
        String receiver = user.getEmail();
        String subject = String.format("Bienvenid@ al sistema, %s", user.getUsername() );
        String text = "";
        String html = "<h1>Bienvenid@ al sistema</h1>" +
                String.format("<p>Estimad@ %s, en unos minutos te enviaremos tus credenciales de acceso a la plataforma</p>", username) +
                "<p>Es un placer para nosotros que te hayas unido a esta gran familia.</p>" +
                "<p>Sin más, me despido de tí y te deseo unas felices fiestas.</p>" +
                "<p>Perico el de los Palotes,\nDirector RRHH.</p>";

        try {
            client.sendMessage(sender, receiver, subject, text, html);
            return 1;
        }  catch (SparkPostException e) {
            System.err.printf("\nError: %s\n",e.getMessage());
            return -1;
        }
    }
}
