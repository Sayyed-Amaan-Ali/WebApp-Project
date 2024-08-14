import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Tenant } from "./tenant";
import { Observable } from "rxjs";


@Injectable({
    providedIn: 'root'
})

export class TenantServices{
    private apiserverurl= 'http://localhost:4000';
    constructor(private http: HttpClient){}

    public getTenants():Observable<Tenant[]>{
        return this.http.get<Tenant[]>(`${this.apiserverurl}/tenant/all`);
    }

    public addTenant(tenant: Tenant):Observable<Tenant>{
        return this.http.post<Tenant>(`${this.apiserverurl}/tenant/add`, tenant);
    }

    public updateTenant(tenant: Tenant):Observable<Tenant>{
        return this.http.put<Tenant>(`${this.apiserverurl}/tenant/update`,tenant);
    }

    public deleteTenant(id: number):Observable<void>{
        return this.http.delete<void>(`${this.apiserverurl}/tenant/delete/${id}`);
    }

}