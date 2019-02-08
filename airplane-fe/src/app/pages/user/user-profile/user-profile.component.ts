import {Component, OnInit} from '@angular/core';
import {UserProfileService} from "./user-profile.service";
import {UserProfileDTO} from "./user-profile.dto";

@Component({
    selector: 'app-user-profile',
    templateUrl: './user-profile.component.html',
    styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {

    userProfileDTO: UserProfileDTO;
    changePassword = {
        oldPassword: '',
        newPassword: ''
    };

    constructor(private userProfileService: UserProfileService) {
    }

    updateProfile(): void {

    }

    ngOnInit() {
        // izvuci iz tokena kada bude implementirano
        const username: string = localStorage.getItem('username');
        // this.userProfileService.getProfile(username).subscribe((user: UserProfileDTO) => this.userProfileDTO = new UserProfileDTO(user));
    }

}
