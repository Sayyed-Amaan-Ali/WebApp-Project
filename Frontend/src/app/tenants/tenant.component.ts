import { CommonModule, DatePipe } from "@angular/common";
import { Component } from "@angular/core";
import { FormsModule, NgForm } from "@angular/forms";
import { TenantServices } from "./TenantServices";
import { Tenant } from "./tenant";
import { response } from "express";
import { error } from "console";
import { HttpErrorResponse } from "@angular/common/http";

@Component({
    selector: 'tenant-root',
    standalone: true,
    imports: [CommonModule,FormsModule],
    providers:[TenantServices],
    templateUrl: './tenant.component.html',
    styleUrls: ['./tenant.component.css']
  })

  export class tenantComponent{
    title="tenant-Component";

    public tenants: Tenant[]=[];



    public editTenant: Tenant | null=null;
    public deleteTenant: Tenant | null=null;
    public messageTenant: Tenant | null=null;
    public showTenant: Tenant| null=null;
    public isEmailDuplicate: boolean = false;
    public isPhoneDuplicate: boolean = false;
    public isDUE: boolean= false;
  

    constructor(public tenantservice: TenantServices){
      
    }

    ngOnInit(){
      this.getTenants();
    }

    public getTenants(){
      this.tenantservice.getTenants().subscribe(
          (response: Tenant[]) => {
            if(!this.isDUE){
               this.tenants=response;
            }
            else{
              this.tenants=[];
              for (let index = 0; index < response.length; index++) {
                const element = response[index];
                if(element.paymentstatus === 'DUE'){
                  this.tenants.push(element);
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
      this.getTenants();
    }


    public onOpenModal(tenant: Tenant | null, mode: string): void {
      const container = document.getElementById('main-container');
      const button = document.createElement('button');
      button.type = 'button';
      button.style.display = 'none';
      button.setAttribute('data-bs-toggle', 'modal');
    
      switch (mode) {
        case 'add':
          button.setAttribute('data-bs-target', '#addTenantModal');
          break;
        case 'show':
          this.showTenant = tenant;
          button.setAttribute('data-bs-target', '#showTenantModal');
          break;
        case 'edit':
          this.editTenant = tenant;
          button.setAttribute('data-bs-target', '#updateTenantModal');
          break;
        case 'delete':
          this.deleteTenant = tenant;
          button.setAttribute('data-bs-target', '#deleteTenantModal');
          break;
        case 'message':
          this.messageTenant = tenant;
          button.setAttribute('data-bs-target', '#messageTenantModal');
          break;
        default:
          return;
      }
      container?.appendChild(button);
      button.click();
    }
    

    
  public emailValidator(email: string): void{
    this.isEmailDuplicate = this.tenants.some(e => e.email === email);
  }

  public phoneValidator(phone: string): void{
    this.isPhoneDuplicate = this.tenants.some(e => e.phone === phone);
  }

  public onAddTenant(addForm: NgForm): void{
    document.getElementById('add-tenant-form')?.click();
    this.tenantservice.addTenant(addForm.value).subscribe(
      (response: Tenant) => {
        console.log(response);
        this.getTenants();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateTenant(editForm: NgForm): void{
        this.tenantservice.updateTenant(editForm.value).subscribe(
          (response: Tenant) => {
            console.log(response);
            this.getTenants();
          },
          (error: HttpErrorResponse) => {
            alert(error.message);
          }
    
        );
  }

  public onDeleteTenant(id: number):void{
    this.tenantservice.deleteTenant(id).subscribe(
        (response: void) => {
            this.getTenants();
        },
        (error: HttpErrorResponse) => {
            alert(error.message);
        }
    )
  }

  public onMessageTenant(id: number):void{
    
  }

  public searchTenants(key: string): void{
    this.getTenants();
    const results: Tenant[] = [];
    for (const tenant of this.tenants) {
      if (tenant.name.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || tenant.email.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || tenant.phone.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || tenant.roomno.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || tenant.address.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || tenant.facility.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || tenant.officename.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || tenant.officeaddress.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || tenant.roomtype.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || tenant.paymentstatus.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || tenant.profession.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(tenant);
      }
    }
    this.tenants = results;
    if (results.length === 0 || !key) {
      this.getTenants();
    }
  }

  public dateFormat(date: Date| undefined): string|null{
    var datepipe= new DatePipe('en-US');
    return datepipe.transform(date,'dd/MM/yyyy');
  }

}