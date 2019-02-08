import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
    providedIn: 'root'
})
export class FlightSearchService {

    getAllUrl: string = 'http://localhost:8090/api/flight';

    constructor(private httpClient: HttpClient) {
    }

    getAll(): Observable<any> {
        return this.httpClient.get(this.getAllUrl);
    }
}
