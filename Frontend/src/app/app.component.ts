import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ManagerComponent } from './manager/manager.component';
import { tenantComponent } from './tenants/tenant.component';
import { MemberService } from './manager/memberService';
import { TenantServices } from './tenants/TenantServices';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,CommonModule,FormsModule,
    ManagerComponent,tenantComponent],
  providers:[MemberService,TenantServices],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'hostelmanagementapp';
}
