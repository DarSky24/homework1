package ru.otus.hm1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.hm1.domain.Student;
import ru.otus.hm1.service.InterviewService;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        InterviewService service = ctx.getBean(InterviewService.class);
        service.conductInterview(new Student());
    }
}
