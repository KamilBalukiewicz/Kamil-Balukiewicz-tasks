package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message) {

        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello account");
        functionality.add("Application allows sending tasks to Trello");
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url","http://localhost:8888/tasks_frontend/");
        context.setVariable("button", "visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("preview", "New Trello card created");
        context.setVariable("goodbye1", "Kind regards");
        context.setVariable("goodbye2", adminConfig.getAdminName());
        context.setVariable("company_details", adminConfig.getAppName() + " | " +
                adminConfig.getAppDesc() + " | " + adminConfig.getCompanyName() + " | " +
                adminConfig.getCompanyMail() +  " | " + adminConfig.getCompanyPhone());
        context.setVariable("show_button", false);
        context.setVariable("is_friend", false);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality", functionality);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String buildDailyInfoEmail(String message) {
        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello account");
        functionality.add("Application allows sending tasks to Trello");
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url","http://localhost:8888/tasks_frontend/");
        context.setVariable("button", "visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("preview", "Daily info email");
        context.setVariable("admin_config", adminConfig);
        context.setVariable("goodbye1", "Kind regards");
        context.setVariable("goodbye2", adminConfig.getAdminName());
        context.setVariable("company_details1", adminConfig.getAppName());
        context.setVariable("company_details2", adminConfig.getAppDesc());
        context.setVariable("company_details3", adminConfig.getCompanyName());
        context.setVariable("company_details4", adminConfig.getCompanyMail());
        context.setVariable("company_details5", adminConfig.getCompanyPhone());
        context.setVariable("show_button", true);
        context.setVariable("is_friend", true);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality", functionality);
        return templateEngine.process("mail/scheduled-mail", context);
    }
}
