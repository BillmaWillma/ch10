import java.util.Random;
import java.util.Scanner;

public class FractionQuiz {
    public static void main(String[] args) {
        System.out.println(
            "Let the Fraction Quiz Begin. Answers should be in lowest terms. Good luck!");
        System.out.println();
        int correct = 0;
        int total = 0;
        String[] operations = {"*", "/", "+", "-"};
        Scanner in = new Scanner(System.in);
        Random r = new Random();
        for (;;) {
            total++;
            Fractions a = new Fractions();
            Fractions b = new Fractions();
            String pick = operations[r.nextInt(4)];
            for(;;){
            if (pick.equals("-")&&a.toDouble() <= b.toDouble()){
				a = new Fractions();
				b = new Fractions();
			} else break;
		}
            System.out.print(a + " " + pick + " " + b + " = ");
            String attempt = in.nextLine();
            if (attempt.equals("quit")) {
				total--;
                Fractions result = new Fractions(correct, total);
                System.out.println("You answered " + result + " correctly, for a score of "
                    + result.toDouble() * 100 + " percent!");
                break;
            } else{
            Fractions att = new Fractions(attempt);
            Fractions ans = new Fractions(1, 1);
            if (pick.equals("+")) {
                ans = Fractions.add(a, b);
            } else if (pick.equals("-")) {
                ans = Fractions.min(a, b);
            } else if (pick.equals("*")) {
                ans = Fractions.mult(a, b);
            } else if (pick.equals("/")) {
                ans = Fractions.div(a, b);
            }
            if (Fractions.compare(att, ans)) {
                correct++;
                System.out.println("Correct!");

            } else
                System.out.println("Wrong, the answer is " + ans);
                             System.out.println();
        }
	}
    }
}
