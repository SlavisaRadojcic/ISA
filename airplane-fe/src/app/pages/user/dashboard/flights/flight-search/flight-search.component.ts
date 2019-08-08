import {Component, OnInit, Output, ViewChild} from '@angular/core';
import {FlightSearchDTO} from "./flight-search.dto";
import {FlightTypeEnum} from "./flight-type.enum";
import {FlightClassEnum} from "./flight-class.enum";
import { OuterSubscriber } from 'rxjs/internal/OuterSubscriber';
import { FlightSearchService } from './flight-search.service';
import {FlightSearchResultComponent} from './../flight-search-result/flight-search-result.component';

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

    @ViewChild(FlightSearchResultComponent)
    flightSearchResult: FlightSearchResultComponent;

    constructor(private flightSearchService: FlightSearchService) {
    }

    ngOnInit() {
    }

    search(searchDTO: FlightSearchDTO) {
        this.flightSearchService.searchFlight(searchDTO).subscribe(data => {
            if (data) {
                this.flightSearchResult.searchResult(data);
            }
        });
    }

    flightsOnDiscount() {
        this.flightSearchService.searchFlightWithDiscount().subscribe(data => {
            if (data) {
                this.flightSearchResult.searchResult(data);
            }
        });
    }

}
