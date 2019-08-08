import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {LoginService} from "./login.service";
import {AuthService} from "../../config/auth.service";
import {UserProfileDTO} from "../user/user-profile/user-profile.dto";
import {ResponseDto} from "./response.dto";
import {UserRole} from "../user/user-profile/user-role";

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

    email: string;
    password: string;

    constructor(private router: Router,
                private loginService: LoginService,
                private authService: AuthService) {
    }

    ngOnInit() {
    }

    login() {
        this.loginService.login(this.email, this.password).subscribe((response: ResponseDto) => {
            if (response.accessToken) {
                this.authService.setToken(response.accessToken);

                const user: UserProfileDTO = new UserProfileDTO();
                user.firstName = response.firstName;
                user.lastName = response.lastName;
                user.email = response.email;
                user.phone = response.phoneNumber;
                user.role = response.role;

                this.authService.setLoggedInUser(user);

                if (user.role.toString() === 'ROLE_ADMIN') {
                    if(!response.firstTimeLogin) {
                        // this.router.navigate(['change-password']);
                    } else {
                        this.router.navigate(['company-dashboard', 'company-profile']);
                    }
                    this.router.navigate(['company-dashboard', 'company-profile']);
                } else {
                    this.router.navigate(['dashboard']);
                }
            }
        });
    }

    register() {
        this.router.navigate(['/register']);
    }

}
