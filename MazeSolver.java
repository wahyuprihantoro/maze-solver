public abstract class MazeSolver {
	private Maze maze;

	public MazeSolver(Maze maze) {
		this.maze = maze;
	}

	public Maze getMaze() {
		return maze;
	}

	public void setMaze(Maze maze) {
		this.maze = maze;
	}

	public abstract boolean solve();

	public void print() {
		Point[][] maze = this.getMaze().getMaze();
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++) {
				Point p = maze[i][j];
				if (p.isPath()) {
					System.out.print('*');
					Point.pathCount++;
				} else if (p.isVisited()) {
					System.out.print('v');
					Point.visitedCount++;
				} else {
					System.out.print(p.getValue());
				}
			}
			System.out.println();
		}
	}

	public boolean isSolved() {
		return maze.isGoal();
	}
}
