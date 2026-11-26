package mylab.notification.di.annot.config;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mylab.notification.di.annot.EmailNotificationService;
import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.SmsNotificationService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = NotificationConfig.class)
public class NotificationConfigTest {

    @Autowired
    NotificationManager notificationM;

    @Test
    void testNotificationManager() {
        assertNotNull(notificationM);

        // email service
        EmailNotificationService emailServ = (EmailNotificationService) notificationM.getEmailService();
        assertNotNull(emailServ);
        assertEquals("smtp.gmail.com", emailServ.getSmtpServer());
        assertEquals(587, emailServ.getPort());

        // sms service
        SmsNotificationService smsServ = (SmsNotificationService) notificationM.getSmsService();
        assertNotNull(smsServ);
        assertEquals("SKT", smsServ.getProvider());

        // notificationManager의 method 실행
        notificationM.sendNotificationByEmail("테스트 이메일");
        notificationM.sendNotificationBySms("테스트 SMS");
    }
}