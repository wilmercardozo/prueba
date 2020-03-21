import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateMantenimientoComponent } from './create-mantenimiento.component';

describe('CreateMantenimientoComponent', () => {
  let component: CreateMantenimientoComponent;
  let fixture: ComponentFixture<CreateMantenimientoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateMantenimientoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateMantenimientoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
