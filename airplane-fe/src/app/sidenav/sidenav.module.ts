import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SidenavComponent} from './sidenav.component';
import {AppRoutingModule} from "../app-routing.module";
import {MatSidenavModule} from "@angular/material";

@NgModule({
    imports: [
        CommonModule,
        MatSidenavModule,
        AppRoutingModule
    ],
    declarations: [
        SidenavComponent
    ],
    exports: [
        SidenavComponent
    ]
})
export class SidenavModule {
}
