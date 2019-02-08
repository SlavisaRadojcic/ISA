import {Component, OnInit} from '@angular/core';
import {CompanyProfileDTO} from "./company-profile.dto";
import {CompanyProfileService} from "./company-profile.service";
import {MatDialog, MatDialogConfig, MatTableDataSource} from "@angular/material";
import {DestinationDTO} from "./destination.dto";
import {FlightDTO} from "./flight.dto";
import {min} from "rxjs/operators";
import {AddFlightComponent} from "./add-flight/add-flight.component";
import {AddDestinationComponent} from "./add-destination/add-destination.component";
import {AddSeatComponent} from "./add-seat/add-seat.component";

@Component({
    selector: 'app-company-profile',
    templateUrl: './company-profile.component.html',
    styleUrls: ['./company-profile.component.scss']
})
export class CompanyProfileComponent implements OnInit {

    companyProfileDTO: CompanyProfileDTO = new CompanyProfileDTO();
    destinations: Map<number, string> = new Map<number, string>();
    flights: Map<number, MatTableDataSource<FlightDTO>> = new Map<number, MatTableDataSource<FlightDTO>>();

    flightsDataSource = new MatTableDataSource();
    flightsTableColumns: string[] = ['endingPoint', 'takeOffTime', 'dateOfLanding', 'timeOfFlight', 'distance', 'numberOfTransfers', 'locationOfTransfer', 'ticketPrice', 'avrageRate', 'tickets', 'actions'];

    constructor(private companyProfileService: CompanyProfileService,
                private dialog: MatDialog) {
    }

    ngOnInit() {
        this.getCompany();
    }

    getCompany() {
        this.companyProfileService.getById(1).subscribe(data => {
            if (data) {
                this.companyProfileDTO = new CompanyProfileDTO(data);
            }
        });
    }

    getFlights() {
        this.companyProfileService.getDestinationsWithFlightsAndTickets().subscribe((data: any[]) => {
            if (data.length > 0) {
                this.companyProfileDTO = new CompanyProfileDTO(data);
                let counter: number = 0;

                this.companyProfileDTO.destinations.forEach((destination: DestinationDTO) => {
                    this.destinations.set(counter, destination.name);
                    this.flights.set(counter, new MatTableDataSource(destination.flights));

                    counter++;
                });
            }
        });
    }

    updateProfile() {

    }

    prettifyTime(timeInMinutes: number): string {
        let hours: number = Math.floor(timeInMinutes / 60);
        let minutes: number = timeInMinutes % 60;

        let hoursString: string = hours < 10 ? '0' + hours : hours.toString();
        let minutesString = minutes < 10 ? '0' + minutes : minutes.toString();

        return `${hours}h ${minutes}min`;
    }

    addFlight(destination: DestinationDTO, flightId?: number) {
        const dialogConfig = new MatDialogConfig();
        dialogConfig.disableClose = true;
        dialogConfig.hasBackdrop = true;
        dialogConfig.panelClass = 'add-flight-dialog';
        dialogConfig.data = {
            destination: destination,
            flightId: flightId
        };

        const dialogRef = this.dialog.open(AddFlightComponent, dialogConfig);

        dialogRef.afterClosed().subscribe(result => {
            if (result) {
                this.getCompany();
            }
        });
    }

    deleteFlight(flightId: number) {
        this.companyProfileService.deleteFlight(flightId).subscribe(() => this.getCompany());
    }

    addDestination() {
        const dialogConfig = new MatDialogConfig();
        dialogConfig.disableClose = true;
        dialogConfig.hasBackdrop = true;
        dialogConfig.panelClass = 'add-destination-dialog';
        dialogConfig.data = this.companyProfileDTO;

        const dialogRef = this.dialog.open(AddDestinationComponent, dialogConfig);

        dialogRef.afterClosed().subscribe(result => {
            if (result) {
                this.getCompany();
            }
        });
    }

    addSeats(flight: FlightDTO) {
        const dialogConfig = new MatDialogConfig();
        dialogConfig.disableClose = true;
        dialogConfig.hasBackdrop = true;
        dialogConfig.panelClass = 'add-seat-dialog';
        dialogConfig.data = flight;

        const dialogRef = this.dialog.open(AddSeatComponent, dialogConfig);

        dialogRef.afterClosed().subscribe(result => {
            if (result) {
                this.getCompany();
            }
        });
    }

    deleteDestination(destination: DestinationDTO) {
        this.companyProfileService.deleteDestination(destination.id).subscribe(() => this.getCompany());
    }

}
