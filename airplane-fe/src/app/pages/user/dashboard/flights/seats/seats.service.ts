import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {FlightSearchItemDTO} from "../flight-search-result/flight-search-item.dto";
import {FlightSearchResultDTO} from "../flight-search-result/flight-search-result.dto";
import {SeatsDTO} from "./seats.dto";
import {map} from "rxjs/operators";

@Injectable({
    providedIn: 'root'
})
export class SeatsService {

    seatsUrl: string = 'http://localhost:8090/api/seats';

    constructor(private httpClient: HttpClient) {}

    getSeatsForFlight(id: number): Observable<any> {
        return this.httpClient.get(`${this.seatsUrl}/flight/${id}`);
    }

    bookTicket(seatId: number): Observable<any> {
        return this.httpClient.post(`${this.seatsUrl}/reserve/${seatId}`, null);
    }

}
