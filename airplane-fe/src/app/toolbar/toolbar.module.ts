import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ToolbarComponent} from './toolbar.component';
import {MatButtonModule, MatIconModule, MatToolbarModule} from "@angular/material";
import {AuthService} from "../config/auth.service";

@NgModule({
    imports: [
        CommonModule,
        MatToolbarModule,
        MatButtonModule,
        MatIconModule
    ],
    declarations: [
        ToolbarComponent
    ],
    exports: [
        ToolbarComponent
    ],
    providers: [
        AuthService
    ]
})
export class ToolbarModule {
}
