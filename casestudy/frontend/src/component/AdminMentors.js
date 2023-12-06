import React, { useState, useEffect, useRef } from 'react';
import MentorCard from './MentorCard';
import { useReactToPrint } from 'react-to-print';

const AdminMentors = () => {
  const [mentors, setMentors] = useState([]);
  const componentRef = useRef();

  useEffect(() => {
    // Fetch mentors from the API
    fetch('http://localhost:8081/api/admin/mentors')
      .then((response) => {
        if (!response.ok) {
          throw new Error(`HTTP error! Status: ${response.status}`);
        }
        return response.json();
      })
      .then((data) => {
        console.log('Received data:', data); // Log the response to check its structure
        if (Array.isArray(data)) {
          setMentors(data);
        } else {
          console.error('Received data is not an array:', data);
        }
      })
      .catch((error) => console.error('Error fetching mentors:', error));
  }, []);
  

  const handlePrint = useReactToPrint({
    content: () => componentRef.current,
  });

  const handleDownloadReport = async () => {
    try {
      // Make a request to your backend to download the mentor report
      const response = await fetch('http://localhost:8081/api/admin/downloadMentorsReport');
      const blob = await response.blob();

      // Create a Blob from the response data
      const link = document.createElement('a');
      link.href = window.URL.createObjectURL(blob);
      link.download = 'mentors_report.pdf';

      // Dispatch a click event on the link to trigger the download
      link.click();
    } catch (error) {
      console.error('Error downloading mentor report:', error);
      // Handle error as needed
    }
  };

  return (
    <div>
      <h2>All Mentors</h2>
      <button onClick={handleDownloadReport}>Download Report</button>
      <button onClick={handlePrint}>Print Report</button>
      {/* The component you want to print */}
      <div style={{ display: 'none' }} ref={componentRef}>
        {mentors.map((mentor) => (
          <MentorCard key={mentor.mentorId} mentor={mentor} />
        ))}
      </div>
      {/* Display mentors */}
      <div style={{ display: 'flex', flexWrap: 'wrap' }}>
        {mentors.map((mentor) => (
          <MentorCard key={mentor.mentorId} mentor={mentor} />
        ))}
      </div>
    </div>
  );
};

export default AdminMentors;




// import React, { useState, useEffect, useRef } from 'react';
// import MentorCard from './MentorCard';
// import { useReactToPrint } from 'react-to-print';

// const AdminMentors = () => {
//   const [mentors, setMentors] = useState([]);
//   const componentRef = useRef();

//   useEffect(() => {
//     // Fetch mentors from the API
//     fetch('http://localhost:8081/api/admin/mentors')
//       .then((response) => response.json())
//       .then((data) => setMentors(data))
//       .catch((error) => console.error('Error fetching mentors:', error));
//   }, []);

//   const handlePrint = useReactToPrint({
//     content: () => componentRef.current,
//   });

//   const handleDownloadReport = async () => {
//     try {
//       // Make a request to your backend to download the mentor report
//       const response = await fetch('http://localhost:8081/api/admin/downloadMentorsReport');
//       const blob = await response.blob();

//       // Create a Blob from the response data
//       const link = document.createElement('a');
//       link.href = window.URL.createObjectURL(blob);
//       link.download = 'mentors_report.pdf';

//       // Dispatch a click event on the link to trigger the download
//       link.click();
//     } catch (error) {
//       console.error('Error downloading mentor report:', error);
//       // Handle error as needed
//     }
//   };

//   return (
//     <div>
//       <h2>All Mentors</h2>
//       <button onClick={handleDownloadReport}>Download Report</button>
//       <button onClick={handlePrint}>Print Report</button>
//       {/* The component you want to print */}
//       <div style={{ display: 'none' }} ref={componentRef}>
//         {mentors.map((mentor) => (
//           <MentorCard key={mentor.mentorId} mentor={mentor} />
//         ))}
//       </div>
//       <div style={{ display: 'flex', flexWrap: 'wrap' }}>
//         {mentors.map((mentor) => (
//           <MentorCard key={mentor.mentorId} mentor={mentor} />
//         ))}
//       </div>
//     </div>
//   );
// };

// export default AdminMentors;




// import React, { useState, useEffect, useRef } from 'react';
// import MentorCard from './MentorCard';
// import { useReactToPrint } from 'react-to-print';

// const AdminMentors = () => {
//   const [mentors, setMentors] = useState([]);
//   const componentRef = useRef();

//   useEffect(() => {
//     // Fetch mentors from the API
//     fetch('http://localhost:8081/api/admin/mentors')
//       .then((response) => response.json())
//       .then((data) => setMentors(data))
//       .catch((error) => console.error('Error fetching mentors:', error));
//   }, []);

//   const handlePrint = useReactToPrint({
//     content: () => componentRef.current,
//   });

//   const handleDownloadReport = async () => {
//     try {
//       // Make a request to your backend to download the mentor report
//       const response = await fetch('http://localhost:8081/api/admin/downloadMentorsReport');
//       const blob = await response.blob();

//       // Create a Blob from the response data
//       const link = document.createElement('a');
//       link.href = window.URL.createObjectURL(blob);
//       link.download = 'mentors_report.pdf';

//       // Dispatch a click event on the link to trigger the download
//       link.click();
//     } catch (error) {
//       console.error('Error downloading mentor report:', error);
//       // Handle error as needed
//     }
//   };

//   // return (
//   //   <div>
//   //     <h2>All Mentors</h2>
//   //     <button onClick={handleDownloadReport}>Download Report</button>
//   //     <div style={{ display: 'flex', flexWrap: 'wrap' }}>
//   //       {mentors.map((mentor) => (
//   //         <MentorCard key={mentor.mentorId} mentor={mentor} />
//   //       ))}
//   //     </div>
//   //     {/* The component you want to print */}
//   //     <div style={{ display: 'none' }}>
//   //       <MentorCard ref={componentRef} />
//   //     </div>
//   //   </div>
//   // );

//   return (
//   <div>
//     <h2>All Mentors</h2>
//     <button onClick={handleDownloadReport}>Download Report</button>
//     <button onClick={handlePrint}>Print Report</button>
//     <div style={{ display: 'flex', flexWrap: 'wrap' }}>
//       {mentors.map((mentor) => (
//         <div key={mentor.mentorId} ref={componentRef} >
//           <MentorCard mentor={mentor} />
//         </div>
//       ))}
//     </div>
//   </div>
// );
// };

// export default AdminMentors;




// ----------------------------- view all mentors-----------------------------------------------
// import React, { useState, useEffect, useRef} from 'react';
// import MentorCard from './MentorCard';
// import { useReactToPrint } from "react-to-print";


// const AdminMentors = () => {
//   const [mentors, setMentors] = useState([]);

//   useEffect(() => {
//     // Fetch mentors from the API
//     fetch('http://localhost:8081/api/admin/mentors')
//       .then((response) => response.json())
//       .then((data) => setMentors(data))
//       .catch((error) => console.error('Error fetching mentors:', error));
//   }, []);


  

//   return (
//     <div>
//       <h2>All Mentors</h2>
//       <div style={{ display: 'flex', flexWrap: 'wrap' }}>
//         {mentors.map((mentor) => (
//           <MentorCard key={mentor.mentorId} mentor={mentor} />
//         ))}
//       </div>
//     </div>
//   );
// };

// export default AdminMentors;
