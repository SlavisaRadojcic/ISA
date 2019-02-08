export class FlightSearchItemDTO {

    fromTime: Date;
    toTime: Date;
    fromCity: string;
    toCity: string;
    stops: number;
    time: string;

    constructor(data?: any) {
        if (data) {
            this.fromTime = data.fromTime;
            this.toTime = data.toTime;
            this.fromCity = data.fromCity;
            this.toCity = data.toCity;
            this.stops = data.stops;
            this.time = data.time;
        }
    }

}
