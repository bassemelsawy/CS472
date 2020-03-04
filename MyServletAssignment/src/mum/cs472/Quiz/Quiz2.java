package mum.cs472.Quiz;

import java.util.Arrays;
import java.util.List;

public class Quiz2 {
    private final List<String> questions;
    private final List<Integer> answers;
    private int questionNumber = 0;
    private int correct = 0;
    private int att = 0;
    private int age = 0;

    public Quiz2() {
        questions = Arrays.asList("3, 1, 4, 1, 5", "1, 1, 2, 3, 5"
                , "1, 4, 9, 16, 25", "2, 3, 5, 7, 11", "1,2,4,8,16");
        answers = Arrays.asList(9, 8, 36, 13, 32);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    private String getQuestion(int n) {
        return questions.get(n);
    }

    public void putAnswer(int ans) {
        if (ans == answers.get(questionNumber)) {
            if (att == 0)
                correct += 10;
            else if (att == 1)
                correct += 5;
            else if (att == 2)
                correct += 2;
            att = 0;
            questionNumber++;
        } else
            att++;

        if (att > 2) {
            att = 0;
            questionNumber++;
        }
    }

    public int getCorrectAnswers() {
        return correct;
    }

    public boolean isGameFinished() {
        return questionNumber == questions.size();
    }

    public String next() {
        if (isGameFinished())
            return "";
        return getQuestion(questionNumber);
    }

    public int getCountOfQuestions() {
        return 50;
    }

}