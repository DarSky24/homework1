package ru.otus.hm1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.hm1.domain.Student;
import ru.otus.hm1.service.InterviewService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring-context.xml");
        InterviewService service = ctx.getBean(InterviewService.class);
        service.conductInterview(new Student());
    }
}
