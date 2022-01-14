import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DepartmentListComponent} from "./department-list/department-list.component";
import {PageNotFoundComponent} from "./page-not-found/page-not-found.component";
import {UserListComponent} from "./user-list/user-list.component";

const routes: Routes = [
  {path: 'department-list', component: DepartmentListComponent},
  {path: 'user-list', component: UserListComponent},
  {path: '', redirectTo: '/department-list', pathMatch: 'full'},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
