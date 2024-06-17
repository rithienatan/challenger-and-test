/**
 * Question I
 * 
 * @author Rithie Natan Carvalhaes Prado
 * @date 2023-07-02
 * Last Update: 2023-07-02
 */
public class QuestionI
{
    /**
     * Revert matriz diagonals.
     * 
     * @throws Exception
     */
    public static void RevertDiagonals(int[][] matriz) throws Exception
    {
        if(matriz.length == matriz[0].length && matriz != null && matriz.length > 0 && matriz[0].length > 0)
        {
            int size = matriz.length;

            for (int i = 0; i < size/2; i++) 
            {
                int aux = matriz[i][i];
                matriz[i][i] = matriz[size - 1 - i][size - 1 - i];
                matriz[size - 1 - i][size - 1 - i] = aux;

                aux = matriz[i][size - 1 - i];
                matriz[i][size - 1 - i] = matriz[size - 1 - i][i];
                matriz[size - 1 - i][i] = aux;
            }//end for
        }
        else
        { throw new Exception("Is not a square matriz!"); }
    }//end RevertDiagonals()

    /**
     * Main function.
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        try
        {
            //----- Test case I -----
            int[][] matrixI = {
                {1, 2},
                {3, 4}
            };

            RevertDiagonals(matrixI);

            System.out.println("----- Test case I -----");
            for (int i = 0; i < matrixI.length; i++) 
            {
                for (int j = 0; j < matrixI[i].length; j++) 
                { System.out.print(matrixI[i][j] + "\t"); }
                System.out.println();
            }//end for


            //----- Test case II -----
            int[][] matrixII = {
                {1, 0, 3},
                {0, 5, 0},
                {7, 0, 9}
            };

            RevertDiagonals(matrixII);

            System.out.println();
            System.out.println("----- Test case II -----");
            for (int i = 0; i < matrixII.length; i++) 
            {
                for (int j = 0; j < matrixII[i].length; j++) 
                { System.out.print(matrixII[i][j] + "\t"); }
                System.out.println();
            }//end for


            //----- Test case III -----
            int[][] matrixIII = {
                {1, 0, 0, 5},
                {0, 2, 6, 0},
                {0, 7, 3, 0},
                {8, 0, 0, 4}
            };

            RevertDiagonals(matrixIII);

            System.out.println();
            System.out.println("----- Test case III -----");
            for (int i = 0; i < matrixIII.length; i++) 
            {
                for (int j = 0; j < matrixIII[i].length; j++) 
                { System.out.print(matrixIII[i][j] + "\t"); }
                System.out.println();
            }//end for
        }
        catch(Exception e)
        { System.out.println(e); }
    }//end main()
}//end class