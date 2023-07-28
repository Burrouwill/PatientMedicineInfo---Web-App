import React from 'react';
import { Route, Routes, BrowserRouter} from 'react-router-dom';
import AccountPage from './Pages/AccountPage';
import HomePage from './Pages/HomePage';
import LoginPage from './Pages/LoginPage';
import MedicinesPage from './Pages/MedicinesPage';
import NoPage from './Pages/NoPage';
import RegisterPage from './Pages/RegisterPage'


export default function App() {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route index element={<MedicinesPage/>} />
          <Route path="/home" element={<HomePage/>}/>
          <Route path="/login" element={<LoginPage/>} />
          <Route path="/account" element={<AccountPage/>} />
          <Route path="/medicines" element={<MedicinesPage/>} />
          <Route path="/register" element={<RegisterPage/>} />
          <Route path="*" element={<NoPage/>} />
        </Routes>
      </BrowserRouter>
    </div> 
  );
}


