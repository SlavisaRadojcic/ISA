import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FriendsComponent} from './friends.component';
import {MatButtonModule, MatFormFieldModule, MatInputModule, MatIconModule, MatDividerModule} from "@angular/material";
import {FormsModule} from "@angular/forms";
import {LayoutModule} from "@angular/cdk/layout";
import {FriendsService} from "./friends.service";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
    imports: [
        CommonModule,
        MatFormFieldModule,
        FormsModule,
        MatButtonModule,
        MatIconModule,
        MatInputModule,
        MatDividerModule,
        LayoutModule,
        HttpClientModule
    ],
    declarations: [
        FriendsComponent
    ],
    providers: [
        FriendsService
    ],
    exports: [
        FriendsComponent
    ]
})
export class FriendsModule {
}
