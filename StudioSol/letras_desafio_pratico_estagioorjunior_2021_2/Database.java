/**
 * @author Rithie Natan Carvalhaes Prado
 * @version 0.1.0
 */
//---------- Imports ----------
import java.util.ArrayList;
import java.util.Collections;


//---------- class ----------
public class Database
{
    public String[] listaDeMusicas = {
        "Que Tiro Foi Esse", "Deixe-me Ir", "Sobre Nós (Poesia Acústica #2)", "Apelido Carinhoso", 
        "Tô Com Moral No Céu", "Lugar Secreto", "Jó", "Perfect", "Fica Tranquilo", 
        "Capricorniana (Poesia Acústica #3)", "Amor da Sua Cama", "Nessas Horas", "Downtown (part. J Balvin)", 
        "Você Vai Entender", "Aquieta Minh'alma", "Havana", "Havana feat Young Thug", 
        "Vai Malandra (part. MC Zaac, Maejor, Tropkillaz e DJ Yuri Martins)", "Prioridade", 
        "Trevo (Tu) (part. Tiago Iorc)", "Machika (part. Anitta y Jeon)", "Trem Bala", "Moça do Espelho", 
        "Safadômetro", "Eu Cuido de Ti", "Too Good At Goodbyes", "Duro Igual Concreto", "Aquela Pessoa", 
        "Rap Lord (part. Jonas Bento)", "Contrato", "IDGAF", "De Quem É a Culpa?", "Não Troco", "Quase", 
        "Deus É Deus", "Anti-Amor", "Eu Era", "Cerveja de Garrafa (Fumaça Que Eu Faço)", "Não Deixo Não",
        "Rockstar feat 21 Savage", "New Rules", "Photograph", "Eu Juro", 
        "Ninguém Explica Deus (part. Gabriela Rocha)", "Lindo És", "Bengala e Crochê", "Pirata e Tesouro", 
        "A Libertina", "Pesadão (part. Marcelo Falcão)", "Aleluia (part. Michely Manuely)", "Eu Cuido de Ti", 
        "Oi", "Céu Azul", "Never Be The Same", "My Life Is Going On", "Imaturo", "Gucci Gang", "Cuidado", 
        "K.O.", "Échame La Culpa", "Échame La Culpa feat Luis Fonsi", "Tem Café (part. MC Hariel)",
        "Raridade", "Te Vi Na Rua Ontem", "Dona Maria (feat Jorge)", "Fica (part. Matheus e Kauan)",
        "9 Meses (Oração do Bebê)", "Muleque de Vila", "A Vitória Chegou", "Ar Condicionado No 15",
        "Vida Loka Também Ama", "Pegada Que Desgrama", "Transplante (part. Bruno & Marrone)",
        "Na Conta da Loucura", "Tem Café (part. Gaab)", "Apelido Carinhoso", "Perfect Duet",
        "Perfect Duet feat Beyoncé", "Coração de Aço", "Minha Morada", "Amar, Amei", "Regime Fechado", 
        "O Escudo", "Minha Namorada", "Quero Conhecer Jesus (O Meu Amado é o Mais Belo)", 
        "Me Leva Pra Casa", "Como é Que Faz? (part. Rob Nunes)", "The Scientist", "Bella Ciao", 
        "O Que Tiver Que Ser Vai Ser", "Corpo Sensual (part. Mateus Carrilho)", "Cor de Marte", 
        "Bom Rapaz (part. Jorge e Mateus)", "Vidinha de Balada", "Não Era Você", "Em Teus Braços", 
        "De Trás Pra Frente", "All Of Me", "Believer", "A Música Mais Triste do Ano", "Rabiola", 
        "Paraíso (part. Pabllo Vittar)", "Vem Pra Minha Vida"
    };

    public ArrayList<Musica> musicaDB;

    /**
     * Constructor
     */
    public Database()
    {
        musicaDB = new ArrayList<Musica>();

        for(int i = 0; i < listaDeMusicas.length; i++)
        {
            if(listaDeMusicas[i].contains("feat") == true)
            { musicaDB.add(new Musica(listaDeMusicas[i], -5, listaDeMusicas[i].split(" "))); }
            else
            { musicaDB.add(new Musica(listaDeMusicas[i], 0, listaDeMusicas[i].split(" "))); }
        }//end for
    }//end Constructor()

    /**
     * Ordena de forma decrescente a lista de musicas de acordo com os pontos
     * de cada musica.
     * 
     * @param buscar Recebe a entrada do usuário
     * 
     * @return Retorna um array 
     */
    public ArrayList<Musica> BuscarMusica(String[] buscar)
    {
        //percorrer a lista de músicas
        for(int i = 0; i < musicaDB.size(); i++)
        {
            //percorrer por cada palavra de cada música individualmente
            for(int j = 0; j < musicaDB.get(i).nameInParts.length; j++)
            {
                String musicWord = musicaDB.get(i).nameInParts[j];

                //percorrer a lista de palavras inseridas pelo usuário
                for(int k = 0; k < buscar.length; k++)
                {
                    int musicPoints = musicaDB.get(i).getPoints();

                    //verificar se as palavras são iguais
                    if(buscar[k].equals(musicWord) == true)
                    { musicaDB.get(i).setPoints(musicPoints + 10 + buscar[k].length()); }
                    else
                    {
                        //se as palavras não são iguais, percorrer letra por letra
                        int individualPoints = 0;

                        for(int l = 0; l < musicWord.length() && l < buscar[k].length(); l++)
                        {
                            if(musicWord.charAt(l) == buscar[k].charAt(l))
                            { individualPoints = individualPoints + 1; }
                        }//end for

                        musicaDB.get(i).setPoints(musicPoints + individualPoints);
                    }//end if
                }//end for
            }//end for
        }//end for

        Collections.sort(musicaDB);

        return(musicaDB);
    }//end BuscarMusica()
}//end class