import javax.swing.JOptionPane;
import java.util.List;

public class QUIZTHREE {

    public static void main(String[] args) {
            run();
    }
    public static void run(){
        try{
            long j = 0;
            long money = j * 50000;

            Question questionLoader = new Question();
            List<Question.Data> qList = questionLoader.questions();

            String[] Decision = { "Congratulations! Would you like to walk away, or take a risk." };
            String[] Choice = { "Walk away", "Continue" };
            String[] choice = { "Discrete Maths Increasing Difficulty", "Discrete Maths Random",
                    "Computer Organization Increasing Difficulty", "Computer Organization Random",
                    "Computer Science Increasing Difficulty", "computer Science Random" };

            JOptionPane.showMessageDialog(null, "Welcome to Who Wants to be a Millionaire: ISE Edition", "Welcome",
                    JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(null,
                    "*There are 20 questions.\n*If you answer all 20 questions, you win $1,000,000!\n*If you get one question wrong, however, you lose all the money.\n*After every 5 questions, you have the option to walk away with the money or continue.\n*Good Luck!",
                    "Rules!", JOptionPane.PLAIN_MESSAGE);

            for (int i = 0; i < qList.size(); i++) {
                Question.Data q = qList.get(i);
                String question = q.getQuestion();
                String[] options = q.getOptions();
                String correctAnswer = q.getCorrectAnswer();
                String userAnswer = (String) JOptionPane.showInputDialog(null, question, "Question " + (i + 1) + ": You have $" + money,
                        JOptionPane.PLAIN_MESSAGE, null, options, null);

                if (userAnswer == null) {
                    JOptionPane.showMessageDialog(null, "Quiz canceled. Exiting...", "Canceled",
                            JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
                if (i == 4 || i == 9 || i == 14) {
                    String decision = JOptionPane.showInputDialog(null, Decision,
                            "Total winnings: $" + money,
                            JOptionPane.PLAIN_MESSAGE, null, Choice, null).toString();
                    if (decision.equals(Choice[0])) {
                        JOptionPane.showMessageDialog(null, "Well Done! You won $ "
                                        + money + " out of $1,000,000",
                                "Congratulations!", JOptionPane.PLAIN_MESSAGE);
                        break;
                    }
                }

                if (userAnswer.equals(correctAnswer)) {
                    j++;
                    money = j * 50000;
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect! You lost $ " + money + " out of $1,000,000",
                            "Game Over", JOptionPane.PLAIN_MESSAGE);
                    break;
                }

                if (userAnswer.equals(qList.get(19).getCorrectAnswer())) {
                    JOptionPane.showMessageDialog(null, "Congratulations! You won $ " + money
                                    + " and have completed Who Wants to be a Millionaire: ISE Edition.", "Game Over",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }

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
                CO_RD.run();
            } else if (next.equals(choice[4])) {
                CS_ID.run();
            } else if (next.equals(choice[5])) {
                CS_RD.run();
            }
        }catch (Exception e) {
            // Handle  unexpected exceptions
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An unexpected error occurred. Exiting...", "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
}