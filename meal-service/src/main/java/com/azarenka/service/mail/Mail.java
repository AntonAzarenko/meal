package com.azarenka.service.mail;

import com.azarenka.service.impl.UserServiceImpl;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;


@Component
public class Mail {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Value("${mail.username}")
    private String username;

    @Autowired
    private JavaMailSender javaMailSender;
    @Resource
    private Configuration freemarkerConfig;

    @Transactional
    public void sendMessage(SendMessage sendMessage) {
        try {
            LOGGER.info("Send mail to {}", "//TODO");
            MailType mailType = sendMessage.getMailType();
            MimeMessage message = javaMailSender.createMimeMessage();
            freemarkerConfig.setClassForTemplateLoading(getClass(), ServiceConfigurations.BASE_PACKAGE_PATH);
            Template template = freemarkerConfig.getTemplate(mailType.getTemplateFilename());
            String body = FreeMarkerTemplateUtils.processTemplateIntoString(template, sendMessage.getData());
            MimeMessageHelper helper = new MimeMessageHelper(message);
            String sender = sendMessage.getSender();
            if (StringUtils.isNotBlank(sender)) {
                helper.setCc(sender);
            }
            helper.setFrom(username);
            helper.setTo(sendMessage.getRecipient());
            helper.setSubject(mailType.getSubject());
            helper.setText(body, true);

            javaMailSender.send(message);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
