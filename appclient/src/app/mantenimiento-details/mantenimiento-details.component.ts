import { Mantenimiento } from '../mantenimiento';
import { Component, OnInit, Input } from '@angular/core';
import { MantenimientoService } from '../mantenimiento.service';
import { MantenimientoListComponent } from '../mantenimiento-list/mantenimiento-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-mantenimiento-details',
  templateUrl: './mantenimiento-details.component.html',
  styleUrls: ['./mantenimiento-details.component.css']
})
export class MantenimientoDetailsComponent implements OnInit {

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

  list(){
    this.router.navigate(['mantenimientos']);
  }
}
