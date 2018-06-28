package ru.otus.hm1.service;

import ru.otus.hm1.domain.Interview;

import java.util.List;

public interface InterviewService {

    List<Interview> getQuestions() throws Exception;

    int checkAnswers(List<Integer> studentsAnswers, List<Integer> rightAnswers);

}
