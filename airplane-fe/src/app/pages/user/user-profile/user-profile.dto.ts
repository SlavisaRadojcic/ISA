import {UserRole} from "./user-role";

export class UserProfileDTO {

    id: number;
    email: string;
    password: string;
    newPassword: string;
    firstName: string;
    lastName: string;
    city: string;
    phone: string;
    friends: string[];
    role: UserRole;

    constructor(data?: any) {
        if (data) {
            this.id = data.id;
            this.email = data.email;
            this.password = data.password;
            this.newPassword = data.newPassword;
            this.firstName = data.firstName;
            this.lastName = data.lastName;
            this.city = data.city;
            this.phone = data.phone;
            this.friends = data.friends;
            this.role = data.role;
        }
    }

}
