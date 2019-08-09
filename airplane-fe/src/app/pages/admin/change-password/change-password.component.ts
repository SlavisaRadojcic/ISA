import {Component, OnInit} from '@angular/core';
import {ChangePasswordService} from "./change-password.service";
import {ChangePasswordDTO} from "./change-password.dto";
import {Router} from "@angular/router";
import {UserProfileDTO} from "./../../user/user-profile/user-profile.dto";
import {UserProfileService} from "./../../user/user-profile/user-profile.service";

@Component({
    selector: 'app-change-password',
    templateUrl: './change-password.component.html',
    styleUrls: ['./change-password.component.scss']
})
export class ChangePasswordComponent implements OnInit {

    changePasswordDTO: ChangePasswordDTO;
    userProfileDTO: UserProfileDTO;
    changePassword = {
        oldPassword: '',
        newPassword: ''
    };

    constructor(private router: Router,
                private changePasswordService: ChangePasswordService,
                private userProfileService: UserProfileService) {
    }

    updateProfile(): void {
        if(this.changePassword.newPassword !== "" && this.changePassword.oldPassword === this.changePassword.newPassword)
        {
            this.userProfileDTO.password = this.changePassword.newPassword;
            this.changePasswordService.updateUser(this.userProfileDTO).subscribe(data => {
                this.router.navigate(['company-dashboard', 'company-profile']);
            });
        }
    }

    ngOnInit() {
        let user = JSON.parse(localStorage.getItem('user'));
        this.userProfileService.getProfileByEmail(user.email).subscribe((user: UserProfileDTO) => this.userProfileDTO = new UserProfileDTO(user));
    }

}
