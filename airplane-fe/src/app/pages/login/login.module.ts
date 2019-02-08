import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {LoginComponent} from './login.component';
import {MatButtonModule, MatFormFieldModule, MatInputModule} from "@angular/material";
import {FormsModule} from "@angular/forms";
import {LayoutModule} from "@angular/cdk/layout";
import {LoginService} from "./login.service";
import {HttpClientModule} from "@angular/common/http";
import {AuthService} from "../../config/auth.service";

@NgModule({
    imports: [
        CommonModule,
        MatFormFieldModule,
        FormsModule,
        MatButtonModule,
        MatInputModule,
        LayoutModule,
        HttpClientModule
    ],
    declarations: [
        LoginComponent
    ],
    exports: [
        LoginComponent
    ],
    providers: [
        LoginService,
        AuthService
    ]
})
export class LoginModule {
}
