import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {UserProfileModule} from "./user-profile/user-profile.module";
import {FriendsModule} from "./friends/friends.module";

@NgModule({
    imports: [
        CommonModule,
        UserProfileModule,
        FriendsModule
    ],
    declarations: []
})
export class UserModule {
}
