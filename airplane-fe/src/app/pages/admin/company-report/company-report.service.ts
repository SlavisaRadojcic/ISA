import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CompanyReportDTO} from "./company-report.dto";

@Injectable({
    providedIn: 'root'
})
export class CompanyReportService {

    private companyUrl: string = 'http://localhost:8080/api/airplane-companies';

    constructor(private httpClient: HttpClient) {
    }

    getOne(): Observable<any> {
        return this.httpClient.get(this.companyUrl + '/getOne');
    }
}
