/*---------- Imports ----------*/
import React, { useState, useEffect, useCallback } from 'react';
import Head from 'next/head';


/*---------- Custom Imports ----------*/
import { StarWarsShips } from '../Services/SWAPI';


/*---------- Bootstrap Imports ----------*/
import 'bootstrap/dist/css/bootstrap.min.css';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Card from 'react-bootstrap/Card';
import Spinner from 'react-bootstrap/Spinner';

/*---------- Styles ----------*/
import HomeStyle from '../styles/Home.module.css';


/*---------- Exports ----------*/
/**
 * Home page
 * 
 * @returns Home page
 */
export default function Home() 
{
  /*--------- useState ----------*/
  const [ships, setShips] = useState([]);
  const [userInput, setUserInput] = useState('');
  const [loading, setLoading] = useState(false);


  /*--------- useCallback ----------*/
  const getShips = useCallback(async () => {
    setShips(await StarWarsShips());
    setLoading(true);
  }, []);


  /*--------- useEffect ----------*/
  useEffect(() => {
    getShips();
  }, [])

  /*--------- customFunctions ----------*/
  /**
   * Calcule numbers of stops needed by each starship following by user input.
   * 
   * @param { string } userQuestion
   * @param { int } consumable
   * @param { int } MGLT
   * 
   * @returns { int | string }
   */
  const stopNumber = (userQuestion, consumable, MGLT) => {
    if(userQuestion === '')
    { return(0); }
    else
    {
      const isNumber = () => {
        return !isNaN(parseFloat(userQuestion)) && isFinite(userQuestion);
      };

      if(isNumber() == true)
      {
        if(consumable === 0 || MGLT === 0)
        { return 'Unable to define stop numbers, because number of consumables or MGLT is unknown!'; }
        else 
        { return Math.floor(userQuestion/(consumable*MGLT)); }
      }
      else
      { return 'These input is not a number!'; }
    }
  };


  /*---------- return ----------*/
  return(
    <div>
      <Head>
        <title>My page title</title>
        <meta name="viewport" content="initial-scale=1.0, width=device-width" />
      </Head>

      {loading ? (
        <Container fluid className={HomeStyle.container}>
          <Row>
            <Col className={HomeStyle.formCol}>
              <h2 className={HomeStyle.title}>How many stops are necessary to complete a journey while traveling in fictional outer space?</h2>
              <Form>
                <Form.Group>
                  <Form.Label>Insert distance:</Form.Label>
                  <Form.Control type="text" onChange={(event) => setUserInput(event.target.value)} />
                  <Form.Text>
                    Only input numbers above 0.
                  </Form.Text>
                </Form.Group>
              </Form>
            </Col>
          </Row>
          <Row>
            <Col className={HomeStyle.contentCol}>
              {ships.map((object) => (
                <Card key={object.key} style={{ width: '100%' }} className={HomeStyle.card}>
                  <Card.Body>
                    <Card.Title>{object.name}</Card.Title>
                    <Card.Subtitle>{object.model}</Card.Subtitle>
                    <Card.Text>
                      <Container fluid className={HomeStyle.cardText}>
                        <p>consumables: {object.consumables}</p>
                        <p>MGLT: {object.MGLT}</p>
                        <p>Stop numbers: {stopNumber(userInput, object.consumables, object.MGLT)}</p>
                      </Container>
                    </Card.Text>
                  </Card.Body>
                </Card>
              ))}
            </Col>
          </Row>
        </Container>
      ) : (
        <Container fluid className={HomeStyle.loadingContainer}>
          <Spinner animation="grow" variant="light" className={HomeStyle.loading} />
        </Container>
      )}
    </div>
  );
}//end Home()