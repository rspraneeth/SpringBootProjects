import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import EmployeeService from '../services/EmployeeService';



class CreateEmployeeComponent extends Component {

    constructor(props){
        super(props)
        this.state = {
            firstName: '',
            lastName: '',
            emailId: ''
        }
        this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
        this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
        this.saveEmployee = this.saveEmployee.bind(this);
    }
    
    saveEmployee = (e) => {
        e.preventDefault();
        let employee = {firstName: this.state.firstName, lastName: this.state.lastName, emailId: this.state.emailId};
        console.log('employee => ' + JSON.stringify(employee));

        EmployeeService.createEmployee(employee).then(res => {
            this.props.onSave('/employees')
        });
    }

    changeFirstNameHandler = (event) => {
        this.setState({firstName:event.target.value});
    }

    changeLastNameHandler = (event) => {
        this.setState({lastName:event.target.value});
    }

    changeEmailIdHandler = (event) => {
        this.setState({emailId:event.target.value});
    }

    render() {
        return (
            <div>
                <div className='container'>
                    <div className='row'>
                        <div className='card col-md-6 offset-md-3 offset-md-3'>
                            <h3 className='text-center'>Add Employee</h3>
                            <div className='card-body'>
                                <form>
                                    <div className='form-group'>
                                        <label>First name: </label>
                                        <input placeholder='First Name' name='firstName' className='form-control'
                                        value={this.state.firstName} onChange={this.changeFirstNameHandler}/>
                                    </div>

                                    <div className='form-group'>
                                        <label>Last name: </label>
                                        <input placeholder='Last Name' name='lastName' className='form-control'
                                        value={this.state.lastName} onChange={this.changeLastNameHandler}/>
                                    </div>

                                    <div className='form-group'>
                                        <label>Email Id: </label>
                                        <input placeholder='Email Id' name='emailId' className='form-control'
                                        value={this.state.emailId} onChange={this.changeEmailIdHandler}/>
                                    </div>

                                    <button className='btn btn-success' onClick={this.saveEmployee}>Save</button>
                                    <Link to='/employees' className='btn btn-danger' style={{marginLeft: "10px"}}>Cancel</Link>
                                </form>
                            </div>

                        </div>
                    </div>

                </div>
            </div>
        );
    }
}

export default CreateEmployeeComponent;