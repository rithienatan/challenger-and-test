export default class Motor
{
    id;
    posicionamentoCilindro;
    cilindros;
    litragem;
    observacao;

    constructor(id, posicionamentoCilindro, cilindros, litragem, observacao)
    {
        this.id = id;
        this.posicionamentoCilindro = posicionamentoCilindro;
        this.cilindros = cilindros;
        this.litragem = litragem;
        this.observacao = observacao;
    }//end constructor()
}//end class