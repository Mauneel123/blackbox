
import java.util.Random;
import java.util.Scanner;

public class BlackBox {
	public static char box[][]; // The matrix for the game.
	public static int size;       // to store the number of rows and columns.
	public static int numball;
	public static int numlink;
	public static boolean end;
	public static int score;
	public static int high_score=-1;
	static Scanner o=new Scanner(System.in);
	static BlackBox b=new BlackBox();
	static int b1r,b2r,b3r,b1c,b2c,b3c;
	static int cou=0;
	static char cn='0';
	static int g1r=-1;
	static int g1c=-1;
	static int g2r =-1;
	static int g2c=-1;
	static int g3r=-1;
	static int g3c=-1;

	public BlackBox()
	{
		this.box=new char[0][0];
		this.size=0;
		this.numball=0;
		this.numlink=0;
		this.end=false;
		this.score=0;
	}

	public BlackBox(int size, int numball, int numlink, boolean end, int score)
	{
		this.box=new char[size][size];
		this.size=size;
		this.numball=numball;
		this.numlink=numlink;
		this.end=end;
		this.score=score;
	}

	/* Main function calls all the necessary functions to make the gameplay possible*/
	public static void main(String[] args) {
		String s;
		//Random function to randomly place the atom-balls in the grid
		Random r=new Random();
		boolean stayon=true;
		do {
			System.out.println("Welcome to the Blackbox Game. Please choose the difficulty level:easy/medium/hard or quit to end the game");
			s = o.nextLine();
			if((s.equalsIgnoreCase("easy")) || (s.equalsIgnoreCase("medium")) || (s.equalsIgnoreCase("hard"))) {
				if (s.equalsIgnoreCase("easy")) {
					size = 7;
				} else if (s.equalsIgnoreCase("medium")) {
					size = 9;
				} else if (s.equalsIgnoreCase("hard")) {
					size = 10;
				}
				b.initialize();
				b.printbox();
				b.playgame();
			}

			else if (s.equalsIgnoreCase("quit")) {
				stayon=false;
				if(high_score==-1)
				{
					System.out.println(" High Score=> None ");
				}
				else
				{
					System.out.println("High Score = "+high_score);
				}

			}


		}while(stayon==true);

	}


	/* This function intializes the game and sets all the necessary items and grid formation*/
	public void initialize() {
		box=new char[size][size];
		Random r=new Random();
		for(int i=0;i<1;i++)
		{for (int j=0;j<size;j++)
		{
			if(i==j)
			{box[i][j]='X';}
			else {
				box[i][j]='#';
			}
		}
		}
		for(int i=size-1;i>size-2;i--)
		{for (int j=0;j<size;j++)
		{
			if(i==j)
			{box[i][j]='X';}
			else {
				box[i][j]='#';
			}
		}
		}
		for(int i=1;i<size-1;i++)
		{for (int j=0;j<1;j++)
		{
			if(i==j)
			{box[i][j]='X';}
			else {
				box[i][j]='#';
			}
		}
		}
		for(int i=1;i<size-1;i++)
		{for (int j=size-1;j>size-2;j--)
		{
			if(i==j)
			{box[i][j]='X';}
			else {
				box[i][j]='#';
			}
		}
		}
		box[0][size-1]='X';
		box[size-1][0]='X';
		for(int i=1;i<size-1;i++)
		{
			for (int j=1;j<size-1;j++)
			{box[i][j]=' ';}}

		b1r=r.nextInt(size-2)+1;
		b2r=r.nextInt(size-2)+1;

		b1c=r.nextInt(size-2)+1;
		b2c=r.nextInt(size-2)+1;
		while(b1r == b2r && b1c==b2c) {
			b2r=r.nextInt(size-2)+1;
			b2c=r.nextInt(size-2)+1;
		}

		b3c=r.nextInt(size-2)+1;
		b3r=r.nextInt(size-2)+1;

		while((b1r==b3r && b1c==b3c) || (b2c==b3c || b2r==b3r))
		{b3c=r.nextInt(size-2)+1;
			b3r=r.nextInt(size-2)+1;}

        for(int i=1;i<size-1;i++)
		{
			for (int j=1;j<size-1;j++)

			{if ((i==b1r && j==b1c) || (i==b2r && j==b2c) || (i==b3r && j==b3c))
			{this.box[i][j]='0';}
			else
			{this.box[i][j]=' ';}

			}
		}

	}

// Function to print the grid after every move made by player
	public static void printbox() {
		for(int i=1;i<=size;i++)
		{System.out.print("  "+i);}
		System.out.print("\n");
		for(int i=0;i<=size;i++)
		{  System.out.print("===");}
		System.out.printf("\n");
		for(int i=0;i<size;i++)
		{
			System.out.print(i+1+"|");
			for (int j=0;j<size;j++)
			{
				if((g1r==i && g1c==j) || (g2r==i && g2c==j) ||(g3r==i && g3c==j)) {
					System.out.print("" + "*" + " |");
				}
				else{
					if ((i == b1r && j == b1c) || (i == b2r && j == b2c) || (i == b3r && j == b3c)) {
						System.out.print("" + " " + " |");
					} else {
						System.out.print("" + box[i][j] + " |");
					}

				}}
			System.out.print("\n");
		}
		for(int i=0;i<=size;i++)
		{  System.out.print("===");}
		// for  5*5 example
		/* 1  2  3  4  5  6  7
		 ======================
		1|X |# |# |# |# |# |X |
		2|# |  |  |  |  |  |# |
		3|# |  |  |  |  |  |# |
		4|# |  |  |  |  |  |# |
		5|# |  |  |  |  |  |# |
		6|# |  |  |  |  |  |# |
		7|X |# |# |# |# |# |X |
		 ======================*/

	}

