package com.dp.Builder;
import java.util.HashSet;
import java.util.Set;

class Email {
    private final String title;
    private final String recipients;
    private final String message;

    private Email(String title, String recipients, String message) {
        this.title = title;
        this.recipients = recipients;
        this.message = message;
    }

    public void send() {
        System.out.println("To: "+recipients);
        System.out.println("Sub: "+title);
        System.out.println(message);
    }

    public static class EmailBuilder {
        private Set<String> recipients = new HashSet<>();
        private String title;
        private String greeting;
        private String mainText;
        private String closing;

        public EmailBuilder addRecipient(String recipient) {
            this.recipients.add(recipient);
            return this;
        }

        public EmailBuilder removeRecipient(String recipient) {
            this.recipients.remove(recipient);
            return this;
        }

        public EmailBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public EmailBuilder setGreeting(String greeting) {
            this.greeting = greeting;
            return this;
        }

        public EmailBuilder setMainText(String mainText) {
            this.mainText = mainText;
            return this;
        }
        public EmailBuilder setClosing(String closing) {
            this.closing = closing;
            return this;
        }

        public Email build() {
            String message = greeting+"\n"+mainText+"\n"+closing;
            String recipientSection = commaSeparatedRecipients();
            return new Email(title,recipientSection,message);
        }

        private String commaSeparatedRecipients() {
            String res = "";
            for(String recipient : recipients) {
                res += recipient + ", ";
            }
            return res;
        }
    }
}

public class Main2 {
    public static void main(String ar[]) {
        Email email = new Email.EmailBuilder()
                .addRecipient("john@Doe.com")
                .addRecipient("deeksha@taips.com")
                .addRecipient("rexie@karunya.edu")
                .setMainText("Check the builder pattern")
                .setGreeting("Hi John!")
                .setClosing("Regards\nMythily.M")
                .setTitle("Builder pattern resources")
                .build();
        email.send();
    }
}
