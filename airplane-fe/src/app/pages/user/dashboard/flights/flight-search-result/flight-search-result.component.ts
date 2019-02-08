import {Component, OnInit} from '@angular/core';
import {FlightSearchResultDTO} from "./flight-search-result.dto";
import {ActivatedRoute, Router} from "@angular/router";
import {FlightSearchService} from "./flight-search.service";

@Component({
    selector: 'app-search-results',
    templateUrl: './flight-search-result.component.html',
    styleUrls: ['./flight-search-result.component.scss']
})
export class FlightSearchResultComponent implements OnInit {

    datasource: FlightSearchResultDTO[] = [];

    constructor(private router: Router,
                private route: ActivatedRoute,
                private flightService: FlightSearchService) {
    }

    ngOnInit() {
        this.flightService.getAll().subscribe((data: any[]) => {
            if (data.length > 0) {
                this.datasource = data;
            }
        });
    }

    flightDetails(flight: FlightSearchResultDTO) {
        this.router.navigate([flight.id, 'seats'], {relativeTo: this.route});
    }

    prettifyTime(timeInMinutes: number) {
        let hours: number = Math.floor(timeInMinutes / 60);
        let minutes: number = timeInMinutes % 60;

        return `${hours}h ${minutes}min`;
    }
}
