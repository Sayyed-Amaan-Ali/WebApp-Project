import { CommonModule, DatePipe } from "@angular/common";
import { Component } from "@angular/core";
import { FormsModule, NgForm } from "@angular/forms";
import e, { response } from "express";
import { error } from "console";
import { HttpErrorResponse } from "@angular/common/http";
import { EmployeeService } from "./EmployeeService";
import { Employee } from "./Employee";

@Component({
    selector: 'Employee-root',
    standalone: true,
    imports: [CommonModule,FormsModule],
    providers:[EmployeeService],
    templateUrl: './employee.component.html',
    styleUrls: ['./employee.component.css']
  })

  export class employeeComponent{
    title="employee-Component";

    public employees: Employee[]=[];

    public editEmployee: Employee | null=null;
    public deleteEmployee: Employee | null=null;
    public messageEmployee: Employee | null=null;
    public showEmployee: Employee| null=null;
    public isEmailDuplicate: boolean = false;
    public isPhoneDuplicate: boolean = false;
    public isDUE: boolean= false;
  

    constructor(public employeeService: EmployeeService){
      
    }

    ngOnInit(){
      this.getEmployee();
    }

    public getEmployee(){
      this.employeeService.getEmployee().subscribe(
          (response: Employee[]) => {
            if(!this.isDUE){
               this.employees=response;
            }
            else{
              this.employees=[];
              for (let index = 0; index < response.length; index++) {
                const element = response[index];
                if(element.salaryStatus === 'DUE'){
                  this.employees.push(element);
                }
              }
            }
          },
          (error: HttpErrorResponse) => {
              alert(error.message);
          }
      );
  }
    
   


  
  

    public checkStatus(): void{
      if(this.isDUE){
        this.isDUE = false;
      }
      else{
        this.isDUE = true;
      }
      this.getEmployee();
    }


    public onOpenModal(employee: Employee | null, mode: string): void {
      const container = document.getElementById('main-container');
      const button = document.createElement('button');
      button.type = 'button';
      button.style.display = 'none';
      button.setAttribute('data-bs-toggle', 'modal');
    
      switch (mode) {
        case 'add':
          button.setAttribute('data-bs-target', '#addEmployeeModal');
          break;
        case 'show':
          this.showEmployee = employee;
          button.setAttribute('data-bs-target', '#showEmployeeModal');
          break;
        case 'edit':
          this.editEmployee = employee;
          button.setAttribute('data-bs-target', '#updateEmployeeModal');
          break;
        case 'delete':
          this.deleteEmployee = employee;
          button.setAttribute('data-bs-target', '#deleteEmployeeModal');
          break;
        case 'message':
          this.messageEmployee = employee;
          button.setAttribute('data-bs-target', '#messageEmployeeModal');
          break;
        default:
          return;
      }
      container?.appendChild(button);
      button.click();
    }
    

    
  public emailValidator(email: string): void{
    this.isEmailDuplicate = this.employees.some(e => e.email === email);
  }

  public phoneValidator(phone: string): void{
    this.isPhoneDuplicate = this.employees.some(e => e.phone === phone);
  }

  public onAddEmployee(addForm: NgForm): void{
    document.getElementById('add-employee-form')?.click();
    this.employeeService.addEmployee(addForm.value).subscribe(
      (response: Employee) => {
        console.log(response);
        this.getEmployee();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateEmployee(editForm: NgForm): void{
        this.employeeService.updateEmployee(editForm.value).subscribe(
          (response: Employee) => {
            console.log(response);
            this.getEmployee();
          },
          (error: HttpErrorResponse) => {
            alert(error.message);
          }
    
        );
  }

  public onDeleteEmployee(id: number):void{
    this.employeeService.deleteEmployee(id).subscribe(
        (response: void) => {
            this.getEmployee();
        },
        (error: HttpErrorResponse) => {
            alert(error.message);
        }
    )
  }

  public onMessageEmployee(id: number):void{
    
  }

  public searchEmployee(key: string): void{
    this.getEmployee();
    const results: Employee[] = [];
    for (const employee of this.employees) {
      if (employee.name.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.email.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.phone.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.gender.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.address.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.salary.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.department.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.jobtitle.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.jobtype.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.leavebalance.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.performanceReview.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.salaryStatus.toLowerCase().indexOf(key.toLowerCase()) !== -1 
      || employee.workshift.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(employee);
      }
    }
    this.employees = results;
    if (results.length === 0 || !key) {
      this.getEmployee();
    }
  }

  public dateFormat(date: Date| undefined): string|null{
    var datepipe= new DatePipe('en-US');
    return datepipe.transform(date,'dd/MM/yyyy');
  }

}