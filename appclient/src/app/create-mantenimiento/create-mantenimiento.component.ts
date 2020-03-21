import { MantenimientoService } from '../mantenimiento.service';
import { Mantenimiento } from '../mantenimiento';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-mantenimiento',
  templateUrl: './create-mantenimiento.component.html',
  styleUrls: ['./create-mantenimiento.component.css']
})
export class CreateMantenimientoComponent implements OnInit {

  mantenimiento: Mantenimiento = new Mantenimiento();
  submitted = false;

  constructor(private mantenimientoService: MantenimientoService,
    private router: Router) { }

  ngOnInit() {
  }

  newMantenimiento(): void {
    this.submitted = false;
    this.mantenimiento = new Mantenimiento();
  }

  save() {
    this.mantenimientoService.createMantenimiento(this.mantenimiento)
      .subscribe(data => console.log(data), error => console.log(error));
    this.mantenimiento = new Mantenimiento();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/mantenimientos']);
  }
}
