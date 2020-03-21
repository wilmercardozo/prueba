import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateMantenimientoComponent } from './create-mantenimiento/create-mantenimiento.component';
import { MantenimientoDetailsComponent } from './mantenimiento-details/mantenimiento-details.component';
import { MantenimientoListComponent } from './mantenimiento-list/mantenimiento-list.component';
import { HttpClientModule } from '@angular/common/http';
import { UpdateMantenimientoComponent } from './update-mantenimiento/update-mantenimiento.component';
@NgModule({
  declarations: [
    AppComponent,
    CreateMantenimientoComponent,
    MantenimientoDetailsComponent,
    MantenimientoListComponent,
    UpdateMantenimientoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
