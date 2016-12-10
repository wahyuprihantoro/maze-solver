import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFSMazeSolver extends MazeSolver {

	private Point goal;
	private Queue<Point> q = new LinkedList<Point>();

	public BFSMazeSolver(Maze maze) {
		super(maze);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean solve() {
		// TODO Auto-generated method stub
		goal = findPath(this.getMaze().getStart());
		return goal != null;
	}

	public Point findPath(Point p) {
		Maze m = this.getMaze();
		m.setCurrent(p);
		q.add(p);
		while (!q.isEmpty()) {
			Point pt = q.remove();
//			System.out.println(pt.toString());
			int x = pt.getX();
			int y = pt.getY();
			m.setCurrent(pt);
			pt.setAsVisited();
			if (m.isGoal()) {
				return m.getCurrent();
			}

			Point next = m.getPoint(x - 1, y);
//			System.out.println(next.toString());
			if (next.canVisit()) {
				next.setPrev(pt);
				q.add(next);
			}
			next = m.getPoint(x + 1, y);
			if (next.canVisit()) {
				next.setPrev(pt);
				q.add(next);
			}
			next = m.getPoint(x, y + 1);
			if (next.canVisit()) {
				next.setPrev(pt);
				q.add(next);
			}
			next = m.getPoint(x, y - 1);
			if (next.canVisit()) {
				next.setPrev(pt);
				q.add(next);
			}
		}
		return null;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		Set<Point> set = new HashSet<>();
		Point path = goal;
		while (path != null) {
			set.add(path);
			path = path.getPrev();
		}
		Maze m = this.getMaze();
		for (int i = 0; i < m.getMaze().length; i++) {
			for (int j = 0; j < m.getMaze()[0].length; j++) {
				if (set.contains(m.getPoint(i, j))) {
					System.out.print('*');
					Point.pathCount++;
				} else {
					if (m.getPoint(i, j).isVisited()) {
						System.out.print("v");
						Point.visitedCount++;
					} else {
						System.out.print(m.getPoint(i, j).getValue());						
					}
				}
			}
			System.out.println();
		}
	}

}
