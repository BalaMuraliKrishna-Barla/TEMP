
import java.util.Scanner;

class TicTacToe{
    Scanner s = new Scanner(System.in);
    char [][]board;
    int [][]demo;
    TicTacToe(){
        board = new char[3][3];
        demo = new int[3][3];
        initBoard();
    }

    void initBoard(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                board[i][j] = ' ';
            }
        }
        for(int i=0;i<demo.length;i++){
            for(int j=0;j<demo.length;j++){
                demo[i][j] = 0;
            }
        }
    }

    void displayBoard(){
        System.out.println("-------------");
        for(int i=0;i<board.length;i++){
            System.out.print("| ");
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    void placeMark(int row,int col,char mark){
        if(row<3 && row>=0 && col<3 && col>=0 ){
                if(isMarked(row,col)){
                    System.out.println("Already Marked!");
                    input(mark);
                }
                else{
                    board[row][col] = mark;
                    demo[row][col] = 1;
                    displayBoard();


                }
            }
        else{
            System.out.println("Invalid position!");
            input(mark);
        }
    }

    boolean isMarked(int row,int col){
        if(demo[row][col]==1)
            return true;
        else
            return false;
    }

    boolean checkColWin(){
        for(int j=0;j<3;j++){
            if(board[0][j]==board[1][j] && board[1][j]==board[2][j] && board[0][j]!=' ')
                return true;
        }
        return false;
    }

    boolean checkRowWin(){
        for(int i=0;i<3;i++){
            if(board[i][0]==board[i][1] && board[i][1]==board[i][2] && board[i][0]!=' ')
                return true;
        }
        return false;
    }

    boolean checkDiagonalWin(){
        if((board[0][0]==board[1][1] && board[1][1]==board[2][2] && board[0][0]!=' ')
                                ||
            (board[0][2]==board[1][1] && board[1][1]==board[2][0] && board[0][2]!=' '))
            return true;
        else 
            return false;
    }

    void input(char mark){
        int r,c;
        System.out.print("Enter row and column to insert : ");
        r = s.nextInt();
        c = s.nextInt();
        placeMark(r, c, mark);
    }
}

public class LaunchGame{
    static String A,B,a,b;
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        newGame();
        while(true){
            System.out.println("1.Play again 2.New Game 3.Exit");
            int ch = s.nextInt();
            switch(ch){
                case 1: game(new TicTacToe());
                        break;
                case 2: newGame();
                        break;
                case 3: System.out.println("Thanks for playing!"); 
                    System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }  
    }
    static void newGame(){
            System.out.println("Welcome to my mini TicTacToe!");
            System.out.println("Instructions:\nPlayer A : X\tPlayer B : O");
            System.out.print("Enter Player A name : ");
            a = s.nextLine();
            System.out.print("Enter Player B name : ");
            b = s.nextLine();
            game(new TicTacToe());
    }
    static void game(TicTacToe t){
        System.out.println("Who starts first?\nEnter 0 for "+a+"\nEnter 1 for "+b);
            int start = s.nextInt();
            if(start==1){
                A = b;
                B = a;
            }
            else{
                A = a;
                B = b;
            }
            int i;
            for(i=0;i<9;i++){
                if(i%2==0){
                    System.out.println(A+"'s turn");
                    t.input('X');
                    if(t.checkColWin()||t.checkRowWin()||t.checkDiagonalWin()){
                        System.out.println("Bravo!\n"+A+" won the game!!");
                        break;
                    }
                }
                else{
                    System.out.println(B+"'s turn");
                    t.input('O');
                    if(t.checkColWin()||t.checkRowWin()||t.checkDiagonalWin()){
                        System.out.println("Bravo!\n"+B+" won the game!!");
                        break;
                    }
                } 
            }
            if(i==9)
                System.out.println("Oops! it's a Tie");
    }   
}