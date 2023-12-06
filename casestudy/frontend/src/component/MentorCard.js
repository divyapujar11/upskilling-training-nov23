// import React from 'react';
// import Card from 'react-bootstrap/Card';

// const MentorCard = ({ mentor }) => {
//   return (
//     <Card style={{ width: '18rem', margin: '10px' }}>
//       <Card.Body>
//         <Card.Text>Mentor ID: {mentor.mentorId}</Card.Text>
//         <Card.Text>Name: {mentor.mentorName}</Card.Text>
//         <Card.Text>User ID: {mentor.userId}</Card.Text>
//         <Card.Text>Work Duration: {mentor.workDuration}</Card.Text>
//       </Card.Body>
//     </Card>
//   );
// };

// export default MentorCard;


// MentorCard.js
import React from 'react';
import Card from 'react-bootstrap/Card';

const MentorCard = ({ mentor }) => {
  return (
    <div>
      <Card style={{ width: '18rem', margin: '10px' }}>
        <Card.Body>
          <Card.Text>Mentor ID: {mentor?.mentorId}</Card.Text>
          <Card.Text>Name: {mentor?.mentorName}</Card.Text>
          <Card.Text>User ID: {mentor?.userId}</Card.Text>
          <Card.Text>Work Duration: {mentor?.workDuration}</Card.Text>
        </Card.Body>
      </Card>
    </div>
  );
};

export default MentorCard;
