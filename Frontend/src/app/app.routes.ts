import { Routes } from '@angular/router';
import { ManagerComponent } from './manager/manager.component';

export const routes: Routes = [
    {path:'',redirectTo:"home",pathMatch:"full"},
    {path:"home",component: ManagerComponent}
    
];
