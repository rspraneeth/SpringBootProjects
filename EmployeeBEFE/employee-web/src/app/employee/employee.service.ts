import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private _httpClient: HttpClient) { }

  private baseUrl = "/customers";

  // Fetch all employees
  fetchAllEmployees(): Observable<Employee[]> {
    return this._httpClient.get<Employee[]>(`${this.baseUrl}`);
  }

  // Fetch employee by ID
  getById(id: number): Observable<Employee> {
    return this._httpClient.get<Employee>(`${this.baseUrl}/${id}`);
  }

  // Create a new employee (adjusting the endpoint to match the backend)
  create(employee: Employee): Observable<Employee> {
    return this._httpClient.post<Employee>(`${this.baseUrl}/new`, employee);
  }

  // Update an existing employee
  update(employee: Employee): Observable<Employee> {
    return this._httpClient.put<Employee>(`${this.baseUrl}/${employee.id}`, employee);
  }

  // Delete an employee by ID
  delete(id: number): Observable<Employee> {
    return this._httpClient.delete<Employee>(`${this.baseUrl}/${id}`);
  }
}
