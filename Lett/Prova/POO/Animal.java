/**
 * @author Rithie Natan Carvalhaes Prado
 * Data: 04/09/2020
 * 
 * @version 0.1.0
 */

//---------- class ----------
public class Animal
{
    private int idade;
    private double tamanho;
    private String som;

    /**
     * Constructor padrão
     */
    public Animal()
    { this(0, 0.0, null); }

    /**
     * Constructor alternativo
     */
    public Animal(int idade, double tamanho, String som)
    {
        this.idade = idade;
        this.tamanho = tamanho;
        this.som = som;
    }//end constructor()

    //----- get(s) and set(s)-----//
    public int getIdade()
    { return(this.idade); }

    public void setIdade(int idade)
    { this.idade = idade; }

    public double getTamanho()
    { return(this.tamanho); }

    public void setTamanho(double tamanho)
    { this.tamanho = tamanho; }

    public String getSom()
    { return(this.som); }

    public void setSom(String som)
    { this.som = som; }
}//end class