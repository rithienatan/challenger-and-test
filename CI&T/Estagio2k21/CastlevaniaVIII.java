/**
 * 8 - Castlevânia
 * 
 * @author Rithie Natan Carvalhaes Prado
 * @version 0.1.0
 */

import java.lang.Math;

class CastlevaniaVIII
{
    /**
     * Metodo main
     */
    public static void main(String []args)
    {
        int numeroDiscos = 5;

        //Calculo para a torre de Hanoi
        double numeroMinimoDeMovimentos = Math.pow(2, numeroDiscos) - 1;

        System.out.println((int)numeroMinimoDeMovimentos);
    }//end main()
}//end class