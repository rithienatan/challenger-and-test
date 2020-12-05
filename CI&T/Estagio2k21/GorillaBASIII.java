/**
 * 3 - Gorilla BAS
 * 
 * @author Rithie Natan Carvalhaes Prado
 * @version 0.1.0
 */

import java.lang.Math;

class GorillaBASIII
{
    /**
     * Metodo main
     */
    public static void main(String []args)
    {
        double velocidade = 80/3.6;//80 km/h convertido em m/s segundos
        double angulo = Math.sqrt(2)/2;//45 graus, sendo sen45 = cos45 = raiz(2)/2
        int tempoPercorrido = 5;//5 segundos

        double distanciaPercorrida = velocidade * angulo * 5;

        System.out.println("Distância horizontal(aproximada): " + (int)distanciaPercorrida + " metros!");


    }//end main()
}//end class