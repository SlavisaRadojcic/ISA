import {FlightTypeEnum} from "./flight-type.enum";
import {FlightClassEnum} from "./flight-class.enum";

export class FlightSearchDTO {

    flightType: FlightTypeEnum;
    flightClass: FlightClassEnum;
    numberOfPassengers: number;
    from: string;
    to: string;
    depart: Date;
    arrival: Date;

    constructor(data?: any) {
        if (data) {
            this.flightType = data.flightType;
            this.flightClass = data.flightClass;
            this.numberOfPassengers = data.numberOfPassengers;
            this.from = data.from;
            this.to = data.to;
            this.depart = data.depart;
            this.arrival = data.arrival;
        }
    }


}
