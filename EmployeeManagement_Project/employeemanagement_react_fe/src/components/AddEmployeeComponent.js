import React, {useState, useEffect} from 'react'
import employeeService from '../services/EmployeeService'
import {Link, useNavigate, useParams} from 'react-router-dom';

const AddEmployeeComponent = () => {

  const [firstName, setfirstName] = useState('')
  const [lastName, setlastName] = useState('')
  const [emailId, setemailId] = useState('')
  const navigate = useNavigate();
  const {id} = useParams();

  const saveOrUpdateEmployee = (e) => {
    e.preventDefault();
    const employee = {firstName, lastName, emailId}
    if(id){
      employeeService.updateEmployee(id, employee).then((response) => {
        console.log(response.data)
        navigate('/employees');
      }).catch(error => {
        console.log(error);
      })
    }else{
      employeeService.createEmployee(employee).then((response) => {
        console.log(response.data)
        navigate('/employees');
      }).catch(error => {
        console.log(error)
      })
    }
  }

  useEffect(() => {
    if (id) {  // Check if id is available before making the API call
      employeeService.getEmployeeById(id).then((response) => {
        setfirstName(response.data.firstName);
        setlastName(response.data.lastName);
        setemailId(response.data.emailId);
      }).catch(error => {
        console.log(error);
      });
    }
  }, [id]);  // Add id to dependency array

  const title = () => {
    if(id){
      return <h2 className='text-center'>Update Employee</h2>
    }else{
      return <h2 className='text-center'>Add Employee</h2>
    }
  }


  return (
    <div>
      <br/>
      <div className='container'>
        <div className='row'>
          <div className='card col-md-6 offset-md-3'>
            {
              title()  
            }
            <div className='card-body'>
              <form>
                <div className='form-group mb-2'>
                  <label className='form-label'>First Name: </label>
                  <input 
                    type='text' 
                    placeholder='Enter First Name' 
                    name='firstName' 
                    className='form-control' 
                    value={firstName} 
                    onChange={(e) => setfirstName(e.target.value)}></input>
                </div>
                <div className='form-group mb-2'>
                  <label className='form-label'>Last Name: </label>
                  <input 
                    type='text' 
                    placeholder='Enter Last Name' 
                    name='lastName' 
                    className='form-control' 
                    value={lastName} 
                    onChange={(e) => setlastName(e.target.value)}></input>
                </div>
                <div className='form-group mb-2'>
                  <label className='form-label'>Email Id: </label>
                  <input 
                    type='email' 
                    placeholder='Enter Email Id' 
                    name='emailId' 
                    className='form-control' 
                    value={emailId} 
                    onChange={(e) => setemailId(e.target.value)}></input>
                </div>
                <button className='btn btn-success' onClick={(e)=> saveOrUpdateEmployee(e)}>Save</button>
                <Link to= '/employees' className='btn btn-danger mx-2'>Cancel</Link>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default AddEmployeeComponent