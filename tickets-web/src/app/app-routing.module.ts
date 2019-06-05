import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {GameTableComponent} from "./game-table/game-table.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: 'table',
    pathMatch: 'full'
  },
  {
    path: 'table',
    component: GameTableComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
