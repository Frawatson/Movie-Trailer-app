import "./App.css";
import api from "./sapey_client_api/axiosConfig";
import { useEffect, useState } from "react";
import Layout from "./Components/Layout";
import { Routes, Route, Outlet, Link } from "react-router-dom";
import Home from "./Components/home/Home";
import Header from "./Components/header/Header";
import Trailer from "./Components/trailer/Trailer";
import Reviews from "./Components/reviews/Reviews";
import NotFound from "./Components/notFound/NotFound";

/**
 * Renders the main App component.
 *
 * @return {JSX.Element} The JSX element representing the App component.
 */
function App() {

  const [movies, setMovies] = useState();
  const [movie, setMovie] = useState();
  const [reviews, setReviews] = useState([]);

  /**
   * Retrieves movies from the API and sets them in the state.
   *
   * @return {Promise<void>} - A promise that resolves when the movies are retrieved and set.
   */
  const getMovies = async () =>{
    
    try
    {

      const response = await api.get("/api/v1/movies");

      setMovies(response.data);

    } 
    catch(err)
    {
      console.log(err);
    }
  }

  /**
   * Retrieves movie data from the API based on the provided movie ID.
   *
   * @param {number} movieId - The ID of the movie to retrieve data for.
   * @return {Promise} A Promise that resolves with the movie data.
   */
  const getMovieData = async (movieId) => {
     
    try 
    {
        const response = await api.get(`/api/v1/movies/${movieId}`);

        const singleMovie = response.data;

        setMovie(singleMovie);

        setReviews(singleMovie.reviews);
        

    } 
    catch (error) 
    {
      console.error(error);
    }

  }

  useEffect(() => {
    getMovies();
  },[])

   /**
   * Retrieves movie data from the API based on the provided movie ID.
   *
   * @param {getMovieData} getMovieData - The ID of the getMovieData to retrieve data for
   * @param {reviews} - retrieve reviews
   */

  return (
    <div className="App">
      <Header/>
      <Routes>
          <Route path="/" element={<Layout/>}>
            <Route path="/" element={<Home movies={movies} />} ></Route>
            <Route path="/Trailer/:ytTrailerId" element={<Trailer/>}></Route>
            <Route path="/Reviews/:movieId" element ={<Reviews getMovieData = {getMovieData} movie={movie} reviews ={reviews} setReviews = {setReviews} />}></Route>
            <Route path="*" element = {<NotFound/>}></Route>
          </Route>
      </Routes>

    </div>
  );
}

export default App;