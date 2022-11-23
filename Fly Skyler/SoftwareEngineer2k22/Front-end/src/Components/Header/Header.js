//----------- Style Imports ----------
import Container from 'react-bootstrap/Container';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faLocationDot } from '@fortawesome/free-solid-svg-icons';


//----------- Custom Style Imports ----------
import './Header.css';


//----------- Function Header ----------
/**
 * Header component 
 * 
 * @returns {JSX}
 */
export default function Header() {
    return (
        <header className="header">
            <h1>Skyler Mini Case</h1>

            <Container fluid className="header-sectitle">
                <FontAwesomeIcon icon={faLocationDot} className="header-icon" />
                <h2>Postal Code Search</h2>
            </Container>
        </header>
    );
}//end Header()