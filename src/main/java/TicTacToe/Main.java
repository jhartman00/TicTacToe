package TicTacToe;

import java.util.*;

//Fix User Input throwing error if bad input
public class Main {
	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		boolean exit = false;
		Scanner scnr = new Scanner(System.in);
		String p1;
		String p2;
		while (true) {
			p1 = "";
			p2 = "";
			System.out.println("Input command: ");
			String[] choices = scnr.nextLine().split(" ");
			if (choices[0].equals("exit")) {
				exit = true;
				break;
			}
			if (choices[0].equals("start") && choices.length == 3) {
				if (choices[1].equals("user") || choices[1].equals("easy") || choices[1].equals("medium") || choices[1].equals("hard")) {
					if (choices[2].equals("user") || choices[2].equals("easy") || choices[2].equals("medium") || choices[2].equals("hard")) {
						p1 = choices[1];
						p2 = choices[2];
						break;
					}
				}
			}
			System.out.println("Bad parameters!");
		}
		if (exit) return;
		System.out.println("users are: p1 " + p1 + " and p2 " + p2);
		game(p1, p2);
	}

	@SuppressWarnings ("ConstantConditions")
	public static void game(String p1, String p2) {
		HashMap<String, String> map = buildBoardEmpty();
		boolean gameNotFinished = true;
		//Loop until game is won lost or tied

		while (gameNotFinished) {
			int countX = Collections.frequency(map.values(), "X");
			int countO = Collections.frequency(map.values(), "O");
			String turn = " ";
			turn = turnDecider(countX, countO, turn);
			PrintBoard(map);
			if (turn.equals("X")) {
				turnHelper(p1, map, turn);
			}
			if (turn.equals("O")) {
				turnHelper(p2, map, turn);
			}
			String winCondition = checkWin(map, turn);
			gameNotFinished = isFinished(map, gameNotFinished, winCondition);
		}
	}

	public static HashMap<String, String> buildBoardEmpty() {
		HashMap<String, String> map;
		map = new HashMap<>();
		int x = 1;
		@SuppressWarnings ("unused") int z = 0;
		for (int i = 1; i <= 3; i++) {
			int y = 1;
			for (int j = 1; j <= 3; j++) {
				map.put(x + " " + y, " ");
				y++;
				z++;
			}
			x++;


		}
		return map;
	}

	private static String turnDecider(int countX, int countO, String turn) {
		if (countX > countO) turn = "O";
		if (countX == countO) turn = "X";
		return turn;
	}

	public static void PrintBoard(HashMap<String, String> map) {
		System.out.println("---------");
		System.out.println("| " + map.get("1 1") + " " + map.get("1 2") + " " + map.get("1 3") + " |");
		System.out.println("| " + map.get("2 1") + " " + map.get("2 2") + " " + map.get("2 3") + " |");
		System.out.println("| " + map.get("3 1") + " " + map.get("3 2") + " " + map.get("3 3") + " |");
		System.out.println("---------");
	}

	private static void turnHelper(String p1, HashMap<String, String> map, String turn) {
		switch (p1) {
			case "easy" -> {
				System.out.println("Making move level \"easy\"");
				easyAiTurn(map, turn);
			}
			case "user" -> playerTurn(map, turn);
			case "medium" -> {
				System.out.println("Making move level \"medium\"");
				mediumAiTurn(map, turn);
			}
			case "hard" -> {
				System.out.println("making move level \"hard\"");
				hardAiTurn(map, turn);
			}
		}
	}

	public static String checkWin(HashMap<String, String> map, String turn) {
		if (checkWinVertical(map, turn)) return turn + " wins";
		if (checkWinHorizontal(map, turn)) return turn + " wins";
		if (checkWinDiagonals(map, turn)) return turn + " wins";
		if (!map.containsValue(" ")) {
			return "Draw";
		}
		return "gameNotFinished";
	}

	private static boolean isFinished(HashMap<String, String> map, boolean finished, String winCondition) {
		switch (winCondition) {
			case "X wins" -> {
				PrintBoard(map);
				System.out.println("X wins");
				finished = false;
			}
			case "O wins" -> {
				PrintBoard(map);
				System.out.println("O wins");
				finished = false;
			}
			case "Draw" -> {
				PrintBoard(map);
				System.out.println("Draw");
				finished = false;
			}
		}
		return finished;
	}

	private static void easyAiTurn(HashMap<String, String> map, String turn) {
		randomPlace(map, turn);
	}

	private static void playerTurn(HashMap<String, String> map, String turn) {
		boolean done = false;
		String coords;
		System.out.println("Enter the coordinates: ");
		while (!done) {
			Scanner scnr = new Scanner(System.in);
			int trigger;
			while (true) {
				trigger = 999;
				if (scnr.hasNext()) {
					coords = scnr.nextLine();
					break;
				}
			}
			String[] coordsXY = coords.split(" ");
			if (coordsXY.length != 2) {
				trigger = 1;
			} else {
				String x = coordsXY[0];
				String y = coordsXY[1];
				if (isNumeric(x) || isNumeric(y)) {
					trigger = 1;
				}
				if (trigger == 999) {
					if (Integer.parseInt(x) < 1 || Integer.parseInt(x) > 3 || Integer.parseInt(y) < 1 || Integer.parseInt(y) > 3) {
						trigger = 2;
					}
				}
			}
			if (trigger == 999) {
				if (!map.get(coords).equals(" ")) {
					trigger = 0;
				}
			}
			switch (trigger) {
				case 0 -> {
					System.out.println("This cell is occupied! Choose another one!");
					System.out.println("Enter the coordinates: ");
				}
				case 1 -> {
					System.out.println("You should enter numbers!");
					System.out.println("Enter the coordinates: ");
				}
				case 2 -> {
					System.out.println("Coordinates should be from 1 to 3!");
					System.out.println("Enter the coordinates: ");
				}
				default -> {
					map.put(coords, turn);
					done = true;
				}
			}
		}
	}

	private static void mediumAiTurn(HashMap<String, String> map, String turn) {
		boolean turnOver;
		//check if med is one away
		turnOver = checkOneAway(map, turn, false);
		if (turnOver) {
			return;
		}
		//check if opponent is one away
		turnOver = checkOneAway(map, turn, true);
		if (turnOver) {
			return;
		}
		randomPlace(map, turn);
	}

	private static boolean checkWinVertical(HashMap<String, String> map, String turn) {
		if (Objects.equals(map.get("1 1"), turn)) {
			if (Objects.equals(map.get("2 1"), turn)) {
				if (Objects.equals(map.get("3 1"), turn)) return true;
				//X__
				//X__
				//X__
			}
		}
		if (Objects.equals(map.get("1 2"), turn)) {
			if (Objects.equals(map.get("2 2"), turn)) {
				if (Objects.equals(map.get("3 2"), turn)) return true;
				//_X_
				//_X_
				//_X_

			}
		}
		if (Objects.equals(map.get("1 3"), turn)) {
			if (Objects.equals(map.get("2 3"), turn)) {
				return Objects.equals(map.get("3 3"), turn);
				//__X
				//__X
				//__X

			}
		}
		return false;
	}

	private static boolean checkWinHorizontal(HashMap<String, String> map, String turn) {
		if (Objects.equals(map.get("1 1"), turn)) {
			if (Objects.equals(map.get("1 2"), turn)) {
				if (Objects.equals(map.get("1 3"), turn)) return true;
				//XXX
				//___
				//___
			}
		}
		if (Objects.equals(map.get("2 1"), turn)) {
			if (Objects.equals(map.get("2 2"), turn)) {
				if (Objects.equals(map.get("2 3"), turn)) return true;
				//___
				//XXX
				//___

			}
		}
		if (Objects.equals(map.get("3 1"), turn)) {
			if (Objects.equals(map.get("3 2"), turn)) {
				return Objects.equals(map.get("3 3"), turn);
				//___
				//___
				//XXX

			}
		}
		return false;
	}

	private static boolean checkWinDiagonals(HashMap<String, String> map, String turn) {
		if (Objects.equals(map.get("1 1"), turn)) {
			if (Objects.equals(map.get("2 2"), turn)) {
				if (Objects.equals(map.get("3 3"), turn)) return true;
				//X__
				//_X_
				//__X
			}
		}
		if (Objects.equals(map.get("1 3"), turn)) {
			if (Objects.equals(map.get("2 2"), turn)) {
				return Objects.equals(map.get("3 1"), turn);
				//__X
				//_X_
				//X__
			}
		}
		return false;
	}

	private static void randomPlace(HashMap<String, String> map, String turn) {
		List<String> availableSpaces = new ArrayList<>();
		if (map.containsValue(" ")) {
			for (int i = 0; i < 9; i++) {
				if (map.get("1 1").equals(" ")) availableSpaces.add("1 1");
				if (map.get("1 2").equals(" ")) availableSpaces.add("1 2");
				if (map.get("1 3").equals(" ")) availableSpaces.add("1 3");
				if (map.get("2 1").equals(" ")) availableSpaces.add("2 1");
				if (map.get("2 2").equals(" ")) availableSpaces.add("2 2");
				if (map.get("2 3").equals(" ")) availableSpaces.add("2 3");
				if (map.get("3 1").equals(" ")) availableSpaces.add("3 1");
				if (map.get("3 2").equals(" ")) availableSpaces.add("3 2");
				if (map.get("3 3").equals(" ")) availableSpaces.add("3 3");
			}
			Random random = new Random();
			String space = availableSpaces.get(random.nextInt(availableSpaces.size()));
			map.put(space, turn);
		}
	}

	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return true;
		}
		try {
			@SuppressWarnings ("unused") double d = Double.parseDouble(strNum);
		} catch (NumberFormatException nfe) {
			return true;
		}
		return false;
	}

	private static boolean checkOneAway(HashMap<String, String> map, String turn, boolean inverse) {
		String turnTemp = turn;
		if (inverse) {
			turn = turn.equals("X") ? "O" : "X";
		}
		String invTurn = turn.equals("X") ? "O" : "X";
		int i = 0;
		String[] availableSpaces = new String[9];
		for (int j = 1; j < 4; j++) {
			for (int k = 1; k < 4; k++) {
				if (map.get(j + " " + k).equals(turn)) availableSpaces[i] = "check";
				else if (map.get(j + " " + k).equals(invTurn)) availableSpaces[i] = "neg";
				else availableSpaces[i] = (" ");
				i++;
			}
		}
		if (inverse) {
			turn = turnTemp;
		}

		//CheckCanWin
		//123
		//456
		//789
		//Horizontal
		//12, 23, 45, 56, 78, 89
		if (availableSpaces[0].equals("check") && availableSpaces[1].equals("check") && availableSpaces[2].equals(" ")) {
			map.put("1 3", turn);
			return true;
		}
		if (availableSpaces[1].equals("check") && availableSpaces[2].equals("check") && availableSpaces[0].equals(" ")) {
			map.put("1 1", turn);
			return true;
		}
		if (availableSpaces[3].equals("check") && availableSpaces[4].equals("check") && availableSpaces[5].equals(" ")) {
			map.put("2 3", turn);
			return true;
		}
		if (availableSpaces[4].equals("check") && availableSpaces[5].equals("check") && availableSpaces[3].equals(" ")) {
			map.put("2 1", turn);
			return true;
		}
		if (availableSpaces[6].equals("check") && availableSpaces[7].equals("check") && availableSpaces[8].equals(" ")) {
			map.put("3 3", turn);
			return true;
		}
		if (availableSpaces[7].equals("check") && availableSpaces[8].equals("check") && availableSpaces[6].equals(" ")) {
			map.put("3 1", turn);
			return true;
		}
		//Vertical
		//14, 47, 25, 58, 36, 69
		if (availableSpaces[0].equals("check") && availableSpaces[3].equals("check") && availableSpaces[6].equals(" ")) {
			map.put("3 1", turn);
			return true;
		}
		if (availableSpaces[3].equals("check") && availableSpaces[6].equals("check") && availableSpaces[0].equals(" ")) {
			map.put("1 1", turn);
			return true;
		}
		if (availableSpaces[1].equals("check") && availableSpaces[4].equals("check") && availableSpaces[7].equals(" ")) {
			map.put("3 2", turn);
			return true;
		}
		if (availableSpaces[4].equals("check") && availableSpaces[7].equals("check") && availableSpaces[1].equals(" ")) {
			map.put("1 2", turn);
			return true;
		}
		if (availableSpaces[2].equals("check") && availableSpaces[5].equals("check") && availableSpaces[8].equals(" ")) {
			map.put("3 3", turn);
			return true;
		}
		if (availableSpaces[5].equals("check") && availableSpaces[8].equals("check") && availableSpaces[2].equals(" ")) {
			map.put("1 3", turn);
			return true;
		}
		//Diagonal
		//15, 59, 35, 57
		if (availableSpaces[0].equals("check") && availableSpaces[4].equals("check") && availableSpaces[8].equals(" ")) {
			map.put("3 3", turn);
			return true;
		}
		if (availableSpaces[4].equals("check") && availableSpaces[8].equals("check") && availableSpaces[0].equals(" ")) {
			map.put("1 1", turn);
			return true;
		}
		if (availableSpaces[2].equals("check") && availableSpaces[4].equals("check") && availableSpaces[6].equals(" ")) {
			map.put("3 1", turn);
			return true;
		}
		if (availableSpaces[4].equals("check") && availableSpaces[6].equals("check") && availableSpaces[2].equals(" ")) {
			map.put("1 3", turn);
			return true;
		}
		//012
		//345
		//678
		//fillInMiddle
		//02, 35, 68
		//Horizontal
		if (availableSpaces[0].equals("check") && availableSpaces[2].equals("check") && availableSpaces[1].equals(" ")) {
			map.put("1 2", turn);
			return true;
		}
		if (availableSpaces[3].equals("check") && availableSpaces[5].equals("check") && availableSpaces[4].equals(" ")) {
			map.put("2 2", turn);
			return true;
		}
		if (availableSpaces[6].equals("check") && availableSpaces[8].equals("check") && availableSpaces[7].equals(" ")) {
			map.put("3 2", turn);
			return true;
		}
		//06, 17, 28
		//Vertical
		if (availableSpaces[0].equals("check") && availableSpaces[6].equals("check") && availableSpaces[3].equals(" ")) {
			map.put("2 1", turn);
			return true;
		}
		if (availableSpaces[1].equals("check") && availableSpaces[7].equals("check") && availableSpaces[5].equals(" ")) {
			map.put("2 2", turn);
			return true;
		}
		if (availableSpaces[2].equals("check") && availableSpaces[8].equals("check") && availableSpaces[5].equals(" ")) {
			map.put("2 3", turn);
			return true;
		}
		//08, 26
		//diagonal
		if (availableSpaces[0].equals("check") && availableSpaces[8].equals("check") && availableSpaces[4].equals(" ")) {
			map.put("2 2", turn);
			return true;
		}
		if (availableSpaces[2].equals("check") && availableSpaces[6].equals("check") && availableSpaces[4].equals(" ")) {
			map.put("2 2", turn);
			return true;
		}
		if (availableSpaces[0].equals(" ")) {
			if (availableSpaces[1].equals("check") && availableSpaces[2].equals("check")) {
				map.put("1 1", turn);
			}
		}
		return false;
	}

	private static void hardAiTurn(HashMap<String, String> map, String turn) {
		String bestMove = findBestMove(map, turn);
		map.put(bestMove, turn);
	}

	public static int minMax(HashMap<String, String> map, boolean isMax, int depth, String turn, String oop) {
		ArrayList<String> emptySpots = emptySpots(map);

		int score = gameState(map, turn, oop);

		if (score == 10) return score;

		if (score == -10) return score;

		if (emptySpots.size() == 0) return 0;

		int best;
		if (isMax) {
			best = -1000;

			for (String spot : emptySpots) {
				map.put(spot, turn);
				best = Math.max(best, minMax(map, false, depth+1, turn, oop));
				map.put(spot, " ");
			}
		} else {
			best = 1000;

			for (String spot : emptySpots) {
				map.put(spot, oop);
				best = Math.min(best, minMax(map, true, depth+1, turn, oop));
				map.put(spot, " ");
			}
		}
		return best;
	}

	public static String findBestMove(HashMap<String, String> map, String turn) {
		String oop = (turn.equals("X")?"O":"X");
		int bestVal = -1000;
		String bestMove = "";
		ArrayList<String> emptySpots = emptySpots(map);
		for (String spot : emptySpots) {

			map.put(spot, turn);
			// compute evaluation function for this
			// move.
			int moveVal = minMax(map, false, 0, turn, oop);
			// Undo the move
			map.put(spot, " ");
			// If the value of the current move is
			// more than the best value, then update
			// best/
			if (moveVal > bestVal) {
				bestMove = spot;
				bestVal = moveVal;
			}
		}
		return bestMove;
	}

	private static int gameState(HashMap<String, String> map, String player, String
			otherPlayer) {
		if (winCondition(map, player)) {
			return 10;
		} else if (winCondition(map, otherPlayer)) {
			return -10;
		}
		return 0;
	}

	public static ArrayList<String> emptySpots(HashMap<String, String> map) {
		ArrayList<String> emptySpots = new ArrayList<>();
		for (int j = 1; j < 4; j++) {
			for (int k = 1; k < 4; k++) {
				String spot = j + " " + k;
				if (map.get(spot).equals(" ")) {
					emptySpots.add(spot);
				}
			}
		}
		return emptySpots;
	}

	public static boolean winCondition(HashMap<String, String> board, String turn) {
		return (board.get("1 1").equals(turn) && board.get("1 2").equals(turn) && board.get("1 3").equals(turn)) ||
				(board.get("2 1").equals(turn) && board.get("2 2").equals(turn) && board.get("2 3").equals(turn)) ||
				(board.get("3 1").equals(turn) && board.get("3 2").equals(turn) && board.get("3 3").equals(turn)) ||
				(board.get("1 1").equals(turn) && board.get("2 1").equals(turn) && board.get("3 1").equals(turn)) ||
				(board.get("1 2").equals(turn) && board.get("2 2").equals(turn) && board.get("3 2").equals(turn)) ||
				(board.get("1 3").equals(turn) && board.get("2 3").equals(turn) && board.get("3 3").equals(turn)) ||
				(board.get("1 1").equals(turn) && board.get("2 2").equals(turn) && board.get("3 3").equals(turn)) ||
				(board.get("1 3").equals(turn) && board.get("2 2").equals(turn) && board.get("3 1").equals(turn));
	}
}


