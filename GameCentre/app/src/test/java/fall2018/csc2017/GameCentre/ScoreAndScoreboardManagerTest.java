package fall2018.csc2017.GameCentre;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import fall2018.csc2017.GameCentre.DataManagers.Score;
import fall2018.csc2017.GameCentre.DataManagers.ScoreboardManager;
import fall2018.csc2017.GameCentre.DataManagers.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ScoreAndScoreboardManagerTest {

    /**
     * Local variables to be re-used for testing.
     */
    private ScoreboardManager lowToHighScoreboardManager = new ScoreboardManager(false);
    private ScoreboardManager highToLowScoreboardManager = new ScoreboardManager(true);
    private User tempUser = new User("temp", "123");


    /**
     * Creates a list of scores of a particular difficulty, where each value is different,
     * in a predicatable manner, for sorting checking.
     *
     * @param difficulty The difficulty of the scores.
     * @param numScores  The number of scores to create,
     * @return The list of scores generated requirements.
     */
    private List<Score> createSomeScores(String gameType, String difficulty, int numScores) {
        List<Score> created = new ArrayList<>();
        int i = 0;
        while (i != numScores) {
            Score tempScore;
            int scoreValue;
            // even indices get a score of 20
            if (i % 2 == 0) {
                scoreValue = 20;

            } else {
                scoreValue = 5 * i;
            }
            tempScore = new Score(tempUser, gameType, difficulty, scoreValue);
            created.add(tempScore);
            i += 1;
        }
        return created;
    }

    /**
     * Makes a scoreboard with various scores for testing purposes.
     */
    private void setUpScores() {
        // So it'll create 20 total easy scores, 10 with 20, 4 with <=, 7 with increasingly >.
        List<Score> easyScoresLowToHigh = createSomeScores("SlidingTiles", "Easy", 20);
        // Create 6 medium scores, 3 with 20, 4 with <=.
        List<Score> mediumScoresLowToHigh = createSomeScores("SlidingTiles", "Medium", 6);
        // Create 15 hard scores, 7 with 20, 4 with <=, 4 with >.
        List<Score> hardScoresLowToHigh = createSomeScores("SlidingTiles", "Hard", 15);
        //Same as above.
        List<Score> easyScoresHighToLow = createSomeScores("Minesweeper", "Easy", 20);
        List<Score> mediumScoresHighToLow = createSomeScores("Minesweeper", "Medium", 6);
        List<Score> hardScoresHighToLow = createSomeScores("Minesweeper", "Hard", 15);
        for (Score easyScore : easyScoresLowToHigh) {
            lowToHighScoreboardManager.addScore(easyScore);
        }
        for (Score mediumScore : mediumScoresLowToHigh) {
            lowToHighScoreboardManager.addScore(mediumScore);
        }
        for (Score hardScore : hardScoresLowToHigh) {
            lowToHighScoreboardManager.addScore(hardScore);
        }

        for (Score easyScore : easyScoresHighToLow) {
            highToLowScoreboardManager.addScore(easyScore);
        }

        for (Score mediumScore : mediumScoresHighToLow) {
            highToLowScoreboardManager.addScore(mediumScore);
        }

        for (Score hardScore : hardScoresHighToLow) {
            highToLowScoreboardManager.addScore(hardScore);
        }
    }

    /**
     * Test whether adding a score adds the score to the correct list.
     */
    @Test
    public void testAddScore() {
        Score easyScore = new Score(tempUser, "SlidingTiles", "Easy", 30);
        Score mediumScore = new Score(tempUser, "SlidingTiles", "Medium", 30);
        Score hardScore = new Score(tempUser, "SlidingTiles", "Hard", 30);

        lowToHighScoreboardManager.addScore(easyScore);
        lowToHighScoreboardManager.addScore(mediumScore);
        lowToHighScoreboardManager.addScore(hardScore);

        List<Score> correctEasyScores = new ArrayList<>();
        correctEasyScores.add(easyScore);
        List<Score> correctMediumScores = new ArrayList<>();
        correctMediumScores.add(mediumScore);
        List<Score> correctHardScores = new ArrayList<>();
        correctHardScores.add(hardScore);

        assertEquals(correctEasyScores, lowToHighScoreboardManager.getEasyScores());
        assertEquals(correctMediumScores, lowToHighScoreboardManager.getMediumScores());
        assertEquals(correctHardScores, lowToHighScoreboardManager.getHardScores());
    }

    /**
     * Test whether you can get the top scores, as defined by local var SHOWLIMIT, of a particular difficulty and game.
     */
    @Test
    public void testGetScoresByTopDifficulty() {
        setUpScores();
        List<Score> easyLowToHighs = lowToHighScoreboardManager.getTopScoresByDifficulty("Easy");
        List<Score> mediumLowToHighs = lowToHighScoreboardManager.getTopScoresByDifficulty("Medium");
        List<Score> hardLowToHighs = lowToHighScoreboardManager.getTopScoresByDifficulty("Hard");
        List<Score> easyHighToLows = highToLowScoreboardManager.getTopScoresByDifficulty("Easy");
        List<Score> mediumHighToLows = highToLowScoreboardManager.getTopScoresByDifficulty("Medium");
        List<Score> hardHighToLows = highToLowScoreboardManager.getTopScoresByDifficulty("Hard");
        // Test case where scores or ordered from low to high(IE SlidingTiles wheres scores are better
        // if you have less clicks, and that only the best 10 are shown.
        boolean isCorrectEasyLowToHighs = true;
        boolean isCorrectMediumLowToHighs = true;
        boolean isCorrectHardLowToHighs = true;
        boolean isCorrectEasyHighToLows = true;
        boolean isCorrectMediumHighToLows = true;
        boolean isCorrectHardHighToLows = true;
        // Goes to the second last index.
        for (int i = 0; i != easyLowToHighs.size() - 2; i++) {
            // if any of the scores are not in order.
            Score before = easyLowToHighs.get(i);
            Score after = easyLowToHighs.get(i + 1);
            if (before.compareTo(after) >= 1) {
                isCorrectEasyLowToHighs = false;
                break;
            }
        }
        for (int i = 0; i != easyLowToHighs.size() - 2; i++) {
            // if any of the scores are not in order.
            Score before = easyLowToHighs.get(i);
            Score after = easyLowToHighs.get(i + 1);
            if (before.compareTo(after) >= 1) {
                isCorrectEasyLowToHighs = false;
                break;
            }
        }
        for (int i = 0; i != mediumLowToHighs.size() - 2; i++) {
            // if any of the scores are not in order.
            Score before = mediumLowToHighs.get(i);
            Score after = mediumLowToHighs.get(i + 1);
            if (before.compareTo(after) >= 1) {
                isCorrectMediumLowToHighs = false;
                break;
            }
        }
        for (int i = 0; i != hardLowToHighs.size() - 2; i++) {
            // if any of the scores are not in order.
            Score before = hardLowToHighs.get(i);
            Score after = hardLowToHighs.get(i + 1);
            if (before.compareTo(after) >= 1) {
                isCorrectHardLowToHighs = false;
                break;
            }
        }
        for (int i = 0; i != easyHighToLows.size() - 2; i++) {
            // if any of the scores are not in order.
            Score before = easyHighToLows.get(i);
            Score after = easyHighToLows.get(i + 1);
            if (before.compareTo(after) <= -1) {
                isCorrectEasyHighToLows = false;
                break;
            }
        }
        for (int i = 0; i != mediumHighToLows.size() - 2; i++) {
            // if any of the scores are not in order.
            Score before = mediumHighToLows.get(i);
            Score after = mediumHighToLows.get(i + 1);
            if (before.compareTo(after) <= -1) {
                isCorrectMediumHighToLows = false;
                break;
            }
        }
        for (int i = 0; i != hardHighToLows.size() - 2; i++) {
            // if any of the scores are not in order.
            Score before = hardHighToLows.get(i);
            Score after = hardHighToLows.get(i + 1);
            if (before.compareTo(after) <= -1) {
                isCorrectHardHighToLows = false;
                break;
            }
        }
        assertTrue(isCorrectEasyLowToHighs);
        assertTrue(isCorrectMediumLowToHighs);
        assertTrue(isCorrectHardLowToHighs);
        assertTrue(isCorrectEasyHighToLows);
        assertTrue(isCorrectMediumHighToLows);
        assertTrue(isCorrectHardHighToLows);
    }

    /**
     * Tests that we can correctly get the top scores(within the show limit) of a particular user,
     * game, and for game sorted from either high to low scores or low to high.ss
     */
    @Test
    public void testGetTopScoresByUser() {
        setUpScores();
        List<Score> easyLowToHighs = lowToHighScoreboardManager.getTopScoresByUser(tempUser, "Easy");
        List<Score> mediumLowToHighs = lowToHighScoreboardManager.getTopScoresByUser(tempUser, "Medium");
        List<Score> hardLowToHighs = lowToHighScoreboardManager.getTopScoresByUser(tempUser, "Hard");
        List<Score> easyHighToLows = highToLowScoreboardManager.getTopScoresByUser(tempUser, "Easy");
        List<Score> mediumHighToLows = highToLowScoreboardManager.getTopScoresByUser(tempUser, "Medium");
        List<Score> hardHighToLows = highToLowScoreboardManager.getTopScoresByUser(tempUser, "Hard");

        boolean isCorrectEasyLowToHighs = true;
        boolean isCorrectMediumLowToHighs = true;
        boolean isCorrectHardLowToHighs = true;
        boolean isCorrectEasyHighToLows = true;
        boolean isCorrectMediumHighToLows = true;
        boolean isCorrectHardHighToLows = true;

        for (int i = 0; i != easyLowToHighs.size() - 2; i++) {
            // if any of the scores are not in order.
            Score before = easyLowToHighs.get(i);
            Score after = easyLowToHighs.get(i + 1);
            if (before.compareTo(after) >= 1 && before.getUser() == tempUser && after.getUser() == tempUser) {
                isCorrectEasyLowToHighs = false;
                break;
            }
        }
        for (int i = 0; i != easyLowToHighs.size() - 2; i++) {
            // if any of the scores are not in order.
            Score before = easyLowToHighs.get(i);
            Score after = easyLowToHighs.get(i + 1);
            if (before.compareTo(after) >= 1 && before.getUser() == tempUser && after.getUser() == tempUser) {
                isCorrectEasyLowToHighs = false;
                break;
            }
        }
        for (int i = 0; i != mediumLowToHighs.size() - 2; i++) {
            // if any of the scores are not in order.
            Score before = mediumLowToHighs.get(i);
            Score after = mediumLowToHighs.get(i + 1);
            if (before.compareTo(after) >= 1 && before.getUser() == tempUser && after.getUser() == tempUser) {
                isCorrectMediumLowToHighs = false;
                break;
            }
        }
        for (int i = 0; i != hardLowToHighs.size() - 2; i++) {
            // if any of the scores are not in order.
            Score before = hardLowToHighs.get(i);
            Score after = hardLowToHighs.get(i + 1);
            if (before.compareTo(after) >= 1 && before.getUser() == tempUser && after.getUser() == tempUser) {
                isCorrectHardLowToHighs = false;
                break;
            }
        }
        for (int i = 0; i != easyHighToLows.size() - 2; i++) {
            // if any of the scores are not in order.
            Score before = easyHighToLows.get(i);
            Score after = easyHighToLows.get(i + 1);
            if (before.compareTo(after) <= -1 && before.getUser() == tempUser && after.getUser() == tempUser) {
                isCorrectEasyHighToLows = false;
                break;
            }
        }
        for (int i = 0; i != mediumHighToLows.size() - 2; i++) {
            // if any of the scores are not in order.
            Score before = mediumHighToLows.get(i);
            Score after = mediumHighToLows.get(i + 1);
            if (before.compareTo(after) <= -1 && before.getUser() == tempUser && after.getUser() == tempUser) {
                isCorrectMediumHighToLows = false;
                break;
            }
        }
        for (int i = 0; i != hardHighToLows.size() - 2; i++) {
            // if any of the scores are not in order.
            Score before = hardHighToLows.get(i);
            Score after = hardHighToLows.get(i + 1);
            if (before.compareTo(after) <= -1 && before.getUser() == tempUser && after.getUser() == tempUser) {
                isCorrectHardHighToLows = false;
                break;
            }
        }

        assertTrue(isCorrectEasyLowToHighs);
        assertTrue(isCorrectMediumLowToHighs);
        assertTrue(isCorrectHardLowToHighs);
        assertTrue(isCorrectEasyHighToLows);
        assertTrue(isCorrectMediumHighToLows);
        assertTrue(isCorrectHardHighToLows);

    }

    /**
     * Tests that getting the scores from the scoreboard manager for a particular difficulty
     * works.
     */
    @Test
    public void testGetters(){
        setUpScores();
        assertEquals(createSomeScores("SlidingTiles", "Easy", 20),
                lowToHighScoreboardManager.getEasyScores());
        assertEquals(createSomeScores("SlidingTiles", "Medium", 6),
                lowToHighScoreboardManager.getMediumScores());
        assertEquals(createSomeScores("SlidingTiles", "Hard", 15),
                lowToHighScoreboardManager.getHardScores());
        assertEquals(createSomeScores("Minesweeper", "Easy", 20),
                highToLowScoreboardManager.getEasyScores());
        assertEquals(createSomeScores("Minesweeper", "Medium", 6),
                highToLowScoreboardManager.getMediumScores());
        assertEquals(createSomeScores("Minesweeper", "Hard", 15),
                highToLowScoreboardManager.getHardScores());
        assertEquals(10, ScoreboardManager.getSHOWLIMIT());
    }

    /**
     * Tests that we can correctly convert a tile into a string.
     */
    @Test
    public void testScoreToString(){
        Score score = new Score(tempUser, "SlidingTiles", "Easy", 30);
        assertEquals("Score{value=30}", score.toString());
    }
}

