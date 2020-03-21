import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateMantenimientoComponent } from './update-mantenimiento.component';

describe('UpdateMantenimientoComponent', () => {
  let component: UpdateMantenimientoComponent;
  let fixture: ComponentFixture<UpdateMantenimientoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateMantenimientoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateMantenimientoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
