# Mancala Board Game
My MSc Computer Science group project.

# Project Context
Your group has been tasked with designing a digital version of the ancient game Mancala. The system, as outlined in this document, will fulfil many
requirements that your client wishes to see implemented in the near future.

Mancala is a traditional African game, thought to
be one of the oldest board games in existence still
today. There are several variations of the game,
but for this task, the base version of the game is
to be used. Mancala is a two player game with the
following rules. 

1. The Mancala board is made up of two rows of
six holes, with a larger hole on both sides of
the rows.
2. Four pieces are placed in each of the 12 holes.
3. Each player has a store (called a Mancala) to
the right side of the Mancala board (the larger
hole at the end of the rows).
4. The game randomly choses a player to start.
That player then picks up all of the pieces in
any one of the holes on their side.
5. Moving counter-clockwise, the player deposits
one of the stones in each hole until the stones
run out.
• If you run into your own store, deposit
one piece in it. If you run into your opponent’s store, skip it.
• If the last piece you drop is in your own
store, you get a free turn.
• If the last piece you drop is in an hole
with pieces, you pick those pieces up and
move again.
• If the last piece you drop is into an empty
hole, your turn is over the other player
begins their turn.
6. The game ends when all six spaces on one side
of the Mancala board are empty.
7. The player who still has pieces on his side of
the board when the game ends capture all of
those pieces.
8. Count all the pieces in each store. The winner
is the player with the most pieces.

# Game System Structure
This section will describe in detail the exact elements of the proposed system and what features
are to be supported.

1. **Game Modes**

The proposed system will allow for two modes of
game style; traditional and arcade. The traditional
variant of the game will follow the exact rules outlined in Section 2 (and as the video demonstration
describes).

The arcade version will expand on the base version
of the game and add new gameplay elements into
the system. In this mode players will have access
to two power-ups at the start of a game:


1. **Continue Turn** - When used, a player can
continue their turn once an empty hole. The
player must move to the next hole which contains stones and continue from that point

2. **Double Points** - For a single turn all points
added to a player’s store are doubled.
These power-ups may only be used at the start of
a turn and must be stated by a player at this time.
In addition to power-ups, the arcade version allows
for the support of 3 special stones that either player
could encounter during a turn:

3. **Half hand** - In this case, the special stone will
reduce the number of pieces picked up by half.
In cases of odd numbers the result should be
rounded up (e.g. a result of 2.5 would round
to 3). The remaining stones (those not picked
up) will remain in the hole.

4. **Reverse turn** - Rather than following an
anti-clockwise movement, for the next round
move in a clockwise direction.

5. **Switch sides** - A player must take the stones
from the opposite side of the board (instead
of where they have chosen)and take turn from
that position

Each time a player picks up a set of stones from
a hole to begin a move, there is a 10% chance of
one of these special stones being triggered on that
player turn. That is each time a player picks up
pieces there is a 1 in 10 chance of a special stone
triggering an action.
The system should clearly present the information
that they have picked up a special stone to a user
in an appropriate manner.

2. **Gameplay**

The system needs to support two player games on a
stand-alone local machine. Players should be able
to pick a profile before starting a game. Additionally, it is required that a computer player can also
be created to play against.

3. **Users**

There are two types of users in the system:


3.1 **Administrators** - Can approve new users
joining the system and will assign new users.
The administrator will also have access to an
extra information screen showing the most frequent users that have logged onto teh system
, as well as the frequency of power-ups and
special stones used in the arcade version of
the game.

3.2 **Players** - Can play the game of Mancala as
described in this document

4. **User Information**

Each player in the game must have an account,
which we refer to as the user’s profile. the following
information is linked to a user’s profile:

1. A username that allows access to the profile
2. A first and a last name
3. The date and time of the last time a user was
logged in
4. A profile image
5. A win percentage

You should design and implement classes to manage this information. Also, you should create an
graphical user interface that allows the input of
this information to create a new account.

5. **Player Records**

The system should track the wins and loses of each
player in the system. This information will then be
used to calculate win percentages for every users
profile page, as well as a leaderboard. This leaderboard will provide a tabular view of the players on
the system and rank them according to either their
win percentage or total number of wins.

6. **Favourite Players**

Users shall be able to browse the limited profiles of
other users (username, profile image and win percentage only) and mark them at favourites. Users
shall also be able to unmark a user as a favourite.
When browsing the leaderboard, the user shall also
have the ability to mark a player as a favourite.

7. **Information Since Last Login**

The user will have the ability to look at a variety of lists which will contain information that has
2
changed since the last time they logged in. Specifically:

7.1 Games that have been completed since they
last logged in

7.2 Changes to their position in the leaderboard

8. **Profile Images**

Each user must have a profile image that can be
selected from a file. The user can select one of
these as their profile picture.

9. **Other Properties**

Initially, all the information shall be stored in files
on disk. More specifically, the Mancala game must
have the following property:

9.1 For all users, their profile information, game
history and favourite user list must be saved to
disk locally. When you restart the program,
these details will be loaded from a series of
files.

The first version of Mancala that you create should
operate on a single machine. A user logs in to the
program and performs actions which are saved locally to disk on that machine. The user logs out. A
new user can then log in to view what has changed.
When you start the implementation part of the
project, please do not proceed to something more
complicated until you have all Mancala functionality working well locally on one machine

10. **Data Persistence**

The user profile data, menu data, and all other
system data is persisted across running of the system. That is, if the user quits the application, then
upon reopening of the application, the data is not
lost.

11. **Libraries and Frameworks**

You must programme this game in Java using
JavaFX. You may use any classes and packages
that are part of the standard Java SDK. If you
wish to use any additional tools / libraries, first
discuss with the module co-ordinator.
You may not use any other libraries or frameworks
without first seeking approval. Please use the lectures to ask such questions.
