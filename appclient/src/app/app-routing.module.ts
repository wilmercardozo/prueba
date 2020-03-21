import { MantenimientoDetailsComponent } from './mantenimiento-details/mantenimiento-details.component';
import { CreateMantenimientoComponent } from './create-mantenimiento/create-mantenimiento.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MantenimientoListComponent } from './mantenimiento-list/mantenimiento-list.component';
import { UpdateMantenimientoComponent } from './update-mantenimiento/update-mantenimiento.component';

const routes: Routes = [
  { path: '', redirectTo: 'mantenimiento', pathMatch: 'full' },
  { path: 'mantenimientos', component: MantenimientoListComponent },
  { path: 'add', component: CreateMantenimientoComponent },
  { path: 'update/:id', component: UpdateMantenimientoComponent },
  { path: 'details/:id', component: MantenimientoDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
