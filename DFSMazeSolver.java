/**
 * @author Wahyu Prihantoro
 *
 */
public class DFSMazeSolver extends MazeSolver {

	public DFSMazeSolver(Maze maze) {
		super(maze);
	}

	@Override
	public boolean solve() {
		return findPath(this.getMaze().getStart().getX(), this.getMaze().getStart().getY());
	}

	public boolean findPath(int x, int y) {
		Maze m = this.getMaze();
		Point p = m.getPoint(x, y);
		m.setCurrent(m.getPoint(x, y));
		
		if (m.isGoal()) {
			p.setAsPath();
			return true;
		}
		if (!p.canVisit()) {
			return false;
		} else {
			p.setAsVisited();
			if (findPath(x - 1, y)) {
				p.setAsPath();
				return true;
			}
			if (findPath(x + 1, y)) {
				p.setAsPath();
				return true;
			}
			if (findPath(x, y + 1)) {
				p.setAsPath();
				return true;
			}
			if (findPath(x, y - 1)) {
				p.setAsPath();
				return true;
			}	
		}

		return false;
	}
}
