/**
 * @author Rithie Natan Carvalhaes Prado
 * Data: 04/09/2020
 * 
 * @version 0.1.0
 */

//---------- imports ----------
import java.io.*;

//---------- class ----------
public class Aplication
{
    public static void main(String []args) throws IOException
    {
        TipoAnimal dadosAnimais = new Fazenda();

        //leitura de arquivos
        InputStream is = System.in;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        //ler linha arquivo de entrada
        String linha = br.readLine();

        while(linha != null)
        {
            if(linha.equalsIgnoreCase("Galinha") == true)
            {
                int idade = Integer.parseInt(br.readLine());
                double tamanho = Double.valueOf(br.readLine()).doubleValue();
                String cor = br.readLine();
                dadosAnimais.addGalinha(idade, tamanho, cor); 
            }
            else if(linha.equalsIgnoreCase("Pato") == true)
            {
                int idade = Integer.parseInt(br.readLine());
                double tamanho = Double.valueOf(br.readLine()).doubleValue();
                String cor = br.readLine();
                dadosAnimais.addPato(idade, tamanho, cor); 
            }
            else if(linha.equalsIgnoreCase("Vaca") == true)
            {
                int idade = Integer.parseInt(br.readLine());
                double tamanho = Double.valueOf(br.readLine()).doubleValue();
                String cor = br.readLine();
                dadosAnimais.addVaca(idade, tamanho, cor); 
            }
            else if(linha.equalsIgnoreCase("Morcego") == true)
            { 
                int idade = Integer.parseInt(br.readLine());
                double tamanho = Double.valueOf(br.readLine()).doubleValue();
                String cor = br.readLine();
                dadosAnimais.addMorcego(idade, tamanho, cor); 
            }
            else
            { System.out.println("Este animal não pertence a fazenda!"); }
            linha = br.readLine();
        }//end while

        dadosAnimais.mostrar();
    }//end main()
}//end class