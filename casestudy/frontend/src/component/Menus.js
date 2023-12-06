import React from "react";
import {  ListGroup, ListGroupItem } from "reactstrap";

function Menus(){
    return(
        <ListGroup>
            <ListGroupItem tag="a" href="/" action>
                Home
            </ListGroupItem>
            <ListGroupItem tag="a" href="/add-mentor" action>
               Mentor
            </ListGroupItem>
            <ListGroupItem tag="a" href="/view-mentors" action>
               View Mentor
            </ListGroupItem>
            <ListGroupItem tag="a" href="/user" action>
               User
            </ListGroupItem>
            <ListGroupItem tag="a" href="/course" action>
                Course
            </ListGroupItem>
        </ListGroup>
    )
}

export default Menus;