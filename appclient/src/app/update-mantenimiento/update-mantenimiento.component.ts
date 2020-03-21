import { Component, OnInit } from '@angular/core';
import { Mantenimiento } from '../mantenimiento';
import { ActivatedRoute, Router } from '@angular/router';
import { MantenimientoService } from '../mantenimiento.service';

@Component({
  selector: 'app-update-mantenimiento',
  templateUrl: './update-mantenimiento.component.html',
  styleUrls: ['./update-mantenimiento.component.css']
})
export class UpdateMantenimientoComponent implements OnInit {

  id: number;
  mantenimiento: Mantenimiento;

  constructor(private route: ActivatedRoute,private router: Router,
    private mantenimientoService: MantenimientoService) { }

  ngOnInit() {
    this.mantenimiento = new Mantenimiento();

    this.id = this.route.snapshot.params['id'];
    
    this.mantenimientoService.getMantenimiento(this.id)
      .subscribe(data => {
        console.log(data)
        this.mantenimiento = data;
      }, error => console.log(error));
  }

  updateMantenimiento() {
    this.mantenimientoService.updateMantenimiento(this.id, this.mantenimiento)
      .subscribe(data => console.log(data), error => console.log(error));
    this.mantenimiento = new Mantenimiento();
    this.gotoList();
  }

  onSubmit() {
    this.updateMantenimiento();    
  }

  gotoList() {
    this.router.navigate(['/mantenimientos']);
  }
}
