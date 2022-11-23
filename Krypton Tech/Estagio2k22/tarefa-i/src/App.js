//---------- Import Libs ----------
import {React, useState, useEffect} from "react";
import axios from "axios";


//---------- Import Middlewares ----------
import Carro from "./middleware/Carro";
import Motor from "./middleware/Motor";


//---------- Import Components ----------
import 'bootstrap/dist/css/bootstrap.min.css';
import Container from "react-bootstrap/Container";
import Accordion from "react-bootstrap/Accordion";
import ListGroup from "react-bootstrap/ListGroup";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import FloatingLabel from "react-bootstrap/esm/FloatingLabel";


//---------- Custom CSS ----------
import './App.css';


//---------- App ---------
/**
 * Main App
 * 
 * @returns {JSX}
 */
export default function App() 
{
  const [carList, setCarList] = useState([]);

  //--------- States para o forms na criação de Carros ----------
  const [marca, setMarca] = useState("");
  const [modelo, setModelo] = useState("");
  const [cor, setCor] = useState("");
  const [posCilindros, setPosCilindros] = useState("");
  const [cilindros, setCilindros] = useState("");
  const [litragem, setLitragem] = useState("");
  const [observacao, setObservacao] = useState("");

  /**
   * Inseri um novo carro na lista
   * 
   * @param {Event} e 
   */
  const inserirCarro = (e) => {
    console.log(marca)
    console.log(modelo)
    console.log(cor)
    console.log(posCilindros)
    console.log(cilindros)
    console.log(litragem)
    console.log(observacao)

    if((marca === null || marca === "") ||
       (modelo === null || modelo === "") ||
       (cor === null || cor === "") ||
       (posCilindros === null || posCilindros === "") ||
       (cilindros === null || cilindros === "") ||
       (litragem === null || litragem === "") ||
       (observacao === null || observacao === ""))
    { alert("Campos vazios!"); }
    else
    {
      e.preventDefault();

      const lastElement = carList[carList.length-1];
      const newList = [...carList];
      newList.push(new Carro(
        lastElement.id + 1,
        marca,
        modelo,
        cor,
        lastElement.id + 1,
        new Motor(
          lastElement.id + 1,
          posCilindros,
          cilindros,
          litragem,
          observacao
        )
      ));

      setCarList(newList);
    }//end if
  };


  /**
   * Deletar carro
   * 
   * @param {Number} id 
   */
  const deletarCarro = (id) => {
    const newList = carList.filter(element => element.id !== id);
    setCarList(newList);
  };


  /**
   * Get Car and Motor list by API
   */
  const getCarList = async () => {
    const url = "https://apiintranet.kryptonbpo.com.br/test-dev/exercise-1";
    const res = await axios.get(url);

    if(res.status === 200)
    {
      const data = res.data;
      const motorList = data.motores;

      setCarList(data.carros.map((element) => {
        const motor = motorList.find(motorElement => motorElement.id === element.motor_id);

        return(new Carro(
          element.id,
          element.marca,
          element.modelo,
          element.cor,
          element.motor_id,
          new Motor(
            motor.id,
            motor.posicionamento_cilindros,
            motor.cilindros,
            motor.litragem,
            motor.observacao
          )
        ));
      }));
    }
    else
    { console.error(res); }
  };

  useEffect(() => {
    //run only on first render
    getCarList();
  }, []);


  return (
    <>
      <Container fluid as="header" className="header">
        <h1>Tarefa I</h1>
      </Container>

      <main className="main">
        <Container as="section" className="formsCar">
          <h3>Crie um novo carro</h3>

          <Form>
            <Form.Group className="formElement">
              <FloatingLabel controlId="marcaInput" label="Marca">
                <Form.Control type="text" placeholder="marca" onChange={(e) => setMarca(e.target.value)} />
              </FloatingLabel>
            </Form.Group>

            <Form.Group className="formElement">
              <FloatingLabel controlId="modeloInput" label="Modelo">
                <Form.Control type="text" placeholder="modelo" onChange={(e) => setModelo(e.target.value)} />
              </FloatingLabel>
            </Form.Group>

            <Form.Group className="formElement">
              <FloatingLabel controlId="corInput" label="Cor">
                <Form.Control type="text" placeholder="cor" onChange={(e) => setCor(e.target.value)} />
              </FloatingLabel>
            </Form.Group>

            <h4>Motor</h4>
            <Form.Group className="formElement">
              <FloatingLabel controlId="posCinInput" label="Posicionamento dos Cilindros">
                <Form.Control type="text" placeholder="Posicionamento dos Cilindros" onChange={(e) => setPosCilindros(e.target.value)} />
              </FloatingLabel>
            </Form.Group>

            <Form.Group className="formElement">
              <FloatingLabel controlId="cilindrosInput" label="Cilindros">
                <Form.Control type="text" placeholder="Cilindros" onChange={(e) => setCilindros(e.target.value)} />
              </FloatingLabel>
            </Form.Group>

            <Form.Group className="formElement">
              <FloatingLabel controlId="posLitragem" label="Litragem">
                <Form.Control type="text" placeholder="Litragem" onChange={(e) => setLitragem(e.target.value)} />
              </FloatingLabel>
            </Form.Group>

            <Form.Group className="formElement">
              <FloatingLabel controlId="posObservacao" label="Observação">
                <Form.Control type="text" placeholder="Obervação" onChange={(e) => setObservacao(e.target.value)} />
              </FloatingLabel>
            </Form.Group>

            <Button onClick={(e) => inserirCarro(e)}>Inserir</Button>
          </Form>
        </Container>
          
        <Container className="visualizarCar" as="section">
          <h3>Visualizar Carros</h3>

          <Accordion defaultActiveKey="0">
            {carList.map((element) => {
              return(
                <Accordion.Item eventKey={element.id} key={element.id}>
                  <Accordion.Header>{element.marca} - {element.modelo}</Accordion.Header>

                  <Accordion.Body>
                    <ListGroup className="carAttributes">
                      <ListGroup.Item>Cor: {element.cor}</ListGroup.Item>
                      <ListGroup.Item>Posicionamento de Cilindros: {element.motorAttribute.posicionamentoCilindro}</ListGroup.Item>
                      <ListGroup.Item>Cilindros: {element.motorAttribute.cilindros}</ListGroup.Item>
                      <ListGroup.Item>Litragem: {element.motorAttribute.litragem}</ListGroup.Item>
                      <ListGroup.Item>Observação: {element.motorAttribute.observacao}</ListGroup.Item>
                    </ListGroup>

                    <Button onClick={() => deletarCarro(element.id)}>Deletar</Button>
                  </Accordion.Body>
                </Accordion.Item>
              );
            })}
          </Accordion>
        </Container>
      </main>
    </>
  );
}//end App()