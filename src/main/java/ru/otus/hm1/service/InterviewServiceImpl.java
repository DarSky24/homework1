package ru.otus.hm1.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.hm1.dao.InterviewDao;
import ru.otus.hm1.domain.Interview;
import ru.otus.hm1.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.System.lineSeparator;

@Service
public class InterviewServiceImpl implements InterviewService {

    private InterviewDao dao;
    private MessageSource ms;

    public InterviewServiceImpl(InterviewDao dao, MessageSource ms) {
        this.dao = dao;
        this.ms = ms;
    }

    private static int checkAnswers(List<Integer> studentsAnswers, List<Integer> rightAnswers) {
        int result = 0;
        for (int i = 0; i < studentsAnswers.size(); i++) {
            if (rightAnswers.get(i).equals(studentsAnswers.get(i))) {
                result++;
            }
        }
        return result;
    }

    private void printQuestion(Interview question) {
        System.out.println(ms.getMessage("interview.number", null, Locale.getDefault()) + question.getNumber()
                + ":" + lineSeparator() + question.getQuestion() + lineSeparator()
                + ms.getMessage("interview.answers", null, Locale.getDefault()) + lineSeparator() + "1. "
                + question.getAnswers().get(0) + lineSeparator()
                + "2. " + question.getAnswers().get(1) + lineSeparator()
                + "3. " + question.getAnswers().get(2) + lineSeparator()
                + ms.getMessage("interview.enter", null, Locale.getDefault()));
    }

    private void printResult(Student student) {
        System.out.println(ms.getMessage("student.name", null, Locale.getDefault()) + student.getName() + " "
                + student.getSurname()
                + ", " + ms.getMessage("student.result1", null, Locale.getDefault()) + student.getResult() + " "
                + ms.getMessage("student.result2", null, Locale.getDefault()));
    }

    @Override
    public List<Interview> getQuestions() throws Exception {
        return dao.readQuestionsFromSource();
    }

    @Override
    public void conductInterview(Student student) {
        try {
            List<Interview> questions = this.getQuestions();
            List<Integer> rightAnswers = new ArrayList<>();
            List<Integer> studentsAnswers = new ArrayList<>();
            int answer;
            Scanner in = new Scanner(System.in);
            System.out.println(ms.getMessage("enter.name", null, Locale.getDefault()));
            String input = in.nextLine();
            student.setName(input);
            System.out.println(ms.getMessage("enter.surname", null, Locale.getDefault()));
            input = in.nextLine();
            student.setSurname(input);
            for (Interview question : questions) {
                printQuestion(question);
                answer = in.nextInt();
                studentsAnswers.add(answer);
                rightAnswers.add(question.getRightNumber());
            }
            student.setResult(checkAnswers(studentsAnswers, rightAnswers));
            printResult(student);
        } catch (Exception e) {
            System.out.println(ms.getMessage("exp.message", null, Locale.getDefault()));
        }
    }


}
