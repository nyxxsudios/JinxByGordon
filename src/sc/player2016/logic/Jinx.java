package sc.player2016.logic;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

import sc.plugin2016.GameState;
import sc.plugin2016.Move;
import sc.player2016.logic.Field;
import sc.player2016.logic.Board;

/**
 *
 * @author gordonkoehn
 */
public class Jinx {

    static int x = 6;
    static int y = 6;
    
    static int visualRange = 2; /*not in use**/
    
    static Move lastlastMove;  /*not in use**/
    
    public static Board board ;  /*not in use**/
     

    public static Move findMove (GameState gameState){
        
        Move selection;
        
        preselectMoves(gameState);
        
        selection = new Move(x, y); 
        
        

        return selection;
    } 

    
    public static ArrayList<Field> preselectMoves (GameState gameState){
        ArrayList<Field> preselectMoves = new ArrayList();
  
        /* preselected moves in realtion to a move **/ 
        int[][] visualRange1 = {
                            {-1,2},{-1,-2},{1,2},{-2,1},{2,1},{-2,-1},{2,-1},{1,-2} 
        };    
        //Not IN USE
        int[][] visualRange2 = {
                    {-2,4},{0,4},{2,4},
                 {-3,3},{-1,3},{1,3},{3,3},
               {-4,2},                      {-4,2},
                    {-3,1},             {3,1},
               {-4,0},                         {4,0},     
                    {-3,-1},             {3,-1},
               {-4,-2},                      {-4,-2},
                 {-3,-3},{-1,-3},{1,-3},{3,-3},        
                   {-2,-4},{0,-4},{2,-4}
        };    
        
        Move lastMove = gameState.getLastMove();
        
        for (int[] a : visualRange1){
            int Mx = lastMove.getX();
            int My = lastMove.getY(); 
            
            Mx = Mx + a[0];        
            My = My + a[1];
            
            Field relatedMove = new Field(Mx, My);
                
           relatedMove.setType(Field.Type.Free);
            
            if (Mx >= 0 && Mx < 24 && My >= 0 && My < 24){
                if (Field.Type.Blocked != relatedMove.getType()){
                    preselectMoves.add(relatedMove);
                    System.out.println(relatedMove.x + ", " + relatedMove.y);
                }
            }
        }
        return preselectMoves;
    }
}
