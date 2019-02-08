import {UserRole} from "./user-role";

export class UserProfileDTO {

    email: string;
    username: string;
    password: string;
    newPassword: string;
    firstName: string;
    lastName: string;
    city: string;
    phone: string;
    birthday: Date;
    friends: string[];
    role: UserRole;

    constructor(data?: any) {
        if (data) {
            this.email = data.email;
            this.username = data.username;
            this.password = data.password;
            this.newPassword = data.newPassword;
            this.firstName = data.firstName;
            this.lastName = data.lastName;
            this.city = data.city;
            this.phone = data.phone;
            this.birthday = data.birthday;
            this.friends = data.friends;
            this.role = data.role;
        }
    }

}
