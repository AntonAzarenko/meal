package com.azarenka.service.mail;

public enum MailType {

    REGISTER_CONFIRMATION("registerConfirmationTemplate.ftl", "Register confirmation"),
    MAILING("mailingTemplate.ftl", "Update MealUI");

    private String templateFilename;
    private String subject;

    /**
     * Constructor.
     *
     * @param templateFilename template filename
     * @param subject          the subject
     */
    MailType(String templateFilename, String subject) {
        this.templateFilename = templateFilename;
        this.subject = subject;
    }

    /**
     * Gets template filename.
     *
     * @return template filename
     */
    public String getTemplateFilename() {
        return templateFilename;
    }

    /**
     * Gets the subject.
     *
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }
}
