import java.util.Scanner;

public class CoinTossing {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        //introductions
        System.out.println("Welcome to the Incredibly Impressive Smallest Number Picker!");
        System.out.println("Enter three numbers and I'll tell you which of them is smallest!\n");

        //let's get going
        double result = start();

        //got results? proceed...
        String response = proceed(result);

        //while user keeps saying "y", keep up the same as above
        while(response.equalsIgnoreCase("y")) {
            result = start();
            response = proceed(result);
        } // let's just assume anything that's not a "y" is a negative response this time

        sayGoodbye();
    }

    public static double start() {
        // go get the numbers
        double[] allNumbers = collectNumbers();

        //math those numbers up
        double smallestNumber = minimum3(allNumbers[0], allNumbers[1], allNumbers[2]);

        //return the returned smallest number
        return smallestNumber;
    }

    public static String proceed(double result) {
        //show them the smallest number
        System.out.printf("\nThe smallest number is %f%n%n", result);

        //ask if they want to keep going
        System.out.print("Would you like to go again? (Y/N):");

        //send response back
        return input.next();
    }

    public static double[] collectNumbers() {

        //create an array with a length of 3 for our three numbers
        double[] allThree = new double[3];

        //I wasn't a fan of having to pre-initialize an array with
        //a length until I realized it means I can iterate on what is, essentially, an empty array
        for (int i = 0; i < allThree.length; ++i) {

            // get the number for your current place in the array
            System.out.printf("Enter number %d: ", i + 1);
            allThree[i] = input.nextDouble();
        }
        //send the array back
        return allThree;
    }

    public static double minimum3(double num1, double num2, double num3) {

        //find the minimums of each pair of numbers
        double minimumOne = Math.min(num1, num2);
        double minimumTwo = Math.min(num2, num3);

        double minimumThree = 0;

        if (minimumOne != minimumTwo) {
            //if each of the above minimums is not the same, compare them again
            minimumThree = Math.min(minimumOne, minimumTwo);
        } else {
            //else, we have a winner
            minimumThree = minimumOne;
        }

        return minimumThree;
    }

    public static void sayGoodbye() {
        System.out.println("Okay! Have a great day!\n\n");
    }
}
