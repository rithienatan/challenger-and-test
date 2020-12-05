/**
 * 5 - Yoshi's Island
 * 
 * @author Rithie Natan Carvalhaes Prado
 * @version 0.1.0
 */

class YoshisIslandV
{
    /**
     * Metodo main
     */
    public static void main(String []args)
    {
        int allPlaces = 30;

        //aqui o primeiro calculo consiste em separa os 30 yoshis que gostam de viver
        //em todos os lugares, daqueles que gostam de viver apenas em 2.
        int chocolateCookie = 100 - 30;
        int yoshiCookie = 180 - 30;
        int yoshiChocolate = 200 - 30;

        //neste 3 calculos abaixo consiste em separar e conhecer o valor individual
        //do número de yoshis que gostam de viver apenas em uma ilha
        int yoshisIsland = 450 - yoshiChocolate - yoshiCookie - allPlaces;
        int chocolateIsland = 330 - yoshiChocolate - chocolateCookie - allPlaces;
        int cookieIsland = 340 - yoshiCookie - chocolateCookie - allPlaces;

        //aqui calculamos o total de Yoshi's que não gostam de viver em nenhuma ilha
        int nenhumaLocalidade = 1000 - allPlaces - chocolateCookie - yoshiCookie - yoshiChocolate - yoshisIsland - chocolateIsland - cookieIsland;

        //aqui calculamos o total de Yoshi's que vivem em apenas uma ilha
        int apenasUmaLocalidade = yoshisIsland + chocolateIsland + cookieIsland;

        System.out.println("Número total de Yoshi's que não gostam de nenhuma das localidades: " + nenhumaLocalidade);
        System.out.println("Número total de Yoshi's que vivem em apenas uma ilha: " + apenasUmaLocalidade);
    }//end main()
}//end class