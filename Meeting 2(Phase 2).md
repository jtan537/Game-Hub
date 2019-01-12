# Meeting Friday, November 23rd.

Tasks Completed:
Minesweeper game and backend logic - Jimmy, Fred. 
    - Fixed bug in the adjacency checker where we did not consider the 'wrapping' property of the
    tiles list.
    - Fixed issue where it was too slow in the recursive 'open' algorithm, since we were updating
    the display with every recursive call. Changed implementation to only update display at last
    recursive call.
Minesweeper frontend UI - Alex, Zuhab.
    - UI was not displaying properly(as a result of above bug)
    - Fixed above bug, UI now displays board correctly, and updates.
    - UI is now complete and functional.
2048 Clone(PowersPlus) - Alex, Zuhab
    - Fixed bug where undo would not 'un merge' the tiles, by removing aliasing in the get tile method.
    - Fixed bug where scoring went negative, by creating a 'past scores' array and accessing it.
    - Fixed bug where in base 3, due to floating point precision the logic did not work because when
    we tried to combine 3 with 3, we would get not 9. Fixed by making a 'power' field to keep track
    of, rather than calculating at run time.
    - Fixed float inaccuracy in calculating the merge by using a helper, rather than java log 
    operator, to get rid of floating point inaccuracy.
    - Finished functionality of the game and the front end UI.
    
Discussion:
Communicated plans on unit testing. Decided to assign unit tests as such:

Sliding Tiles: Jimmy and Alex

Scoreboard/Leader-board/Score: Jimmy

Minesweeper: Fred

Powers-Plus: Zuhab

Next meeting on Saturday, November 24th.
    