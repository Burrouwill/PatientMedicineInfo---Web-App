import React from 'react';
import Header from '../Components/Header';
import { Link } from 'react-router-dom';
import { Typography } from '@material-ui/core'; // Anything with text --> Material UI typography

function HomePage() {
  return (
    <div>
      <Header />
      <Typography variant="h1">Welcome to My App</Typography>
      {/* Add more content and styling as needed */}
      <Link to="/">Go to Home</Link>
    </div>
  );
}

export default HomePage;