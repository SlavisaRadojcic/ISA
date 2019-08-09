import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {UserProfileComponent} from "./pages/user/user-profile/user-profile.component";
import {CompanyProfileComponent} from "./pages/admin/company-profile/company-profile.component";
import {CompanyReportComponent} from "./pages/admin/company-report/company-report.component";
import {LoginComponent} from "./pages/login/login.component";
import {RegisterComponent} from "./pages/register/register.component";
import {DashboardComponent} from "./pages/user/dashboard/dashboard.component";
import {FlightSearchComponent} from "./pages/user/dashboard/flights/flight-search/flight-search.component";
import {HotelSearchComponent} from "./pages/user/dashboard/hotels/hotel-search/hotel-search.component";
import {CarSearchComponent} from "./pages/user/dashboard/cars/car-search/car-search.component";
import {SeatsComponent} from "./pages/user/dashboard/flights/seats/seats.component";
import {CompanyDashboardComponent} from "./pages/admin/company-dashboard/company-dashboard.component";
import {ChangePasswordComponent} from "./pages/admin/change-password/change-password.component";

const routes: Routes = [
    {
        path: '',
        redirectTo: '/login',
        pathMatch: 'full'
    },
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: 'register',
        component: RegisterComponent
    },
    {
        path: 'change-password',
        component: ChangePasswordComponent
    },
    {
        path: 'dashboard',
        component: DashboardComponent,
        children: [
            {
                path: '',
                redirectTo: 'flights',
                pathMatch: 'full'
            },
            {
                path: 'flights',
                component: FlightSearchComponent,
            },
            {
                path: 'flights/:id/seats',
                component: SeatsComponent
            },
            {
                path: 'hotels',
                component: HotelSearchComponent
            },
            {
                path: 'cars',
                component: CarSearchComponent
            },
            {
                path: 'user-profile',
                component: UserProfileComponent
            }
        ]
    },
    {
        path: 'company-dashboard',
        component: CompanyDashboardComponent,
        children: [
            {
                path: '',
                redirectTo: 'company-profile',
                pathMatch: 'full'
            },
            {
                path: 'company-profile',
                component: CompanyProfileComponent
            },
            {
                path: 'reports',
                component: CompanyReportComponent
            },
            {
                path: 'user-profile',
                component: UserProfileComponent
            }

        ]
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes, { enableTracing: false })],
    exports: [RouterModule]
})
export class AppRoutingModule { }
