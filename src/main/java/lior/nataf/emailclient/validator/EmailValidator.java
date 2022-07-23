package lior.nataf.emailclient.validator;

import lior.nataf.emailclient.exception.InvalidEmailException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Slf4j
@Component
public class EmailValidator {
    public void validateAddress(String emailAddress) throws InvalidEmailException {
        Pattern emailPattern = Pattern.compile("^(.+)@(\\S+)$");
        if (!emailPattern.matcher(emailAddress).matches()) {
            log.error("Invalid email from {}", emailAddress);
            throw new InvalidEmailException(emailAddress);
        }
    }
}
