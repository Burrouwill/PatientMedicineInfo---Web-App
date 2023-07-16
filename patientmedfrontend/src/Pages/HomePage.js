import React from 'react';
import Header from '../Components/Header';
import { Link } from 'react-router-dom';

function HomePage() {
  return (
    <div>
      <Header />
      <h1>Welcome to My App</h1>
      {/* Add more content and styling as needed */}
      <Link to="/">Go to Home</Link>
    </div>
  );
}

export default HomePage;