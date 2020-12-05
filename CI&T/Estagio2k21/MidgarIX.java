/**
 * 9 - Midgar
 * 
 * @author Rithie Natan Carvalhaes Prado
 * @version 0.1.0
 */

class MidgarIX
{
    /**
     * Metodo main
     */
    public static void main(String []args)
    {
        double midgarArea = 2827.43;//2827.43 km quadrados
        double centralArea = 314.15;//314.15 km quadrados

        //consederando que 1 setor é composto por parte Midgar mais um pedaço da área central
        double areaDeBusca = (midgarArea + centralArea)/8;

        System.out.println("Aproximadamente: " + (int)areaDeBusca + " km²");
    }//end main()
}//end class