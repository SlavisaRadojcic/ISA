import {Component, OnInit} from '@angular/core';
import {UserProfileDTO} from "../user/user-profile/user-profile.dto";
import {Router} from "@angular/router";
import {LoginService} from "../login/login.service";
import {RegisterService} from "./register.service";

@Component({
    selector: 'app-register',
    templateUrl: './register.component.html',
    styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

    userProfileDTO: UserProfileDTO = new UserProfileDTO();
    originalPasswordInputType: string = 'password';
    repeatPasswordInputType: string = 'password';
    passwords = {
        original: '',
        repeat: ''
    };
    originalPasswordVisible: boolean = false;
    repeatPasswordVisible: boolean = false;

    constructor(private router: Router,
                private registerService: RegisterService) {
    }

    ngOnInit() {
    }

    seeOriginalPassword() {
        if (this.originalPasswordVisible) {
            this.originalPasswordInputType = 'password';
        } else {
            this.originalPasswordInputType = 'text';
        }
        this.originalPasswordVisible = !this.originalPasswordVisible;
    }

    seeRepeatPassword() {
        if (this.repeatPasswordVisible) {
            this.repeatPasswordInputType = 'password';
        } else {
            this.repeatPasswordInputType = 'text';
        }
        this.repeatPasswordVisible = !this.repeatPasswordVisible;
    }

    register() {
        this.userProfileDTO.password = this.passwords.original;
        this.registerService.register(
            this.userProfileDTO.firstName,
            this.userProfileDTO.lastName,
            this.userProfileDTO.email,
            this.userProfileDTO.password,
            this.userProfileDTO.city,
            this.userProfileDTO.phone).subscribe(data => {
                this.router.navigate(['/login']);
            });
    }

}
