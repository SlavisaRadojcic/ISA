import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FlightSearchComponent} from './flight-search.component';
import {
    MAT_DATE_LOCALE,
    MatButtonModule,
    MatDatepickerModule,
    MatIconModule,
    MatInputModule,
    MatNativeDateModule,
    MatSelectModule
} from "@angular/material";
import {FormsModule} from "@angular/forms";
import {FlightSearchResultModule} from "../flight-search-result/flight-search-result.module";
import {SeatsModule} from "../seats/seats.module";

@NgModule({
    imports: [
        CommonModule,
        FlightSearchResultModule,
        MatButtonModule,
        MatSelectModule,
        MatInputModule,
        FormsModule,
        MatIconModule,
        MatDatepickerModule,
        MatNativeDateModule,
        SeatsModule
    ],
    declarations: [
        FlightSearchComponent
    ],
    exports: [
        FlightSearchComponent
    ],
    providers: [
        {
            provide: MAT_DATE_LOCALE,
            useValue: 'rs'
        }
    ],
})
export class FlightSearchModule {
}
