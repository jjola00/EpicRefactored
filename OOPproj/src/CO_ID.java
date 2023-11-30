//impports for GUI and List for CSV
import javax.swing.JOptionPane;
import java.util.List;

public class CO_ID {
    public static void main(String[] args) {
        run();//initilisation of run method
    }

    public static void run() {
        try {
            int score = 0;//score tracker
            Question questionLoader = new Question();
            List<Question.Data> qList = questionLoader.questions();

            String[] choice = {"Discrete Maths Increasing Difficulty", "Discrete Maths Random",
                    "Computer Organization Random", "Computer Science Increasing Difficulty", "Computer Science Random",
                    "Who Wants to be a Millionaire!"};

            JOptionPane.showMessageDialog(null, "Welcome to the Computer Organization Quiz", "Welcome",
                    JOptionPane.PLAIN_MESSAGE);
            //index for comp org questions in csv file
            for (int i = 7; i < 12; i++) {
                Question.Data q = qList.get(i);
                String question = q.getQuestion();
                String[] options = q.getOptions();
                String correctAnswer = q.getCorrectAnswer();

                // Handle NullPointerException if the user cancels the input dialog
                String userAnswer = (String) JOptionPane.showInputDialog(null, question, "Question " + (i + 1),
                        JOptionPane.PLAIN_MESSAGE, null, options, null);

                if (userAnswer == null) {//handle exception if user closes program
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

            String next = (String) JOptionPane.showInputDialog(null, null, "Would you like to Play the next Quiz",
                    JOptionPane.PLAIN_MESSAGE, null, choice, null);

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
                CO_RD.run();
            } else if (next.equals(choice[3])) {
                CS_ID.run();
            } else if (next.equals(choice[4])) {
                CS_RD.run();
            } else if (next.equals(choice[5])) {
                QUIZTHREE.run();
            }
        } catch (Exception e) {
            // Handle  unexpected exceptions
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An unexpected error occurred. Exiting...", "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
}
