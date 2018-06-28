package ru.otus.hm1.service;

import ru.otus.hm1.dao.InterviewDao;
import ru.otus.hm1.domain.Interview;

import java.util.List;

public class InterviewServiceImpl implements InterviewService{

private InterviewDao dao;

    public InterviewServiceImpl(InterviewDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Interview> getQuestions() throws Exception{
        return dao.readQuestionsFromSource();
    }

    @Override
    public int checkAnswers(List<Integer> studentsAnswers, List<Integer> rightAnswers) {
        int result = 0;
        for (int i = 0; i < studentsAnswers.size(); i++){
            if (rightAnswers.get(i).equals(studentsAnswers.get(i))){
                result++;
            }
        }
        return result;
    }


}
