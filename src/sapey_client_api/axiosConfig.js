import axios from "axios";

 /**
   * Retrieves movie data from the API based on the provided movie ID.
   *
   * @param {baseURLr} baseURLr - provided baseURL route and pull directly from ngrok
   * @param {Headers} expose localhost to public internet that doesn't have option to skip browser warning
   */
//exposing http requests with ngrok
export default axios.create({
    baseURL: "http://localhost:8080",
    //baseURL: "https://a838-2603-8080-a9f0-3cf0-50b8-8ebb-dd42-6d40.ngrok-free.app",
    headers: {
        "ngrok-skip-browser-warning": "true"
    }
})