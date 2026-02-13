import java.util.Scanner;

public class OnlineQuiz {


    public static int startQuiz(Scanner sc) {

        String[] questions = {
                "1. Which language is platform independent?",
                "2. Which keyword is used to inherit a class in Java?",
                "3. Which loop executes at least once?",
                "4. Size of int in Java?",
                "5. Which method is entry point of Java program?"
        };

        String[][] options = {
                {"A. C", "B. C++", "C. Java", "D. Assembly"},
                {"A. implements", "B. extends", "C. inherit", "D. super"},
                {"A. for", "B. while", "C. do-while", "D. foreach"},
                {"A. 2 bytes", "B. 4 bytes", "C. 8 bytes", "D. 1 byte"},
                {"A. start()", "B. run()", "C. main()", "D. init()"}
        };

        char[] answers = {'C', 'B', 'C', 'B', 'C'};

        int score = 0;

        for (int i = 0; i < questions.length; i++) {

            System.out.println("\n-----------------------------------");
            System.out.println(questions[i]);

            for (int j = 0; j < 4; j++) {
                System.out.println(options[i][j]);
            }

            System.out.print("Enter your answer (A/B/C/D): ");
            char userAnswer = sc.next().toUpperCase().charAt(0);

            if (userAnswer == answers[i]) {
                System.out.println("Correct Answer");
                score++;
            } else {
                System.out.println("Wrong Answer");
                System.out.println("Correct Answer is:" + answers[i]);
            }
        }
        return score;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("      ONLINE QUIZ APPLICATION      ");
        System.out.println("===================================");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("\nWelcome " + name + "!");
        System.out.println("\nInstructions:");
        System.out.println("1. There are total 5 Questions");
        System.out.println("2. For each correct answer you will be getting  = 1 mark");
        System.out.println("3. There is no negative marking");
        System.out.println("4. Enter only A, B, C or D");

        System.out.println("\nQuiz starting in...");
        for (int i = 5; i >= 1; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error in timer.");
            }
        }

        int score = startQuiz(sc);

        System.out.println("\n===================================");
        System.out.println("              RESULT               ");
        System.out.println("===================================");

        System.out.println("Name: " + name);
        System.out.println("Score: " + score + "/5");

        double percentage = (score / 5.0) * 100;
        System.out.println("Percentage: " + percentage + "%");

        switch (score) {
            case 5:
            case 4:
                System.out.println("Excellent Performance !!!!!!");
                break;
            case 3:
                System.out.println("Good Job !!");
                break;
            default:
                System.out.println("Keep Practicing :-(");
        }

        System.out.print("\n Do you want to try again ?: ");
        String choice = sc.next();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.println("\nRestarting Quiz...\n");
            score = startQuiz(sc);
            System.out.println("Your New Score: " + score + "/5");
        } else {
            System.out.println("\nThank you for participating, " + name + "!");
        }

        sc.close();
    }
}
