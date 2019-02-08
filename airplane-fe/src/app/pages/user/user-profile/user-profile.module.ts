import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {UserProfileComponent} from './user-profile.component';
import {MatButtonModule, MatFormFieldModule, MatInputModule} from "@angular/material";
import {FormsModule} from "@angular/forms";
import {LayoutModule} from "@angular/cdk/layout";
import {UserProfileService} from "./user-profile.service";
import {HttpClientModule} from "@angular/common/http";

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
        UserProfileComponent
    ],
    providers: [
        UserProfileService
    ],
    exports: [
        UserProfileComponent
    ]
})
export class UserProfileModule {
}
