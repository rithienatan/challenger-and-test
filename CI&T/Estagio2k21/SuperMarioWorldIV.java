/**
 * 4 - Super Mario World
 * 
 * @author Rithie Natan Carvalhaes Prado
 * @version 0.1.0
 */

class SuperMarioWorldIV
{
    /**
     * Recebe o número de variações e lista as possibilidades
     * 
     * @param numeroVariacoes número inteiro
     * @return Retorna um vetor de strings
     */
    public static String[] listaVariacoes(int numeroVariacoes)
    {
        String[] resp = new String[numeroVariacoes];
        int lastPosition = 0;//para andar no vetor

        for(int i = 0; i < 3; i++)
        {
            if(i == 0)//se 21 ou mais moedas: variação A
            {
                for(int j = 0; j < 3; j++)
                {
                    if(j == 0)//se 250 segundos ou mais: variação A
                    { 
                        resp[lastPosition] = "AREA 1 -> AREA 2: variação A -> AREA 3: variação A"; 
                        lastPosition = lastPosition + 1; 
                    }//end if
                    else if(j == 1)//se entre 235 e 249 - variação B
                    {
                        for(int k = 0; k < 2; k++)
                        {
                            if(k == 0)//se 3 Dragon Coins ou menos - variação A
                            {
                                resp[lastPosition] = "AREA 1 -> AREA 2: variação A -> AREA 3: variação B -> AREA 4: variação A"; 
                                lastPosition = lastPosition + 1; 
                            }
                            else if(k == 1)//se Pelo menos 4 Dragon Coins - variação B
                            {
                                resp[lastPosition] = "AREA 1 -> AREA 2: variação A -> AREA 3: variação B -> AREA 4: variação B"; 
                                lastPosition = lastPosition + 1; 
                            }
                        }//end for
                    }
                    else if(j == 2)//se Menos de 235 segundos - variação C
                    {
                        for(int k = 0; k < 2; k++)
                        {
                            if(k == 0)//se 3 Dragon Coins ou menos - variação A
                            {
                                resp[lastPosition] = "AREA 1 -> AREA 2: variação A -> AREA 3: variação C -> AREA 4: variação A"; 
                                lastPosition = lastPosition + 1; 
                            }
                            else if(k == 1)//se Pelo menos 4 Dragon Coins - variação B
                            {
                                resp[lastPosition] = "AREA 1 -> AREA 2: variação A -> AREA 3: variação C -> AREA 4: variação B"; 
                                lastPosition = lastPosition + 1; 
                            }
                        }//end for
                    }
                }//end for
            }
            else if(i == 1)//se menos de 8 moedas: variação B
            {
                for(int j = 0; j < 3; j++)
                {
                    if(j == 0)//se 250 segundos ou mais: variação A
                    { 
                        resp[lastPosition] = "AREA 1 -> AREA 2: variação B -> AREA 3: variação A"; 
                        lastPosition = lastPosition + 1; 
                    }//end if
                    else if(j == 1)//se entre 235 e 249 - variação B
                    {
                        for(int k = 0; k < 2; k++)
                        {
                            if(k == 0)//se 3 Dragon Coins ou menos - variação A
                            {
                                resp[lastPosition] = "AREA 1 -> AREA 2: variação B -> AREA 3: variação B -> AREA 4: variação A"; 
                                lastPosition = lastPosition + 1; 
                            }
                            else if(k == 1)//se Pelo menos 4 Dragon Coins - variação B
                            {
                                resp[lastPosition] = "AREA 1 -> AREA 2: variação B -> AREA 3: variação B -> AREA 4: variação B"; 
                                lastPosition = lastPosition + 1; 
                            }
                        }//end for
                    }
                    else if(j == 2)//se Menos de 235 segundos - variação C
                    {
                        for(int k = 0; k < 2; k++)
                        {
                            if(k == 0)//se 3 Dragon Coins ou menos - variação A
                            {
                                resp[lastPosition] = "AREA 1 -> AREA 2: variação B -> AREA 3: variação C -> AREA 4: variação A"; 
                                lastPosition = lastPosition + 1; 
                            }
                            else if(k == 1)//se Pelo menos 4 Dragon Coins - variação B
                            {
                                resp[lastPosition] = "AREA 1 -> AREA 2: variação B -> AREA 3: variação C -> AREA 4: variação B"; 
                                lastPosition = lastPosition + 1; 
                            }
                        }//end for
                    }
                }//end for
            }
            else if(i == 2)//se entre 9 e 20 moedas: variação C
            {
                for(int j = 0; j < 3; j++)
                {
                    if(j == 0)//se 250 segundos ou mais: variação A
                    { 
                        resp[lastPosition] = "AREA 1 -> AREA 2: variação C -> AREA 3: variação A"; 
                        lastPosition = lastPosition + 1; 
                    }//end if
                    else if(j == 1)//se entre 235 e 249 - variação B
                    {
                        for(int k = 0; k < 2; k++)
                        {
                            if(k == 0)//se 3 Dragon Coins ou menos - variação A
                            {
                                resp[lastPosition] = "AREA 1 -> AREA 2: variação C -> AREA 3: variação B -> AREA 4: variação A"; 
                                lastPosition = lastPosition + 1; 
                            }
                            else if(k == 1)//se Pelo menos 4 Dragon Coins - variação B
                            {
                                resp[lastPosition] = "AREA 1 -> AREA 2: variação C -> AREA 3: variação B -> AREA 4: variação B"; 
                                lastPosition = lastPosition + 1; 
                            }
                        }//end for
                    }
                    else if(j == 2)//se Menos de 235 segundos - variação C
                    {
                        for(int k = 0; k < 2; k++)
                        {
                            if(k == 0)//se 3 Dragon Coins ou menos - variação A
                            {
                                resp[lastPosition] = "AREA 1 -> AREA 2: variação C -> AREA 3: variação C -> AREA 4: variação A"; 
                                lastPosition = lastPosition + 1; 
                            }
                            else if(k == 1)//se Pelo menos 4 Dragon Coins - variação B
                            {
                                resp[lastPosition] = "AREA 1 -> AREA 2: variação C -> AREA 3: variação C -> AREA 4: variação B"; 
                                lastPosition = lastPosition + 1; 
                            }
                        }//end for
                    }
                }//end for
            }//end if
        }//end for

        return(resp);
    }//end listaVariacoes()

    /**
     * Metodo main
     */
    public static void main(String []args)
    {
        int area1 = 1;
        int area2 = 3;
        int area3 = 3;
        int area4 = 2;

        //O calculo do número de variações consiste em:
        //número de possibilidades da area 1, 2, 3, 4, sendo que na area3 não iremos considerar
        //a área que tem acesso a saida secreta.
        //Depois iremos somar o que faltou na primeira conta, que o acesso a saida secreta na
        //area 3.
        int numeroVariacoes = (area1 * area2 * (area3-1) * area4) + (area1 * area2 * (area3-2));

        String[] variacoes = listaVariacoes(numeroVariacoes);

        System.out.println("Lista de variações: ");
        for(int i = 0; i < variacoes.length; i++)
        { System.out.println(variacoes[i]); }

        System.out.println("Número de variações é: " + numeroVariacoes);
    }//end main()
}//end class