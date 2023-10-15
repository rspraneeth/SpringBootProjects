import React from 'react';
import './App.css';
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import ListEmployeeComponent from './components/ListEmployeeComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
// import CreateEmployeeComponent from './components/CreateEmployeeComponent';
import CreateEmployeeContainer from './components/CreateEmployeeContainer';


function App() {
  
  return (
    <div>
      <Router>
        
          <HeaderComponent/>
            <div className="container">
              <Routes>
                <Route path="/" exact element={<ListEmployeeComponent/>}/>
                <Route path="/employees" element={<ListEmployeeComponent/>}/>
                <Route path="/add-employee" element={<CreateEmployeeContainer />}/>
              </Routes>
            </div>
          <FooterComponent/>
        
      </Router>
      
    </div>
    
  );
}

export default App;
