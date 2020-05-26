import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ModalComponent } from './modal/modal.component';
import { NavComponent } from './nav/nav.component';
import { FooterComponent } from './footer/footer.component';
import { VtableComponent } from './vtable/vtable.component';
import { TableModule } from 'primeng/table';
import { DropdownModule } from 'primeng/dropdown';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ViajeService } from './services/viaje.service';
import { VueloService } from './services/vuelo.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ModalComponent,
    NavComponent,
    FooterComponent,
    VtableComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    TableModule,
    DropdownModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [ ViajeService, VueloService ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
