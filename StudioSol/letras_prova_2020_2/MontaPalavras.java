/**
 * @author Rithie Natan Carvalhaes Prado
 * @email rithienatan@gmail.com
 * 
 * @version 1.0.0
 *
 * Descrição da resolução da prova:
 * 
 * 1º Em primeira instância, é criado uma classe chamada 'Letra' e 'BancoDePalavras',
 *    no qual são utilizadas para armazenar o banco de palavras e cada letra com sua respectivo valor.
 *    Nesse caso, a estrutura de dados utilizadas para armazena-lás são: 'vetor' e 'ArrayList'.
 * 
 * 2º Criação da classe 'MontaPalavras'
 *    2.1º Fazer a leitura de entrada do usuário, após a leitura, o metodo criado 'replaceAcento',
 *         substituirá todas as letras que foram digitadas pelo usuário que estão com acento e 'Ç'.
 *    2.2º Após a leitura da entrada, será utilizado o método 'formaPalavra', no qual será reponsável
 *         pela montagem e seleção da melhor palavra possível. Este metodo, após formar todas as palavras
 *         possíveis, ele verifica e escolhe a palavra de maior pontuação. Em caso de empate na pontuação,
 *         o critério de desempate é o tamanho de cada palavra, sendo assim escolhida a menor.
 *    2.3º O método 'calcularPontucacao' é responsável por calcular a pontuação de cada palavra.
 *    2.4º Por último, para imprimir os caractéres que sobraram, utilizo o metodo 'letrasRestantes', no
 *         qual separa a palavra formada da entrada de caracteres iniciais.
 */

//----- imports libs -----//
import java.io.*;
import java.util.*;
import java.text.*;

//----- Classe Letras -----//
class Letra
{
    char word;
    int value;

    /**
     * Construtor
     * 
     * @param word Recebe uma letra
     * @param value Recebe o valor desta letra
     */
    public Letra(char word, int value)
    {
        this.word = word;
        this.value = value;
    }//end construtor
}//end class

//----- Classe BancoDePalavras -----//
class BancoDePalavras
{
    ArrayList<Letra> letras;

    //----- cadastrar todas as letras disponíveis -----//
    String palavras[] = {"Abacaxi", "Manada", "mandar", "porta", "mesa", "Dado", "Mangas", "Já", "coisas", 
    "radiografia", "matemática", "Drogas", "prédios", "implementação", "computador", "balão", "Xícara", 
    "Tédio", "faixa", "Livro", "deixar", "superior", "Profissão", "Reunião", "Prédios", "Montanha", 
    "Botânica", "Banheiro", "Caixas", "Xingamento", "Infestação", "Cupim", "Premiada", "empanada", "Ratos",
    "Ruído", "Antecedente", "Empresa", "Emissário", "Folga", "Fratura", "Goiaba", "Gratuito",
    "Hídrico", "Homem", "Jantar", "Jogos", "Montagem", "Manual", "Nuvem", "Neve", "Operação",
    "Ontem", "Pato", "Pé", "viagem", "Queijo", "Quarto", "Quintal", "Solto", "rota", "Selva",
    "Tatuagem", "Tigre", "Uva", "Último", "Vitupério", "Voltagem", "Zangado", "Zombaria", "Dor"};

    /**
     * Construtor
     */
    public BancoDePalavras()
    {
        //----- cadastrar todas as letras e suas pontuações -----//
        letras = new ArrayList<Letra>();

        //inserir todas as letras que tem valor = 1
        letras.add(new Letra('E', 1));
        letras.add(new Letra('A', 1));
        letras.add(new Letra('I', 1));
        letras.add(new Letra('O', 1));
        letras.add(new Letra('N', 1));
        letras.add(new Letra('R', 1));
        letras.add(new Letra('T', 1));
        letras.add(new Letra('L', 1));
        letras.add(new Letra('S', 1));
        letras.add(new Letra('U', 1));

        //inserir todas as letras que tem valor = 2
        letras.add(new Letra('W', 2));
        letras.add(new Letra('D', 2));
        letras.add(new Letra('G', 2));

        //inserir todas as letras que tem valor = 3
        letras.add(new Letra('B', 3));
        letras.add(new Letra('C', 3));
        letras.add(new Letra('M', 3));
        letras.add(new Letra('P', 3));

        //inserir todas as letras que tem valor = 4
        letras.add(new Letra('F', 4));
        letras.add(new Letra('H', 4));
        letras.add(new Letra('V', 4));

        //inserir todas as letras que tem valor = 8
        letras.add(new Letra('J', 8));
        letras.add(new Letra('X', 8));

        //inserir todas as letras que tem valor = 10
        letras.add(new Letra('Q', 10));
        letras.add(new Letra('Z', 10));
    }//end construtor()
}//end class

