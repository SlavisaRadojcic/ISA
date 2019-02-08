import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {UserProfileDTO} from "./user-profile.dto";

@Injectable({
    providedIn: 'root'
})
export class UserProfileService {

    url: string = 'http://localhost:8090/api/users';

    constructor(private httpClient: HttpClient) {}

    getProfile(id: number): Observable<any> {
        return this.httpClient.get(this.url + '/' + id).pipe(map((result: any) => new UserProfileDTO(result)));
    }

    updateUser(dto: UserProfileDTO): Observable<any> {
        return this.httpClient.put(this.url, dto);
    }
}
