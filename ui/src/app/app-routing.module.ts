import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
<<<<<<< HEAD
import { EstadisticasComponent } from './estadisticas/estadisticas.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'Inicio', component: HomeComponent },
  {path: 'Estadisticas', component: EstadisticasComponent},
];
=======
import { ViajesComponent } from './viajes/viajes.component';


const routes: Routes = [{
  path: 'inicio', component: HomeComponent },{
    path: 'viajes', component: ViajesComponent },];
>>>>>>> dad91c5cc52cd5c54a8fa7d069659a5cb7560bdd

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
