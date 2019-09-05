import {Component, OnInit} from '@angular/core';
import {FriendsService} from "./friends.service";
import {FriendsDTO} from "./friends.dto";
import {UserProfileDTO} from "./../user-profile/user-profile.dto";
import {Router} from "@angular/router";

@Component({
    selector: 'app-friends',
    templateUrl: './friends.component.html',
    styleUrls: ['./friends.component.scss']
})
export class FriendsComponent implements OnInit {

    datasource: UserProfileDTO[] = [];
    datasourceFriends: UserProfileDTO[] = [];

    constructor(private router: Router,
        private friendsService: FriendsService) {
    }

    ngOnInit() {
        let user = JSON.parse(localStorage.getItem('user'));
        this.friendsService.getFriendList(user.email).subscribe((data: any[]) => {
            if (data.length > 0) {
                this.datasourceFriends = data;
                this.datasource = [];
            }
        });
    }

    addFriend(friend: UserProfileDTO) {
        let user = JSON.parse(localStorage.getItem('user'));
        this.friendsService.addFriend(friend, user.email).subscribe((data: any[]) => { });
    }

    getAllNonFriends() {
        let user = JSON.parse(localStorage.getItem('user'));
        this.friendsService.getNoneFriendList(user.email).subscribe((data: any[]) => {
            if (data.length > 0) {
                this.datasourceFriends = [];
                this.datasource = data;
            }
        });
    }

    removeFriend(friend: UserProfileDTO) {
        let user = JSON.parse(localStorage.getItem('user'));
        this.friendsService.removeFriend(friend, user.email).subscribe((data: any[]) => { });
    }

}