//----- Classe principal -----//
class MontaPalavras
{

    /**
     * Metodo que troca todas as letras com Acento ou 'Ç'
     * 
     * @param entrada recebe uma string de entrada
     * 
     * @return retorna a string passada pelo parametro
     */
    public static String replaceAcentos(String entrada)
    {
        //---- replace caracter especial A -----//
        if(entrada.contains("À") || entrada.contains("Á") || entrada.contains("Â") ||
           entrada.contains("Ã") || entrada.contains("Ä"))
        {
            entrada = entrada.replace("À", "A"); entrada = entrada.replace("Á", "A");
            entrada = entrada.replace("Â", "A"); entrada = entrada.replace("Ã", "A");
            entrada = entrada.replace("Ä", "A");
        }//end if

        //---- replace caracter especial E -----//
        if(entrada.contains("È") || entrada.contains("É") || entrada.contains("Ê") ||
           entrada.contains("Ë"))
        {
            entrada = entrada.replace("È", "E"); entrada = entrada.replace("É", "E");
            entrada = entrada.replace("Ê", "E"); entrada = entrada.replace("Ë", "E");
        }//end if

        //---- replace caracter especial I -----//
        if(entrada.contains("Ì") || entrada.contains("Í") || entrada.contains("Î") ||
           entrada.contains("Ï"))
        {
            entrada = entrada.replace("Ì", "I"); entrada = entrada.replace("Í", "I");
            entrada = entrada.replace("Î", "I"); entrada = entrada.replace("Ï", "I");
        }//end if

        //---- replace caracter especial O -----//
        if(entrada.contains("Ò") || entrada.contains("Ó") || entrada.contains("Ô") ||
           entrada.contains("Õ") || entrada.contains("Ö"))
        {
            entrada = entrada.replace("Ò", "O"); entrada = entrada.replace("Ó", "O");
            entrada = entrada.replace("Ô", "O"); entrada = entrada.replace("Õ", "O");
            entrada = entrada.replace("Ö", "O");    
        }//end if

        //---- replace caracter especial U -----//
        if(entrada.contains("Ù") || entrada.contains("Ú") || entrada.contains("Û") ||
           entrada.contains("Ü"))
        {
            entrada = entrada.replace("Ù", "U"); entrada = entrada.replace("Ú", "U");
            entrada = entrada.replace("Û", "U"); entrada = entrada.replace("Ü", "U");
        }//end if

        //---- replace caracter especial C -----//
        if(entrada.contains("Ç"))
        { entrada = entrada.replace("Ç", "C"); }

        return(entrada);
    }//end replaceAcentos()

