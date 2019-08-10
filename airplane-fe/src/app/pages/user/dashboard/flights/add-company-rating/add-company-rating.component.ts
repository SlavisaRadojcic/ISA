import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {CompanyProfileService} from "./../../../../admin/company-profile/company-profile.service";
import {FlightSearchResultDTO} from "./../flight-search-result/flight-search-result.dto";

@Component({
    selector: 'app-add-company-rating',
    templateUrl: './add-company-rating.component.html',
    styleUrls: ['./add-company-rating.component.scss']
})
export class AddCompanyRatingComponent implements OnInit {

    dto: FlightSearchResultDTO;
    companyId: number;
    comapnyRate: number;

    constructor(public dialogRef: MatDialogRef<AddCompanyRatingComponent>,
                @Inject(MAT_DIALOG_DATA) public data,
                private companyService: CompanyProfileService) {
    }

    ngOnInit() {
        this.companyService.getOne().subscribe(data => {
            if (data) {
                this.companyId = data.id;
            }
        });
    }

    submit() {
        this.companyService.rateCompany(this.companyId, this.comapnyRate).subscribe(() => this.dialogRef.close(true));
    }

    close() {
        this.dialogRef.close();
    }

}
