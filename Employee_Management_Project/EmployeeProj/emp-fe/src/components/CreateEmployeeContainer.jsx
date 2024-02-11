import React from 'react';
import { useNavigate } from 'react-router-dom';
import CreateEmployeeComponent from './CreateEmployeeComponent';

function CreateEmployeeContainer() {
  const navigate = useNavigate();

  const saveEmployee = (employee) => {
    
    navigate('/employees');
  };

  return <CreateEmployeeComponent onSave={saveEmployee} />;
}

export default CreateEmployeeContainer;
