
import java.util.Random;
import java.util.Scanner;



/**
 * Created by Sripath Mishra on 9/8/2017.
 *
 */
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
    /**
     * The default constructor which places default values to the class variables
     */
    public BlackBox()
    {
        this.box=new char[0][0];
        this.size=0;
        this.numball=0;
        this.numlink=0;
        this.end=false;
        this.score=0;
    }
    /**
     * The parameterized constructor which places values to the class variables
     */
    public BlackBox(int size, int numball, int numlink, boolean end, int score)
    {
        this.box=new char[size][size];
        this.size=size;
        this.numball=numball;
        this.numlink=numlink;
        this.end=end;
        this.score=score;
    }
    /**
     * The main function takes input for the difficulty level and call the functions initialize(int) and
     * playgame()
     */
    public static void main(String[] args) {
        //Todo:start the game print the welcome message and ask for correct difficulty level.
        String s;
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
        //Todo: end the game if the user says quit.
        //Todo:call the functions initialize and playgame()
        // Todo: take care of high score
    }
    /**
     * The initialize funtion
     */
    public void initialize() {


        //Todo:initialise the Box[][]
        box=new char[size][size];
        Random r=new Random();
        //Todo: place the 'X' and the '#'
        // Todo: place 3 '0''s randomly.

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

    /**
     * The printbox funtion prints out the matrix in a particular format as given in the handout.
     */
    public static void printbox() {
        //Todo:print the box in the correct order

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
        //place the guesses as the come and print the balls when the player enter sumbit.
    }
    /**
     * The playgame funtion opens the first cell and is the main controller for the game. It calls various function when needed.
     */
    public static void printfinal() {
        //Todo:print the box in the correct order

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
        //place the guesses as the come and print the balls when the player enter sumbit.
    }
    public static void playgame() {
        //Todo:Take input of a guess or hint from the user.
        //Todo:Check for valid input
        //Todo:call required functions
        //Todo:keep tab on score.
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
        //Todo:place a guess when the input of i and j are valid
        //Todo:Check for a Hit


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
           /* if(j==0)
            {for(int c=0;c<size-1;c++)
            {
                if (box[i][c+1]=='0')
                { boolean h = b.hitcheck(i, j);
                    if (h == true) {
                        box[i][j] = 'H';
                        break;
                    }
                    }
                if(box[i-1][c+1]=='0' || box[i+1][c+1]=='0')
                {
                    boolean as = b.deflectionCheck(i, j);
                    if (as == true)
                    {
                        box[i][j] = 'D';
                        break;

                    }

                }
                if(box[i-1][0]=='0' || box[i+1][0]=='0')
                {
                    boolean r = b.reflectionCheck(i, j);
                    if (r == true) {
                        box[i][j] = 'R';
                        break;
                    }
                }

            boolean h = b.hitcheck(i, j);
            if (h == true) {
                box[i][j] = 'H';
            }
            //Todo:Check for a reflection
            boolean r = b.reflectionCheck(i, j);
            if (r == true) {
                box[i][j] = 'R';
            }

           boolean as = b.deflectionCheck(i, j);
            if (as == true) {
                box[i][j] = 'D';*/
        }

        boolean ac = b.straightRay(i, j);
        if (ac == true) {

        }
        box[0][0]='X';
        box[0][size-1]='X';
        box[size-1][0]='X';
        box[size-1][size-1]='X';
    }
    //Todo:Check for a bounce
    //Todo:Print a statement telling the user they cannot place a fourth ball.

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
        //todo: check if the ray causes a Reflection as defined in the handout

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


        /*// ball 1
        if(j==0 && i-b1r==1 && b1c==1)
        {
            box[b1r-1][0]='R';z1=true;
        }
        if(j==0 && i-b1r==-1 && b1c==1)
        {
            box[b1r+1][0]='R';z1=true;
        }
        if (j==size-1 && i-b1r==1 && b1c==size-2)
        {
            box[b1r-1][size-1]='R';z1=true;
        }
        if (j==size-1 && i-b1r==-1 && b1c==size-2)
        {
            box[b1r+1][size-1]='R';z1=true;
        }
        //ball 2
        if(j==0 && i-b2r==1 && b2c==1)
        {
            box[b2r-1][0]='R';z1=true;
        }
        if(j==0 && i-b2r==-1 && b2c==1)
        {
            box[b2r+1][0]='R';z1=true;
        }
        if (j==size-1 && i-b2r==1 && b2c==size-2)
        {
            box[b2r-1][size-1]='R';z1=true;
        }
        if (j==size-1 && i-b2r==-1 && b2c==size-2)
        {
            box[b2r+1][size-1]='R';z1=true;
        }
     //ball 3
        if(j==0 && i-b3r==1 && b3c==1)
        {
            box[b3r-1][0]='R';z1=true;
        }
        if(j==0 && i-b3r==-1 && b3c==1)
        {
            box[b3r+1][0]='R';z1=true;
        }
        if (j==size-1 && i-b3r==1 && b3c==size-2)
        {
            box[b3r-1][size-1]='R';z1=true;
        }
        if (j==size-1 && i-b3r==-1 && b3c==size-2)
        {
            box[b3r+1][size-1]='R';z1=true;
        }*/

        return z1;
    }
    /**
     * The check funtion takes in the row and column in the matrix, checks for Divergence(#num)
     *
     */
    public boolean deflectionCheck(int i,int j) {

        Boolean z=false;
        //todo: check if the ray causes a Deflection as defined in the handout

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
        /*
        double d1=Math.sqrt(Math.pow((i-b1r),2)+Math.pow((j-b1c),2));
        double d2=Math.sqrt(Math.pow((i-b2r),2)+Math.pow((j-b2c),2));
        double d3=Math.sqrt(Math.pow((i-b3r),2)+Math.pow((j-b3c),2));

        if (b.hitcheck(i,j)==false){
        // ball 1
        if((d1<=d2 && d1<=d3) || Math.abs(i-b1r)==1 || Math.abs(j-b1c)==1 || Math.abs(i-b3r)==1 || Math.abs(j-b3c)==1 || Math.abs(i-b2r)==1 || Math.abs(j-b2c)==1) {
            if ((b1r - i) == 1 && j == 0) {
                box[0][b1c - 1] = 'D';
                z = true;
            } else if ((i - b1r) == 1 && j == 0) {
                box[size - 1][b1c - 1] = 'D';
                z = true;
            } else if ((b1r - i) == 1 && j == size - 1) {
                box[0][b1c + 1] = 'D';
                z = true;
            } else if ((i - b1r) == 1 && j == size - 1) {
                box[size - 1][b1c + 1] = 'D';
                z = true;
            }
        }
        // Ball 2
        if((d2<=d1 && d2<=d3) || Math.abs(i-b2r)==1 || Math.abs(j-b2c)==1 || Math.abs(i-b1r)==1 || Math.abs(j-b1c)==1 || Math.abs(i-b3r)==1 || Math.abs(j-b3c)==1) {
            if ((b2r - i) == 1 && j == 0) {
                box[0][b2c - 1] = 'D';
                z = true;
            } else if ((i - b2r) == 1 && j == 0) {
                box[size - 1][b2c - 1] = 'D';
                z = true;
            } else if ((b2r - i) == 1 && j == size - 1) {
                box[0][b2c + 1] = 'D';
                z = true;
            } else if ((i - b2r) == 1 && j == size - 1) {
                box[size - 1][b2c + 1] = 'D';
                z = true;
            }
        }
        // Ball 3
        if((d3<=d1 && d3<=d2) || Math.abs(i-b3r)==1 || Math.abs(j-b3c)==1 || Math.abs(i-b1r)==1 || Math.abs(j-b1c)==1 || Math.abs(i-b2r)==1 || Math.abs(j-b2c)==1) {
            if ((b3r - i) == 1 && j == 0) {
                box[0][b3c - 1] = 'D';
                z = true;
            } else if ((i - b3r) == 1 && j == 0) {
                box[size - 1][b3c - 1] = 'D';
                z = true;
            } else if ((b3r - i) == 1 && j == size - 1) {
                box[0][b3c + 1] = 'D';
                z = true;
            } else if ((i - b3r) == 1 && j == size - 1) {
                box[size - 1][b3c + 1] = 'D';
                z = true;
            }
        }}*/
        return z;
    }
    /**
     * The straightRay funtion takes in the row and column in the matrix, checks for Straight ray
     *
     */
    public boolean straightRay(int i,int j){
        //todo: check if the ray is a straight ray as defined in the handout

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
    /**
     * The following definitions are the getters and setter functions which have to be implemented
     *
     */
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
