
public class WallFollowerMazeSolver extends MazeSolver {
	public static final int UP = 1;
	public static final int RIGHT = 2;
	public static final int DOWN = 3;
	public static final int LEFT = 4;
	public static int pathLength;

	public static int visited;

	public static int direction;

	public WallFollowerMazeSolver(Maze maze) {
		super(maze);
		direction = UP;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean solve() {
		// TODO Auto-generated method stub
		// return find(LEFT);
		return findLoop();
	}

	public boolean find(int direction) {
		Maze m = this.getMaze();
		Point p = m.getCurrent();
		p.setAsVisited();
		int x = p.getX();
		int y = p.getY();
		if (m.isGoal()) {
			return true;
		}
		Point next = null;
		if (direction == UP) {
			if (!(next = m.getPoint(x, y + 1)).isWall()) {
				m.setCurrent(next);
				return find(RIGHT);
			} else if (!(next = m.getPoint(x - 1, y)).isWall()) {
				m.setCurrent(next);
				return find(UP);
			} else if (!(next = m.getPoint(x, y - 1)).isWall()) {
				m.setCurrent(next);
				return find(LEFT);
			} else if (!(next = m.getPoint(x + 1, y)).isWall()) {
				m.setCurrent(next);
				return find(DOWN);
			}

		} else if (direction == RIGHT) {
			if (!(next = m.getPoint(x + 1, y)).isWall()) {
				m.setCurrent(next);
				return find(DOWN);
			} else if (!(next = m.getPoint(x, y + 1)).isWall()) {
				m.setCurrent(next);
				return find(RIGHT);
			} else if (!(next = m.getPoint(x - 1, y)).isWall()) {
				m.setCurrent(next);
				return find(UP);
			} else if (!(next = m.getPoint(x, y - 1)).isWall()) {
				m.setCurrent(next);
				return find(LEFT);
			}
		} else if (direction == DOWN) {
			if (!(next = m.getPoint(x, y - 1)).isWall()) {
				m.setCurrent(next);
				return find(LEFT);
			} else if (!(next = m.getPoint(x + 1, y)).isWall()) {
				m.setCurrent(next);
				return find(DOWN);
			} else if (!(next = m.getPoint(x, y + 1)).isWall()) {
				m.setCurrent(next);
				return find(RIGHT);
			} else if (!(next = m.getPoint(x - 1, y)).isWall()) {
				m.setCurrent(next);
				return find(UP);
			}
		} else {
			if (!(next = m.getPoint(x - 1, y)).isWall()) {
				m.setCurrent(next);
				return find(UP);
			} else if (!(next = m.getPoint(x, y - 1)).isWall()) {
				m.setCurrent(next);
				return find(LEFT);
			} else if (!(next = m.getPoint(x + 1, y)).isWall()) {
				m.setCurrent(next);
				return find(DOWN);
			} else if (!(next = m.getPoint(x, y + 1)).isWall()) {
				m.setCurrent(next);
				return find(RIGHT);
			}
		}
		return false;
	}

	public boolean findLoop() {
		int dir = UP;
		boolean flag = false;
		while (!flag) {
			Maze m = this.getMaze();
			Point p = m.getCurrent();
			pathLength++;
			p.setAsVisited();
			int x = p.getX();
			int y = p.getY();
			if (m.isGoal()) {
				return true;
			}
			Point next = null;
			if (dir == UP) {
				if (!(next = m.getPoint(x, y + 1)).isWall()) {
					m.setCurrent(next);
					dir = (RIGHT);
				} else if (!(next = m.getPoint(x - 1, y)).isWall()) {
					m.setCurrent(next);
					dir = (UP);
				} else if (!(next = m.getPoint(x, y - 1)).isWall()) {
					m.setCurrent(next);
					dir = (LEFT);
				} else if (!(next = m.getPoint(x + 1, y)).isWall()) {
					m.setCurrent(next);
					dir = (DOWN);
				}

			} else if (dir == RIGHT) {
				if (!(next = m.getPoint(x + 1, y)).isWall()) {
					m.setCurrent(next);
					dir = (DOWN);
				} else if (!(next = m.getPoint(x, y + 1)).isWall()) {
					m.setCurrent(next);
					dir = (RIGHT);
				} else if (!(next = m.getPoint(x - 1, y)).isWall()) {
					m.setCurrent(next);
					dir = (UP);
				} else if (!(next = m.getPoint(x, y - 1)).isWall()) {
					m.setCurrent(next);
					dir = (LEFT);
				}
			} else if (dir == DOWN) {
				if (!(next = m.getPoint(x, y - 1)).isWall()) {
					m.setCurrent(next);
					dir = (LEFT);
				} else if (!(next = m.getPoint(x + 1, y)).isWall()) {
					m.setCurrent(next);
					dir = (DOWN);
				} else if (!(next = m.getPoint(x, y + 1)).isWall()) {
					m.setCurrent(next);
					dir = (RIGHT);
				} else if (!(next = m.getPoint(x - 1, y)).isWall()) {
					m.setCurrent(next);
					dir = (UP);
				}
			} else {
				if (!(next = m.getPoint(x - 1, y)).isWall()) {
					m.setCurrent(next);
					dir = (UP);
				} else if (!(next = m.getPoint(x, y - 1)).isWall()) {
					m.setCurrent(next);
					dir = (LEFT);
				} else if (!(next = m.getPoint(x + 1, y)).isWall()) {
					m.setCurrent(next);
					dir = (DOWN);
				} else if (!(next = m.getPoint(x, y + 1)).isWall()) {
					m.setCurrent(next);
					dir = (RIGHT);
				}
			}

		}

		return false;
	}

}
