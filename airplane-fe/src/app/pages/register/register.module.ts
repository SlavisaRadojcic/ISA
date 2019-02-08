import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RegisterComponent} from './register.component';
import {MatButtonModule, MatFormFieldModule, MatIconModule, MatInputModule, MatRadioModule} from "@angular/material";
import {FormsModule} from "@angular/forms";
import {LayoutModule} from "@angular/cdk/layout";
import {RegisterService} from "./register.service";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
    imports: [
        CommonModule,
        MatFormFieldModule,
        FormsModule,
        MatButtonModule,
        MatInputModule,
        MatIconModule,
        LayoutModule,
        MatRadioModule,
        HttpClientModule
    ],
    declarations: [
        RegisterComponent
    ],
    exports: [
        RegisterComponent
    ],
    providers: [
        RegisterService
    ]
})
export class RegisterModule {
}
