/**
 * @author Rithie Natan Carvalhaes Prado
 * @email rithienatan@gmail.com
 */

//------------------- imports --------------------------

import java.net.*;
import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;

//------------------- class ----------------------------
class Main
{

    public static String requestGetHTTP() throws IOException
    {
        String result;

        String myToken = "7643263f3a746a6b5eef3541a8f51cc99f46f3ae";   
        URL url = new URL("https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=" + myToken);

        HttpURLConnection connectar = (HttpURLConnection) url.openConnection();
        connectar.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connectar.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) 
        {
            response.append(inputLine);
        }//end while
        in.close();

        result = response.toString();

        connectar.disconnect();

        return(result);
    }//end requestGetHTTP()

    public static FileWriter answerJSON(String nome, String jsonInfo) throws IOException
    {
        //extraindo as informações e descifrando
        String array[] = new String[5];
        array = jsonInfo.toLowerCase().split(",");

        int numero_casas = Integer.parseInt(array[0].substring(16,18));
        String cifrado = array[2].substring(11,60);

        String decifrado = "";
        
        for(int i = 0; i < cifrado.length(); i++)
        {
            if(cifrado.charAt(i) >= 'a' && cifrado.charAt(i) <= 'z')
            {
                int ascii = (int)cifrado.charAt(i);
                int calculo = (ascii - 97 - numero_casas) % 26;
                char letra;
                if(calculo >= 0 && calculo <= 25)
                {
                    letra = (char)(calculo + 97);
                    decifrado = decifrado + letra;
                }
                else
                {
                    letra = (char)(calculo + 97 + 26);
                    decifrado = decifrado + letra;
                }//end if
            }
            else
            {
                decifrado = decifrado + cifrado.charAt(i);
            }//end if
        }//end for


        //resumo cripitografico
        String sha1 = "";
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
	        digest.update(decifrado.getBytes("utf8"));
            sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }//end try-catch

        //reescrevendo o arquivo answer.json
        FileWriter fw = new FileWriter(nome);

        PrintWriter inputInfo = new PrintWriter(fw);

        char aspas = '"';

        inputInfo.printf(array[0]+",");
        inputInfo.printf(array[1]+",");
        inputInfo.printf(array[2]+",");
        inputInfo.printf(aspas+"decifrado"+aspas+":"+aspas+decifrado+aspas+",");
        inputInfo.printf(aspas+"resumo_criptografico"+aspas+":"+aspas+sha1+aspas+"}");

        fw.close();

        return(fw);
    }//end answerJSON

    public static void main(String[] args) throws IOException
    {
        String jsonInfo = requestGetHTTP();

        FileWriter fw = answerJSON("answer.json", jsonInfo);
        fw.close();
    }//end main
}//end class