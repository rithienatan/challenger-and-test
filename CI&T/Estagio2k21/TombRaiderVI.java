/**
 * 6 - Tomb Raider
 * 
 * @author Rithie Natan Carvalhaes Prado
 * @version 0.1.0
 */

class TombRaiderVI
{
    //No caso de combinações entre letras somente temos:
    //Possibilidade 1: Se as primeiras letras forem diferentes de A e D
    //Possibilidade 2: Se a primeira letra for A ou D e a segunda letra ser diferente de A e D
    //Possibilidade 3: Se a primeira letra for A ou D e a terceira letra ser diferente de A e D
    //Obs.: Lembrando que obrigatoriamente temos A e D em todas as combinações de chaves
    static int letras1 = 4 * 2 * 1;
    static int letras2 = 2 * 4 * 1;
    static int letras3 = 2 * 1 * 4;

    //Estas variáveis aqui diz respeito as combinações de somente
    //entre os digitos, sendo o primeiro digito sendo 3 ou 6
    //obs.: É respeitado a soma dos digitos que é 8 no total e desconsiderando o 0.
    //Exemplo: Primeiro digito 6, os dois proximos
    //obrigatoriamente devem ser 1 e 2 ou 2 e 1
    static int tres = 1 * 4 * 1;
    static int seis = 1 * 2 * 1;

