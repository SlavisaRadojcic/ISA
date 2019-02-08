export class FlightDetailsPassengerDTO {

    firstName: string;
    lastName: string;
    birthday: Date;
    contact: string;
    gender: number;
    passport: string;

    constructor(data?: any) {
        if (data) {
            this.firstName = data.firstName;
            this.lastName = data.lastName;
            this.birthday = data.birthday;
            this.contact = data.contact;
            this.gender = data.gender;
            this.passport = data.passport;
        }
    }

}
