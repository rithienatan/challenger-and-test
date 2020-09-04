/**
 * @author Rithie Natan Carvalhaes Prado
 * Data: 04/09/2020
 * 
 * @version 0.1.0
 */

//---------- imports ----------
import java.net.*;
import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//---------- class ----------
class Aplication
{
    /**
     * Recebe uma url e extrai todo o html para uma String
     * 
     * @param urlSite recebe a url de um site
     * 
     * @return retorna uma String que representa a página html deste site
     */
    public static String requestGetHTTP(String urlSite) throws IOException
    {
        String result;

        URL url = new URL(urlSite);

        HttpURLConnection connectar = (HttpURLConnection) url.openConnection();
        connectar.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connectar.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) 
        { response.append(inputLine); }
        in.close();

        result = response.toString();

        connectar.disconnect();

        return(result);
    }//end requestGetHTTP()

    /**
     * Busca o nome do produto
     * 
     * @param text Recebe um texto de entrada
     * 
     * @return Retorna o nome do produto
     */
    public static String productName(String text)
    {
        String resp = "";

        Pattern pattern = Pattern.compile("<h1 class=(.*?)/h1>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) 
        { resp = matcher.group(1); }

        pattern = Pattern.compile(">(.*?)<", Pattern.DOTALL);
        matcher = pattern.matcher(resp);
        while (matcher.find()) 
        { resp = matcher.group(1); }

        return(resp);
    }//end productName()

    /**
     * Busca o preço do produto
     * 
     * @param text Recebe um texto de entrada
     * 
     * @return Retorna o preço do produto
     */
    public static String productPrice(String text)
    {
        String resp = "";

        Pattern pattern = Pattern.compile("<div class="+(char)34+"preco_normal(.*?)/div>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) 
        { resp = matcher.group(1); }

        pattern = Pattern.compile(">(.*?)<", Pattern.DOTALL);
        matcher = pattern.matcher(resp);
        while (matcher.find()) 
        { resp = matcher.group(1); }

        return(resp);
    }//end productPrice()

    /**
     * Busca a descrição do produto
     * 
     * @param text Recebe um texto de entrada
     * 
     * @return Retorna a descrição do produto
     */
    public static String productDescription(String text)
    {
        String resp = "";

        Pattern pattern = Pattern.compile("<div class="+
                                                (char)34+
                                                "content_tab"+
                                                (char)34+" style=(.*?)<link rel=", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) 
        { resp = matcher.group(1); }

        pattern = Pattern.compile("</h2>(.*?)<a", Pattern.DOTALL);
        matcher = pattern.matcher(resp);
        while (matcher.find()) 
        { resp = matcher.group(1); }

        pattern = Pattern.compile("</div>(.*?)/p>", Pattern.DOTALL);
        matcher = pattern.matcher(resp);
        while (matcher.find()) 
        { resp = matcher.group(1); }

        pattern = Pattern.compile("<p>(.*?)<", Pattern.DOTALL);
        matcher = pattern.matcher(resp);
        while (matcher.find()) 
        { resp = matcher.group(1); }

        return(resp);
    }//end productDescription()

    public static void main(String []args) throws IOException
    {
        //leitura de arquivos
        InputStream is = System.in;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        //ler linha arquivo de entrada
        String linha = br.readLine();

        String text;

        while(linha != null)
        {
            text = requestGetHTTP(linha);

            System.out.println("Nome produto: " + productName(text));
            System.out.println("Preço produto: " + productPrice(text));
            System.out.println("Descrição produto: " + productDescription(text));

            System.out.println();

            linha = br.readLine();
        }//end while
    }//end main()
}//end class