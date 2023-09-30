public class RabbitChallenge {

    public static void main(String[] args) {
        int[][] garden = {
                {1, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 1, 1, 0, 1},
                {0, 0, 0, 0, 1},
                {1, 1, 1, 0, 0}
        };

        int jumps = countJumpsToCollectCarrots(garden);
        System.out.println("The rabbit needs " + jumps + " jumps to collect all carrots.");
    }

    public static int countJumpsToCollectCarrots(int[][] garden) {
        int jumps = 0;
        int rows = garden.length;
        int cols = garden[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (garden[i][j] == 1) {
                    jumps++;
                    jumpToNextGroup(garden, i, j);
                }
            }
        }

        return jumps;
    }

    public static void jumpToNextGroup(int[][] garden, int row, int col) {
        int rows = garden.length;
        int cols = garden[0].length;

        garden[row][col] = 0;

        if (row > 0 && garden[row - 1][col] == 1) {
            jumpToNextGroup(garden, row - 1, col);
        }
        if (row < rows - 1 && garden[row + 1][col] == 1) {
            jumpToNextGroup(garden, row + 1, col);
        }
        if (col > 0 && garden[row][col - 1] == 1) {
            jumpToNextGroup(garden, row, col - 1);
        }
        if (col < cols - 1 && garden[row][col + 1] == 1) {
            jumpToNextGroup(garden, row, col + 1);
        }
    }
}
