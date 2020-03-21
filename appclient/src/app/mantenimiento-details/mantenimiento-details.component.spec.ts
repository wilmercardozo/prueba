import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MantenimientoDetailsComponent } from './mantenimiento-details.component';

describe('MantenimientoDetailsComponent', () => {
  let component: MantenimientoDetailsComponent;
  let fixture: ComponentFixture<MantenimientoDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MantenimientoDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MantenimientoDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
