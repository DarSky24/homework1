package ru.otus.hm1.service;

import ru.otus.hm1.dao.InterviewDao;
import ru.otus.hm1.domain.Interview;
import ru.otus.hm1.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterviewServiceImpl implements InterviewService {

    private InterviewDao dao;

    public InterviewServiceImpl(InterviewDao dao) {
        this.dao = dao;
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
            student.setResult(checkAnswers(studentsAnswers, rightAnswers));
            System.out.println(student);
        } catch (Exception e) {
            System.out.println("Проблема с получением списка вопросов!");
        }
    }


}
