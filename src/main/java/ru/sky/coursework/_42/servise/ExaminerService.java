package ru.sky.coursework._42.servise;


import ru.sky.coursework._42.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);

}