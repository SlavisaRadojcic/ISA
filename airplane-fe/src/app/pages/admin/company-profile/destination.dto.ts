import {FlightDTO} from "./flight.dto";

export class DestinationDTO {

    id: number;
    name: string;
    companyId: number;
    flights: FlightDTO[];

    constructor(data?: any) {
        if (data) {
            this.id = data.id;
            this.name = data.name;
            this.companyId = data.companyId;
            this.flights = data.flights;
        }
    }

}
