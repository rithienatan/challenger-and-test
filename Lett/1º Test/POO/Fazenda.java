/**
 * @author Rithie Natan Carvalhaes Prado
 * Data: 04/09/2020
 * 
 * @version 0.1.0
 */

//---------- imports ----------
import java.io.*;
import java.util.*;

//---------- class ----------
public class Fazenda implements TipoAnimal
{
    //hash que aramazena os dados de todos os animais
    private HashMap<String, Aves> aves = new HashMap<String, Aves>();
    private HashMap<String, Mamiferos> mamiferos = new HashMap<String, Mamiferos>();

    /**
     * Adiciona Galinha na tabela hash, sendo a cor da pena como key para distição entre as aves
     * 
     * @param idade Recebe um inteiro que representa idade
     * @param tamanho Recebe um double que representa tamanho
     * @param cor Recebe uma string que indica a cor
     */
    @Override
    public void addGalinha(int idade, double tamanho, String cor)
    {
        //verifica se a ave com está cor não foi cadastrada, ou se foi, mas o tipo é diferente
        if(aves.get(cor) == null || aves.get(cor).getNomeAve().equalsIgnoreCase("Pato") == true)
        {
            Aves av = new Aves("Galinha", false, true, cor);

            av.setIdade(idade);
            av.setTamanho(tamanho);
            av.setSom("cacarejo");
    
            aves.put(cor, av);
        }//end if
    }//end addGalinha()

    /**
     * Adiciona Pato na tabela hash
     * 
     * @param idade Recebe um inteiro que representa idade
     * @param tamanho Recebe um double que representa tamanho
     * @param cor Recebe uma string que indica a cor
     */
    @Override
    public void addPato(int idade, double tamanho, String cor)
    {
        //verifica se a ave com está cor não foi cadastrada, ou se foi, mas o tipo é diferente
        if(aves.get(cor) == null || aves.get(cor).getNomeAve().equalsIgnoreCase("Galinha") == true)
        {
            Aves av = new Aves("Pato", true, true, cor);

            av.setIdade(idade);
            av.setTamanho(tamanho);
            av.setSom("grasnido");

            aves.put(cor, av);
        }//end if
    }//end addPato()

    /**
     * Adiciona Vaca na tabela hash
     * 
     * @param idade Recebe um inteiro que representa idade
     * @param tamanho Recebe um double que representa tamanho
     * @param cor Recebe uma string que indica a cor
     */
    @Override
    public void addVaca(int idade, double tamanho, String cor)
    {
        //verifica se o mamifero com está cor não foi cadastrada, ou se foi, mas o tipo é diferente
        if(mamiferos.get(cor) == null || mamiferos.get(cor).getNomeMamifero().equalsIgnoreCase("Morcego") == true)
        {
            Mamiferos ma = new Mamiferos("Vaca", false, true, cor);

            ma.setIdade(idade);
            ma.setTamanho(tamanho);
            ma.setSom("mugido");

            mamiferos.put(cor, ma);
        }//end if
    }//end addVaca()

    /**
     * Adiciona Morcego na tabela hash
     * 
     * @param idade Recebe um inteiro que representa idade
     * @param tamanho Recebe um double que representa tamanho
     * @param cor Recebe uma string que indica a cor
     */
    @Override
    public void addMorcego(int idade, double tamanho, String cor)
    {
        //verifica se o mamifero com está cor não foi cadastrada, ou se foi, mas o tipo é diferente
        if(mamiferos.get(cor) == null || mamiferos.get(cor).getNomeMamifero().equalsIgnoreCase("Vaca") == true)
        {
            Mamiferos ma = new Mamiferos("Morcego", true, true, cor);

            ma.setIdade(idade);
            ma.setTamanho(tamanho);
            ma.setSom("farfalho");

            mamiferos.put(cor, ma);
        }//end if
    }//end addMorcego()

    /**
     * Mostra os elementos das hashs
     */
    @Override
    public void mostrar()
    { 
        //mostra a lista de aves
        for (String i : aves.keySet()) 
        { 
            aves.get(i).informacoes();
            System.out.println();
        }//end for

        //mostra a lista de mamiferos
        for (String i : mamiferos.keySet()) 
        { 
            mamiferos.get(i).informacoes();
            System.out.println();
        }//end for
    }//end mostrar()
}//end class