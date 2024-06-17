/**
 * Question II
 * 
 * @author Rithie Natan Carvalhaes Prado
 * @date 2023-07-02
 * Last Update: 2023-07-02
 */
public class QuestionII
{
    /**
     * Count how many sub matriz exists in a matriz.
     * 
     * @param matrixA
     * @param matrixB
     * 
     * @throws Exception
     * 
     * @return Return max number of submatriz exist.
     */
    public static int CountSubmatriz(int[][] matrixA, int[][] matrixB) throws Exception
    {
        int count = 0;

        if(matrixA != null && matrixB != null && matrixA.length > matrixB.length && matrixA.length > 0 && matrixB.length > 0)
        {
            int totalLinesA = matrixA.length;
            int totalColsA = matrixA[0].length;

            int totalLinesB = matrixB.length;
            int totalColsB = matrixB[0].length;

            for (int i = 0; i <= totalLinesA - totalLinesB; i++) 
            {
                for (int j = 0; j <= totalColsA - totalColsB; j++) {
                    if (CheckSubmatriz(matrixA, matrixB, i, j)) 
                    { count++; }
                }//end for
            }//end for
        }
        else
        { throw new Exception("Inválid parameters!"); }

        return(count);
    }//end CountSubmatriz()

    /**
     * Check if is a sub matriz.
     * 
     * @param matrixA
     * @param matrixB
     * @param i
     * @param j
     * 
     * @return
     */
    private static boolean CheckSubmatriz(int[][] matrixA, int[][] matrixB, int i, int j) 
    {
        boolean answer = true;
        
        int totalLinesB = matrixB.length;
        int totalColsB = matrixB[0].length;

        for (int m = 0; m < totalLinesB; m++) 
        {
            for (int n = 0; n < totalColsB; n++) 
            {
                if (matrixA[i + m][j + n] != matrixB[m][n]) 
                { answer = false; }
            }//end for
        }//end for

        return(answer);
    }//end CheckSubmatriz()


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
            int[][] matrixAI = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            };
            int[][] matrixBI = {
                {1, 2},
                {4, 5}
            };

            System.out.println("----- Test case I -----");
            System.out.println("Quantidade de submatrizes: " + CountSubmatriz(matrixAI, matrixBI));


            //----- Test case II -----
            int[][] matrixAII = {
                {1, 2},
                {4, 5},
                {1, 2},
                {4, 5}
            };
            int[][] matrixBII = {
                {1, 2},
                {4, 5}
            };

            System.out.println();
            System.out.println("----- Test case II -----");
            System.out.println("Quantidade de submatrizes: " + CountSubmatriz(matrixAII, matrixBII));


            //----- Test case III -----
            int[][] matrixAIII = {
                {1, 2, 3, 1, 0},
                {4, 1, 0, 0, 1},
                {7, 0, 1, 5, 9},
                {1, 0, 9, 1, 0},
                {0, 1, 9, 0, 1},
            };
            int[][] matrixBIII = {
                {1, 0},
                {0, 1}
            };

            System.out.println();
            System.out.println("----- Test case III -----");
            System.out.println("Quantidade de submatrizes: " + CountSubmatriz(matrixAIII, matrixBIII));
        }
        catch(Exception e)
        { System.out.println(e); }
    }//end main()
}//end class