    //Function to print the grid after the player wins or loses the game
	public static void printfinal() {

		for(int i=1;i<=size;i++)
		{System.out.print("  "+i);}
		System.out.print("\n");
		for(int i=0;i<=size;i++)
		{  System.out.print("===");}
		System.out.printf("\n");
		for(int i=0;i<size;i++)
		{
			System.out.print(i+1+"|");
			for (int j=0;j<size;j++)
			{
				if((g1r==i && g1c==j) || (g2r==i && g2c==j) ||(g3r==i && g3c==j)) {
					System.out.print("" + "*" + " |");
				}
				else{
					System.out.print(""+box[i][j]+" |");}
			}
			System.out.print("\n");
		}
		for(int i=0;i<=size;i++)
		{  System.out.print("===");}
		// for  5*5 example
		/* 1  2  3  4  5  6  7
		 ======================
		1|X |# |# |# |# |# |X |
		2|# |  |  |  |  |  |# |
		3|# |  |  |  |  |  |# |
		4|# |  |  |  |  |  |# |
		5|# |  |  |  |  |  |# |
		6|# |  |  |  |  |  |# |
		7|X |# |# |# |# |# |X |
		 ======================*/

	}
    
    // playgame() is Main controller of the game which calls different methods to check if the rays hit atoms
	public static void playgame() {

		int gg=0;int co=0;
		while(gg==0) {
			String in1, in2, in3;

			System.out.println("\nChoose the new Coordinates (row,column) to play the next step or say submit/quit to end the game: ");
			in1 = o.nextLine();
			if(in1.equalsIgnoreCase("quit")){gg=1;}
			else if(in1.equalsIgnoreCase("submit"))
			{
				if(numball<3)
				{
					System.out.println("Please place all guess-balls");
				}

				else {
					for (int r = 0; r < size - 1; r++) {
						for (int c = 0; c < size - 1; c++) {

							if (box[r][c] == '0') {
								if ((r == g1r && c == g1c) || (r == g2r && c == g2c) || (r == g3r && c == g3c)) {
									co++;
								}
							}
						}}
					if(co==3)
					{
						b.printfinal();
						System.out.println("");
						System.out.println("Thank you for playing the game.Your score is :"+score);
						gg=1;
						if(high_score==-1)
						{high_score=score;}
						else if(high_score>score)
						{high_score=score;}

						numball=0;
						cou=0;
						g1c=-1;
						g1r=-1;
						g2c=-1;
						g2r=-1;
						g3r=-1;
						g3c=-1;
						cn='0';
						score=0;
					}
					else {

						b.printfinal();
						System.out.println("");
						System.out.println(" Fail ");gg=1;
						numball=0;
						cou=0;
						g1c=-1;
						g1r=-1;
						g2c=-1;
						g2r=-1;
						g3r=-1;
						g3c=-1;
						cn='0';
						score=0;
					}



				}}
			else{
				int id=in1.indexOf(",");
				int len=in1.length();
				int r1 = Integer.parseInt(in1.substring(0, id));
				int c1 = Integer.parseInt(in1.substring(id+1,len));
				check(r1-1, c1-1);


				b.printbox();
			}}

	}
	/**
	 * The check funtion takes in the row and column in the matrix, checks for Hit (H), Reflection (R) or Divergence(#num)
	 *
	 */
	public static void check(int i,int j) {

		if(i<0 || j<0 || i>size-1 || j>size-1 || (i==0 && j==0) || (i==size-1 && j==size-1) || (i==size-1 && j==0) || (i==0 && j==size-1))
		{
			System.out.println(" Invalid input ");
		}

		else if((i>0 && i<size-1) && (j>0 && j<size-1))
		{
			score++;
			cou++;
			if(cou==1)
			{g1r=i;
				g1c=j;
				numball++;}
			else if(cou==2)
			{g2c=j;g2r=i;
				numball++;}
			else if(cou==3)
			{
				g3r=i;g3c=j;numball++;
			}
			else {
				System.out.println("You cannot put any other balls");
			}

		}
		else if(i==0 || j==0 || i==size-1 || j==size-1)
		{
			score++;
			if(j==0)
			{
				for(int c=0;c<size-1;c++)
				{
					if(box[i][c+1]=='0')
					{
						boolean h = b.hitcheck(i, j);
						if (h == true) {
							box[i][j] = 'H';
						}break;
					}
					else if(box[i+1][1]=='0' || box[i-1][1]=='0' || (box[i+1][c+1]=='0' && box[i-1][c+1]=='0'))
					{
						boolean r = b.reflectionCheck(i, j);
						if (r == true) {
							box[i][j] = 'R';
						}break;
					}
					else if(box[i-1][c+1]=='0' || box[i+1][c+1]=='0')
					{cn++;
						boolean as = b.deflectionCheck(i, j);
						if (as == true) {

							box[i][j] = cn;
						}break;

					}

				}
			}
			if(j==size-1)
			{
				for(int c=size-1;c>0;c--)
				{
					if(box[i][c-1]=='0')
					{
						boolean h = b.hitcheck(i, j);
						if (h == true) {
							box[i][j] = 'H';
						}break;
					}
					else if(box[i+1][size-2]=='0' || box[i-1][size-2]=='0'|| (box[i+1][c-1]=='0' && box[i-1][c-1]=='0'))
					{
						boolean r = b.reflectionCheck(i, j);
						if (r == true) {
							box[i][j] = 'R';
						}break;
					}
					else if(box[i-1][c-1]=='0' || box[i+1][c-1]=='0')
					{cn++;
						boolean as = b.deflectionCheck(i, j);
						if (as == true) {
							box[i][j] = cn;
						}break;
					}

				}
			}

			if(i==0)
			{
				for(int r=0;r<size-1;r++)
				{
					if(box[r+1][j]=='0')
					{
						boolean h = b.hitcheck(i, j);
						if (h == true) {
							box[i][j] = 'H';
						}break;
					}
					else if(box[1][j-1]=='0' || box[1][j+1]=='0' || (box[r+1][j+1]=='0' && box[r+1][j-1]=='0'))
					{
						boolean r1 = b.reflectionCheck(i, j);
						if (r1 == true) {
							box[i][j] = 'R';
						}break;
					}
					else if(box[r+1][j-1]=='0' || box[r+1][j+1]=='0')
					{cn++;
						boolean as = b.deflectionCheck(i, j);
						if (as == true) {

							box[i][j] =cn;
						}break;
					}
				}
			}

			if(i==size-1)
			{
				for(int r=size-1;r>0;r--)
				{
					if(box[r-1][j]=='0')
					{
						boolean h = b.hitcheck(i, j);
						if (h == true) {
							box[i][j] = 'H';
						}break;
					}
					else if(box[size-2][j-1]=='0' || box[size-2][j+1]=='0' || (box[r-1][j+1]=='0' && box[r-1][j-1]=='0'))
					{
						boolean r1 = b.reflectionCheck(i, j);
						if (r1 == true) {
							box[i][j] = 'R';
						}break;
					}
					else if(box[r-1][j-1]=='0' || box[r-1][j+1]=='0')
					{cn++;
						boolean as = b.deflectionCheck(i, j);
						if (as == true) {

							box[i][j] = cn;
						}break;
					}

				}
			}

		}

		boolean ac = b.straightRay(i, j);
		if (ac == true) {

		}
		box[0][0]='X';
		box[0][size-1]='X';
		box[size-1][0]='X';
		box[size-1][size-1]='X';
	}


