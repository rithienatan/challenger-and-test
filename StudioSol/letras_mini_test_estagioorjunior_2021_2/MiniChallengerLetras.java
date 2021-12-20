/**
 * @author Rithie Natan Carvalhaes Prado
 * Date: 20/09/2021
 * @version 0.1.0
 */

//---------- Imports ----------
import java.io.IOException;
import java.util.Scanner;

//---------- Main Class ----------
public class MiniChallengerLetras
{
    /**
     * Clean word duplication
     * 
     * @param word Receives string
     * 
     * @return Return word without repetition.
     */
    public static String TreatWord(String word)
    {
        String answer = "";
        boolean findDuplicate = false;

        if(word.length() % 2 == 0)
        {
            int indexControl = word.length()/2;

            for(int i = 0; i < word.length() && findDuplicate == false; i = i + 2, indexControl++)
            {
                String beginWord = word.substring(i, indexControl);
                String endWord = word.substring(indexControl, word.length());

                if(beginWord.equals(endWord) == true)
                { answer = answer + beginWord; findDuplicate = true; }
                else
                { answer = answer + word.charAt(i) + word.charAt(i+1); }
            }//end for
        }
        else
        {
            answer = answer + word.charAt(0);

            int indexControl = (word.length()+1)/2;

            for(int i = 1; i < word.length() && findDuplicate == false; i = i + 2, indexControl++)
            {
                String beginWord = word.substring(i, indexControl);
                String endWord = word.substring(indexControl, word.length());

                if(beginWord.equals(endWord) == true)
                { answer = answer + beginWord; findDuplicate = true; }
                else
                { answer = answer + word.charAt(i) + word.charAt(i+1); }
            }//end for
        }//end if

        return(answer);
    }//end TreatWord()

    /**
     * Clean duplication text.
     * 
     * @param entrada Receives initial String
     * 
     * @return Returns string without repetition. 
     */
    public static String CleanRepetition(String entrada)
    {
        String answer = "";

        String[] buffer = entrada.split(" ");

        for(int i = 0; i < buffer.length; i++)
        {
            if(buffer[i].length() > 1)
            { buffer[i] = TreatWord(buffer[i]); }
        }//end for

        answer = String.join(" ", buffer);

        return(answer + ".");
    }//end CleanRepetition()

    public static void main(String []args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        String entrada = scanner.nextLine();

        String resposta = CleanRepetition(entrada);

        System.out.println(resposta);
        scanner.close();
    }//end main()
}//end class