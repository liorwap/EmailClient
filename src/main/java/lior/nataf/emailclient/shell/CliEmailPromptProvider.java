package lior.nataf.emailclient.shell;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

@Component
public class CliEmailPromptProvider implements PromptProvider {
    @Override
    public AttributedString getPrompt() {
        return new AttributedString("EMAIL-EMULATOR:>",
                AttributedStyle.DEFAULT.foreground(AttributedStyle.WHITE));
    }
}
