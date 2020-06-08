import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MapSmallComponent } from './map-small.component';

describe('MapSmallComponent', () => {
  let component: MapSmallComponent;
  let fixture: ComponentFixture<MapSmallComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MapSmallComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MapSmallComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
