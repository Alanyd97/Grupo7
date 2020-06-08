import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { EstadisticasComponent } from './estadisticas/estadisticas.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'Inicio', component: HomeComponent },
  {path: 'Estadisticas', component: EstadisticasComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
