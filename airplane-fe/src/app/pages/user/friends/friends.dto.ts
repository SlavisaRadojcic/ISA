import {UserProfileDTO} from "./../user-profile/user-profile.dto";

export class FriendsDTO {

    status: string;
    friendFirstName: string;
    friendLastName: string;
    user: UserProfileDTO;

    constructor(data?: any) {
        if (data) {
            this.status = data.status;
            this.friendFirstName = data.friendFirstName;
            this.friendLastName = data.friendLastName;
            this.user = data.user;
        }
    }

}
