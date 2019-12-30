package com.azarenka.service.mail;

import java.util.Map;

public class SendMessage {

    private final String recipient;
    private final MailType mailType;
    private final Map<String, String> data;
    private final String sender;

    /**
     * Constructor.
     *
     * @param recipient the mail recipient
     * @param data      the mail data
     * @param mailType  the mail type
     */
    public SendMessage(String recipient, MailType mailType, Map<String, String> data) {
        this(recipient, mailType, data, null);
    }

    /**
     * Constructor.
     *
     * @param recipient the mail recipient
     * @param data      the mail data
     * @param mailType  the mail type
     * @param sender    the sender
     */
    public SendMessage(String recipient, MailType mailType, Map<String, String> data, String sender) {
        this.recipient = recipient;
        this.mailType = mailType;
        this.data = data;
        this.sender = sender;
    }

    /**
     * Gets the mail recipient.
     *
     * @return the mail recipient
     */
    public String getRecipient() {
        return recipient;
    }

    /**
     * Gets the mail type.
     *
     * @return the mail type
     */
    public MailType getMailType() {
        return mailType;
    }

    /**
     * Gets the mail data.
     *
     * @return the mail data
     */
    public Map<String, String> getData() {
        return data;
    }

    /**
     * Gets the sender.
     *
     * @return the sender
     */
    public String getSender() {
        return sender;
    }
}
