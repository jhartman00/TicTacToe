# Welcome to my TicTacToe project!

The program has 4 different modes: easy, medium, hard, and user

When running the main.java file you will be prompted for an input

To start input: start user1 user2

user1 can be any one of the 4 modes
user2 can be any one of the 4 modes

easy plays the game by picking a random space and filling it in with their mark.

medium plays the game by winning if it can (two spaces in a row or space in the middle) or by blocking
the opponent if they are about to win (two spaces in a row or space in the middle).  If neither of these conditions are met
medium plays in a random available space.

hard plays the game by picking 1 of the available spaces and simulating every possible game from that point. 
It does this for every spot available and then picks the space that has the most strategic value. It then 
plays their mark in that space.