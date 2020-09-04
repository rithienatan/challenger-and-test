/**
 * @author Rithie Natan Carvalhaes Prado
 * Data: 04/09/2020
 * 
 * @version 0.1.0
 */

//---------- class ----------
public class Aves extends Animal
{
    private String nomeAve;
    private boolean voar;
    private boolean ovos;
    private String pena;

    /**
     * Construtor padrão
     */
    public Aves()
    { this(null, false, false, null); }

    /**
     * Constructor alternativo
     */
    public Aves(String nomeAve, boolean voar, boolean ovos, String pena)
    {
        this.nomeAve = nomeAve;
        this.voar = voar;
        this.ovos = ovos;
        this.pena = pena;
    }//end constructor()

    //----- get(s) and set(s)-----//
    public String getNomeAve()
    { return(this.nomeAve); }

    public void setNomeAve(String nomeAve)
    { this.nomeAve = nomeAve; }

    public boolean getVoar()
    { return(this.voar); }

    public void setVoar(boolean voar)
    { this.voar = voar; }

    public boolean getOvos()
    { return(this.ovos); }

    public void setOvos(boolean ovos)
    { this.ovos = ovos; }

    public String getPena()
    { return(this.pena); }

    public void setPena(String pena)
    { this.pena = pena; }

    //----- other functions -----//
    /**
     * Printa informações de um determinado animal
     */
    public void informacoes()
    { 
        System.out.println(this.nomeAve);
        System.out.println("- Idade " + this.getIdade() + " meses.");
        System.out.println("- Tamanho " + this.getTamanho());
        System.out.println("- O som emitido é um " + this.getSom());

        if(voar == true)
        { System.out.println("- O " + this.nomeAve + " pode voar."); }

        if(ovos == true)
        { System.out.println("- Bota ovos."); }

        System.out.println("- Pena " + this.pena);
    }//end informacoes()
}//end class