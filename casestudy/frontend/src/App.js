import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import { BrowserRouter as Router, Route, Link, Routes } from 'react-router-dom';
import AdminMentors from './component/AdminMentors';
import Header from './component/Header';
import Menus from './component/Menus';
import Home from './component/Home';
import Mentor from './component/Mentor';
import AllMentors from './component/AllMentor';
import './App.css';
import { Button, Container, Row, Col } from 'reactstrap';
import { ToastContainer, toast } from 'react-toastify';


function App() {
  return (
    // <div className="App">
    //   <header className="App-header">
    //    <AdminMentors />
    //   </header>
    // </div>
    
    <div className="App">
      <header className="App-header">
      <div>
      <ToastContainer />
      {/* <Container> */}
        <Header />
        <Row>
          <Col md={4}><Menus /></Col>
          <Col md={8}>
            <Router>
              <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/add-mentor" element={<Mentor/>} />
                <Route path="/view-mentors" element={<AdminMentors />} />
              </Routes>
            </Router>
          </Col>
        </Row>
      {/* </Container> */}

    </div>
      {/* <Router>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/mentors" element={<AdminMentors />} />
          
        </Routes>
      </Router> */}
      </header>
    </div >
  );

}

export default App;
