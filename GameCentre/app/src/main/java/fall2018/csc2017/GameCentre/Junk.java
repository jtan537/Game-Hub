package fall2018.csc2017.GameCentre;

import android.app.Activity;
import android.view.View;
import android.widget.Button;

import fall2018.csc2017.GameCentre.MineSweeper.MineSweeperBoardManager;
import fall2018.csc2017.GameCentre.PowersPlus.PowersPlusBoardManager;
import fall2018.csc2017.GameCentre.SlidingTiles.SlidingTilesBoardManager;

public class Junk {
}

//The save button for sliding tiles
//    /**
//     * Activate the save button.
//     */
//    private void addSaveButtonListener() {
//        Button saveButton = findViewById(R.id.SaveButton);
//        saveButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                User currentUser;
//                //Get the current user's saved games from the database
//                currentUser = userManager.getUser(curUser);
//                if  (slidingTilesBoardManager == null || slidingTilesBoardManager.getClicks() == -1){
//                    makeToastSavedErrorText();
//                }else if(slidingTilesBoardManager.gameOver()){
//                    makeToastSavedErrorGameOverText();
//                }
//                else {
//                    SavedGamesManager<SlidingTilesBoardManager> curSavedGames = currentUser.userSavedGames.get("SlidingTiles");
//                    if (GameHubActivity.difficulty.equals("Easy")) {
//                        curSavedGames.setEasySave(slidingTilesBoardManager);
//                    } else if (GameHubActivity.difficulty.equals("Medium")) {
//                        curSavedGames.setMediumSave(slidingTilesBoardManager);
//                    } else {
//                        curSavedGames.setHardSave(slidingTilesBoardManager);
//                    }
//                    //Put the save game into the user
//                    currentUser.userSavedGames.put("SlidingTiles", curSavedGames);
//                    //Put the updated user into the database
//                    userManager.replaceUser(currentUser);
//                    Activity host = (Activity) v.getContext();
//                    userFileManager.saveToFile(LaunchCentre.USER_SAVE_FILENAME, host, userManager);
//                    //saveUserManager(LaunchCentre.USER_SAVE_FILENAME);
//
//                    //Temporary save
//                    boardFileManager.saveToFile(TEMP_SAVE_FILENAME, host, slidingTilesBoardManager);
//                    makeToastSavedText();
//                }
//            }
//        });
//    }


//The save button for powers plus
//    /**
//     * Activate the save button.
//     */
//    private void addSaveButtonListener() {
//        Button saveButton = findViewById(R.id.SaveButton);
//        saveButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                User currentUser;
//                //Get the current user's saved games from the database
//                currentUser = userManager.getUser(curUser);
//                //Need to edit
//                if (powersPlusBoardManager == null) {
//                    makeToastSavedErrorText();
//                } else if (powersPlusBoardManager.isGameOver()) {
//                    makeToastSavedErrorGameOverText();
//                } else {
//                    SavedGamesManager<PowersPlusBoardManager> curSavedGames = currentUser.userSavedGames.get("PowersPlus");
//                    if (GameHubActivity.difficulty.equals("Easy")) {
//                        curSavedGames.setEasySave(powersPlusBoardManager);
//                    } else if (GameHubActivity.difficulty.equals("Medium")) {
//                        curSavedGames.setMediumSave(powersPlusBoardManager);
//                    } else {
//                        curSavedGames.setHardSave(powersPlusBoardManager);
//                    }
//                    //Put the save game into the user
//                    currentUser.userSavedGames.put("PowersPlus", curSavedGames);
//                    //Put the updated user into the database
//                    userManager.replaceUser(currentUser);
//                    Activity host = (Activity) v.getContext();
//                    userFileManager.saveToFile(LaunchCentre.USER_SAVE_FILENAME, host, userManager);
//                    //saveUserManager(LaunchCentre.USER_SAVE_FILENAME);
//
//                    //Temporary save
//                    boardFileManager.saveToFile(TEMP_SAVE_FILENAME, host, powersPlusBoardManager);
//                    makeToastSavedText();
//                }
//            }
//        });
//    }


