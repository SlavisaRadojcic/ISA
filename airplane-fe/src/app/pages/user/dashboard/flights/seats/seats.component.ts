import {Component, OnInit} from '@angular/core';
import {SeatsService} from "./seats.service";
import {ActivatedRoute, Router} from "@angular/router";
import {SeatDTO} from "../../../../admin/company-profile/seat.dto";
import {UserProfileDTO} from "../../../user-profile/user-profile.dto";
import {AuthService} from "../../../../../config/auth.service";
import {FlightDTO} from "../../../../admin/company-profile/flight.dto";

@Component({
    selector: 'app-seats',
    templateUrl: './seats.component.html',
    styleUrls: ['./seats.component.scss']
})
export class SeatsComponent implements OnInit {

    flightDetails: FlightDTO = new FlightDTO();
    seatMatrix: Map<number, SeatDTO[]> = new Map<number, SeatDTO[]>();
    seatNameLetters: string[] = ['A', 'B', 'C', 'D', 'E', 'F'];
    selectedSeats: SeatDTO[] = [];
    user: UserProfileDTO = new UserProfileDTO();

    constructor(private seatsService: SeatsService,
                private authService: AuthService,
                private route: ActivatedRoute,
                private router: Router) {
    }

    ngOnInit() {
        this.route.params.subscribe(params => {
            this.seatsService.getSeatsForFlight(params.id).subscribe((seats: SeatDTO[]) => {
                this.flightDetails.id = params.id;
                this.flightDetails.seats = seats;

                this.user = this.authService.getLoggedInUser();

                let counter: number = 1;
                let row: SeatDTO[] = [];

                if (this.flightDetails.seats.length > 0) {
                    this.flightDetails.seats.forEach((seat: SeatDTO) => {
                        if (row.length === 6) {
                            this.seatMatrix.set(counter, row);
                            counter++;
                            row = [];
                        }

                        row.push(seat);
                    });
                    this.seatMatrix.set(counter, row);
                }
            });
        });
    }

    selectSeat(seat: SeatDTO): void {
        seat.selected = !seat.selected;
    }

    goBack() {
        this.router.navigate(['../../'], {relativeTo: this.route});
    }

    makeReservation() {
        const reservedSeats: SeatDTO[] = [];
        this.seatMatrix.forEach((row: SeatDTO[], key: number) => {
            row.forEach((seat: SeatDTO) => {
                if (seat.selected) {
                    const reservedSeat: SeatDTO = this.flightDetails.seats
                        .find((flightSeat: SeatDTO) => flightSeat.id === seat.id);
                    if (reservedSeat) {
                        reservedSeat.available = false;
                        reservedSeat.user = this.user;

                        reservedSeats.push(reservedSeat);
                    }
                }
            });
        });

        this.seatsService.bookTicket(reservedSeats[0].id).subscribe(() => this.goBack());
    }

}