    /**
     * Metodo que monta a melhor palavra disponível
     * 
     * @param dbPalavras Recebe a classe BancoDePalavras
     * @param entrada recebe a entrada digitada pelo usuário
     * 
     * @return Retorna a melhor palavra montada possível
     */
    public static String formaPalavra(BancoDePalavras dbPalavras, String entrada)
    {
        ArrayList<String> resposta = new ArrayList<String>();
        ArrayList<Integer> pontuacao = new ArrayList<Integer>();

        int auxPontuacao = 0;//sempre estára com a maior pontuação das palavras

        entrada = replaceAcentos(entrada);

        for(int i = 0; i < dbPalavras.palavras.length; i++)
        {
            String palavraDoBanco = dbPalavras.palavras[i].toUpperCase();
            palavraDoBanco = replaceAcentos(palavraDoBanco);

            String possivelResposta = "";
            String auxEntrada = entrada;//variavel auxiliar para leitura da entrada
            String aux = "";//variavel reconfigura a String de entrada

            for(int j = 0; j < palavraDoBanco.length(); j++)
            {
                for(int z = 0; z < auxEntrada.length(); z++)
                {
                    if(palavraDoBanco.charAt(j) == auxEntrada.charAt(z))
                    {
                        for(int h = z+1; h < auxEntrada.length(); h++)
                        { aux = aux + auxEntrada.charAt(h); }

                        z = auxEntrada.length(); 
                        possivelResposta = possivelResposta + palavraDoBanco.charAt(j);
                    }
                    else
                    { aux = aux + auxEntrada.charAt(z); }
                }//end for

                auxEntrada = aux;
                aux = "";
            }//end for

            //adiciona a palavra e seu valor total no array de palavras e 
            //de respostas respectivamente
            if(possivelResposta.equals("") == false && possivelResposta.equals(palavraDoBanco) == true)
            { 
                resposta.add(possivelResposta); 

                int value = calcularPontuacao(dbPalavras, possivelResposta);

                if(auxPontuacao <= value)//armazena a maior pontuação numa variavel auxiliar
                { auxPontuacao = value; }

                pontuacao.add(value); 
            }//endif
        }//end for

        String resp = "";

        for(int i = 0; i < resposta.size(); i++)
        {
            if(auxPontuacao == pontuacao.get(i) && resp.length() <= resposta.get(i).length())
            { resp = resposta.get(i); } 
        }//end for

        return(resp);
    }//end formaPalavra()

    /**
     * Calcula a pontuação de uma palavra
     * 
     * @param resposta Recebe a string refente a palavra montada
     * @param dbPalavras Recebe a classe do banco de palavras onde tem as letras registradas
     * 
     * @return Retorna a pontuação da palavra
     */
    public static int calcularPontuacao(BancoDePalavras dbPalavras, String resposta)
    {
        int resp = 0;

        for(int i = 0; i < resposta.length(); i++)
        {
            for(int j = 0; j < dbPalavras.letras.size(); j++)
            {
                if(resposta.charAt(i) == dbPalavras.letras.get(j).word)
                { resp = resp + dbPalavras.letras.get(j).value; j = dbPalavras.letras.size(); }
            }//end for
        }//end for

        return(resp);
    }//end calculaPontuacao()

    /**
     * Verifica as letras restantes
     * 
     * @param resposta Palavra de resultado
     * @param entrada Letras digitadas pelo usuário
     * 
     * @return Retorna uma string com as letras restantes
     */
    public static String letrasRestantes(String resposta, String entrada)
    {
        String resp = entrada;

        for(int i = 0; i < resposta.length(); i++)
        {
            String sobra = "";
            for(int z = 0; z < resp.length(); z++)
            {
                if(resposta.charAt(i) == resp.charAt(z))
                {
                    for(int h = z+1; h < resp.length(); h++)
                    { sobra = sobra + resp.charAt(h); }

                    z = resp.length(); 
                }
                else
                { sobra = sobra + resp.charAt(z); }
            }//end for

            resp = sobra;
            sobra = "";
        }//end for

        return(resp);
    }//end letrasRestantes()

    /**
     * Metodo main
     */
    public static void main(String []args) throws IOException
    {
        BancoDePalavras dbPalavras = new BancoDePalavras();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("# Digite as letras disponíveis nessa jogada: ");
        String entrada = br.readLine().toUpperCase();

        System.out.println("#");

        //----- resposta -----//
        String resposta = formaPalavra(dbPalavras, entrada);
        int pontuacao = calcularPontuacao(dbPalavras, resposta);
        System.out.print("# " + resposta + ", palavra de " + pontuacao + " pontos\n");

        //----- caracteres que sobraram ----//
        System.out.println("# Sobraram: " + letrasRestantes(resposta, entrada));
    }//end main()
}//end class