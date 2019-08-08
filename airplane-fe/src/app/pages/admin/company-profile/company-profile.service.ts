import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {FlightDTO} from "./flight.dto";
import {DestinationDTO} from "./destination.dto";
import {CompanyProfileDTO} from "./company-profile.dto";
import {SeatDTO} from "./seat.dto";

@Injectable({
    providedIn: 'root'
})
export class CompanyProfileService {

    private companyUrl: string = 'http://localhost:8080/api/airplane-companies';
    private flightUrl: string = 'http://localhost:8080/api/flight';
    private destinationUrl: string = 'http://localhost:8080/api/destinations';
    private seatsUrl: string = 'http://localhost:8080/api/seats';

    constructor(private httpClient: HttpClient) {
    }

    getDestinationsWithFlightsAndTickets(): Observable<any> {
        return this.httpClient.get(this.flightUrl);
    }

    getById(id: number): Observable<any> {
        return this.httpClient.get(this.companyUrl + `/${id}`);
    }

    addFlight(dto: FlightDTO): Observable<any> {
        return this.httpClient.post(this.flightUrl, dto);
    }

    updateFlight(dto: FlightDTO): Observable<any> {
        return this.httpClient.put(this.flightUrl, dto);
    }

    deleteFlight(flightId: number): Observable<any> {
        return this.httpClient.delete(this.flightUrl + '/' + flightId);
    }

    addDestination(dto: DestinationDTO): Observable<any> {
        return this.httpClient.post(this.destinationUrl, dto);
    }

    deleteDestination(id: number): Observable<any> {
        return this.httpClient.delete(this.destinationUrl + '/' + id);
    }

    updateCompany(dto: CompanyProfileDTO): Observable<any> {
        return this.httpClient.put(this.companyUrl, dto);
    }

    saveNewSeats(seats: SeatDTO[]): Observable<any> {
        return this.httpClient.post(this.seatsUrl + '/list', seats);
    }

    deleteSeats(seats: SeatDTO[]): Observable<any> {
        return this.httpClient.post(this.seatsUrl + '/deleteSeats', seats);
    }

    rateCompany(companyId: number, rating: number): Observable<any> {
        return this.httpClient.get(this.companyUrl + '/vote/' + companyId + '/' + rating);
    }
}
