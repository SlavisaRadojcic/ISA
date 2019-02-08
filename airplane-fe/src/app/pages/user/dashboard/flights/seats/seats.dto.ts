import {FlightDTO} from "../../../../admin/company-profile/flight.dto";
import {UserProfileDTO} from "../../../user-profile/user-profile.dto";

export class SeatsDTO {

    id: number;
    name: string;
    discounted: boolean;
    available: boolean;
    selected: boolean = false;
    flight: FlightDTO;
    user: UserProfileDTO;

    constructor(data?: any) {
        console.log(data);
        this.id = data.id;
        this.name = data.name;
        this.discounted = data.discounted;
        this.available = data.available;
        this.selected = data.selected;
        this.flight = data.flight;
        this.user = data.user;
    }

}
