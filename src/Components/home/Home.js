import Hero from '../hero/Hero';

/**
 * Renders the Home component.
 *
 * @param {Object} movies - The movies data.
 * @return {JSX.Element} The rendered Hero component.
 */
const Home = ({movies}) => {
  return (
    <Hero movies = {movies} />
  )
}

export default Home