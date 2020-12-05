/**
 * 2 - Myst
 * 
 * @author Rithie Natan Carvalhaes Prado
 * @version 0.1.0
 */
class MystII
{
    static int vetor[] = new int[119];
    static boolean state[] = new boolean[119];
    static int primos[]; //vetor de resposta do exercício

    /**
     * Verifica se um determinado número é primo ou não
     * 
     * @param valor Número que será verificado
     * @return Retorna o resultado da verificação do número
     */
    public static boolean isPrimo(int valor)
    {
        boolean resposta = true;

        for(int i = 2; i < valor; i++)
        {
            if(valor % i == 0)
            {
                resposta = false;
                i = valor;
            }//end if
        }//end for

        //marca o número que é primo no vetor state
        if( resposta == true )
        { state[valor-2] = true; }

        return(resposta);
    }//end isPrimo()

    /**
     * Metodo main
     */
    public static void main(String []args)
    {
        int quantPrimos = 0;

        //preencher o vetor com números de 2 até 120
        //preencher o vetor 'state' (que representa se número é primo ou não) com tudo falso
        for(int i = 0; i < vetor.length; i++)
        { vetor[i] = i+2; state[i] = false; }

        for(int i = 0; i < vetor.length; i++)
        {
            if(isPrimo(vetor[i]) == true)
            {
                quantPrimos++;
            }//end if
        }//end for

        primos = new int[quantPrimos];
        int j = 0;

        System.out.print("Os números primos entre 2 e 120 são: ");

        for(int i = 0; i < state.length && j < quantPrimos; i++)
        {
            if(state[i] == true)
            {
                primos[j] = i+2;
                System.out.print(primos[j] + " ");
                j = j + 1;
            }//end if
        }//end for
    }//end main()
}//end class