//The save button for minesweeper
//    /**
//     * Activate the save button.
//     */
//    private void addSaveButtonListener() {
//        Button saveButton = findViewById(R.id.SaveButton);
//        saveButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                User currentUser;
//                //Get the current user's saved games from the database
//                currentUser = userManager.getUser(curUser);
//                //Need to edit
//                if (mineSweeperBoardManager == null || !mineSweeperBoardManager.isHasStarted()) {
//                    makeToastSavedErrorText();
//                } else if (mineSweeperBoardManager.gameOver()) {
//                    makeToastSavedErrorGameOverText();
//                } else {
//                    SavedGamesManager<MineSweeperBoardManager> curSavedGames = currentUser.userSavedGames.get("MineSweeper");
//                    if (GameHubActivity.difficulty.equals("Easy")) {
//                        curSavedGames.setEasySave(mineSweeperBoardManager);
//                    } else if (GameHubActivity.difficulty.equals("Medium")) {
//                        curSavedGames.setMediumSave(mineSweeperBoardManager);
//                    } else {
//                        curSavedGames.setHardSave(mineSweeperBoardManager);
//                    }
//                    //Put the save game into the user
//                    currentUser.userSavedGames.put("MineSweeper", curSavedGames);
//                    //Put the updated user into the database
//                    userManager.replaceUser(currentUser);
//                    Activity host = (Activity) v.getContext();
//                    userFileManager.saveToFile(LaunchCentre.USER_SAVE_FILENAME, host, userManager);
//                    //saveUserManager(LaunchCentre.USER_SAVE_FILENAME);
//
//                    //Temporary save
//                    boardFileManager.saveToFile(TEMP_SAVE_FILENAME, host, mineSweeperBoardManager);
//                    makeToastSavedText();
//                }
//            }
//        });
//    }





//    private void setDifficulty(Class gameClass){
//        gameClass.class.setDifficulty
//    }


//    private void setPowersPlusDifficulty() {
//        if (difficulty.equals("Medium")) {
//            PowersPlusBoardManager.setDifficulty(0);
//        } else if (difficulty.equals("Easy")) {
//            PowersPlusBoardManager.setDifficulty(-1);
//        } else {
//            PowersPlusBoardManager.setDifficulty(1);
//        }
//    }


//
//    /**
//     * Sets the difficulty for minesweeper
//     */
//    private void setMineSweeperDifficulty() {
//        if (difficulty.equals("Medium")) {
//            MineSweeperBoard.setNumCols(12);
//            MineSweeperBoard.setNumRows(20);
//        } else if (difficulty.equals("Easy")) {
//            MineSweeperBoard.setNumCols(8);
//            MineSweeperBoard.setNumRows(14);
//        } else {
//            MineSweeperBoard.setNumCols(16);
//            MineSweeperBoard.setNumRows(26);
//        }
//    }
//    /**
//     * Sets the difficulty for sliding tiles
//     */
//    private void setSlidingTilesDifficulty() {
//        if (difficulty.equals("Medium")) {
//            SlidingTilesBoard.setNumCols(4);
//            SlidingTilesBoard.setNumRows(4);
//        } else if (difficulty.equals("Easy")) {
//            SlidingTilesBoard.setNumCols(3);
//            SlidingTilesBoard.setNumRows(3);
//        } else {
//            SlidingTilesBoard.setNumRows(5);
//            SlidingTilesBoard.setNumCols(5);
//        }
//    }
//
////Determine what saved game to load based on user selected difficulty
//                if (GameHubActivity.difficulty.equals("Easy")){
//                        slidingTilesBoardManager = curSaves.getEasySave();
//                        }else if (GameHubActivity.difficulty.equals("Medium")){
//                        slidingTilesBoardManager = curSaves.getMediumSave();
//                        }else{
//                        slidingTilesBoardManager = curSaves.getHardSave();
//                        }


////Determine what saved game to load based on user selected difficulty
//                if (GameHubActivity.difficulty.equals("Easy")) {
//                        powersPlusBoardManager = curSaves.getEasySave();
//                        } else if (GameHubActivity.difficulty.equals("Medium")) {
//                        powersPlusBoardManager = curSaves.getMediumSave();
//                        } else {
//                        powersPlusBoardManager = curSaves.getHardSave();
//                        }

