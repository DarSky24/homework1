package ru.otus.hm1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.hm1.domain.Interview;
import ru.otus.hm1.domain.Student;
import ru.otus.hm1.service.InterviewService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {//
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring-context.xml");
        InterviewService service = ctx.getBean(InterviewService.class);
        try {
            List<Interview> questions = service.getQuestions();
            List<Integer> rightAnswers = new ArrayList<>();
            List<Integer> studentsAnswers = new ArrayList<>();
            Student student = new Student();
            int answer;
            Scanner in = new Scanner(System.in);
            System.out.println("Введите имя:");
            String input = in.nextLine();
            student.setName(input);
            System.out.println("Введите фамилию:");
            input = in.nextLine();
            student.setSurname(input);
            for (Interview question : questions) {
                System.out.println(question);
                answer = in.nextInt();
                studentsAnswers.add(answer);
                rightAnswers.add(question.getRightNumber());
            }
            student.setResult(service.checkAnswers(studentsAnswers, rightAnswers));
            System.out.println(student);
        } catch (Exception e) {
            System.out.println("Проблема с получением списка вопросов!");
        }
    }
}
