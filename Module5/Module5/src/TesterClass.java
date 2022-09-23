import java.util.Arrays;
public class TesterClass 
{
	public static void main(String[] args) 
	{
		String[][] board = new String[3][3];
		board[0][0] = "a";
		board[0][1] = "a";
		board[0][2] = "a";
		board[1][0] = "b";
		board[1][1] = "b";
		board[1][2] = "b";
		board[2][0] = "c";
		board[2][1] = "c";
		board[2][2] = "c";
		
		System.out.print(Arrays.deepToString(board));
	}

}
