/**
 * 1 - Metroid
 * 
 * @author Rithie Natan Carvalhaes Prado
 * @version 0.1.0
 */

class MetroidI
{
    /**
     * Metodo main
     */
    public static void main(String []args)
    {
        int distancia = 149600000;
        int velocidadeMedia = 28440;

        //a resposta segue a seguinte formula:
        //(distancia/velocidadeMedia)/24 para achar o número de dias 
        int resposta = (int)((distancia/velocidadeMedia)/24);

        System.out.println("Aproximadamente: " + resposta + " dias!");
    }//end main()
}//end class