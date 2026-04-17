package com.akhan.quiz.quizapp.DTO;

import java.util.List;

public class QuizResponse {

    private int overallGrade;
    private List<TopicResult> topicWiseResults;

    public static class TopicResult {

        private String topicName;
        private int percentage;

        public TopicResult(String topicName, int percentage) {
            this.topicName = topicName;
            this.percentage = percentage;
        }

        public String getTopicName() {
            return topicName;
        }

        public void setTopicName(String topicName) {
            this.topicName = topicName;
        }

        public int getPercentage() {
            return percentage;
        }

        public void setPercentage(int percentage) {
            this.percentage = percentage;
        }
    }

    public int getOverallGrade() {
        return overallGrade;
    }

    public void setOverallGrade(int overallGrade) {
        this.overallGrade = overallGrade;
    }

    public List<TopicResult> getTopicWiseResults() {
        return topicWiseResults;
    }

    public void setTopicWiseResults(List<TopicResult> topicWiseResults) {
        this.topicWiseResults = topicWiseResults;
    }
}
