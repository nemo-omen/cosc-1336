public class CoinTossing {
    public static void main(String[] args) {
        //instantiate a Coin
        Coin silverDollar = new Coin();

        //ask the user to choose heads or tails
        System.out.print("You look like someone who enjoys a game of chance.");
        System.out.println("\nCall it!");
        System.out.println("\nHeads   (1):");
        System.out.println("\nTails   (2):");
        System.out.println("\nQuit    (3):");
        String flipResult = silverDollar.flip();
        System.out.println("\n" + flipResult);
    }
}


// let's play with a simple class!
// I defined Side globally because
class Coin {
// these are the sides our flipped coin can have
    enum Side {
        HEADS, TAILS
    }
    String flip() {
        double randomResult = Math.random();
        //since Math.random() will return a random float between 0.0 and 1.0
        // we can probably just say that any return with a value greater than 0.5
        // shall constitute "HEADS", below 0.5 is "TAILS"
        Side coinSide;
        if (randomResult > 0.5) {
            coinSide = Side.HEADS;
        } else {
            coinSide = Side.TAILS;
        }
        //parsing value of Side enum so it can be defined as a member of this Coin class
        // rather than moving it into global scope
        return coinSide.toString().toLowerCase();
    }
}