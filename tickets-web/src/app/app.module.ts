import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {GameTableComponent} from './game-table/game-table.component';
import {MatButtonModule, MatDialogModule, MatTableModule} from "@angular/material";
import {BrowserModule} from "@angular/platform-browser";
import {HttpClientModule} from '@angular/common/http';
import {PopupComponent} from './popup/popup.component'
import {HttpModule} from "@angular/http";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    GameTableComponent,
    PopupComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatTableModule,
    HttpModule,
    HttpClientModule,
    MatButtonModule,
    MatDialogModule,
    BrowserAnimationsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
