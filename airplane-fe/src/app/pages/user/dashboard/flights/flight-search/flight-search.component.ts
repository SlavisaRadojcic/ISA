import {Component, OnInit, Output} from '@angular/core';
import {FlightSearchDTO} from "./flight-search.dto";
import {FlightTypeEnum} from "./flight-type.enum";
import {FlightClassEnum} from "./flight-class.enum";
import { OuterSubscriber } from 'rxjs/internal/OuterSubscriber';
import { EventEmitter } from 'events';
import { FlightSearchService } from './flight-search.service';

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

    @Output()
    searchResult = new EventEmitter();

    constructor(private flightSearchService: FlightSearchService) {
    }

    ngOnInit() {
    }

    search(dto: FlightSearchDTO) {
        // this.search(dto);
        //pozvati servis sa prikaz
        // this.searchResult.emit('prosledjujem rezultat promisa')
    }

}
