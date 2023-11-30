import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Question {
    public List<Data> questions() {
        String csvFile = "src//Question.csv";
        List<Data> questionList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            // Read the header line
            br.readLine();
            while ((line = br.readLine()) != null) {
                // Split the line by commas
                String[] data = line.split(",");
                // reads columns questions, options, and correct answers
                String question = data[0];
                String[] options = new String[data.length - 2];
                System.arraycopy(data, 1, options, 0, data.length - 2);
                String correctAnswer = data[data.length - 1];

                // Create a QuestionData object and add it to the list
                Data questionData = new Data(question, options, correctAnswer);
                questionList.add(questionData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questionList;
    }

    // Represents the structure of a question
    public static class Data {
        private final String question;
        private final String[] options;
        private final String correctAnswer;

        public Data(String question, String[] options, String correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }

        public String getQuestion() {
            return question;
        }

        public String[] getOptions() {
            return options;
        }

        public String getCorrectAnswer() {
            return correctAnswer;
        }
    }
}
