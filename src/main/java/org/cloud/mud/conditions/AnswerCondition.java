package org.cloud.mud.conditions;

public class AnswerCondition implements ICondition {
    private String answer;

    public AnswerCondition(String answer) {
        this.answer = answer;
    }

    public AnswerCondition(int answer) {
        this.answer = String.valueOf(answer);
    }

    @Override
    public boolean isCompleted(String answer) {
        return this.answer.equals(answer);
    }
}
