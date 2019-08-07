import {Component, OnInit} from '@angular/core';
import {CompanyReportDTO} from "./company-report.dto";
import {CompanyReportService} from "./company-report.service";
import {MatDialog, MatDialogConfig, MatTableDataSource} from "@angular/material";
import {min} from "rxjs/operators";

@Component({
    selector: 'app-company-report',
    templateUrl: './company-report.component.html',
    styleUrls: ['./company-report.component.scss']
})
export class CompanyReportComponent implements OnInit {

    constructor() {
    }

    ngOnInit() {
    }

}
