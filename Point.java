public class Point {
	public static final char WALL = '#';
	public static final char EMPTY = ' ';
	public static final char PATH = '*';
	public static final char VISITED = 'v';
	public static final char START = 'S';
	public static final char FINISH = 'F';
	public static int pathCount;
	public static int visitedCount;
	
	private boolean isVisited;
	private int x;
	private int y;
	private char value;
	private Point prev;

	public Point(int x, int y, char value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}

	public boolean canVisit() {
		return !isWall() && !isVisited();
	}

	public boolean isWall() {
		return value == WALL;
	}

	public boolean isEmpty() {
		return value == EMPTY;
	}

	public boolean isStart() {
		return value == START;
	}

	public boolean isFinish() {
		return value == FINISH;
	}

	public boolean isPath() {
		return value == PATH;
	}

	public boolean isVisited() {
		return this.isVisited;
	}

	public void setAsWall() {
		value = WALL;
	}

	public void setAsEmpty() {
		value = EMPTY;
	}

	public void setAsStart() {
		value = START;
	}

	public void setAsFinish() {
		value = FINISH;
	}

	public void setAsPath() {
		value = PATH;
	}

	public void setAsVisited() {
		setVisited(true);
//		setFlag(++visited);
//		lastVisit = this;
//		System.out.println(toString());
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Point getPrev() {
		return prev;
	}

	public void setPrev(Point prev) {
		this.prev = prev;
	}
	

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Point o = (Point) obj;
		return x == o.getX() && y == o.getY();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return x + " " + y;
	}

}