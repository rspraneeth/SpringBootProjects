import { Component } from '@angular/core';
import { Employee } from '../employee';
import { FormsModule } from '@angular/forms';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './create.component.html',
  styleUrl: './create.component.css'
})
export class CreateComponent{
  employee: Employee={
    id:0,
    name:'',
    email:'',
    phone:''
  }

  constructor(private employeeService: EmployeeService, private router: Router){}

  create(){
    this.employeeService.create(this.employee).subscribe({
      next:(data)=>{
        this.router.navigate(["employee/home"])
      },
      error:(err)=>{console.log(err);}
    })
  }

  cancel(){
    this.router.navigate(["employee/home"]);
  }
}
