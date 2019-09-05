import {Component, OnInit} from '@angular/core';
import {UserProfileService} from "./user-profile.service";
import {UserProfileDTO} from "./user-profile.dto";
import {Router} from "@angular/router";
import { UserRole } from './user-role';

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
    userRole: UserRole;

    constructor(private router: Router,
        private userProfileService: UserProfileService) {
    }

    updateProfile(): void {
        if(this.changePassword.newPassword !== "" && this.changePassword.oldPassword === this.changePassword.newPassword)
        {
            this.userProfileDTO.password = this.changePassword.newPassword;
            this.userProfileService.updateUser(this.userProfileDTO).subscribe(data => {
                let user = JSON.parse(localStorage.getItem('user'));
                if(user.role == 'ROLE_ADMIN') {
                    this.router.navigate(['company-dashboard', 'company-profile']);
                } else {
                    this.router.navigate(['dashboard', 'flights']);
                }
            });
        }
    }

    ngOnInit() {
        let user = JSON.parse(localStorage.getItem('user'));
        this.userProfileService.getProfileByEmail(user.email).subscribe((user: UserProfileDTO) => this.userProfileDTO = new UserProfileDTO(user));
    }


    friendList() {
        this.router.navigate(['dashboard', 'friends']);
    }
}
