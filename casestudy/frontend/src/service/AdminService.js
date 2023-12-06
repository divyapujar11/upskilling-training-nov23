import axios from 'axios'

const ADMIN_SERVICE_BASE_URL = "http://localhost:8081/api/admin/mentors";

const COURSE_ID= 1;


class AdminService{

    getAdmin(){
        return axios.get(ADMIN_SERVICE_BASE_URL);
    }
    getUsersByCourse(){
        return axios.get("http://localhost:8081/api/admin/get/users/" + COURSE_ID);
    }

}

export default new AdminService