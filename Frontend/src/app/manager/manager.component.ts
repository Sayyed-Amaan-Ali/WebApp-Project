import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MemberService } from './memberService';
import { CommonModule } from '@angular/common';
import { tenantComponent } from '../tenants/tenant.component';
import { TenantServices } from '../tenants/TenantServices';
import { error } from 'console';
import { FormsModule } from '@angular/forms';
import { Observable } from 'rxjs';
import { employeeComponent } from "../employee/employee.component";
import { EmployeeService } from '../employee/EmployeeService';


@Component({
  selector: 'manager-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule, tenantComponent, FormsModule, employeeComponent],
  providers:[MemberService,TenantServices,EmployeeService],
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent {
  title = 'ManagerApp';
  activeTenant: boolean=false;
  activeEmployee: boolean=false;
  activeOthers: boolean=false;
  dropdownopen: boolean=false;
  ngOnInit(){

  }

  
  toggledropdown(){
    this.dropdownopen = !this.dropdownopen;
  }
  

  SearchBox(key: string){
      if(this.activeEmployee==true){
        
      }
    }

  public changeStatus(key: string):void{
    if(key === 'home'){
      this.activeTenant=false;
      this.activeEmployee=false;
      this.activeOthers=false;
    }
    if(key === 'tenant'){
      this.activeTenant=true;
    }
    if(key == 'employee'){
      this.activeEmployee=true;
    }
    if(key == 'Others'){
      this.activeOthers=true;
    }
  }
  


}

