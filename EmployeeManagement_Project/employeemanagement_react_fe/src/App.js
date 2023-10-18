import './App.css';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom'
import ListEmployeeComponent from './components/ListEmployeeComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent />
        <div className='container'>
          <Routes>
            <Route> exact path = "/" element = {ListEmployeeComponent} </Route>
          </Routes>
          <ListEmployeeComponent />
        </div>
        <FooterComponent /> 
      </Router>         
    </div>
  );
}

export default App;
