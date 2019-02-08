import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {UserModule} from "./user/user.module";
import {AdminModule} from "./admin/admin.module";
import {LoginModule} from "./login/login.module";
import {RegisterModule} from "./register/register.module";
import {DashboardModule} from "./user/dashboard/dashboard.module";
import {CompanyDashboardModule} from "./admin/company-dashboard/company-dashboard.module";

@NgModule({
    imports: [
        CommonModule,
        UserModule,
        AdminModule,
        LoginModule,
        RegisterModule,
        DashboardModule,
        CompanyDashboardModule
    ],
    declarations: []
})
export class PagesModule {
}
