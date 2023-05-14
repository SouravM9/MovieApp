import { useState, useEffect } from 'react';
import Layout from './components/Layout';
import { Routes, Route } from 'react-router-dom';
import Home from './components/Home';
import './App.css';
import Header from './components/Header';
import Trailer from './components/Trailer';
import Reviews from './components/Review';
import NotFound from './components/NotFound';

function App() {

  const [movies, setMovies] = useState();
  const [movie, setMovie] = useState();
  const [reviews, setReviews] = useState([]);

  const getMovies = () => {
    fetch('/api/v1/movies')
      .then(res => res.json())
      .then(result => {
        console.log(result);
        setMovies(result);
      })
      .catch(err => {
        console.log(err);
      });
  }

  const getMovieData = (movieId) => {

    fetch(`/api/v1/movies/${movieId}`)
      .then(res => res.json())
      .then(result => {
        console.log(result);
        setMovie(result);
        setReviews(result.reviewIds);
      })
      .catch(err => {
        console.log(err);
      });
  }

  useEffect(() => {
    getMovies();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [])

  return (
    <div className="App">
      <Header />
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route path="/" element={<Home movies={movies} />} ></Route>
          <Route path="/Trailer/:ytTrailerId" element={<Trailer />}></Route>
          <Route path="/Reviews/:movieId" element={<Reviews getMovieData={getMovieData} movie={movie} reviews={reviews} setReviews={setReviews} />}></Route>
          <Route path="*" element={<NotFound />}></Route>
        </Route>
      </Routes>

    </div>
  );
}

export default App;
