import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {UserProfileDTO} from "./../user-profile/user-profile.dto";

@Injectable({
    providedIn: 'root'
})
export class FriendsService {

    url: string = 'http://localhost:8080/api/users';

    constructor(private httpClient: HttpClient) {}

    getFriendList(email: string): Observable<any> {
        return this.httpClient.get(this.url + '/' + email + '/friends');
    }

    getNoneFriendList(email: string): Observable<any> {
        return this.httpClient.get(this.url + '/' + email + '/none-friends');
    }

    addFriend(friend: UserProfileDTO, email: string): Observable<any> {
        let friendId = friend.id;
        return this.httpClient.get(this.url + '/friends/' + email + '/' + friendId);
    }

    removeFriend(friend: UserProfileDTO, email: string): Observable<any> {
        let friendId = friend.id;
        return this.httpClient.get(this.url + '/remove-friends/' + email + '/' + friendId);
    }

    acceptFriend(friend: UserProfileDTO, email: string): Observable<any> {
        let friendId = friend.id;
        return this.httpClient.get(this.url + '/accept-friends/' + email + '/' + friendId);
    }
}
