public class RobotMonitor {

    // Enumeration for the possible moves of the robot
    enum Move {
        LEFT, RIGHT, UP, DOWN
    }

    // Maximum and minimum row and column values
    public static final int MAX = 6;
    public static final int MIN = 1;

    // Current row and column values
    private int row;

    // Current column value
    private int col;

    // Last move made by the robot
    private Move lastMove;

    /**
     * Constructor for initialization
     */
    public RobotMonitor() {
        this.row = MIN;
        this.col = MIN;
        this.lastMove = null;
    }

    /**
     * Invariant check to ensure the robot is within the valid range
     * @return true if the robot is within the valid range, false otherwise
     */
    public boolean inv() {
        return (row >= MIN && row <= MAX) && (col >= MIN && col <= MAX);
    }

    /**
     * Get the current column value
     * @return the current column value
     */
    public int GetCol() {
        return this.col;
    }

    /**
     * Get the current row value
     * @return the current row value
     */
    public int GetRow() {
        return this.row;
    }

    /**
     * Get the last move made by the robot
     * @return the last move made by the robot
     */
    public Move GetMove() {
        return this.lastMove;
    }

    /**
     * Move the robot to the right
     * @throws VDMException if the precondition is broken
     */
    public void MoveRight() {
        if (col >= MAX || lastMove == Move.RIGHT) {
            throw new VDMException("precondition broken");
        }
        col++;
        lastMove = Move.RIGHT;
        assert inv();
    }

    /**
     * Move the robot to the left
     * @throws VDMException if the precondition is broken
     */
    public void MoveLeft() {
        if (col <= MIN || lastMove == Move.LEFT) {
            throw new VDMException("precondition broken");
        }
        col--;
        lastMove = Move.LEFT;
        assert inv();
    }

    /**
     * Move the robot down
     * @throws VDMException if the precondition is broken
     */
    public void MoveDown() {
        if (row >= MAX || lastMove == Move.DOWN) {
            throw new VDMException("precondition broken");
        }
        row++;
        lastMove = Move.DOWN;
        assert inv();
    }

    /**
     * Move the robot up
     * @throws VDMException if the precondition is broken
     */
    public void MoveUp() {
        if (row <= MIN || lastMove == Move.UP) {
            throw new VDMException("precondition broken");
        }
        row--;
        lastMove = Move.UP;
        assert inv();
    }

    /**
     * Exit the robot at the maximum row and column values
     * @throws VDMException if the precondition is broken
     */
    public void Exit() {
        if (row!= MAX || col!= MAX) {
            throw new VDMException("precondition broken");
        }
        row = MIN;
        col = MIN;
        lastMove = null;
        assert inv();
    }

    /**
     * Override the toString method to provide a string representation of the robot's position and last move
     * @return a string representation of the robot's position and last move
     */
    @Override
    public String toString() {
        return String.format("Robot Position: (%d, %d). Last Move: %s", row, col, lastMove!= null? lastMove : "None");
    }
}