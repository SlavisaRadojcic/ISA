import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {CompanyProfileService} from "../company-profile.service";
import {CompanyProfileDTO} from "../company-profile.dto";

@Component({
    selector: 'app-add-rating',
    templateUrl: './add-rating.component.html',
    styleUrls: ['./add-rating.component.scss']
})
export class AddRatingComponent implements OnInit {

    dto: CompanyProfileDTO;
    companyRate: number;

    constructor(public dialogRef: MatDialogRef<AddRatingComponent>,
                @Inject(MAT_DIALOG_DATA) public data,
                private companyService: CompanyProfileService) {
    }

    ngOnInit() {
        this.dto = new CompanyProfileDTO(this.data);
    }

    submit() {
        this.companyService.rateCompany(this.dto.id, this.companyRate).subscribe(() => this.dialogRef.close(true));
    }

    close() {
        this.dialogRef.close();
    }

}