    /**
     * Lista todas as Strings e as colocam em um arranjo
     * 
     * @param totalDeChaves número inteiro
     * @return Retorna um arranjo de Strings
     */
    public static String[] listaDeChaves(int totalDeChaves)
    {
        String[] resp = new String[totalDeChaves];
        int lastPosition = 0;//para andar no vetor

        for(int i = 0; i < 6; i++)
        {
            if(i == 0)//primeira letra: A
            {
                for(int j = 0; j < 5; j++)
                {
                    if(j == 0)//segunda letra: B
                    {
                        for(int k = 0; k < 2; k++)
                        {
                            if(k == 0)//primeiro número: 3
                            {
                                for(int l = 0; l < 4; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "ABD314"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "ABD341"; lastPosition = lastPosition + 1; }
                                    else if(l == 2)
                                    { resp[lastPosition] = "ABD323"; lastPosition = lastPosition + 1; }
                                    else if(l == 3)
                                    { resp[lastPosition] = "ABD332"; lastPosition = lastPosition + 1; }
                                }//end for
                            }
                            else if(k == 1)//primeiro número: 6
                            {
                                for(int l = 0; l < 2; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "ABD612"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "ABD621"; lastPosition = lastPosition + 1; }
                                }//end for
                            }//end if
                        }//end for
                    }
                    else if(j == 1)//segunda letra: C
                    {
                        for(int k = 0; k < 2; k++)
                        {
                            if(k == 0)//primeiro número: 3
                            {
                                for(int l = 0; l < 4; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "ACD314"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "ACD341"; lastPosition = lastPosition + 1; }
                                    else if(l == 2)
                                    { resp[lastPosition] = "ACD323"; lastPosition = lastPosition + 1; }
                                    else if(l == 3)
                                    { resp[lastPosition] = "ACD332"; lastPosition = lastPosition + 1; }
                                }//end for
                            }
                            else if(k == 1)//primeiro número: 6
                            {
                                for(int l = 0; l < 2; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "ACD612"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "ACD621"; lastPosition = lastPosition + 1; }
                                }//end for
                            }//end if
                        }//end for
                    }
                    else if(j == 2)//segunda letra: D
                    {
                        for(int q = 0; q < 4; q++)
                        {
                            if(q == 0)//terceira letra: B
                            {
                                for(int k = 0; k < 2; k++)
                                {
                                    if(k == 0)//primeiro número: 3
                                    {
                                        for(int l = 0; l < 4; l++)
                                        {
                                            if(l == 0)
                                            { resp[lastPosition] = "ADB314"; lastPosition = lastPosition + 1; }
                                            else if(l == 1)
                                            { resp[lastPosition] = "ADB341"; lastPosition = lastPosition + 1; }
                                            else if(l == 2)
                                            { resp[lastPosition] = "ADB323"; lastPosition = lastPosition + 1; }
                                            else if(l == 3)
                                            { resp[lastPosition] = "ADB332"; lastPosition = lastPosition + 1; }
                                        }//end for
                                    }
                                    else if(k == 1)//primeiro número: 6
                                    {
                                        for(int l = 0; l < 2; l++)
                                        {
                                            if(l == 0)
                                            { resp[lastPosition] = "ADB612"; lastPosition = lastPosition + 1; }
                                            else if(l == 1)
                                            { resp[lastPosition] = "ADB621"; lastPosition = lastPosition + 1; }
                                        }//end for
                                    }//end if
                                }//end for
                            }
                            else if(q == 1)//terceira letra: C
                            {
                                for(int k = 0; k < 2; k++)
                                {
                                    if(k == 0)//primeiro número: 3
                                    {
                                        for(int l = 0; l < 4; l++)
                                        {
                                            if(l == 0)
                                            { resp[lastPosition] = "ADC314"; lastPosition = lastPosition + 1; }
                                            else if(l == 1)
                                            { resp[lastPosition] = "ADC341"; lastPosition = lastPosition + 1; }
                                            else if(l == 2)
                                            { resp[lastPosition] = "ADC323"; lastPosition = lastPosition + 1; }
                                            else if(l == 3)
                                            { resp[lastPosition] = "ADC332"; lastPosition = lastPosition + 1; }
                                        }//end for
                                    }
                                    else if(k == 1)//primeiro número: 6
                                    {
                                        for(int l = 0; l < 2; l++)
                                        {
                                            if(l == 0)
                                            { resp[lastPosition] = "ADC612"; lastPosition = lastPosition + 1; }
                                            else if(l == 1)
                                            { resp[lastPosition] = "ADC621"; lastPosition = lastPosition + 1; }
                                        }//end for
                                    }//end if
                                }//end for
                            }
                            else if(q == 2)//terceira letra: E
                            {
                                for(int k = 0; k < 2; k++)
                                {
                                    if(k == 0)//primeiro número: 3
                                    {
                                        for(int l = 0; l < 4; l++)
                                        {
                                            if(l == 0)
                                            { resp[lastPosition] = "ADE314"; lastPosition = lastPosition + 1; }
                                            else if(l == 1)
                                            { resp[lastPosition] = "ADE341"; lastPosition = lastPosition + 1; }
                                            else if(l == 2)
                                            { resp[lastPosition] = "ADE323"; lastPosition = lastPosition + 1; }
                                            else if(l == 3)
                                            { resp[lastPosition] = "ADE332"; lastPosition = lastPosition + 1; }
                                        }//end for
                                    }
                                    else if(k == 1)//primeiro número: 6
                                    {
                                        for(int l = 0; l < 2; l++)
                                        {
                                            if(l == 0)
                                            { resp[lastPosition] = "ADE612"; lastPosition = lastPosition + 1; }
                                            else if(l == 1)
                                            { resp[lastPosition] = "ADE621"; lastPosition = lastPosition + 1; }
                                        }//end for
                                    }//end if
                                }//end for
                            }
                            else if(q == 3)//terceira letra: F
                            {
                                for(int k = 0; k < 2; k++)
                                {
                                    if(k == 0)//primeiro número: 3
                                    {
                                        for(int l = 0; l < 4; l++)
                                        {
                                            if(l == 0)
                                            { resp[lastPosition] = "ADF314"; lastPosition = lastPosition + 1; }
                                            else if(l == 1)
                                            { resp[lastPosition] = "ADF341"; lastPosition = lastPosition + 1; }
                                            else if(l == 2)
                                            { resp[lastPosition] = "ADF323"; lastPosition = lastPosition + 1; }
                                            else if(l == 3)
                                            { resp[lastPosition] = "ADF332"; lastPosition = lastPosition + 1; }
                                        }//end for
                                    }
                                    else if(k == 1)//primeiro número: 6
                                    {
                                        for(int l = 0; l < 2; l++)
                                        {
                                            if(l == 0)
                                            { resp[lastPosition] = "ADF612"; lastPosition = lastPosition + 1; }
                                            else if(l == 1)
                                            { resp[lastPosition] = "ADF621"; lastPosition = lastPosition + 1; }
                                        }//end for
                                    }//end if
                                }//end for
                            }//end if
                        }//end for
                    }
                    else if(j == 3)//segunda letra: E
                    {
                        for(int k = 0; k < 2; k++)
                        {
                            if(k == 0)//primeiro número: 3
                            {
                                for(int l = 0; l < 4; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "AED314"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "AED341"; lastPosition = lastPosition + 1; }
                                    else if(l == 2)
                                    { resp[lastPosition] = "AED323"; lastPosition = lastPosition + 1; }
                                    else if(l == 3)
                                    { resp[lastPosition] = "AED332"; lastPosition = lastPosition + 1; }
                                }//end for
                            }
                            else if(k == 1)//primeiro número: 6
                            {
                                for(int l = 0; l < 2; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "AED612"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "AED621"; lastPosition = lastPosition + 1; }
                                }//end for
                            }//end if
                        }//end for
                    }
                    else if(j == 4)//segunda letra: F
                    {
                        for(int k = 0; k < 2; k++)
                        {
                            if(k == 0)//primeiro número: 3
                            {
                                for(int l = 0; l < 4; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "AFD314"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "AFD341"; lastPosition = lastPosition + 1; }
                                    else if(l == 2)
                                    { resp[lastPosition] = "AFD323"; lastPosition = lastPosition + 1; }
                                    else if(l == 3)
                                    { resp[lastPosition] = "AFD332"; lastPosition = lastPosition + 1; }
                                }//end for
                            }
                            else if(k == 1)//primeiro número: 6
                            {
                                for(int l = 0; l < 2; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "AFD612"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "AFD621"; lastPosition = lastPosition + 1; }
                                }//end for
                            }//end if
                        }//end for
                    }//end if
                }//end for
            }
            else if(i == 1)//primeira letra: B
            {
                for(int j = 0; j < 2; j++)
                {
                    if(j == 0)//segunda letra: A
                    {
                        for(int k = 0; k < 2; k++)
                        {
                            if(k == 0)//primeiro número: 3
                            {
                                for(int l = 0; l < 4; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "BAD314"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "BAD341"; lastPosition = lastPosition + 1; }
                                    else if(l == 2)
                                    { resp[lastPosition] = "BAD323"; lastPosition = lastPosition + 1; }
                                    else if(l == 3)
                                    { resp[lastPosition] = "BAD332"; lastPosition = lastPosition + 1; }
                                }//end for
                            }
                            else if(k == 1)//primeiro número: 6
                            {
                                for(int l = 0; l < 2; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "BAD612"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "BAD621"; lastPosition = lastPosition + 1; }
                                }//end for
                            }//end if
                        }//end for
                    }
                    else if(j == 1)//segunda letra: D
                    {
                        for(int k = 0; k < 2; k++)
                        {
                            if(k == 0)//primeiro número: 3
                            {
                                for(int l = 0; l < 4; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "BDA314"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "BDA341"; lastPosition = lastPosition + 1; }
                                    else if(l == 2)
                                    { resp[lastPosition] = "BDA323"; lastPosition = lastPosition + 1; }
                                    else if(l == 3)
                                    { resp[lastPosition] = "BDA332"; lastPosition = lastPosition + 1; }
                                }//end for
                            }
                            else if(k == 1)//primeiro número: 6
                            {
                                for(int l = 0; l < 2; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "BDA612"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "BDA621"; lastPosition = lastPosition + 1; }
                                }//end for
                            }//end if
                        }//end for
                    }//end if
                }//end for
            }
            else if(i == 2)//primeira letra: C
            {
                for(int j = 0; j < 2; j++)
                {
                    if(j == 0)//segunda letra: A
                    {
                        for(int k = 0; k < 2; k++)
                        {
                            if(k == 0)//primeiro número: 3
                            {
                                for(int l = 0; l < 4; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "CAD314"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "CAD341"; lastPosition = lastPosition + 1; }
                                    else if(l == 2)
                                    { resp[lastPosition] = "CAD323"; lastPosition = lastPosition + 1; }
                                    else if(l == 3)
                                    { resp[lastPosition] = "CAD332"; lastPosition = lastPosition + 1; }
                                }//end for
                            }
                            else if(k == 1)//primeiro número: 6
                            {
                                for(int l = 0; l < 2; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "CAD612"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "CAD621"; lastPosition = lastPosition + 1; }
                                }//end for
                            }//end if
                        }//end for
                    }
                    else if(j == 1)//segunda letra: D
                    {
                        for(int k = 0; k < 2; k++)
                        {
                            if(k == 0)//primeiro número: 3
                            {
                                for(int l = 0; l < 4; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "CDA314"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "CDA341"; lastPosition = lastPosition + 1; }
                                    else if(l == 2)
                                    { resp[lastPosition] = "CDA323"; lastPosition = lastPosition + 1; }
                                    else if(l == 3)
                                    { resp[lastPosition] = "CDA332"; lastPosition = lastPosition + 1; }
                                }//end for
                            }
                            else if(k == 1)//primeiro número: 6
                            {
                                for(int l = 0; l < 2; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "CDA612"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "CDA621"; lastPosition = lastPosition + 1; }
                                }//end for
                            }//end if
                        }//end for
                    }//end if
                }//end for
            }
            else if(i == 3)//primeira letra: D
            {
                for(int j = 0; j < 5; j++)
                {
                    if(j == 0)//segunda letra: B
                    {
                        for(int k = 0; k < 2; k++)
                        {
                            if(k == 0)//primeiro número: 3
                            {
                                for(int l = 0; l < 4; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "DBA314"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "DBA341"; lastPosition = lastPosition + 1; }
                                    else if(l == 2)
                                    { resp[lastPosition] = "DBA323"; lastPosition = lastPosition + 1; }
                                    else if(l == 3)
                                    { resp[lastPosition] = "DBA332"; lastPosition = lastPosition + 1; }
                                }//end for
                            }
                            else if(k == 1)//primeiro número: 6
                            {
                                for(int l = 0; l < 2; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "DBA612"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "DBA621"; lastPosition = lastPosition + 1; }
                                }//end for
                            }//end if
                        }//end for
                    }
                    else if(j == 1)//segunda letra: C
                    {
                        for(int k = 0; k < 2; k++)
                        {
                            if(k == 0)//primeiro número: 3
                            {
                                for(int l = 0; l < 4; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "DCA314"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "DCA341"; lastPosition = lastPosition + 1; }
                                    else if(l == 2)
                                    { resp[lastPosition] = "DCA323"; lastPosition = lastPosition + 1; }
                                    else if(l == 3)
                                    { resp[lastPosition] = "DCA332"; lastPosition = lastPosition + 1; }
                                }//end for
                            }
                            else if(k == 1)//primeiro número: 6
                            {
                                for(int l = 0; l < 2; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "DCA612"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "DCA621"; lastPosition = lastPosition + 1; }
                                }//end for
                            }//end if
                        }//end for
                    }
                    else if(j == 2)//segunda letra: A
                    {
                        for(int q = 0; q < 4; q++)
                        {
                            if(q == 0)//terceira letra: B
                            {
                                for(int k = 0; k < 2; k++)
                                {
                                    if(k == 0)//primeiro número: 3
                                    {
                                        for(int l = 0; l < 4; l++)
                                        {
                                            if(l == 0)
                                            { resp[lastPosition] = "DAB314"; lastPosition = lastPosition + 1; }
                                            else if(l == 1)
                                            { resp[lastPosition] = "DAB341"; lastPosition = lastPosition + 1; }
                                            else if(l == 2)
                                            { resp[lastPosition] = "DAB323"; lastPosition = lastPosition + 1; }
                                            else if(l == 3)
                                            { resp[lastPosition] = "DAB332"; lastPosition = lastPosition + 1; }
                                        }//end for
                                    }
                                    else if(k == 1)//primeiro número: 6
                                    {
                                        for(int l = 0; l < 2; l++)
                                        {
                                            if(l == 0)
                                            { resp[lastPosition] = "DAB612"; lastPosition = lastPosition + 1; }
                                            else if(l == 1)
                                            { resp[lastPosition] = "DAB621"; lastPosition = lastPosition + 1; }
                                        }//end for
                                    }//end if
                                }//end for
                            }
                            else if(q == 1)//terceira letra: C
                            {
                                for(int k = 0; k < 2; k++)
                                {
                                    if(k == 0)//primeiro número: 3
                                    {
                                        for(int l = 0; l < 4; l++)
                                        {
                                            if(l == 0)
                                            { resp[lastPosition] = "DAC314"; lastPosition = lastPosition + 1; }
                                            else if(l == 1)
                                            { resp[lastPosition] = "DAC341"; lastPosition = lastPosition + 1; }
                                            else if(l == 2)
                                            { resp[lastPosition] = "DAC323"; lastPosition = lastPosition + 1; }
                                            else if(l == 3)
                                            { resp[lastPosition] = "DAC332"; lastPosition = lastPosition + 1; }
                                        }//end for
                                    }
                                    else if(k == 1)//primeiro número: 6
                                    {
                                        for(int l = 0; l < 2; l++)
                                        {
                                            if(l == 0)
                                            { resp[lastPosition] = "DAC612"; lastPosition = lastPosition + 1; }
                                            else if(l == 1)
                                            { resp[lastPosition] = "DAC621"; lastPosition = lastPosition + 1; }
                                        }//end for
                                    }//end if
                                }//end for
                            }
                            else if(q == 2)//terceira letra: E
                            {
                                for(int k = 0; k < 2; k++)
                                {
                                    if(k == 0)//primeiro número: 3
                                    {
                                        for(int l = 0; l < 4; l++)
                                        {
                                            if(l == 0)
                                            { resp[lastPosition] = "DAE314"; lastPosition = lastPosition + 1; }
                                            else if(l == 1)
                                            { resp[lastPosition] = "DAE341"; lastPosition = lastPosition + 1; }
                                            else if(l == 2)
                                            { resp[lastPosition] = "DAE323"; lastPosition = lastPosition + 1; }
                                            else if(l == 3)
                                            { resp[lastPosition] = "DAE332"; lastPosition = lastPosition + 1; }
                                        }//end for
                                    }
                                    else if(k == 1)//primeiro número: 6
                                    {
                                        for(int l = 0; l < 2; l++)
                                        {
                                            if(l == 0)
                                            { resp[lastPosition] = "DAE612"; lastPosition = lastPosition + 1; }
                                            else if(l == 1)
                                            { resp[lastPosition] = "DAE621"; lastPosition = lastPosition + 1; }
                                        }//end for
                                    }//end if
                                }//end for
                            }
                            else if(q == 3)//terceira letra: F
                            {
                                for(int k = 0; k < 2; k++)
                                {
                                    if(k == 0)//primeiro número: 3
                                    {
                                        for(int l = 0; l < 4; l++)
                                        {
                                            if(l == 0)
                                            { resp[lastPosition] = "DAF314"; lastPosition = lastPosition + 1; }
                                            else if(l == 1)
                                            { resp[lastPosition] = "DAF341"; lastPosition = lastPosition + 1; }
                                            else if(l == 2)
                                            { resp[lastPosition] = "DAF323"; lastPosition = lastPosition + 1; }
                                            else if(l == 3)
                                            { resp[lastPosition] = "DAF332"; lastPosition = lastPosition + 1; }
                                        }//end for
                                    }
                                    else if(k == 1)//primeiro número: 6
                                    {
                                        for(int l = 0; l < 2; l++)
                                        {
                                            if(l == 0)
                                            { resp[lastPosition] = "DAF612"; lastPosition = lastPosition + 1; }
                                            else if(l == 1)
                                            { resp[lastPosition] = "DAF621"; lastPosition = lastPosition + 1; }
                                        }//end for
                                    }//end if
                                }//end for
                            }//end if
                        }//end for
                    }
                    else if(j == 3)//segunda letra: E
                    {
                        for(int k = 0; k < 2; k++)
                        {
                            if(k == 0)//primeiro número: 3
                            {
                                for(int l = 0; l < 4; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "DEA314"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "DEA341"; lastPosition = lastPosition + 1; }
                                    else if(l == 2)
                                    { resp[lastPosition] = "DEA323"; lastPosition = lastPosition + 1; }
                                    else if(l == 3)
                                    { resp[lastPosition] = "DEA332"; lastPosition = lastPosition + 1; }
                                }//end for
                            }
                            else if(k == 1)//primeiro número: 6
                            {
                                for(int l = 0; l < 2; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "DEA612"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "DEA621"; lastPosition = lastPosition + 1; }
                                }//end for
                            }//end if
                        }//end for
                    }
                    else if(j == 4)//segunda letra: F
                    {
                        for(int k = 0; k < 2; k++)
                        {
                            if(k == 0)//primeiro número: 3
                            {
                                for(int l = 0; l < 4; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "DFA314"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "DFA341"; lastPosition = lastPosition + 1; }
                                    else if(l == 2)
                                    { resp[lastPosition] = "DFA323"; lastPosition = lastPosition + 1; }
                                    else if(l == 3)
                                    { resp[lastPosition] = "DFA332"; lastPosition = lastPosition + 1; }
                                }//end for
                            }
                            else if(k == 1)//primeiro número: 6
                            {
                                for(int l = 0; l < 2; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "DFA612"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "DFA621"; lastPosition = lastPosition + 1; }
                                }//end for
                            }//end if
                        }//end for
                    }//end if
                }//end for   
            }
            else if(i == 4)//primeira letra: E
            {
                for(int j = 0; j < 2; j++)
                {
                    if(j == 0)//segunda letra: A
                    {
                        for(int k = 0; k < 2; k++)
                        {
                            if(k == 0)//primeiro número: 3
                            {
                                for(int l = 0; l < 4; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "EAD314"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "EAD341"; lastPosition = lastPosition + 1; }
                                    else if(l == 2)
                                    { resp[lastPosition] = "EAD323"; lastPosition = lastPosition + 1; }
                                    else if(l == 3)
                                    { resp[lastPosition] = "EAD332"; lastPosition = lastPosition + 1; }
                                }//end for
                            }
                            else if(k == 1)//primeiro número: 6
                            {
                                for(int l = 0; l < 2; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "EAD612"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "EAD621"; lastPosition = lastPosition + 1; }
                                }//end for
                            }//end if
                        }//end for
                    }
                    else if(j == 1)//segunda letra: D
                    {
                        for(int k = 0; k < 2; k++)
                        {
                            if(k == 0)//primeiro número: 3
                            {
                                for(int l = 0; l < 4; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "EDA314"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "EDA341"; lastPosition = lastPosition + 1; }
                                    else if(l == 2)
                                    { resp[lastPosition] = "EDA323"; lastPosition = lastPosition + 1; }
                                    else if(l == 3)
                                    { resp[lastPosition] = "EDA332"; lastPosition = lastPosition + 1; }
                                }//end for
                            }
                            else if(k == 1)//primeiro número: 6
                            {
                                for(int l = 0; l < 2; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "EDA612"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "EDA621"; lastPosition = lastPosition + 1; }
                                }//end for
                            }//end if
                        }//end for
                    }//end if
                }//end for
            }
            else if(i == 5)//primeira letra: F
            {
                for(int j = 0; j < 2; j++)
                {
                    if(j == 0)//segunda letra: A
                    {
                        for(int k = 0; k < 2; k++)
                        {
                            if(k == 0)//primeiro número: 3
                            {
                                for(int l = 0; l < 4; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "FAD314"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "FAD341"; lastPosition = lastPosition + 1; }
                                    else if(l == 2)
                                    { resp[lastPosition] = "FAD323"; lastPosition = lastPosition + 1; }
                                    else if(l == 3)
                                    { resp[lastPosition] = "FAD332"; lastPosition = lastPosition + 1; }
                                }//end for
                            }
                            else if(k == 1)//primeiro número: 6
                            {
                                for(int l = 0; l < 2; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "FAD612"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "FAD621"; lastPosition = lastPosition + 1; }
                                }//end for
                            }//end if
                        }//end for
                    }
                    else if(j == 1)//segunda letra: D
                    {
                        for(int k = 0; k < 2; k++)
                        {
                            if(k == 0)//primeiro número: 3
                            {
                                for(int l = 0; l < 4; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "FDA314"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "FDA341"; lastPosition = lastPosition + 1; }
                                    else if(l == 2)
                                    { resp[lastPosition] = "FDA323"; lastPosition = lastPosition + 1; }
                                    else if(l == 3)
                                    { resp[lastPosition] = "FDA332"; lastPosition = lastPosition + 1; }
                                }//end for
                            }
                            else if(k == 1)//primeiro número: 6
                            {
                                for(int l = 0; l < 2; l++)
                                {
                                    if(l == 0)
                                    { resp[lastPosition] = "FDA612"; lastPosition = lastPosition + 1; }
                                    else if(l == 1)
                                    { resp[lastPosition] = "FDA621"; lastPosition = lastPosition + 1; }
                                }//end for
                            }//end if
                        }//end for
                    }//end if
                }//end for
            }//end if
        }//end for

        return(resp);
    }//end listaDeChaves()

    /**
     * Metodo main
     */
    public static void main(String []args)
    {
        //Total de chaves é a multiplicação entre todas as combinações de letras e todas as combinações
        //de números.
        int totalDeChaves = (letras1 + letras2 + letras3) * (tres + seis);
        String[] listaChaves = listaDeChaves(totalDeChaves);

        System.out.println("Lista de chaves: ");

        for(int i = 0; i < listaChaves.length; i++)
        { System.out.println(listaChaves[i]); }

        //Lembrando que o tempo de teste de todas as chaves, para que consiga o acesso ao cofre antes de soar
        //o alarme, tem que ser menor que 5 minutos(300 segundos)
        int tempoDeTeste = 2 * totalDeChaves;

        System.out.println("Tempo para testar todas as combinações: " + tempoDeTeste + " segundos!");
    }//end main()
}//end class