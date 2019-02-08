import {UserRole} from "../user/user-profile/user-role";

export class ResponseDto {
    accessToken: string;
    dateOfBirth: Date;
    email: string;
    firstName: string;
    lastName: string;
    phoneNumber: string;
    role: UserRole;

    constructor(data: any) {
        this.accessToken = data.accessToken;
        this.dateOfBirth = data.dateOfBirth;
        this.email = data.email;
        this.firstName = data.firstName;
        this.lastName = data.lastName;
        this.phoneNumber = data.phoneNumber;
        this.role = data.role;
    }
}
