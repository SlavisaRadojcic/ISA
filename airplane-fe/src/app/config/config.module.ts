import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HttpRequestTokenInterceptorService,} from "./http-request-token-interceptor.service";
import {AuthService} from "./auth.service";

@NgModule({
    imports: [
        CommonModule
    ],
    declarations: [],
    providers: [
        AuthService,
        HttpRequestTokenInterceptorService
    ]
})
export class ConfigModule {
}
