//---------- Custom Imports ----------
import Motor from "./Motor";


//---------- Class ---------
export default class Carro
{
    id;
    marca;
    modelo;
    cor;
    motorID;
    motorAttribute;

    /**
     * Default constructor
     * 
     * @param {Number} id 
     * @param {String} marca 
     * @param {String} modelo 
     * @param {String} cor 
     * @param {Number} motorID
     * @param {Motor} motorAttribute
     */
    constructor(id, marca, modelo, cor, motorID, motorAttribute)
    {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.motorID = motorID;
        this.motorAttribute = motorAttribute;
    }//end constructor()
}//end class