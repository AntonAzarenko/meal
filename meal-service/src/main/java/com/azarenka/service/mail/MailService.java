package com.azarenka.service.mail;

import com.azarenka.domain.User;
import com.azarenka.repository.UserRepository;
import com.azarenka.service.impl.auth.UserPrinciple;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MailService {

    @Autowired
    private Mail mail;
    @Autowired
    private UserRepository userRepository;
    @Value("${uri}")
    private String URI;

    //@Scheduled
    public void sendMail(){
        List<User> users = userRepository.getAll();
        String login = UserPrinciple.safeGet().getEmail();
        users.forEach(this::accept);
    }

    public  void sendMessage(String uri, String email) {
        SendMessage sendMessage = new SendMessage(email, MailType.MAILING,
                buildMessageData(uri, email));
        mail.sendMessage(sendMessage);
    }

    public static Map<String, String> buildMessageData(String uri, String login) {
        Map<String, String> data = new HashMap<>();
        int endIndex = StringUtils.ordinalIndexOf(uri, "/", 3);
        data.put("uri", endIndex < 0 ? uri : uri.substring(0, endIndex));
        data.put("link", uri);
        return data;
    }

    private void accept(User user) {
        sendMessage(URI, user.getEmail());
    }
}