//
//        if (GameHubActivity.difficulty.equals("Easy")) {
//                curSavedGames.setEasySave(o);
//                } else if (GameHubActivity.difficulty.equals("Medium")) {
//                curSavedGames.setMediumSave(o);
//                } else {
//                curSavedGames.setHardSave(o);
//                }
//    /**
//     * Return the easy saved game
//     *
//     * @return returns the type of the game
//     */
//    public T getEasySave() {
//        return easySave;
//    }
//
//    /**
//     * Return the medium saved game
//     *
//     * @return returns the type of the game
//     */
//    public T getMediumSave() {
//        return mediumSave;
//    }
//
//    /**
//     * Return the hard saved game
//     *
//     * @return returns the type of the game
//     */
//    public T getHardSave() {
//        return hardSave;
//    }
//
//    /**
//     * Sets the easy save
//     *
//     * @param easySave the type of the game
//     */
//    public void setEasySave(T easySave) {
//        this.easySave = easySave;
//    }
//
//    /**
//     * Sets the medium save
//     *
//     * @param mediumSave the type of the game
//     */
//    public void setMediumSave(T mediumSave) {
//        this.mediumSave = mediumSave;
//    }
//
//    /**
//     * Sets the hard save
//     *
//     * @param hardSave the type of the game
//     */
//    public void setHardSave(T hardSave) {
//        this.hardSave = hardSave;
//    }

