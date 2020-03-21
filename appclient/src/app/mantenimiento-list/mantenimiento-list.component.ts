import { MantenimientoDetailsComponent } from '../mantenimiento-details/mantenimiento-details.component';
import { Observable } from "rxjs";
import { MantenimientoService } from "../mantenimiento.service";
import { Mantenimiento } from "../mantenimiento";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: "app-mantenimiento-list",
  templateUrl: "./mantenimiento-list.component.html",
  styleUrls: ["./mantenimiento-list.component.css"]
})
export class MantenimientoListComponent implements OnInit {
  mantenimientos: Observable<Mantenimiento[]>;

  constructor(private mantenimientoService: MantenimientoService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.mantenimientos = this.mantenimientoService.getMantenimientosList();
  }

  deleteMantenimiento(id: number) {
    this.mantenimientoService.deleteMantenimiento(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  mantenimientoDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateMantenimiento(id: number){
    this.router.navigate(['update', id]);
  }
}
