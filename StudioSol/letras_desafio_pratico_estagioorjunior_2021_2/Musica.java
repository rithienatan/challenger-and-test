/**
 * @author Rithie Natan Carvalhaes Prado
 * @version 0.1.0
 */
//---------- Imports ----------
import java.lang.Comparable;

//---------- class ----------
public class Musica implements Comparable<Musica>
{
    public String name;
    private int points;
    public String[] nameInParts;

    /**
     * Constructor
     * 
     * @param name Nome da musica
     * @param points Pontos da música
     * @param nameInParts Lista de palavras da música
     */
    public Musica(String nome, int points, String[] nameInParts)
    { this.name = nome; this.points = points; this.nameInParts = nameInParts; }

    //---------- get(s) and set(s) -----------
    public int getPoints()
    { return(this.points); }

    public void setPoints(int newPoints)
    { this.points = newPoints; }
    //---------- end get(s) and set(s) -----------

    /**
     * Compara os pontos entre duas musicas para ordenar de forma decrescente
     * 
     * @param compareMusica Recebe outro objeto musica
     * 
     * @return Retorna os pontos comparados
     */
    public int compareTo(Musica compareMusica)
    {
        int comparePoints = ((Musica) compareMusica).points;

        return(comparePoints - this.points);
    }//end compareTo()
}//end class