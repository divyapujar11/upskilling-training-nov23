import React, { Fragment, useState } from "react";
import { Form, FormGroup, Label, Input, Container, Button } from 'reactstrap';
import axios from "axios";
import { toast } from "react-toastify";

function Mentor() {
    const [mentor, setMentor] = useState({
        id: "",
        name: "",
        userId: "",
        workDuration: ""
    });

    const handleForm = async (e) => {
        e.preventDefault();
        try {
            console.log(mentor);
            await postMentorDataToServer(mentor);
            toast.success("Mentor added");
        } catch (error) {
            console.error(error);
            toast.error("Oh no! Mentor not added");
        }
    };

    const postMentorDataToServer = async (data) => {
        try {
            const response = await axios.post("http://localhost:8081/api/admin/mentor/save", data, { withCredentials: true });

            console.log(response);
            console.log("success");
        } catch (error) {
            console.log(error);
            console.log("something is wrong!");
            throw error; // Rethrow the error to be caught in the calling function
        }
    };

    return (
        <Fragment>
            <h1 className="text-center my-3">Fill the Mentor Details</h1>
            <Form onSubmit={handleForm}>
                <FormGroup>
                    <Label htmlFor="mentorId">Mentor Id</Label>
                    <Input
                        type="text"
                        placeholder="Enter Here"
                        name="mentorId"
                        id="mentorId"
                        onChange={(e) => { setMentor({ ...mentor, id: e.target.value }) }}
                    ></Input>
                </FormGroup>
                <FormGroup>
                    <label htmlFor='mentorName'>Mentor Name</label>
                    <Input
                        type='text'
                        placeholder="Enter name here"
                        id="mentorName"
                        onChange={(e) => { setMentor({ ...mentor, name: e.target.value }) }}
                    ></Input>
                </FormGroup>
                <FormGroup>
                    <label htmlFor='userId'> UserId</label>
                    <Input
                        type='text'
                        placeholder="Enter id here"
                        id="userId"
                        onChange={(e) => { setMentor({ ...mentor, userId: e.target.value }) }}
                    ></Input>
                </FormGroup>
                <FormGroup>
                    <label htmlFor='workDuration'>Mentor workDuration</label>
                    <Input
                        type='text'
                        placeholder="Enter workDuration here"
                        id="workDuration"
                        onChange={(e) => { setMentor({ ...mentor, workDuration: e.target.value.toString() }) }}
                    ></Input>
                </FormGroup>
                <Container className="text-center">
                    <Button type="submit" color="success" style={{ margin: 3 }}>Add Mentor</Button>
                    <Button type="reset" color="warning" onClick={(e) => { setMentor({}) }}>Clear</Button>
                </Container>
            </Form>
        </Fragment>
    );
}

export default Mentor;


// import React, { Fragment, useState } from "react";
// import { Form, FormGroup, Label, Input, Container, Button } from 'reactstrap';
// import axios from "axios";
// import { toast } from "react-toastify";


// function Mentor() {
//     const [mentor, setMentor] = useState({});

//     const handleForm = (e) => {
//         console.log(mentor);
//         postMentorDataToServer(mentor);
//         e.preventDefault();
//     };

//     const postMentorDataToServer = (data) => { 
//         axios.post(`http://localhost:9191/api/mentors/save`, data).then(
//             (response) => {
//                 console.log(response);
//                 console.log("success");
//                 toast.success("Mentor added");
//             },
//             (error) => {
//                 console.log(error);
//                 console.log("something is wrong!");
//                 toast.error("Oh no! Mentor not added");
//             }
//         );
//     };

//     return (
//         <Fragment>
//             <h1 className="text-center my-3">Fill the Mentor Details</h1>
//             <Form onSubmit={handleForm}>
//                 <FormGroup>
//                     <Label htmlFor="mentorId">Mentor Id</Label>
//                     <Input
//                         type="text"
//                         placeholder="Enter Here"
//                         name="mentorId"
//                         id="mentorId"
//                         onChange={(e) => { setMentor({ ...mentor, id: e.target.value }) }}
//                     ></Input>
//                 </FormGroup>
//                 <FormGroup>
//                     <label htmlFor='mentorName'>Mentor Name</label>
//                     <Input
//                         type='text'
//                         placeholder="Enter name here"
//                         id="mentorName"
//                         onChange={(e) => { setMentor({ ...mentor, name: e.target.value }) }}
//                     ></Input>
//                 </FormGroup>
//                 <FormGroup>
//                     <label htmlFor='userId'> UserId</label>
//                     <Input
//                         type='text'
//                         placeholder="Enter id here"
//                         id="userId"
//                         onChange={(e) => { setMentor({ ...mentor, userId: e.target.value }) }}
//                     ></Input>
//                 </FormGroup>
//                 <FormGroup>
//                     <label htmlFor='workDuration'>Mentor workDuration</label>
//                     <Input
//                         type='text'
//                         placeholder="Enter workDuration here"
//                         id="workDuration"
//                         onChange={(e) => { setMentor({ ...mentor, workDuration: e.target.value }) }}
//                     ></Input>
//                 </FormGroup>
//                 <Container className="text-center">
//                     <Button type="submit" color="success" style={{ margin: 3 }}>Add Mentor</Button>
//                     <Button type="reset" color="warning" onClick={(e) => { setMentor({}) }}>Clear</Button>
//                 </Container>
//             </Form>
//         </Fragment>
//     );
// }

// export default Mentor;
