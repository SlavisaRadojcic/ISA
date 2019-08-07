import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CompanyReportDTO} from "./company-report.dto";

@Injectable({
    providedIn: 'root'
})
export class CompanyReportService {

    private companyUrl: string = 'http://localhost:8080/api/airplane-companies';
    private flightUrl: string = 'http://localhost:8080/api/flight';
    private destinationUrl: string = 'http://localhost:8080/api/destinations';
    private seatsUrl: string = 'http://localhost:8080/api/seats';

    constructor(private httpClient: HttpClient) {
    }

}
