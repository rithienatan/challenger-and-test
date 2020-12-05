/**
 * @author Rithie Natan Carvalhaes Prado
 * @email rithienatan@gmail.com
 * @version 1.0.0
 * 
 */

class QuestaoIV
{
    /**
     * Chamador recursivo
     * 
     * @param lista Recebe uma lista de nomes para ser ordenadas
     * 
     * @return Retorna um array de Strings ordenado
     * 
     */
    public static String[] quicksort(String lista[])
    { return(quicksort(lista, 0, lista.length)); }

    /**
     * Método de ordenação quicksort
     * 
     * @param lista Recebe uma lista de nomes
     * @param began Inicio da lista
     * @param end Fim da lista
     * 
     * @return Retorna um array de Strings ordenado
     */
    public static String[] quicksort(String lista[], int began, int end)
    {
        int i = began, j = end-1;
        String pivo = lista[(began + end) / 2], aux;

        while(i <= j)
        {
            while(lista[i].compareTo(pivo) < 0 && i < end)
            { i++; }
            while(lista[j].compareTo(pivo) > 0 && j > began)
            { j--; }

            if(i <= j)
            {
                aux = lista[i]; lista[i] = lista[j]; lista[j] = aux;
                i++; j--;
            }//end if
        }//end while

        if(j > began)
        { lista = quicksort(lista, began, j+1); }
        if(i < end)
        { lista = quicksort(lista, i, end); }

        return(lista);
    }//end quicksort()
    

    /**
     * Metodo que retorna uma lista ordenada com todos os nomes que contem Martins, mas não contém Silva
     * 
     * @param lista Recebe uma lista de nomes
     * 
     * @return Retorna uma lista de Strings
     */
    public static String[] onlyMartins(String lista[])
    {
        //----- fazer a leitura da quantidade de Martins existentes que não contém Silva -----//
        int tamanho = 0;
        for(int i = 0; i < lista.length; i++)
        {
            if(lista[i].contains("Martins") == true && lista[i].contains("Silva") == false)
            { tamanho++; }
        }//end for

        //----- fazer a leitura da quantidade de Martins existentes que não contém Silva -----//
        String resp[] = new String[tamanho];
        int j = 0;//para percorrer no vetor 'resp'
        for(int i = 0; i < lista.length; i++)
        {
            if(lista[i].contains("Martins") == true && lista[i].contains("Silva") == false)
            { resp[j] = lista[i]; j++; }
        }//end for

        //----- Ordena o vetor de saida em ordem alfabetica -----//
        resp = quicksort(resp);

        return(resp);
    }//end onlyMartins()

    public static void main(String []args)
    {
        String lista[] = {"Martins Silva", "Martins Araujo", "Augusto Martins", "Matheus Resende", "Augusto Martins", "Be Martins"};

        String martins[] = onlyMartins(lista);

        System.out.println(martins.length);

        for(int i = 0; i < martins.length; i++)
        { System.out.println(martins[i]); }
    }//end main
}//end class