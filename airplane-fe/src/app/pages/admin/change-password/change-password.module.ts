import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ChangePasswordComponent} from './change-password.component';
import {MatButtonModule, MatFormFieldModule, MatInputModule} from "@angular/material";
import {FormsModule} from "@angular/forms";
import {LayoutModule} from "@angular/cdk/layout";
import {ChangePasswordService} from "./change-password.service";
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
        ChangePasswordComponent
    ],
    providers: [
        ChangePasswordService
    ],
    exports: [
        ChangePasswordComponent
    ]
})
export class ChangePasswordModule {
}
