### Studio Sol - Letras.com.br - Prova Estágio 2020.2

  #### Descrição da resolução da prova:
 
 1º Em primeira instância, é criado uma classe chamada 'Letra' e 'BancoDePalavras',
    no qual são utilizadas para armazenar o banco de palavras e cada letra com sua respectivo valor.
    Nesse caso, a estrutura de dados utilizadas para armazena-lás são: 'vetor' e 'ArrayList'.
 
 2º Criação da classe 'MontaPalavras'
    2.1º Fazer a leitura de entrada do usuário, após a leitura, o metodo criado 'replaceAcento',
         substituirá todas as letras que foram digitadas pelo usuário que estão com acento e 'Ç'.
    2.2º Após a leitura da entrada, será utilizado o método 'formaPalavra', no qual será reponsável
         pela montagem e seleção da melhor palavra possível. Este metodo, após formar todas as palavras
         possíveis, ele verifica e escolhe a palavra de maior pontuação. Em caso de empate na pontuação,
         o critério de desempate é o tamanho de cada palavra, sendo assim escolhida a menor.
    2.3º O método 'calcularPontucacao' é responsável por calcular a pontuação de cada palavra.
    2.4º Por último, para imprimir os caractéres que sobraram, utilizo o metodo 'letrasRestantes', no
         qual separa a palavra formada da entrada de caracteres iniciais.