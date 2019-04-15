import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ThesisFormComponent } from './thesis-form.component';

describe('ThesisFormComponent', () => {
  let component: ThesisFormComponent;
  let fixture: ComponentFixture<ThesisFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ThesisFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ThesisFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
