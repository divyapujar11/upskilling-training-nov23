// import React, { useState } from "react";
// import axios from "axios";

// function AllMentors() {
//   const [mentors, setMentors] = useState([]);

//   // Function to handle the download button click
//   const handleDownloadReport = async () => {
//     try {
//       // Make a request to your backend to download the mentor report
//       const response = await axios.get("http://localhost:8081/api/admin/downloadMentorsReport", {
//         responseType: "blob", // Important: responseType should be 'blob' for binary data
//       });

//       // Create a Blob from the response data
//       const blob = new Blob([response.data], { type: "application/pdf" });

//       // Create a link element to trigger the download
//       const link = document.createElement("a");
//       link.href = window.URL.createObjectURL(blob);
//       link.download = "mentors_report.pdf";

//       // Dispatch a click event on the link to trigger the download
//       link.click();
//     } catch (error) {
//       console.error("Error downloading mentor report:", error);
//       // Handle error as needed
//     }
//   };

//   // Assume mentors are fetched and stored in the 'mentors' state

//   return (
//     <div>
//       {/* Display mentors */}
//       <h1>All Mentors</h1>
//       {mentors.map((mentor) => (
//         <div key={mentor.id}>
//           {/* Display mentor information */}
//           <p>Mentor ID: {mentor.id}</p>
//           <p>Mentor Name: {mentor.name}</p>
//           {/* ... Display other mentor details ... */}
//         </div>
//       ))}

//       {/* Button to download mentor report */}
//       <button onClick={handleDownloadReport}>Download Report</button>
//     </div>
//   );
// }

// export default AllMentors;


import React, { useEffect, useState, useRef } from "react";
import axios from "axios";
import Mentor from "./Mentor";

function AllMentors() {
  const [mentors, setMentors] = useState([]);
  const componentRef = useRef();

  const getAllMentorsFromServer = () => {
    axios.get(`http:/localhost:8081/api/admin/mentors`).then(
      (response) => {
        setMentors(response.data);
      },
      (error) => {
        console.log(error);
      }
    );
  };

  useEffect(() => {
    getAllMentorsFromServer();
  }, []);

  const handleDownloadPDF = async () => {
    // Dynamically import html2pdf library
    const html2pdf = await import("html2pdf.js");

    // Select the div containing mentor details
    const element = document.getElementById("mentorDetails");

    // Configure options for html2pdf
    const options = {
      margin: 10,
      filename: "mentors_report.pdf",
      image: { type: "jpeg", quality: 0.98 },
      html2canvas: { scale: 2 },
      jsPDF: { unit: "mm", format: "a4", orientation: "portrait" },
    };

    // Generate PDF
    html2pdf.default().from(element).set(options).outputPdf();
  };

  return (
    <div>
      <h1>All Mentors</h1>
      <button onClick={handleDownloadPDF}>Download PDF</button>
      <div id="mentorDetails">
        <p>List of mentors:</p>
        {mentors.length > 0 ? (
          mentors.map((mentor) => (
            <Mentor key={mentor.id} mentor={mentor} />
          ))
        ) : (
          "No mentors available"
        )}
      </div>
    </div>
  );
}

export default AllMentors;








// import React, { useEffect, useState } from "react";
// import Mentor from "./Mentor"; // Assuming Mentor component is available
// import base_url from './../api/bootapi';
// import axios from "axios";
// import { toast } from "react-toastify";

// function AllMentors() {
//     useEffect(() => {
//         document.title = "All Mentors || MentorApp";
//     }, []);

//     // Get mentors from the Spring Boot API
//     const getAllMentorsFromServer = () => {
//         axios.get(`http:/localhost:8081/api/admin/mentors`).then(
//             (response) => {
//                 console.log(response.data);
//                 toast.success("Mentors have been loaded", {
//                     position: "bottom-center"
//                 });
//                 setMentors(response.data);
//             },
//             (error) => {
//                 console.log(error);
//                 toast.error("Something went wrong!", {
//                     position: "bottom-center"
//                 });
//             }
//         );
//     };

//     // Load getAllMentorsFromServer on component mount
//     useEffect(() => {
//         getAllMentorsFromServer();
//     }, []);

//     const [mentors, setMentors] = useState([]);

//     // Remove mentor from mentors
//     const updateMentor = (id) => {
//         setMentors(mentors.filter((mentor) => mentor.id !== id));
//     };

//     return (
//         <div>
//             <h1>All Mentors</h1>
//             <p>List of mentors:</p>
//             {mentors.length > 0 ? (
//                 mentors.map((mentor) => (
//                     <Mentor key={mentor.id} mentor={mentor} update={updateMentor} />
//                 ))
//             ) : (
//                 "No mentors available"
//             )}
//         </div>
//     );
// }

// export default AllMentors;
