import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {AuthService} from "../config/auth.service";
import {Router} from "@angular/router";

@Component({
    selector: 'app-toolbar',
    templateUrl: './toolbar.component.html',
    styleUrls: ['./toolbar.component.scss']
})
export class ToolbarComponent implements OnInit {

    @Output()
    sidenavClick = new EventEmitter();
    userLoggedIn: boolean = false;

    constructor(private authService: AuthService,
                private router: Router) {
    }

    ngOnInit() {
        if (this.authService.getToken()) {
            this.userLoggedIn = true;
        }
    }

    sidenavToggle(): void {
        this.sidenavClick.emit();
    }

    logout() {
        this.authService.removeTokenFromLocalStorage();
        this.authService.removeUserFromLocalStorage();
        this.userLoggedIn = false;

        this.router.navigate(['login']);
    }

}
