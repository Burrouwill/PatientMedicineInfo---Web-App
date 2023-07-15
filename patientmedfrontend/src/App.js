import React from 'react';
import {BrowserRouter as Router, Route, Link, Routes} from 'react-router-dom';
import AccountPage from './Pages/AccountPage';
import HomePage from './Pages/HomePage';
import LoginPage from './Pages/LoginPage';
import MedicinesPage from './Pages/MedicinesPage';

export default function App() {
  return (
    <Router>
      <Route exact path="/" component={HomePage} />
      <Route path="/login" component={LoginPage} />
      <Route path="/account" component={AccountPage} />
      <Route path="/medicines" component={MedicinesPage} />
    </Router>
  );
}