	/**
	 * The hitcheck funtion takes in the row and column in the matrix, checks for Hit (H)
	 *
	 */
	public boolean hitcheck(int i,int j) {
		//todo: check if the ray causes a HIT as defined in the handout



		if((i==b1r || j==b1c) || (i==b2r || j==b2c) || (i==b3r || j==b3c )){

			return true;
		}
		else{return false;}
	}
	/**
	 * The check funtion takes in the row and column in the matrix, checks for Reflection (R)
	 *
	 */
	public boolean reflectionCheck(int i,int j) {
		boolean z1=false;
		if(j==0)
		{
			for(int c=0;c<size-1;c++) {
				if (box[i+1][1]=='0')
				{
					box[i+2][0]='R';z1=true;
				}
				if(box[i-1][0]=='0')
				{
					box[i-2][0]='R';z1=true;
				}
				if(box[i+1][c+1]=='0' && box[i-1][c+1]=='0')
				{
					z1=true;
				}
			}
		}

		if(j==size-1)
		{
			for(int c=size-1;c>0;c--)
			{
				if(box[i+1][size-2]=='0')
				{
					box[i+2][size-1]='R';z1=true;
				}
				if(box[i-1][size-2]=='0')
				{
					box[i-2][size-1]='R';z1=true;
				}
				if(box[i+1][c-1]=='0' && box[i-1][c-1]=='0')
				{
					z1=true;
				}
			}
		}

		if (i == 0) {
			for(int r=0;r<size-1;r++)
			{
				if(box[1][j-1]=='0')
				{
					box[0][j-2]='R';z1=true;
				}
				if(box[1][j+1]=='0')
				{
					box[0][j+2]='R';z1=true;
				}
				if(box[r+1][j+1]=='0' && box[r+1][j-1]=='0')
				{
					z1=true;
				}
			}
		}

		if(i==size-1)
		{
			for(int r=size-1;r>0;r--)
			{
				if(box[size-2][j-1]=='0')
				{box[size-1][j-2]='R';z1=true;}
				if(box[size-2][j+1]=='0')
				{box[size-1][j+2]='R';z1=true;}
				if(box[r-1][j+1]=='0' && box[r-1][j-1]=='0')
				{z1=true;}

			}
		}




		return z1;
	}
	/**
	 * The check funtion takes in the row and column in the matrix, checks for Divergence(#num)
	 */
	public boolean deflectionCheck(int i,int j) {

		Boolean z=false;

		if(j==0)
		{
			for(int c=1;c<size-1;c++)
			{
				if(box[i-1][c+1]=='0')
				{box[size-1][c]=cn;z=true;break;}
				else if(box[i+1][c+1]=='0')
				{box[0][c]=cn;z=true;break;}

			}
		}

		if(j==size-1)
		{
			for(int c=size-2;c>0;c--)
			{
				if(box[i-1][c-1]=='0')
				{
					box[size-1][c]=cn;z=true;break;
				}
				else if(box[i+1][c-1]=='0')
				{
					box[0][c]=cn;z=true;break;
				}
			}
		}

		if(i==0)
		{
			for(int r=1;r<size-2;r++)
			{
				if(box[r+1][j-1]=='0')
				{
					box[r][size-1]=cn;z=true;break;
				}
				else if(box[r+1][j+1]=='0')
				{
					box[r][0]=cn;z=true;break;
				}

			}
		}

		if(i==size-1)
		{
			for(int r=size-1;r>0;r--)
			{
				if(box[r-1][j-1]=='0')
				{
					box[r][size-1]=cn;z=true;break;
				}

				else if(box[r-1][j+1]=='0')
				{
					box[r][0]=cn;z=true;break;
				}
			}
		}

		return z;
	}
    /**
	 * The straightRay function takes in the row and column in the matrix, checks for Straight ray
	 */
	public boolean straightRay(int i,int j){
		boolean cc2=false;
		if(j==0)
		{
			for(int c=1;c<size-1;c++)
			{
				if(box[i-1][c+1]=='0' || (box[i+1][c+1]=='0'))
				{cc2=true;}

			}
		}
		if(j==size-1)
		{
			for(int c=size-2;c>0;c--)
			{
				if(box[i-1][c-1]=='0' || (box[i+1][c-1]=='0'))
				{
					cc2=true;
				}
			}
		}


		if(i==0)
		{
			for(int r=1;r<size-2;r++)
			{
				if(box[r+1][j-1]=='0' || (box[r+1][j+1]=='0'))
				{
					cc2=true;
				}

			}
		}

		if(i==size-1)
		{
			for(int r=size-1;r>0;r--)
			{
				if(box[r-1][j-1]=='0' || (box[r-1][j+1]=='0'))
				{
					cc2=true;}
			}
		}

		boolean cc1=b.hitcheck(i,j);

		boolean cc3=b.reflectionCheck(i,j);
		boolean z=false;
		if(cc1==false && cc2==false  && cc3==false)
		{
			cn++;
			z=true;

			if (i==0)
			{
				box[size-1][j]=cn;
				box[i][j] = cn;
			}
			if(i==size-1)
			{box[0][j]=cn;box[i][j] = cn;}
			if(j==0)
			{
				box[i][size-1]=cn;
				box[i][j] = cn;
			}
			if(j==size-1)
			{
				box[i][0]=cn;box[i][j] = cn;
			}

		}
		return cc2;
	}

	public char[][] getbox()
	{


		return box;
	}
	public int getscore() {return this.score;

	}
	public int getNumball() {return 0;

	}
	public int getNumlink() {return cou;

	}
	public boolean getend() {return false;

	}
	public void setbox(char box[][]) {
		this.box=box;

	}
	public void setSize(int size){
	}
	public void setNumball(int Numball) {

	}
	public void setNumlink(int Numlink) {

	}
	public void setEnd(boolean end) {

	}
	public void setScore(int score) {this.score=score;

	}
}
