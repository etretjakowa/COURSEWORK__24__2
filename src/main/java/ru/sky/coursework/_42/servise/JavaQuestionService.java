package ru.sky.coursework._42.servise;

import org.springframework.stereotype.Service;
import ru.sky.coursework._42.Question;
import ru.sky.coursework._42.exception.QuestionExistsException;
import ru.sky.coursework._42.exception.QuestionNotFoundException;


import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();
    private int questionNumber;
    private Random random = new Random();

    @Override
    public Question add(String question, String answer) {

        Question newQuestion = new Question(question, answer);
        if (questions.contains(newQuestion)) {
            throw new QuestionExistsException();
        }
        questions.add(newQuestion);
        questionNumber++;
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionExistsException();
        }
        questions.add(question);
        questionNumber++;
        return question;
    }

    @Override
    public Question find(Question question) {
        if (questions.contains(question)) {
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Question remove(Question question) {
        if (questions.contains(question)) {
            questions.remove(question);
            questionNumber--;
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Set<Question> getAll() {
        return Set.copyOf(questions);
    }

    @Override
    public Question getRandomQuestion() {

        int randomNumber = random.nextInt(questionNumber);
        List<Question> questionList = new ArrayList<>(questions);
        return questionList.get(randomNumber);
    }

}
