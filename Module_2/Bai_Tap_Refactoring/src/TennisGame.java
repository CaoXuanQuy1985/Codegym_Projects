import java.lang.Math;

public class TennisGame {
    private static final String[] DEFAULTS = new String[] {"Love", "Fifteen", "Thirty", "Forty"};
    private static final String WIN = "Win for #player";
    private static final String ADVANTAGE = "Advantage #player";
    private static final String DEUCE = "Deuce";
    private static final String ALL = "All";

    private static String deuce(int player1Score) {
        if (player1Score <= 3)
            return DEFAULTS[player1Score] + "-" + ALL;
        return DEUCE;
    }

    private static String win(String player1Name, String player2Name, int player1Score, int player2Score) {
        if (player1Score > player2Score)
            return WIN.replace("#player", "player1");
        return WIN.replace("#player", "player2");
    }

    private static String tie(String player1Name, String player2Name, int player1Score, int player2Score) {
        if (player1Score > player2Score)
            return ADVANTAGE.replace("#player", "player1");
        return ADVANTAGE.replace("#player", "player2");
    }

    private static String winOrTie(String player1Name, String player2Name, int player1Score, int player2Score) {
        if (Math.abs(player1Score - player2Score) >= 2)
            return win(player1Name, player2Name, player1Score, player2Score);
        return tie(player1Name, player2Name, player1Score, player2Score);
    }

    private static String defaultScore(int player1Score, int player2Score) {
        return DEFAULTS[player1Score] + "-" + DEFAULTS[player2Score];
    }

    public static String calculate(String player1Name, String player2Name, int player1Score, int player2Score) {
        String score = "";
        if (player1Score == player2Score) {
            score = deuce(player1Score);
        }
        else if ((player1Score >= 4) || (player2Score >= 4)) {
            score = winOrTie(player1Name, player2Name, player1Score, player2Score);
        }
        else {
            score = defaultScore(player1Score, player2Score);
        }
        return score;
    }
}
