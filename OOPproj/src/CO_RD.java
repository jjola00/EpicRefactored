import javax.swing.JOptionPane;
import java.util.Collections;
import java.util.List;

public class CO_RD {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        try {
            int score = 0;
            Question ques = new Question();
            List<Question.Data> qList = ques.questions();
            List<Question.Data> subList = qList.subList(7, 12);

            // Shuffle the questions before entering the loop
            Collections.shuffle(subList);

            String[] choice = { "Discrete Maths Increasing Difficulty", "Discrete Maths Random",
                    "Computer Organization Increasing Difficulty", "Computer Science Increasing Difficulty",
                    "Computer Science Random", "Who Wants to be a Millionaire!" };

            JOptionPane.showMessageDialog(null, "Welcome to the Computer Organization Quiz", "Welcome",
                    JOptionPane.PLAIN_MESSAGE);

            for (int i = 0; i < subList.size(); i++) {
                Question.Data q = subList.get(i);
                String question = q.getQuestion();
                String[] options = q.getOptions();
                String correctAnswer = q.getCorrectAnswer();

                // Check if userAnswer is null before calling .equals()
                String userAnswer = (String) JOptionPane.showInputDialog(null, question, "Question " + (i + 1),
                        JOptionPane.PLAIN_MESSAGE, null, options, null);

                if (userAnswer == null) {
                    JOptionPane.showMessageDialog(null, "Quiz canceled. Exiting...", "Canceled",
                            JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
                if (userAnswer.equals(correctAnswer)) {
                    score += 1;
                }
            }
            JOptionPane.showMessageDialog(null, "Congratulations! You scored  " + score + " out of 6", null,
                    JOptionPane.PLAIN_MESSAGE);
            String next = JOptionPane.showInputDialog(null, null, "Would you like to Play the next Quiz",
                    JOptionPane.PLAIN_MESSAGE, null, choice, null).toString();

            if (next == null) {
                JOptionPane.showMessageDialog(null, "Quiz selection canceled. Exiting...", "Canceled",
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

            if (next.equals(choice[0])) {
                DM_ID.run();
            } else if (next.equals(choice[1])) {
                DM_RD.run();
            } else if (next.equals(choice[2])) {
                CO_ID.run();
            } else if (next.equals(choice[3])) {
                CS_ID.run();
            } else if (next.equals(choice[4])) {
                CS_RD.run();
            } else if (next.equals(choice[5])) {
                QUIZTHREE.run();
            }
        } catch (Exception e) {
            // Handle unexpected exceptions
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An unexpected error occurred. Exiting...", "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
}
