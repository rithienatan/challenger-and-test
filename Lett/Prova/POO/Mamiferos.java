/**
 * @author Rithie Natan Carvalhaes Prado
 * Data: 04/09/2020
 * 
 * @version 0.1.0
 */

//---------- class ----------
public class Mamiferos extends Animal
{
    String nomeMamifero;
    private boolean voar;
    private boolean amamentar;
    private String pelo;

    /**
     * Construtor padrão
     */
    public Mamiferos()
    { this(null, false, false, null); }

    /**
     * Constructor alternativo
     */
    public Mamiferos(String nomeMamifero, boolean voar, boolean amamentar, String pelo)
    {
        this.nomeMamifero = nomeMamifero;
        this.voar = voar;
        this.amamentar = amamentar;
        this.pelo = pelo;
    }//end constructor()

    //----- get(s) and set(s)-----//
    public String getNomeMamifero()
    { return(this.nomeMamifero); }

    public void setNomeMamifero(String nomeMamifero)
    { this.nomeMamifero = nomeMamifero; }

    public boolean getVoar()
    { return(this.voar); }

    public void setVoar(boolean voar)
    { this.voar = voar; }

    public boolean getAmamentar()
    { return(this.amamentar); }

    public void setAmamentar(boolean amamentar)
    { this.amamentar = amamentar; }

    public String getPelo()
    { return(this.pelo); }

    public void setPelo(String pelo)
    { this.pelo = pelo; }

    //----- other functions -----//
    /**
     * Printa informações de um determinado animal
     */
    public void informacoes()
    { 
        System.out.println(this.nomeMamifero);
        System.out.println("- Idade " + this.getIdade() + " meses.");
        System.out.println("- Tamanho " + this.getTamanho());
        System.out.println("- O som emitido é um " + this.getSom());

        if(voar == true)
        { System.out.println("- O " + this.nomeMamifero + " pode voar."); }

        if(amamentar == true)
        { System.out.println("- Amamenta."); }

        System.out.println("- Pelo " + this.pelo);
    }//end informacoes()
}//end class