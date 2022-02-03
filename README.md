
# Tic Tac Toe Ai - Easy, Medium, Hard

In order to learn more about recursion, I decided to build my own Tic Tac Toe Ai.  Sadly, it isn't possible to guarantee a win in Tic Tac Toe, you can however guarantee a tie.

This program has 3 different "AI's":  
- Easy plays the game by picking a random space and filling it in with their mark.


- Medium plays the game by winning if it can (two spaces in a row or space in the middle) or by blocking
the opponent if they are about to win (two spaces in a row or space in the middle).  If neither of these conditions are met
medium plays in a random available space.  


- Hard plays the game by picking 1 of the available spaces and simulating every possible game from that point.
It does this for every spot available and then picks the space that has the most strategic value. It then
plays their mark in that space.

## Authors

- [@jhartman00](https://www.github.com/jhartman00)


## Demo

https://youtu.be/m4lNCrd34J4

## Running the Program

1. To try this project for yourself make sure you have Java installed on your computer.  If you don't you can go to https://www.java.com/en/download/ to get it for free!
    - Windows: https://www.youtube.com/watch?v=IJ-PJbvJBGs
    - Mac: https://www.youtube.com/watch?v=pxi3iIy4F5A
2. Clone the directory or download the zip file to a location of your choosing.
3. Open a terminal/command shell in the src/main/java/TicTacToe folder
4. Run the command to compile the program "javac main.java"
5. To run the program run the command "java main"

## Once the program is running

The program has 4 different modes: easy, medium, hard, and user

When running the main.java file you will be prompted for an input

To start input: start user1 user2

user1 can be any one of the 4 modes
user2 can be any one of the 4 modes

eg. 
- start hard hard: Hard Ai vs Hard Ai
- start hard easy: Hard Ai vs Easy Ai
- start user hard: User vs Hard Ai
- start user user: Two users no AI
- etc.

If you selected user as one of the options you will have to input the space you want when it is your turn:
- The board is based on a grid system where the rows and columns are numbered 1 through 3
- To go in the top left space you would enter "1 1" with no quotes. 
  - The first number corresponds to the row and the second number corresponds to the column.
- A list of all possible spots
  - 1 1 | top left
  - 1 2 | top middle
  - 1 3 | top right
  - 2 1 | middle left
  - 2 2 | center spot
  - 2 3 | middle right
  - 3 1 | bottom left
  - 3 2 | bottom middle
  - 3 3 | bottom right
  
## A few things to note

1. As stated before, it is impossible to guarantee a win in Tic Tac Toe.  If you tie with the hard AI congrats!
2. There is one improvement I thought of after completing the project and that would be to record the recursion depth of the hard AI and have that factor into the move it chooses.  At the moment the hard AI works however it goes for any win condition.  In recording the recursion depth and having that factor into the move choice the hard algorithm would go for the fastest win condition instead of any win condition.

## FAQ

#### Questions?

Feel free to email me at jamiehartman00@gmail.com or jhartman1@tulane.edu, and I will get back to you as soon as possible.




## Lessons Learned

This was an interesting project.  I learned a lot about how recursion works in general as well as how to apply recursion to different situations.  I learned how bases cases work in recursion and finally how to troubleshoot a recursive program. 

After I finished the project, looking back I would have done things differently.  For starters having the tic-tac-toe board stored in a dictionary overcomplicated the program.  If I were to redo the program I would store the board in an array.  I also would split the program up with 2 classes: board and player.  This would greatly increase the scalability of the project as well as the readability of the project.

## Want more?

Check out my website at https://jamiehartman-com.stackstaging.com/

<h3 align="left">Connect with me:</h3>
<p align="left">
<a href="https://linkedin.com/in/jamiehartman00" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/linked-in-alt.svg" alt="jamiehartman00" height="30" width="40" /></a>
<a href="https://instagram.com/jamie_hartman99" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/instagram.svg" alt="jamie_hartman99" height="30" width="40" /></a>
<a href="https://github.com/jhartman00" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/github.svg" alt="jamiehartman00" height="30" width="40" /></a>
</p>

<h3 align="left">Languages and Tools:</h3>
<p align="left"> <a href="https://getbootstrap.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/bootstrap/bootstrap-plain-wordmark.svg" alt="bootstrap" width="40" height="40"/> </a> <a href="https://www.cprogramming.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/c/c-original.svg" alt="c" width="40" height="40"/> </a> <a href="https://www.w3schools.com/cpp/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/cplusplus/cplusplus-original.svg" alt="cplusplus" width="40" height="40"/> </a> <a href="https://www.w3schools.com/css/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/css3/css3-original-wordmark.svg" alt="css3" width="40" height="40"/> </a> <a href="https://git-scm.com/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="git" width="40" height="40"/> </a> <a href="https://www.w3.org/html/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/html5/html5-original-wordmark.svg" alt="html5" width="40" height="40"/> </a> <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/javascript/javascript-original.svg" alt="javascript" width="40" height="40"/> </a> <a href="https://www.mathworks.com/" target="_blank" rel="noreferrer"> <img src="https://upload.wikimedia.org/wikipedia/commons/2/21/Matlab_Logo.png" alt="matlab" width="40" height="40"/> </a> <a href="https://www.mysql.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="40" height="40"/> </a> <a href="https://nodejs.org" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/nodejs/nodejs-original-wordmark.svg" alt="nodejs" width="40" height="40"/> </a> <a href="https://pandas.pydata.org/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/2ae2a900d2f041da66e950e4d48052658d850630/icons/pandas/pandas-original.svg" alt="pandas" width="40" height="40"/> </a> <a href="https://www.php.net" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/php/php-original.svg" alt="php" width="40" height="40"/> </a> <a href="https://www.postgresql.org" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original-wordmark.svg" alt="postgresql" width="40" height="40"/> </a> <a href="https://www.python.org" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/python/python-original.svg" alt="python" width="40" height="40"/> </a> <a href="https://pytorch.org/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/pytorch/pytorch-icon.svg" alt="pytorch" width="40" height="40"/> </a> <a href="https://scikit-learn.org/" target="_blank" rel="noreferrer"> <img src="https://upload.wikimedia.org/wikipedia/commons/0/05/Scikit_learn_logo_small.svg" alt="scikit_learn" width="40" height="40"/> </a> <a href="https://seaborn.pydata.org/" target="_blank" rel="noreferrer"> <img src="https://seaborn.pydata.org/_images/logo-mark-lightbg.svg" alt="seaborn" width="40" height="40"/> </a> <a href="https://www.sqlite.org/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/sqlite/sqlite-icon.svg" alt="sqlite" width="40" height="40"/> </a> <a href="https://svelte.dev" target="_blank" rel="noreferrer"> <img src="https://upload.wikimedia.org/wikipedia/commons/1/1b/Svelte_Logo.svg" alt="svelte" width="40" height="40"/> </a> <a href="https://www.tensorflow.org" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/tensorflow/tensorflow-icon.svg" alt="tensorflow" width="40" height="40"/> </a> </p>


<h3 align="left">Support:</h3>
<p><a href="https://www.buymeacoffee.com/jamiehartman"> <img align="left" src="https://cdn.buymeacoffee.com/buttons/v2/default-yellow.png" height="50" width="210" alt="jamiehartman" /></a></p><br><br>
