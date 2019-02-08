import {Component, OnInit} from '@angular/core';
import {FlightSearchDTO} from "./flight-search.dto";
import {FlightTypeEnum} from "./flight-type.enum";
import {FlightClassEnum} from "./flight-class.enum";

@Component({
    selector: 'app-flight-search',
    templateUrl: './flight-search.component.html',
    styleUrls: ['./flight-search.component.scss']
})
export class FlightSearchComponent implements OnInit {

    today: Date = new Date(Date.now());
    searchDTO: FlightSearchDTO = new FlightSearchDTO();
    // FIXME
    flightTypes: string[] = [FlightTypeEnum.ONE_WAY, FlightTypeEnum.MULTI_CITY, FlightTypeEnum.ROUND_TRIP];
    flightClasses: string[] = [FlightClassEnum.BUSINESS, FlightClassEnum.ECONOMY, FlightClassEnum.FIRST];

    constructor() {
    }

    ngOnInit() {
    }

}
