import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
    providedIn: 'root'
})
export class RegisterService {

    registerUrl: string = 'http://localhost:8080/api/auth/signup';

    constructor(private httpClient: HttpClient) {
    }

    register(firstName: string, lastName: string, email: string, password: string, city: string, phone: string): Observable<any> {
        return this.httpClient.post(this.registerUrl, {
            firstName: firstName,
            lastName: lastName,
            email: email,
            password: password,
            city: city,
            phoneNumber: phone
        });
    }
}
