import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ViajesComponent } from './viajes/viajes.component';


const routes: Routes = [{
  path: 'inicio', component: HomeComponent },{
    path: 'viajes', component: ViajesComponent },];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
