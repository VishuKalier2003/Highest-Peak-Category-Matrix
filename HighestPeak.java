/* You are given an integer matrix isWater of size m x n that represents a map of land and water cells.
1)- If isWater[i][j] == 0, cell (i, j) is a land cell.
2)- If isWater[i][j] == 1, cell (i, j) is a water cell.
You must assign each cell a height in a way that follows these rules:
1)- The height of each cell must be non-negative.
2)- If the cell is a water cell, its height must be 0.
3)- Any two adjacent cells must have an absolute height difference of at most 1. A cell is adjacent to another cell 
if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).
Find an assignment of heights such that the maximum height in the matrix is maximized. Return the maximum height in
the given Map.
* Eg 1 : grid = [[0,1],[1,0]]                                   Output = 2 
* Eg 2 : grid = [[0,0,1],[1,0,0],[0,0,0]]                       Output = 2 
*/
import java.util.*;
public class HighestPeak
{
      public int HighestPeakOfLand(int grid[][])
      {
            if((grid.length == 0) && (grid[0].length == 0)) return -1;    // Base condition...
            Vector<int[]> water = new Vector<int[]>();    // Creating a Vector to store Coordinates of Water cells...
            int answer[][] = new int[grid.length][grid[0].length];     //*  Matrix Declaration -> O(N x M)
            int index = 0;
            for(int i = 0; i < grid.length; i++)    //! Grid Traversal -> O(N x M)
            {
                  for(int j = 0; j < grid[0].length; j++)
                  {
                        if(grid[i][j] == 1)    // If a water cell is found...
                        {
                              water.add(index, new int[]{i, j});   // Store its coordinates in the vector...
                              index++;     // Increment the vector index...
                        }
                  }
            }
            int Max = Integer.MIN_VALUE;    //* Variable Declaration -> O(1)
            for(int i = 0; i < grid.length; i++)      //! Grid Traversal -> O(N x M)
            {
                  for(int j = 0; j < grid[0].length; j++)
                  {
                        int Min = Integer.MAX_VALUE;
                        for(int k = 0; k < water.size(); k++)     //! Vector Traversal -> O(k)
                              Min = Math.min(Min, Math.abs(i - (water.get(k)[0]) + Math.abs(j - water.get(k)[1])));
                        // For current cell, finding the minimum distance of water which will determine the cell height...
                        answer[i][j] = Min;           // Storing it in the answer...
                        Max = Math.max(Max, Min);     // Taking the Maximum of the Minimum distance, the Max Height...
                  }
            }
            System.out.println("The Maxtrix formed : ");
            for(int i = 0; i < answer.length; i++)     //! Grid Traversal -> O(N x M)
            {
                  for(int j = 0; j < answer[0].length; j++)
                        System.out.print(answer[i][j]+", ");
                  System.out.println();
            }
            return Max;
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int row, col;
            System.out.print("Enter number of Rows : ");
            row = sc.nextInt();
            System.out.print("Enter number of Columns : ");
            col = sc.nextInt();
            int grid[][] = new int[row][col];
            for(int i = 0; i < grid.length; i++)
            {
                  for(int j = 0; j < grid[0].length; j++)
                  {
                        System.out.print("Enter value of "+(i+1)+" row and "+(j+1)+" column : ");
                        grid[i][j] = sc.nextInt();
                  }
            }
            HighestPeak highestPeak = new HighestPeak();     // Object creation...
            System.out.println("The Maximum Height of Land Possible : "+highestPeak.HighestPeakOfLand(grid));
            sc.close();
      }
}



//! Time Complexity -> O(N x M x k)
//* Space Complexity -> O(N x M)