//        if (this.value < o.value) {
//            return -1;
//        } else if (this.value == o.value) {
//            return 0;
//        } else {
//            return 1;
//        }
//        int row = position / SlidingTilesBoard.getNumRows();
//        int col = position % SlidingTilesBoard.getNumCols();
//        int blankId = slidingTilesBoard.numTiles();
//
//        //Checks to see if its a valid tap (game not over and clicked the proper area
//        if (!gameOver() && isValidTap(position)) {
//
//            //This determines if the game has started or not because we call
//            //touch move to shuffle the board
//            if (!gameStarted){
//                //Increments the user score
//                clicks += 1;
//            }
//
//            // Are any of the 4 the blank tiles?, if so assign null
//            SlidingTilesTile aboveSlidingTilesTile = row == 0 ? null : slidingTilesBoard.getTile(row - 1, col);
//            SlidingTilesTile belowSlidingTilesTile = row == SlidingTilesBoard.getNumRows() - 1 ? null : slidingTilesBoard.getTile(row + 1, col);
//            SlidingTilesTile leftSlidingTilesTile = col == 0 ? null : slidingTilesBoard.getTile(row, col - 1);
//            SlidingTilesTile rightSlidingTilesTile = col == SlidingTilesBoard.getNumCols() - 1 ? null : slidingTilesBoard.getTile(row, col + 1);
//
//            //Interior tile case
//            if (aboveSlidingTilesTile != null && belowSlidingTilesTile != null && leftSlidingTilesTile != null && rightSlidingTilesTile != null) {
//                if (aboveSlidingTilesTile.getId() == blankId) {
//                    slidingTilesBoard.swapTiles(row - 1, col, row, col);
//                } else if (belowSlidingTilesTile.getId() == blankId) {
//                    slidingTilesBoard.swapTiles(row + 1, col, row, col);
//                } else if (leftSlidingTilesTile.getId() == blankId) {
//                    slidingTilesBoard.swapTiles(row, col - 1, row, col);
//                } else {
//                    slidingTilesBoard.swapTiles(row, col + 1, row, col);
//                }
//                //Edge cases, we call swapTiles inside the helper methods
//            } else {
//                checkEdgeCase(position, aboveSlidingTilesTile, belowSlidingTilesTile, leftSlidingTilesTile, rightSlidingTilesTile);
//            }
//        }
//    }
//
//    /**
//     * Checks the edges of the board
//     *
//     * @param position The current position where the user clicked
//     * @param aboveSlidingTilesTile The tile above the tile that the user clicked
//     * @param belowSlidingTilesTile The tile below
//     * @param leftSlidingTilesTile The tile to the left
//     * @param rightSlidingTilesTile The tile to the right
//     */
//    private void checkEdgeCase(int position, SlidingTilesTile aboveSlidingTilesTile, SlidingTilesTile belowSlidingTilesTile, SlidingTilesTile leftSlidingTilesTile, SlidingTilesTile rightSlidingTilesTile) {
//        //Top row missing case
//        if (aboveSlidingTilesTile == null) {
//            int adder = 1;
//            swapAboveOrBelow(adder, belowSlidingTilesTile, leftSlidingTilesTile, rightSlidingTilesTile, position);
//            //Below row missing case
//        } else if (belowSlidingTilesTile == null) {
//            int adder = -1;
//            swapAboveOrBelow(adder, aboveSlidingTilesTile, leftSlidingTilesTile, rightSlidingTilesTile, position);
//            //Right column missing case
//        } else if (rightSlidingTilesTile == null && leftSlidingTilesTile != null) {
//            //Already took care of corner cases
//            int adder = -1;
//            //Left tile can never be null at the same time right is
//            swapLeftOrRight(adder, leftSlidingTilesTile, aboveSlidingTilesTile, position);
//            //Left column missing case
//        } else if (rightSlidingTilesTile != null) {
//            int adder = 1;
//            swapLeftOrRight(adder, rightSlidingTilesTile, aboveSlidingTilesTile, position);
//        }
//    }
//
//    /**
//     * Helper method that swaps the left or right tiles, depending on which one is the edge case
//     *
//     * @param adder       the adder depending on which column was null
//     * @param genericSlidingTilesTile the tile either to the left or right of the current tile
//     * @param aboveSlidingTilesTile   the tile above the current tile
//     * @param position    the position given
//     */
//    private void swapLeftOrRight(int adder, SlidingTilesTile genericSlidingTilesTile, SlidingTilesTile aboveSlidingTilesTile, int position) {
//        //This avoids having 7 parameters, cut down to 5
//        int row = position / SlidingTilesBoard.getNumRows();
//        int col = position % SlidingTilesBoard.getNumCols();
//        int blankId = slidingTilesBoard.numTiles();
//        if (genericSlidingTilesTile.getId() == blankId) {
//            slidingTilesBoard.swapTiles(row, col + adder, row, col);
//        } else if (aboveSlidingTilesTile.getId() == blankId) {
//            slidingTilesBoard.swapTiles(row - 1, col, row, col);
//        } else {
//            slidingTilesBoard.swapTiles(row + 1, col, row, col);
//        }
//    }
//
//    /**
//     * Helper method that swaps the below or above tiles, depending on which one is the edge case
//     *
//     * @param adder       the adder depending on which row was null
//     * @param genericSlidingTilesTile the tile either above or below the current tile
//     * @param leftSlidingTilesTile    the tile to the left of the current tile
//     * @param rightSlidingTilesTile   the tile to the right of the current tile
//     * @param position    the position given
//     */
//    private void swapAboveOrBelow(int adder, SlidingTilesTile genericSlidingTilesTile, SlidingTilesTile leftSlidingTilesTile, SlidingTilesTile rightSlidingTilesTile, int position) {
//        //This avoids having 7 parameters, cut down to 5
//        int row = position / SlidingTilesBoard.getNumRows();
//        int col = position % SlidingTilesBoard.getNumCols();
//        int blankId = slidingTilesBoard.numTiles();
//        //left corner case
//        if (leftSlidingTilesTile == null) {
//            if (genericSlidingTilesTile.getId() == blankId) {
//                slidingTilesBoard.swapTiles(row + adder, col, row, col);
//                //Since its a valid move, we know that there is only one other position it
//                //can move
//            } else {
//                slidingTilesBoard.swapTiles(row, col + 1, row, col);
//            }
//            //Right corner case
//        } else if (rightSlidingTilesTile == null) {
//            if (genericSlidingTilesTile.getId() == blankId) {
//                slidingTilesBoard.swapTiles(row + adder, col, row, col);
//            } else {
//                slidingTilesBoard.swapTiles(row, col - 1, row, col);
//            }
//            //Interior row case
//        } else {
//            if (leftSlidingTilesTile.getId() == blankId) {
//                slidingTilesBoard.swapTiles(row, col - 1, row, col);
//            } else if (genericSlidingTilesTile.getId() == blankId) {
//                slidingTilesBoard.swapTiles(row + adder, col, row, col);
//            } else {
//                slidingTilesBoard.swapTiles(row, col + 1, row, col);
//            }
//        }