import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
    providedIn: 'root'
})
export class RegisterService {

    registerUrl: string = 'http://localhost:8090/api/auth/signup';

    constructor(private httpClient: HttpClient) {
    }

    register(name: string, username: string, email: string, password: string): Observable<any> {
        return this.httpClient.post(this.registerUrl, {
            name: name,
            username: username,
            email: email,
            password: password
        });
    }
}
