import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {UserProfileComponent} from './user-profile.component';
import {MatButtonModule, MatFormFieldModule, MatInputModule} from "@angular/material";
import {FormsModule} from "@angular/forms";
import {LayoutModule} from "@angular/cdk/layout";
import {UserProfileService} from "./user-profile.service";
import {HttpClientModule} from "@angular/common/http";
import {ChangePasswordComponent} from './change-password/change-password.component';

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
        UserProfileComponent,
        ChangePasswordComponent
    ],
    providers: [
        UserProfileService
    ],
    exports: [
        UserProfileComponent,
        ChangePasswordComponent
    ]
})
export class UserProfileModule {
}
