package com.om.hotel.sendEmail;

import lombok.SneakyThrows;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SendMail {

    static GetUserInfoForSendEmail getUserInfoForSendEmail;

    @SneakyThrows
    protected void sendEmailInfo() {

        System.out.println("Podaj adres email");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.next();

        if (isValid(email)) {

            sendSimpleEmail(email);
        } else
            sendEmailInfo();
    }

    protected boolean isValid(String email) {

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +

                "[a-zA-Z0-9_+&*-]+)*@" +

                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +

                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);

        if (email == null)
            sendEmailInfo();

        return pat.matcher(email).matches();
    }

    private static void sendSimpleEmail(String recepient) throws MessagingException {

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = "mojtesthotel@gmail.com";
        String password = "qjvvlevbvutomoio";

        Session session = Session.getInstance(properties, new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = prepareMassage(session,
                myAccountEmail,
                recepient);

        Transport.send(message);

    }

    private static Message prepareMassage(Session session,
                                          String myAccountEmail,
                                          String recepient) {


        Message message = new MimeMessage(session);

        try {

            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Hello dear " + getUserInfoForSendEmail.getName());
            message.setText(
                            " your price is " +
                            getUserInfoForSendEmail.getPrice() +
                            "zł, from " + getUserInfoForSendEmail.getDateOn() +
                            " to " + getUserInfoForSendEmail.getDateOff()
            );

            return message;

        }
        catch (Exception e) { e.printStackTrace(); }

        return null;
    }
}
