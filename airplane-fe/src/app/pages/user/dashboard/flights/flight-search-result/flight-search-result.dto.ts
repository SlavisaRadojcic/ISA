export class FlightSearchResultDTO {

    id: number;
    startingPoint: string;
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

    constructor(data?: any) {
        if (data) {
            this.id = data.id;
            this.startingPoint = data.startingPoint;
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
        }
    }

}
