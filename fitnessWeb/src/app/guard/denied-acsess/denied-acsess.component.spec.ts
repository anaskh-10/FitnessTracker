import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeniedAcsessComponent } from './denied-acsess.component';

describe('DeniedAcsessComponent', () => {
  let component: DeniedAcsessComponent;
  let fixture: ComponentFixture<DeniedAcsessComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DeniedAcsessComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DeniedAcsessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
