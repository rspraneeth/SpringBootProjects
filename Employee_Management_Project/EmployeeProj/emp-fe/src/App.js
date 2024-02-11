import React from 'react';
import './App.css';
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import ListEmployeeComponent from './components/ListEmployeeComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import CreateEmployeeContainer from './components/CreateEmployeeContainer';
import UpdateEmployeeComponent from './components/UpdateEmployeeComponent';


function App() {
  
  return (
    <div>
      <Router>
        
          <HeaderComponent/>
            <div className="container">
              <Routes> 
                {/* localhost:3000/ */}
                <Route path="/" exact element={<ListEmployeeComponent/>}/>
                <Route path="/employees" element={<ListEmployeeComponent/>}/>
                <Route path="/add-employee" element={<CreateEmployeeContainer />}/>
                <Route path="/update-employee/:id" element={<UpdateEmployeeComponent />}/>
              </Routes>
            </div>
          <FooterComponent/>
  
      </Router>
      
    </div>
    
  );
}

export default App;
