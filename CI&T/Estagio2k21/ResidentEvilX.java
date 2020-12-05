/**
 * 10 - Resident Evil 2
 * 
 * @author Rithie Natan Carvalhaes Prado
 * @version 0.1.0
 */

class ResidentEvilX
{
    /**
     * Metodo main
     */
    public static void main(String []args)
    {
        //No caso desse código, iremos começar a procurar a partir da linha 5
        int n = 5;//representa o número da linha atual
        int numerosAdicionais = 8;//números a mais além do primeiro
        int numeroDaLinha = 17;

        while(numeroDaLinha < 1969)
        {
            for(int i = 0; i < numerosAdicionais; i++)
            {
                numeroDaLinha = numeroDaLinha + i;
                if(numeroDaLinha == 1969)
                { i = numerosAdicionais; }
            }//end for

            if(numeroDaLinha < 1969)
            { n = n + 1; numerosAdicionais = numerosAdicionais + 2; }
        }//end while

        System.out.println("Linha " + n);
    }//end main()
}//end class