import {Injectable, ViewChild} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {FlightSearchDTO} from "./flight-search.dto";

@Injectable({
    providedIn: 'root'
})
export class FlightSearchService {

    getAllUrl: string = 'http://localhost:8080/api/flight';
    seatUrl: string = 'http://localhost:8080/api/seats';

    constructor(private httpClient: HttpClient) {
    }

    getAll(): Observable<any> {
        return this.httpClient.get(this.getAllUrl);
    }

    searchFlight(dto: FlightSearchDTO): Observable<any> {
        return this.httpClient.post(this.getAllUrl + "/search", dto);
    }

    searchFlightWithDiscount(): Observable<any> {
        return this.httpClient.get(this.getAllUrl + "/discount");
    }

    rateFlight(flightId: number, rating: number): Observable<any> {
        return this.httpClient.get(this.getAllUrl + '/vote/' + flightId + '/' + rating);
    }
    
    reserveFlight(flightId: number): Observable<any> {
        return this.httpClient.get(this.seatUrl + "/fastReservation/" + flightId);
    }
}