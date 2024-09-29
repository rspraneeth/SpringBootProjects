import { Routes } from '@angular/router';
import { HomeComponent } from './employee/home/home.component';
import { CreateComponent } from './employee/create/create.component';
import { EditComponent } from './employee/edit/edit.component';

export const routes: Routes = [
    {path:"employee/home", component:HomeComponent},
    {path:"employee", redirectTo:"employee/home", pathMatch:"full"},
    {path:"", redirectTo:"employee/home", pathMatch:"full"},
    {path:"employee/create", component: CreateComponent},
    {path:"employee/edit/:id", component: EditComponent}, 
    {path:"employee/delete/:id", component: HomeComponent}
];
