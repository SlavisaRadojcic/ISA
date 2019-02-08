import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class LoginService {

    loginUrl: string = 'http://localhost:8090/api/auth/signin';

    constructor(private httpClient: HttpClient) {
    }

    login(email: string, password: string): Observable<any> {
        return this.httpClient.post(this.loginUrl, {
            usernameOrEmail: email,
            password: password
        });
    }
}
