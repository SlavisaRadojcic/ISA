import {Component, OnInit} from '@angular/core';
import {UserProfileService} from "./../user-profile.service";
import {UserProfileDTO} from "./../user-profile.dto";
import {Router} from "@angular/router";

@Component({
    selector: 'app-change-password',
    templateUrl: './change-password.component.html',
    styleUrls: ['./change-password.component.scss']
})
export class ChangePasswordComponent implements OnInit {

    userProfileDTO: UserProfileDTO;
    changePassword = {
        oldPassword: '',
        newPassword: ''
    };

    constructor(private router: Router,
        private userProfileService: UserProfileService) {
    }

    updateProfile(): void {
        if(this.changePassword.newPassword !== "" && this.changePassword.oldPassword === this.changePassword.newPassword)
        {
            this.userProfileDTO.password = this.changePassword.newPassword;
            this.userProfileService.updateUser(this.userProfileDTO).subscribe(data => {
                this.router.navigate(['company-dashboard', 'company-profile']);
            });
        }
    }

    ngOnInit() {
        let user = JSON.parse(localStorage.getItem('user'));
        this.userProfileService.getProfileByEmail(user.email).subscribe((user: UserProfileDTO) => this.userProfileDTO = new UserProfileDTO(user));
    }

}
