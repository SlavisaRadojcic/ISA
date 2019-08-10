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
    MatTableModule,
    MatDialogModule
} from "@angular/material";
import {FormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {AddFlightRatingComponent} from "./../add-flight-rating/add-flight-rating.component";
import {AddCompanyRatingComponent} from "./../add-company-rating/add-company-rating.component";

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
        RouterModule,
        MatDialogModule
    ],
    entryComponents: [
        FlightSearchResultComponent,
        AddFlightRatingComponent,
        AddCompanyRatingComponent
    ],
    declarations: [
        FlightSearchResultComponent,
        AddFlightRatingComponent,
        AddCompanyRatingComponent
    ],
    providers: [
    ],
    exports: [
        FlightSearchResultComponent
    ]
})
export class FlightSearchResultModule {
}
