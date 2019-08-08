import {SeatDTO} from "./seat.dto";
import {FlightTypeEnum} from "./../../user/dashboard/flights/flight-search/flight-type.enum";
import {FlightClassEnum} from "./../../user/dashboard/flights/flight-search/flight-class.enum";

export class FlightDTO {

    id: number;
    startingPoint: string;
    destinationId: number;
    endingPoint: string;
    dateOfTakeOff: Date;
    dateOfLanding: Date;
    timeOfFlight: number;
    distanceOfFlight: number;
    numberOfTransfers: number;
    locationOfTransfer: string[];
    ticketPrice: number;
    discount: number;
    avrageRate: number;
    seats: SeatDTO[];
    flightType: FlightTypeEnum;
    flightClass: FlightClassEnum;

    constructor(data?: any) {
        if (data) {
            this.id = data.id;
            this.startingPoint = data.startingPoint;
            this.destinationId = data.destinationId;
            this.endingPoint = data.endingPoint;
            this.dateOfTakeOff = data.dateOfTakeOff;
            this.dateOfLanding = data.dateOfLanding;
            this.timeOfFlight = data.timeOfFlight;
            this.distanceOfFlight = data.distanceOfFlight;
            this.numberOfTransfers = data.numberOfTransfers;
            this.locationOfTransfer = data.locationOfTransfer;
            this.ticketPrice = data.ticketPrice;
            this.discount = data.discount;
            this.avrageRate = data.avrageRate;
            this.seats = data.seats;
            this.flightType = data.flightType;
            this.flightClass = data.flightClass;
        }
    }

}
