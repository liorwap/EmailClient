package lior.nataf.emailclient.command;

import lior.nataf.emailclient.exception.InvalidEmailException;
import lior.nataf.emailclient.validator.EmailValidator;
import org.springframework.http.MediaType;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.net.URISyntaxException;

@ShellComponent
public class SendEmailCommand {

    private final EmailValidator emailValidator;

    public SendEmailCommand(EmailValidator emailValidator) {
        this.emailValidator = emailValidator;
    }

    @ShellMethod("Emulates email sending")
    public String sendEmail(@ShellOption({"-F", "--from"}) String from,
                            @ShellOption({"-T", "--to"}) String to,
                            @ShellOption({"-M", "--body"}) String body) throws URISyntaxException, InvalidEmailException {
        validateEmail(from, to);
        MultiValueMap<String, String> email = createMail(from, to, body);
        WebClient client = WebClient.create();
        return client.post()
                .uri(new URI("http://localhost:8080/sendEmail"))
                .header("Content-Type", "application/json")
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromFormData(email))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    private void validateEmail(String from, String to) throws InvalidEmailException {
        emailValidator.validateAddress(from);
        emailValidator.validateAddress(to);
    }

    private MultiValueMap<String, String> createMail(String from, String to, String body) {
        return new LinkedMultiValueMap<>() {{
            add("from", from);
            add("to", to);
            add("body", body);
        }};
    }
}
