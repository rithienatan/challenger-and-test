/**
 * 7 - Ayrton Senna's Super Monaco GP II
 * 
 * @author Rithie Natan Carvalhaes Prado
 * @version 0.1.0
 */

import java.lang.Math;

class AyrtonSennaVII
{
    /**
     * Metodo main
     */
    public static void main(String []args)
    {
        int velocidade = 260;//260 km/h
        int coeficienteAtrito = 1;//coeficiente de atrito 1u
        double distancia = Math.pow(260, 2)/coeficienteAtrito;

        System.out.println("Precisará: " + distancia + " metros");
    }//end main()
}//end class