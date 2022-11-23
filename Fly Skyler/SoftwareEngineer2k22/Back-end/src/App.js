//----------- Import libs ----------
import React, {useState} from 'react';
import axios from 'axios';


//----------- Style Imports ----------
import 'bootstrap/dist/css/bootstrap.min.css';
import Container from 'react-bootstrap/Container';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import FloatingLabel from 'react-bootstrap/FloatingLabel';
import Table from 'react-bootstrap/Table';


//----------- Custom Style Imports ----------
import './App.css';
 

//----------- Function App ----------
/**
 * App page
 * 
 * @returns {JSX}
 */
export default function App() 
{
  const [info, setInfo] = useState("");

  /**
   * Search for postal code
   * 
   * @param {String} input 
   */
  const searchPostalCode = async (input) => {
    const url = "https://ws.apicep.com/cep/06233-030.json";

    const res = await axios.get(url);
    console.log(res);
  };


  return (
    <>
      <header>
        <h1>Skyler Mini Case</h1>3

        <Container>
          <i class="fa-solid fa-location-check"></i>
          <h2>Postal Code Search</h2>
        </Container>
      </header>

      <main>
        <section className="search-postalcode">
          <Form>
            <FloatingLabel
              controlId="cepInput"
              label="Digite o CEP"
            >
              <Form.Control type="text" onChange={(e) => setInfo(e.target.value)}></Form.Control>
            </FloatingLabel>
          </Form>

          <Button onClick={() => searchPostalCode(null)}>Pesquisar</Button>
        </section>

        <section>
          <Table>
            <thead></thead>
            <tbody></tbody>
          </Table>
        </section>
      </main>
    </>
  );
}//end App()
