import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {CompanyProfileService} from "../company-profile.service";
import {DestinationDTO} from "../destination.dto";
import {CompanyProfileDTO} from "../company-profile.dto";

@Component({
    selector: 'app-add-destination',
    templateUrl: './add-destination.component.html',
    styleUrls: ['./add-destination.component.scss']
})
export class AddDestinationComponent implements OnInit {

    dto: CompanyProfileDTO;
    destinationName: string;

    constructor(public dialogRef: MatDialogRef<AddDestinationComponent>,
                @Inject(MAT_DIALOG_DATA) public data,
                private companyService: CompanyProfileService) {
    }

    ngOnInit() {
        this.dto = new CompanyProfileDTO(this.data);
    }

    submit() {
        // this.dto.destinations.push(new DestinationDTO({name: this.destinationName}));
        const destinationDto: DestinationDTO = new DestinationDTO();
        destinationDto.name = this.destinationName;
        destinationDto.companyId = this.dto.id;
        this.companyService.addDestination(destinationDto).subscribe(() => this.dialogRef.close(true));
    }

    close() {
        this.dialogRef.close();
    }

}
