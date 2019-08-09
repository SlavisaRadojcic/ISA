import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {ChangePasswordDTO} from "./change-password.dto";

@Injectable({
    providedIn: 'root'
})
export class ChangePasswordService {

    url: string = 'http://localhost:8080/api/users';

    constructor(private httpClient: HttpClient) {}

    getProfile(id: number): Observable<any> {
        return this.httpClient.get(this.url + '/' + id).pipe(map((result: any) => new ChangePasswordDTO(result)));
    }

    getProfileByEmail(email: String): Observable<any> {
        return this.httpClient.get(this.url + '/get/' + email).pipe(map((result: any) => new ChangePasswordDTO(result)));
    }

    updateUser(dto: ChangePasswordDTO): Observable<any> {
        return this.httpClient.post(this.url + "/" + dto.id, dto);
    }
}
