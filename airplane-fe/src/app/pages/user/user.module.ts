import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {UserProfileModule} from "./user-profile/user-profile.module";

@NgModule({
    imports: [
        CommonModule,
        UserProfileModule
    ],
    declarations: []
})
export class UserModule {
}
