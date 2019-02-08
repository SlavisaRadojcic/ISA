import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FlightSearchResultComponent} from './flight-search-result.component';
import {
    MatButtonModule,
    MatCheckboxModule,
    MatDividerModule,
    MatIconModule,
    MatInputModule,
    MatSelectModule,
    MatSliderModule,
    MatTableModule
} from "@angular/material";
import {FormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {FlightSearchService} from "./flight-search.service";

@NgModule({
    imports: [
        CommonModule,
        MatTableModule,
        MatButtonModule,
        MatSliderModule,
        MatIconModule,
        FormsModule,
        MatInputModule,
        MatDividerModule,
        MatCheckboxModule,
        MatSelectModule,
        RouterModule
    ],
    declarations: [
        FlightSearchResultComponent
    ],
    providers: [
        FlightSearchService
    ],
    exports: [
        FlightSearchResultComponent
    ]
})
export class FlightSearchResultModule {
}