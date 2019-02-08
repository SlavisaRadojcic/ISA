import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {FlightDTO} from "../flight.dto";
import {CompanyProfileService} from "../company-profile.service";
import {DestinationDTO} from "../destination.dto";

@Component({
    selector: 'app-add-flight',
    templateUrl: './add-flight.component.html',
    styleUrls: ['./add-flight.component.scss']
})
export class AddFlightComponent implements OnInit {

    destinationDto: DestinationDTO;
    flightId: number;
    transfers: string;
    takeOffTime: string;
    landingTime: string;
    flight: FlightDTO = new FlightDTO();

    constructor(public dialogRef: MatDialogRef<AddFlightComponent>,
                @Inject(MAT_DIALOG_DATA) public data,
                private companyService: CompanyProfileService) {
    }

    ngOnInit() {
        this.destinationDto = new DestinationDTO(this.data.destination);
        this.flightId = this.data.flightId;

        if (this.flightId) {
            this.flight = new FlightDTO(this.destinationDto.flights.find((flight: FlightDTO) => this.flightId === flight.id));
            this.transfers = this.flight.locationOfTransfer.join(',');
        }
    }

    submit() {
        this.flight.startingPoint = this.destinationDto.name;
        this.flight.destinationId = this.destinationDto.id;
        this.flight.dateOfTakeOff = this.addTimeToDate(this.takeOffTime, this.flight.dateOfTakeOff);
        this.flight.dateOfLanding = this.addTimeToDate(this.landingTime, this.flight.dateOfLanding);
        this.flight.locationOfTransfer = this.transfers? this.transfers.split(",") : [];

        if (this.flightId) {
            this.companyService.updateFlight(this.flight).subscribe(data => this.close(true));
        } else {
            this.companyService.addFlight(this.flight).subscribe(data => this.close(true));
        }
    }

    close(data?: any) {
        this.dialogRef.close(data);
    }

    addTimeToDate(time: string, date: Date) {
        const newDate = new Date(date);
        const hoursMinutes = time.split(":");

        newDate.setHours(+hoursMinutes[0]);
        newDate.setMinutes(+hoursMinutes[1]);

        return newDate;
    }
}
