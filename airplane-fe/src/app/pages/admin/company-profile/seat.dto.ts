import {UserProfileDTO} from "../../user/user-profile/user-profile.dto";

export class SeatDTO {

    id: number = 0;
    name: string = '';
    flightId: number = 0;
    discounted: boolean = false;
    available: boolean = false;
    selected: boolean = false;
    user: UserProfileDTO;
    isNew: boolean = false;
    isDeleted: boolean = false;
    version: number = 0;

    constructor(data?: any) {
        if (data) {
            this.id = data.id;
            this.name = data.name;
            this.flightId = data.flightId;
            this.discounted = data.discounted;
            this.available = data.available;
            this.selected = data.selected;
            this.user = data.user;
            this.isNew = data.isNew;
            this.isDeleted = data.isDeleted;
            this.version = data.version;
        }
    }
}
