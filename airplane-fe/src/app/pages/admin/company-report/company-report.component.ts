import {Component, OnInit} from '@angular/core';
import {CompanyReportDTO} from "./company-report.dto";
import {CompanyReportService} from "./company-report.service";
import {MatDialog, MatDialogConfig, MatTableDataSource} from "@angular/material";
import {min} from "rxjs/operators";
import {CompanyProfileDTO} from "./../company-profile/company-profile.dto";
import {FlightSearchService} from './../../user/dashboard/flights/flight-search/flight-search.service';
import {FlightSearchResultDTO} from './../../user/dashboard/flights/flight-search-result/flight-search-result.dto';



@Component({
    selector: 'app-company-report',
    templateUrl: './company-report.component.html',
    styleUrls: ['./company-report.component.scss']
})
export class CompanyReportComponent implements OnInit {

    company: CompanyProfileDTO = new CompanyProfileDTO();
    flights: FlightSearchResultDTO[] = [];

    constructor(private companyReportService: CompanyReportService,
                private flightService: FlightSearchService) {
    }

    ngOnInit() {
        this.getCompany();
        this.getFlights();
    }

    getCompany() {
        this.companyReportService.getOne().subscribe(data => {
            if (data) {
                this.company = new CompanyProfileDTO(data);
            }
        });
    }

    getFlights() {
        this.flightService.getAll().subscribe((data: any[]) => {
            if (data.length > 0) {
                this.flights = data;
            }
        });
    }

}
