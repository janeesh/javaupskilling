package Lesson_02.Exercise_01;

public class Exercise_02 {

    static void main(String[] args) {
        MessagingFactory customerFactory =new CustomerMessagingFactory();

        MessagingFactory opsFactory = new OperationsMessagingFactory();

        System.out.println("---- Customer Notifications ----");
        notifyTeam(customerFactory);

        System.out.println();

        System.out.println("---- Operations Notifications ----");
        notifyTeam(opsFactory);
    }

    abstract static class NotificationTemplate {
        abstract String body();
        abstract String channel();

        final void send() {
            System.out.println(channel() + ": " + body());
        }
    }

    static class EmailNotification extends NotificationTemplate {
        private final String subject;
        private final String recipient;
        EmailNotification(String subject, String recipient) {
            this.subject = subject;
            this.recipient = recipient;
        }
        @Override
        public String body() {
            return subject + " (to: " + recipient + ")";
        }

        @Override
        String channel() {
            return "EMAIL";
        }
    }

    static class SMSNotification extends NotificationTemplate {
        private final String phone;

        SMSNotification(String phone) {
            this.phone = phone;
        }

        @Override
        String body() {
            return "SMS alert for " + phone;
        }

        @Override
        String channel() {
            return "SMS";
        }
    }

    interface MessagingFactory {
        NotificationTemplate createAlert(String message);
        NotificationTemplate createReport(String subject);
    }

    static class CustomerMessagingFactory implements MessagingFactory {

        @Override
        public NotificationTemplate createAlert(String message) {
            return new SMSNotification(message);
        }

        @Override
        public NotificationTemplate createReport(String subject) {
            return new EmailNotification(subject,"customer@example.com");
        }
    }

    static class OperationsMessagingFactory implements MessagingFactory {
        @Override
        public NotificationTemplate createAlert(String message) {
            return new EmailNotification(message,"ops@bank.internal");
        }

        @Override
        public NotificationTemplate createReport(String subject) {
            return new EmailNotification(subject,"ops@bank.internal");
        }
    }

    static void notifyTeam(MessagingFactory f){
        NotificationTemplate alert = f.createAlert("Create Alert");
        NotificationTemplate report = f.createReport("Create Report");
        alert.send();
        report.send();
    }
}
