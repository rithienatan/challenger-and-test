/**
 * @author Rithie Natan Carvalhaes Prado
 * Data: 04/09/2020
 * 
 * @version 0.1.0
 */

//---------- class ----------
public interface TipoAnimal
{
    public void addGalinha(int idade, double tamanho, String cor);
    public void addPato(int idade, double tamanho, String cor);
    public void addVaca(int idade, double tamanho, String cor);
    public void addMorcego(int idade, double tamanho, String cor);
    public void mostrar();
}//end class