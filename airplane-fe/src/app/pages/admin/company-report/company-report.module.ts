import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CompanyReportComponent} from './company-report.component';
import {
    MAT_DATE_LOCALE,
    MatButtonModule, MatCheckboxModule,
    MatDatepickerModule,
    MatDialogModule,
    MatExpansionModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatTableModule,
    MatDividerModule
} from "@angular/material";
import {FormsModule} from "@angular/forms";
import {LayoutModule} from "@angular/cdk/layout";
import {CompanyReportService} from "./company-report.service";
import {HttpClientModule} from "@angular/common/http";
import {NgxMaterialTimepickerModule} from "ngx-material-timepicker";
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
        MatDividerModule,
        NgxMaterialTimepickerModule.forRoot()
    ],
    providers: [
        CompanyReportService,
        AuthService,
        {
            provide: MAT_DATE_LOCALE,
            useValue: 'rs'
        }
    ],
    declarations: [
        CompanyReportComponent
    ],
    exports: [
        CompanyReportComponent
    ]
})
export class CompanyReportModule {
}
