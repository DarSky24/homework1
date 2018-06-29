package ru.otus.hm1.dao;

import ru.otus.hm1.domain.Interview;

import java.util.List;

public interface InterviewDao {

    List<Interview> readQuestionsFromSource() throws Exception;
}
