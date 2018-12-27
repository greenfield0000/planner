import { RouterModule } from '@angular/router';
import { DashbordRoutingModule } from './dashbord-routing.module';
import { DashbordComponent } from './dashbord.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderOutletComponent } from 'src/app/outlets/header-outlet/header-outlet.component';
import { MainOutletComponent } from 'src/app/outlets/main-outlet/main-outlet.component';
import { FooterOutletComponent } from 'src/app/outlets/footer-outlet/footer-outlet.component';
import { MatToolbarModule, MatSidenavModule, MatButtonModule, MatIconModule } from '@angular/material';

@NgModule({
  declarations: [DashbordComponent, HeaderOutletComponent, MainOutletComponent, FooterOutletComponent],
  imports: [
    CommonModule,
    DashbordRoutingModule,
    RouterModule,
    MatToolbarModule,
    MatSidenavModule,
    MatButtonModule,
    MatIconModule
  ],
  exports: [
    HeaderOutletComponent, MainOutletComponent, FooterOutletComponent
  ],
  bootstrap: [HeaderOutletComponent, MainOutletComponent, FooterOutletComponent]
})
export class DashbordModule { }
