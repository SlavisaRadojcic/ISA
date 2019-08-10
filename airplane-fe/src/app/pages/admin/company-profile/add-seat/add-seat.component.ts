import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {CompanyProfileService} from "../company-profile.service";
import {FlightDTO} from "../flight.dto";
import {SeatDTO} from "../seat.dto";
import {AuthService} from "../../../../config/auth.service";
import {UserProfileDTO} from "../../../user/user-profile/user-profile.dto";

@Component({
    selector: 'app-add-seat',
    templateUrl: './add-seat.component.html',
    styleUrls: ['./add-seat.component.scss']
})
export class AddSeatComponent implements OnInit {

    flight: FlightDTO;
    seatMatrix: Map<number, SeatDTO[]> = new Map<number, SeatDTO[]>();
    seatNameLetters: string[] = ['A', 'B', 'C', 'D', 'E', 'F'];
    selectedSeats: SeatDTO[] = [];
    user: UserProfileDTO;

    constructor(public dialogRef: MatDialogRef<AddSeatComponent>,
                @Inject(MAT_DIALOG_DATA) public data,
                private companyService: CompanyProfileService,
                private authService: AuthService) {
    }

    ngOnInit() {
        this.flight = this.data;
        this.user = this.authService.getLoggedInUser();

        let counter: number = 1;
        let row: SeatDTO[] = [];

        if (this.flight.seats.length > 0) {
            this.flight.seats.forEach((seat: SeatDTO) => {
                if (row.length === 6) {
                    this.seatMatrix.set(counter, row);
                    counter++;
                    row = [];
                }

                row.push(seat);
            });
            this.seatMatrix.set(counter, row);
        }
    }

    submit() {
        const newSeats: SeatDTO[] = [];
        const deleteSeats: SeatDTO[] = [];

        this.seatMatrix.forEach((row: SeatDTO[], key: number) => {
            row.forEach((seat: SeatDTO) => {
                if (seat.isNew && !seat.isDeleted) {
                    newSeats.push(seat);
                } else if (seat.isDeleted && seat.available) {
                    deleteSeats.push(seat);
                }
            });
        });

        this.companyService.saveNewSeats(newSeats).subscribe(() => {
            this.companyService.deleteSeats(deleteSeats).subscribe(() => this.close(true));
        });


        // fixme prebaciti u rezervaciju sedista
        // const reservedSeats: SeatDTO[] = [];
        // this.seatMatrix.forEach((row: SeatDTO[], key: number) => {
        //     row.forEach((seat: SeatDTO) => {
        //         if (seat.selected) {
        //             const reservedSeat: SeatDTO = this.flight.seats.find((flightSeat: SeatDTO) => flightSeat.id === seat.id);
        //             if (reservedSeat) {
        //                 reservedSeat.available = false;
        //                 reservedSeat.user = this.user;
        //
        //                 reservedSeats.push(reservedSeat);
        //             }
        //         }
        //     });
        // });
    }

    close(data?: any) {
        this.dialogRef.close(data);
    }

    addNewRow() {
        const newRow: SeatDTO[] = [];
        const rowNumber: number = this.seatMatrix.size + 1;

        for (let i = 0; i < 6; i++) {
            const newSeat: SeatDTO = new SeatDTO();
            // newSeat.user = this.user;
            newSeat.available = true;
            newSeat.discounted = false;
            newSeat.name = `${rowNumber}${this.seatNameLetters[i]}`;
            newSeat.flightId = this.flight.id;
            newSeat.isNew = true;

            newRow.push(newSeat);
        }

        if (newRow.length === 6) {
            this.seatMatrix.set(rowNumber, newRow);
        }
    }

    deleteRow(matrixKey: number) {
        const deleteRow: SeatDTO[] = this.seatMatrix.get(matrixKey);
        deleteRow.forEach((seat: SeatDTO) => seat.isDeleted = true);
        // this.seatMatrix.delete(matrixKey);
    }

    addDiscount() {
        // TODO
    }

    isRowDeletable(matrixKey: number) {
        return !(this.seatMatrix.get(matrixKey).filter((seat: SeatDTO) => !seat.available).length === 0);
    }

    selectSeat(seat: SeatDTO) {
        seat.selected = !seat.selected;

        if (seat.selected) {
            this.selectedSeats.push(seat);
        } else {
            this.selectedSeats = this.selectedSeats.filter((seat: SeatDTO) => seat.selected);
        }
    }

    isRowForDelete(matrixKey: number) {
        return this.seatMatrix.get(matrixKey).filter((seat: SeatDTO) => seat.isDeleted).length > 0;
    }

    isRowForAdd(matrixKey: number) {
        return this.seatMatrix.get(matrixKey).filter((seat: SeatDTO) => seat.isNew && !seat.isDeleted).length > 0
    }

}
