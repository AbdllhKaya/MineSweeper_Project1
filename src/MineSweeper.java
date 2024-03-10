import java.util.Scanner;

public class MineSweeper { // Sınıf içerisinde kullanılacak değişken tanımlaması yapıldı.
    Scanner scanner = new Scanner(System.in);
    int rowSize, colSize;
    char[][] board;
    boolean[][] visited;
    int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public void startGame() {
        initializeBoard();
        placeMines();
        play();
    }

    public void initializeBoard() { // Kullanıcının girdiği değerler doğrultusunda mayın tarlası oluşturuldu .
        System.out.println("Please enter the dimensions you want to play! ");
        System.out.print("Enter the number of rows: ");
        rowSize = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        colSize = scanner.nextInt();
        while ((rowSize<2) && (colSize<2)) {
            System.out.println("The rows and columns of the game must be greater than 2! Enter again! ");
            initializeBoard();
        }
        board = new char[rowSize][colSize];
        visited = new boolean[rowSize][colSize];

        // Board boşluklarla dolduruldu.
        for(int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                board[i][j] = '-';
                visited[i][j] = false;
            }
        }
    }

    public void placeMines() {
        double mineRate = 0.25; // Mayın oranı %25 olarak belirlendi.
        int totalCells = rowSize * colSize;
        int mineCount = (int) (totalCells * mineRate);

        // Belirlenen mayın oran sayısı kadar random olarak konumlara mayın yerleştirildi.
        int minesPlaced = 0;
        while (minesPlaced < mineCount) {
            int row = (int) (Math.random() * rowSize);
            int col = (int) (Math.random() * colSize);
            if (board[row][col] != '*') {
                board[row][col] = '*';
                minesPlaced++;
            }
        }
    }

    public void play() {
        while (true) {
            printBoard();
            // Oyun esnasında girilen noktaların kontrolü yapıldı.
            System.out.print("Select the row: ");
            int selectedRow = scanner.nextInt();
            System.out.print("Select the column: ");
            int selectedCol = scanner.nextInt();
            if (selectedRow < 0 || selectedRow >= rowSize || selectedCol < 0 || selectedCol >= colSize) {
                System.out.println("You have selected an invalid location! Try again!");
                continue;
            }

            if (visited[selectedRow][selectedCol]) {
                System.out.println("You have already chosen this location! Try again!");
                continue;
            }
            visited[selectedRow][selectedCol] = true;

            if (board[selectedRow][selectedCol] == '*') {
                System.out.println("Game Over");
                board[selectedRow][selectedCol] = 'X';
                printBoard();
                break;
            } else {
                int adjacentMines = countAdjacentMines(selectedRow, selectedCol);
                board[selectedRow][selectedCol] = (char) (adjacentMines + '0');
                if (adjacentMines == 0) {
                    exploreAdjacentCells(selectedRow, selectedCol);
                }
                boolean win = checkWin();
                if (win) {
                    System.out.println("Congratulations! Win! ");
                    break;
                }
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow >= 0 && newRow < rowSize && newCol >= 0 && newCol < colSize && board[newRow][newCol] == '*') {
                count++;
            }
        }
        return count;
    }

    public void exploreAdjacentCells(int row, int col) {
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow >= 0 && newRow < rowSize && newCol >= 0 && newCol < colSize && !visited[newRow][newCol]) {
                visited[newRow][newCol] = true;
                int adjacentMines = countAdjacentMines(newRow, newCol);
                board[newRow][newCol] = (char) (adjacentMines + '0');
                if (adjacentMines == 0) {
                    exploreAdjacentCells(newRow, newCol);
                }
            }
        }
    }
    public boolean checkWin() { // Kullanıcının kazanma durumunun kontrolü yapıldı.
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (board[i][j] == '-' && !visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}