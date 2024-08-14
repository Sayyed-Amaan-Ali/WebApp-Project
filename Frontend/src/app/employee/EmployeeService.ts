import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Employee } from "./Employee";

@Injectable({
    providedIn: 'root'
})

export class EmployeeService {
    private apiserverurl= 'http://localhost:4000';
    constructor(private http: HttpClient){    }

    public getEmployee():Observable<Employee[]>{
        return this.http.get<Employee[]>(`${this.apiserverurl}/employee/all`);
    }

    public addEmployee(member: Employee):Observable<Employee>{
        return this.http.post<Employee>(`${this.apiserverurl}/employee/add`, member);
    }

    public updateEmployee(member: Employee):Observable<Employee>{
        return this.http.put<Employee>(`${this.apiserverurl}/employee/update`, member);
    }

    public deleteEmployee(memberid: number):Observable<void>{
         return this.http.delete<void>(`${this.apiserverurl}/employee/delete/${memberid}`);
    }
}