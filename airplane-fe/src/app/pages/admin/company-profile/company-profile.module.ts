import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CompanyProfileComponent} from './company-profile.component';
import {
    MAT_DATE_LOCALE,
    MatButtonModule, MatCheckboxModule,
    MatDatepickerModule,
    MatDialogModule,
    MatExpansionModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatTableModule
} from "@angular/material";
import {FormsModule} from "@angular/forms";
import {LayoutModule} from "@angular/cdk/layout";
import {CompanyProfileService} from "./company-profile.service";
import {HttpClientModule} from "@angular/common/http";
import {AddFlightComponent} from './add-flight/add-flight.component';
import {NgxMaterialTimepickerModule} from "ngx-material-timepicker";
import {AddDestinationComponent} from './add-destination/add-destination.component';
import {AddSeatComponent} from './add-seat/add-seat.component';
import {AuthService} from "../../../config/auth.service";

@NgModule({
    imports: [
        CommonModule,
        MatFormFieldModule,
        FormsModule,
        MatButtonModule,
        MatInputModule,
        LayoutModule,
        HttpClientModule,
        MatTableModule,
        MatIconModule,
        MatDialogModule,
        MatExpansionModule,
        MatDatepickerModule,
        MatCheckboxModule,
        NgxMaterialTimepickerModule.forRoot()
    ],
    providers: [
        CompanyProfileService,
        AuthService,
        {
            provide: MAT_DATE_LOCALE,
            useValue: 'rs'
        }
    ],
    entryComponents: [
        AddFlightComponent,
        AddDestinationComponent,
        AddSeatComponent
    ],
    declarations: [
        CompanyProfileComponent,
        AddFlightComponent,
        AddDestinationComponent,
        AddSeatComponent
    ],
    exports: [
        CompanyProfileComponent
    ]
})
export class CompanyProfileModule {
}
