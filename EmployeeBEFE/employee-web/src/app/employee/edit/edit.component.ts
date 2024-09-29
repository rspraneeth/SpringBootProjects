import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-edit',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './edit.component.html',
  styleUrl: './edit.component.css'
})
export class EditComponent implements OnInit{

  constructor(private employeeService: EmployeeService, private router: Router, private route: ActivatedRoute){}
  
  employee: Employee={
    id:0,
    name:'',
    email:'',
    phone:''
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params)=>{
      let id=Number(params.get('id'));
      this.getById(id);
    })
  }
  getById(id: number) {
    this.employeeService.getById(id).subscribe((data)=>{
      this.employee=data;
    })
  }

  cancel(){
    this.router.navigate(["employee/home"]);
  }
  
  update(){
    this.employeeService.update(this.employee).subscribe({
      next:(data)=>{
        this.router.navigate(["employee/home"])
      },
      error:(err)=>{console.log(err);}
    })
  }
}
