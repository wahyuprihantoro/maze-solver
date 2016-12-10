import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Watchable;

public class Main {
	public static void main(String[] args) throws IOException {
		String input = "";
		File file = new File("C:/Users/wahyu/workspace/maze/src/400x400.maze");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String thisLine;
		while ((thisLine = br.readLine()) != null) {
			input += thisLine + "\n";
		}
		String line[] = input.split("\n");
		Point[][] maze = new Point[line.length][line[0].length()];
		Point start = null;
		Point finish = null;
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				maze[i][j] = new Point(i, j, line[i].charAt(j));
				if (maze[i][j].isStart()) {
					start = maze[i][j];
				} else if (maze[i][j].isFinish()) {
					finish = maze[i][j];
				}
			}
		}
		Maze m = new Maze(maze);
		m.setStart(start);	
		m.setFinish(finish);
		m.setCurrent(start);
//		WallFollowerMazeSolver mazeSolver = new WallFollowerMazeSolver(m);
		DFSMazeSolver mazeSolver = new DFSMazeSolver(m);
//		BFSMazeSolver mazeSolver = new BFSMazeSolver(m);

		long s = System.currentTimeMillis();
		boolean solved = mazeSolver.solve();
		long f = System.currentTimeMillis();
		if (solved) {
			mazeSolver.print();
			System.out.println(f-s);
			System.out.println("Path count: " + Point.pathCount);
			System.out.println("visited count: " + (Point.visitedCount + Point.pathCount));
			System.out.println("path length: " + (WallFollowerMazeSolver.pathLength));
//			mazeSolver.print();			
		}
	}
}
