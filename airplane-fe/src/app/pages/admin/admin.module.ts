import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CompanyProfileModule} from "./company-profile/company-profile.module";
import {CompanyReportModule} from "./company-report/company-report.module";

@NgModule({
    imports: [
        CommonModule,
        CompanyProfileModule,
        CompanyReportModule
    ],
    declarations: []
})
export class AdminModule {
}
