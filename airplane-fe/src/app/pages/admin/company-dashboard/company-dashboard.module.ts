import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CompanyDashboardComponent} from './company-dashboard.component';
import {MatIconModule, MatTabsModule} from "@angular/material";
import {RouterModule} from "@angular/router";

@NgModule({
    imports: [
        CommonModule,
        MatTabsModule,
        MatIconModule,
        RouterModule
    ],
    declarations: [
        CompanyDashboardComponent
    ],
    exports: [
        CompanyDashboardComponent
    ]
})
export class CompanyDashboardModule {
}
