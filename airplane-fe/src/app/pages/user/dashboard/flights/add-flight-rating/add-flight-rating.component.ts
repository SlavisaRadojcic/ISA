import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {FlightSearchService} from "./../flight-search/flight-search.service";
import {FlightSearchResultDTO} from "./../flight-search-result/flight-search-result.dto";

@Component({
    selector: 'app-add-fligt-rating',
    templateUrl: './add-flight-rating.component.html',
    styleUrls: ['./add-flight-rating.component.scss']
})
export class AddFlightRatingComponent implements OnInit {

    dto: FlightSearchResultDTO;
    flightId: number;
    flightRate: number;

    constructor(public dialogRef: MatDialogRef<AddFlightRatingComponent>,
                @Inject(MAT_DIALOG_DATA) public data,
                private flightService: FlightSearchService) {
    }

    ngOnInit() {
        // this.dto = new FlightSearchResultDTO(this.data);
        this.flightId = this.data.id;
    }

    submit() {
        this.flightService.rateFlight(this.flightId, this.flightRate).subscribe(() => this.dialogRef.close(true));
    }

    close() {
        this.dialogRef.close();
    }

}
