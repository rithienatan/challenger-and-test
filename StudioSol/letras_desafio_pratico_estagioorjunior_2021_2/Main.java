/**
 * @author Rithie Natan Carvalhaes Prado
 * @version 0.1.0
 * 
 * Documentation: 
 * 
 * 1. Como rodar o programa: javac Main.java e depois java Main
 * 2. Explicando cada classe:
 *      2.1 Classe Musica: Contém os atributos basicos nome, pontos e lista de palavras. A classe música
 *                         foi implementada com uma inteface para fazer comparações entre cada objeto música
 *                         pelo atributo pontos.
 *      2.2 Classe Database: Contém uma lista de músicas fornecidas pelo enunciado.
 *          2.2.1 Método BuscarMusica: Recebe a entrada de música do usuário, busca músicas, atribui pontos e
 *                                     ordena de forma decrescente de acordo com os pontos.
 *      2.3 Classe Main: Classe principal, que processa a entrada do usuário e mostra na tela de forma 
 *                       decrescente as 10 primeiras músicas com maior pontuação.
 */
//---------- Imports ----------
import java.util.Scanner;
import java.util.ArrayList;


//---------- Class ----------
public class Main
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        Database musicDB = new Database();

        // program begin
        System.out.print("# Digite sua busca: ");
        String buscar = sc.nextLine();
        System.out.println("#");
        sc.close();

        // search and display results
        System.out.println("# Resultados:");

        ArrayList<Musica> musicaList = musicDB.BuscarMusica(buscar.split(" "));

        for(int i = 0; i < 10; i++)
        { System.out.println("# " + musicaList.get(i).getPoints() + " pontos, " + musicaList.get(i).name); }

        // program end
        System.out.println("#");
        System.out.println("# -------------------------------------");
    }//end main()
}//end class