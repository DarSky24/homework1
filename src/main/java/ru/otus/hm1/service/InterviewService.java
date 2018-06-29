package ru.otus.hm1.service;

import ru.otus.hm1.domain.Interview;
import ru.otus.hm1.domain.Student;

import java.util.List;

public interface InterviewService {

    List<Interview> getQuestions() throws Exception;

    void conductInterview(Student student);

}
