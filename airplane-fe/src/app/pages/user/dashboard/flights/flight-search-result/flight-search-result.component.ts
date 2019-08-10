import {Component, OnInit} from '@angular/core';
import {MatDialog, MatDialogConfig, MatTableDataSource} from "@angular/material";
import {FlightSearchResultDTO} from "./flight-search-result.dto";
import {ActivatedRoute, Router} from "@angular/router";
import { FlightSearchService } from '../flight-search/flight-search.service';
import {AddFlightRatingComponent} from "./../add-flight-rating/add-flight-rating.component";
import {AddCompanyRatingComponent} from "./../add-company-rating/add-company-rating.component";
import {SeatsService} from "./../seats/seats.service";

@Component({
    selector: 'app-search-results',
    templateUrl: './flight-search-result.component.html',
    styleUrls: ['./flight-search-result.component.scss']
})
export class FlightSearchResultComponent implements OnInit {

    datasource: FlightSearchResultDTO[] = [];

    constructor(private router: Router,
                private route: ActivatedRoute,
                private flightService: FlightSearchService,
                private dialog: MatDialog,
                private seatsService: SeatsService) {
    }

    ngOnInit() {
        this.getFlights();
    }

    getFlights() {
        this.flightService.getAll().subscribe((data: any[]) => {
            if (data.length > 0) {
                this.datasource = data;
            }
        });
    }

    flightDetails(flight: FlightSearchResultDTO) {
        this.router.navigate([flight.id, 'seats'], {relativeTo: this.route});
    }

    prettifyTime(timeInMinutes: number) {
        let hours: number = Math.floor(timeInMinutes / 60);
        let minutes: number = timeInMinutes % 60;

        return `${hours}h ${minutes}min`;
    }

    searchResult(data: FlightSearchResultDTO[]) {
        this.datasource = data;
    }

    addRating(flight: FlightSearchResultDTO) {
        const dialogConfig = new MatDialogConfig();
        dialogConfig.disableClose = true;
        dialogConfig.hasBackdrop = true;
        dialogConfig.panelClass = 'add-flight-rating-dialog';
        dialogConfig.data = flight;

        const dialogRef = this.dialog.open(AddFlightRatingComponent, dialogConfig);

        dialogRef.afterClosed().subscribe(result => {
            if (result) {
                this.getFlights();
            }
        });
    }

    addCompanyRating() {
        const dialogConfig = new MatDialogConfig();
        dialogConfig.disableClose = true;
        dialogConfig.hasBackdrop = true;
        dialogConfig.panelClass = 'add-company-rating-dialog';

        const dialogRef = this.dialog.open(AddCompanyRatingComponent, dialogConfig);

        dialogRef.afterClosed().subscribe(result => {
            if (result) {
                this.getFlights();
            }
        });
    }

    byTicket(flight: FlightSearchResultDTO) {
        this.seatsService.fastReservation(flight.id).subscribe((data: any[]) => {
            if (data.length > 0) {
                this.getFlights();
            }
        });
    }
}
