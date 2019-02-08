import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SeatsComponent} from './seats.component';
import {HttpClientModule} from "@angular/common/http";
import {SeatsService} from "./seats.service";
import {
    MAT_DATE_LOCALE,
    MatButtonModule,
    MatDatepickerModule, MatIconModule,
    MatInputModule,
    MatRadioModule,
    MatStepperModule
} from "@angular/material";
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {LayoutModule} from "@angular/cdk/layout";
import {AuthService} from "../../../../../config/auth.service";

@NgModule({
    imports: [
        CommonModule,
        HttpClientModule,
        MatButtonModule,
        RouterModule,
        MatStepperModule,
        FormsModule,
        MatInputModule,
        LayoutModule,
        MatRadioModule,
        MatDatepickerModule,
        MatIconModule
    ],
    declarations: [
        SeatsComponent
    ],
    exports: [
        SeatsComponent
    ],
    providers: [
        SeatsService,
        AuthService,
        {
            provide: MAT_DATE_LOCALE,
            useValue: 'rs'
        }
    ]
})
export class SeatsModule {
}
