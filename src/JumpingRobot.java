public class JumpingRobot extends Robot {

    /**
     * Personal (jumping) robot constructor
     * @param maze
     */
    public JumpingRobot (Maze maze) {
        super(maze);
        mazeCopy.setCell(mazeCopy.getStartRow(), mazeCopy.getStartCol(), getCurrentName());
    }

    /**
     * chooses where to jump to, finds ending row and column
     * @return
     */
    public int chooseMoveDirection() {
        return mazeCopy.getEndRow();
    }

    /**
     * robot jumps to the finish
     * @param endRow
     * @return
     */
    public boolean move(int endRow) {
        boolean inMaze = false;
        setCurrentRow(endRow);
        setCurrentCol(mazeCopy.getEndCol());
        mazeCopy.setCell(mazeCopy.getStartRow(), mazeCopy.getStartCol(), 'S');
        mazeCopy.setCell(mazeCopy.getEndRow(), mazeCopy.getEndCol(), getCurrentName());
        inMaze = true;
        return inMaze;
    }
}
