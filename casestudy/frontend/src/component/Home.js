import React, { useEffect } from "react";
import { Button, Container } from 'reactstrap';

function Home() {
    useEffect(() => {
        document.title = "Home || CourseApp"
    }, [])
    return (
        <div className="jumbotron" >


            <h1>Welcome to our Mentorship Platform!</h1>
            <p>Explore and connect with mentors to enhance your skills.</p>
            {/* <Container>
                <Button color="primary">Start</Button>
            </Container> */}


        </div>
    )
}

export default Home;

// import React from 'react';
// import { Link } from 'react-router-dom';

// const Home = () => {
//   return (
//     <div>
//       <h1>Welcome to our Mentorship Platform!</h1>
//       <p>Explore and connect with mentors to enhance your skills.</p>

//       <Link to="/mentors">
//       <button type="button" class="btn btn-light">View Mentors</button>
//       </Link>
//     </div>
//   );
// };

// export default Home;