import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EmployeeModule } from '../employee.module';
import { RouterLink } from '@angular/router';


@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, FormsModule, EmployeeModule, RouterLink],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit{
  
  constructor(private employeeService: EmployeeService){}

  employees: Employee[] = [];
  allEmployees: Employee[] = [];
  sortProperty: string='name';
  sortOrder=1;

  ngOnInit(): void {
    this.employeeService.fetchAllEmployees().subscribe((data)=>{
      this.employees=data;
      this.allEmployees=data; // another list to keep all the employees, when using filter
    })    
  }

  filterEmployees(input: string) {
    
    this.employees = this.allEmployees.filter(item=>item.name.toLowerCase().includes(input.toLowerCase()) 
        || item.email.toLowerCase().includes(input.toLowerCase()) || item.phone.toLowerCase().includes(input.toLowerCase()))
    
  }
  

  delete(id: number){
    const isConfirmed = window.confirm("You're going to delete this employee! Sure?");
    if(isConfirmed){
      this.employeeService.delete(id).subscribe((data)=>{
        this.employees = this.employees.filter(item=>item.id!=id);
      });
      window.location.reload();
    }
    
  }

  sortBy(value: string) {
    this.sortOrder=value===this.sortProperty?(this.sortOrder*-1):1;
    this.sortProperty=value;
    this.employees=[...this.allEmployees.sort((a:any, b:any)=>{
      let result = 0;
      if(a[value] < b[value]){
        result = -1;
      }
      if(a[value] > b[value]){
        result = 1;
      }
      return (result*this.sortOrder);
    })]
  }
 
  
}
