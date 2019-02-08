import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {DashboardComponent} from './dashboard.component';
import {MatIconModule, MatTabsModule} from "@angular/material";
import {FlightSearchModule} from "./flights/flight-search/flight-search.module";
import {RouterModule} from "@angular/router";
import {HotelSearchModule} from "./hotels/hotel-search/hotel-search.module";
import {CarSearchModule} from "./cars/car-search/car-search.module";

@NgModule({
    imports: [
        CommonModule,
        MatTabsModule,
        MatIconModule,
        FlightSearchModule,
        HotelSearchModule,
        CarSearchModule,
        RouterModule
    ],
    declarations: [
        DashboardComponent
    ],
    exports: [
        DashboardComponent
    ]
})
export class DashboardModule {
}
