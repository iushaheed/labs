/*
problem statement:
#####################
Problem: Suppose you have an intelligent robot which will explore a 2D maze.
The robot will have a map to learn about the maze.
Before we go into any further, have a look how your helpless robot is placed 
in this scary maze.

given matrix
  
0 0 1 0 8 
1 0 0 0 0 
0 1 0 1 0 
0 5 0 0 0 
0 0 0 1 0 
1 0 0 0 0

Matrix grammar:
in matrix 

5 for robot(start point)
0 for free (robot can go through these)
1 for block (robot cant pass through these)
8 for home(home, End point)


now run DFS

author: ush 
iushaheed@gmail.com
www.teambinary.net
 */ 


import java.util.Scanner;
import java.awt.Point;

public class DFS {
	static int[][] matrix;
	static int[][] visited;
	static int robotX;
	static int robotY;
	static int homeX;
	static int homeY;
	static int cost;
	static int currentNodeX;
	static int currentNodeY;
	static int matrixRow;
	static int matrixCol;
	static boolean reachedHome=false;


	public static void main(String[] args) {
		Scanner AI = new Scanner(System.in);

		// initializing matrix (by default each position is 0)
		System.out.println("matrix dimention please. example : 6 5");
		matrixRow = 6;//AI.nextInt();
		matrixCol = 5;//AI.nextInt();
		matrix = new int[matrixRow][matrixCol];
		visited = new int[matrixRow][matrixCol];
		// taking robot position input//initializing robot position in matrix
		// with 5
		System.out.println("robot position please. example : 3 1");
		robotX = 3;//AI.nextInt();
		robotY = 1;//AI.nextInt();
		matrix[robotX][robotY] = 5;
		System.out.println("robot position : (" + robotX + "," + robotY + ")");
		// taking home position input//initializing home position in matrix wiht
		// 8
		System.out.println("home position please. example : 0 4");
		homeX = 0;//AI.nextInt();
		homeY = 4;//AI.nextInt();
		matrix[homeX][homeY] = 8;
		System.out.println("home position : (" + homeX + "," + homeY + ")");
		// taking total block number //taking block position input
		// //initializing block position in matrix with 1

		System.out.println("Total number of block");
		int totalBlock = AI.nextInt();
		System.out.println("total block: "+totalBlock);

		for (int c = 0; c < totalBlock; c++) {
			int temporaryblockX = AI.nextInt();
			int temporaryblockY = AI.nextInt();
			matrix[temporaryblockX][temporaryblockY] = 1;
		}

		// printing the whole matrix
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println("Matrix grammer:\n0 for free\n1 for block\n5 for robot\n8 for home");

		// ////////////////////////////////////////////////////
		// ///////////////// input done ///////////////////////
		// ////////////////////////////////////////////////////



		visited[robotX][robotY] = 1;
		DFS(robotX,robotY);
		System.out.println("DFS COST :" + cost);
	}

	// DFS sequence left-up-right-down
	
	static void DFS(int botX, int botY) {
		
		if(botX==homeX && botY==homeY){
			System.out.println("Home!!! ;) ");
			reachedHome=true;
			return;
		}
		
		if (canGoLeft(botX, botY) && !reachedHome) 
		{
			cost++;
			System.out.println(botX+","+(botY-1));
			visited[botX][botY-1] = 1;
			DFS(botX,botY-1);

		}
		if (canGoUp(botX,botY) && !reachedHome) 
		{
			cost++;
			System.out.println((botX-1)+","+botY);
			visited[botX-1][botY] = 1;
			DFS(botX-1,botY);

		}
		if (canGoRight(botX, botY) && !reachedHome) 
		{
			cost++;
			System.out.println(botX+","+(botY+1));
			visited[botX][botY+1] = 1;
			DFS(botX,botY+1);
		}
		if (canGoDown(botX, botY) && !reachedHome)
		{
			cost++;
			System.out.println((botX+1)+","+botY);
			visited[botX+1][botY] = 1;
			DFS(botX+1,botY);
		}

	}

	static boolean canGoLeft(int x, int y) {

		if (isYvalid(y-1))
		{
			if (matrix[x][y - 1] == 1 || visited[x][y - 1] == 1) {
				return false;
			}
			else
				return true;
		}
		return false;

		// out of matrix that's why exception...so can't visit;
	}

	static boolean canGoUp(int x, int y) {
		//		
		if (isXvalid(x-1))
		{
			if (matrix[x - 1][y] == 1 || visited[x - 1][y] == 1) {
				return false;
			}
			return true;
		}
		return false;
	}

	static boolean canGoRight(int x, int y) {

		if (isYvalid(y+1))
		{
			if (matrix[x][y + 1] == 1 || visited[x][y + 1] == 1) {
				return false;
			}
			return true;
		}
		return false;
	}

	static boolean canGoDown(int x, int y) {

		if (isXvalid(x+1))
		{
			if (matrix[x + 1][y] == 1 || visited[x + 1][y] == 1)
			{
				return false;
			}
			return true;
		}
		return false;
	}
	
	

	static boolean isXvalid(int x)
	{
		if ((x <0 || x > matrixRow-1))
			return false;
		return true;

	}
	static boolean isYvalid(int y)
	{
		if ((y <0 || y > matrixCol-1))
			return false;
		return true;

	}

}
