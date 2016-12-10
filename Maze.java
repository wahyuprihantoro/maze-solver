public class Maze {
	private Point start;
	private Point finish;
	private Point current;
	private Point[][] maze;
	private int height;
	private int width;

	public Maze(int w, int h) {
		maze = new Point[h][w];
	}

	public Maze(Point[][] maze) {
		this.maze = maze;
		height = maze.length;
		width = maze[0].length;
	}

	public boolean moveUp() {
		int x = current.getX();
		int y = current.getY() - 1;
		if (y > 0) {
			Point p = getPoint(x, y);
			if (p.canVisit()) {
				p.setAsVisited();
				current = p;
				System.out.println("up");
				return true;
			}
		}
		return false;
	}

	public boolean moveDown() {
		int x = current.getX();
		int y = current.getY() + 1;
		if (y < height) {
			Point p = getPoint(x, y);
			//System.out.println(p.toString());
			if (p.canVisit()) {
				p.setAsVisited();
				current = p;
				System.out.println("down");
				return true;
			}
		}
		return false;
	}

	public boolean moveRight() {
		int x = current.getX() + 1;
		int y = current.getY();
		if (x < width) {
			Point p = getPoint(x, y);
			if (p.canVisit()) {
				p.setAsVisited();
				current = p;
				System.out.println("right");
				return true;
			}
		}
		return false;
	}

	public boolean moveLeft() {
		int x = current.getX() - 1;
		int y = current.getY();
		if (x > 0) {
			Point p = getPoint(x, y);
			if (p.canVisit()) {
				p.setAsVisited();
				current = p;
				System.out.println("left");
				return true;
			}
		}
		return false;
	}

	public Point getCurrent() {
		return current;
	}

	public void setCurrent(Point current) {
		this.current = current;
	}

	public void setCurrent(int x, int y) {
		this.current = maze[y][x];
		current.setAsVisited();
	}

	public Point getPoint(int x, int y) {
		return maze[x][y];
	}

	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public Point getFinish() {
		return finish;
	}

	public void setFinish(Point finish) {
		this.finish = finish;
	}

	public Point[][] getMaze() {
		return maze;
	}

	public void setMaze(Point[][] maze) {
		this.maze = maze;
	}

	public boolean isGoal() {
		return current.getX() == finish.getX() && current.getY() == finish.getY();
	}
}
