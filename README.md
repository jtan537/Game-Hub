# Android Studio Setup Instructions

1. Log into your markus for csc207 and get the link needed for cloning (located in Phase1: Project)
..*[Link for cloning provided here](https://markus.teach.cs.toronto.edu/git/csc207-2018-09-reg/group_0469)

2. Open Android Studio and clone it by clicking "Check out project from version control" and selecting git
If one of your projects open instead of the main menu, go click "File", "New", "Project from version control", "Git"

3. Paste the URL, click test to make sure its okay, then click clone and wait for it to process

4. Select yes to creating a new android studio project

5. Select "Import project from external model" and click Next (Make sure you selected "Gradle" and not "Android Gradle"

6. Click Gradle project, navigate to where your project is saved and select "group_0469/Phase1/GameCentre", then click OK.
This adds "Phase1/GameCentre" to the Gradle project path

7. Click Finish (Leave everything else the same)

8. You might get an error that says "The path 'C:\Users\Alex Quach\AppData\Local\Android\Sdk'
does not belong to a directory. Android Studio will use this Android SDK instead:
*the path to your android sdk* and will modify the project's local.properties file."
Click Ok, this simply changes the android sdk local properties to your own because the git has the original pusher's local properties.

9. You might get the message "Unregistered VS root detected", and you should choose to "Add root"

10. Wait for the project to build

11. You might get a message about adding a bunch of XML files to git, select no/cancel

12. You might get an "Unsupported modules detected" message, ignore that

13. Test if the project runs by using the AVD: Pixel 2, API27.0

14. You should now see our project! Enjoy.

# Pushing instructions:
ALWAYS (all under right click -> GIT):
1. Add
2. Commit (Please put a meaningful message that the other members can interpret)
3. Push
4. Pull / Merge if other group members have pushed before you did

# Commit message instructions:
Copy and paste these for any commit messages. Be specific, note the functionality thats changed.
(For example, as opposed to saying ‘made edits to scoreboard class’, say ‘created addScoreByDifficulty method)  
Functionality/method changes:  
UI/Design/Code Structure changes:  
Minor code smells, bug fixes:  
Changes Made By :  

Note: MAKE SURE YOU DON'T OVERRIDE AND ERASE OTHER GROUP MEMBERS' WORK WITHOUT CONSULTING THEM FIRST
Proper order for pushing is add, commit, pull, fix any merge conflicts THEN push

# Notes on implementation:
1. WE HAVE A MAX OF ONE SAVED GAME PER DIFFICULTY, PER GAME:  
For Example: You can have a saved game for SlidingTiles Easy, SlidingTiles Medium and MineSweeper Medium
at the same time. This makes sense because most mobile games have this design choice.  
2. WE HAVE NO SAVED BUTTON BECAUSE WE AUTOSAVE EVERY TURN
3. ONCE YOU WIN/COMPLETE A GAME, THE SAVE IS ERASED AND YOU HAVE TO START A NEW GAME
4. WE CHOSE TO FIX THE DIFFICULTIES TO EASY, MEDIUM AND HARD   
5. WE SELECT DIFFICULTY FIRST BECAUSE YOU CAN HAVE DIFFERENT SAVED GAMES DEPENDING ON DIFFICULTY  
6. WHEN YOU LOSE A GAME, YOUR SAVE IS ERASED SO YOU CAN START A NEW GAME