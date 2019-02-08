import {FlightDetailsPassengerDTO} from "./flight-details-passenger.dto";
import {SeatStatus} from "./seat-status.enum";
import {SeatsDTO} from "./seats.dto";

export class FlightDetailsDTO {

    id: number;
    seats: SeatsDTO[] = [];
    passenger: FlightDetailsPassengerDTO = new FlightDetailsPassengerDTO();

    constructor(data?: any) {
        if (data) {
            this.id = data.id;
            this.seats = data.seats;
            this.passenger = data.passenger;
        }
    }

}
