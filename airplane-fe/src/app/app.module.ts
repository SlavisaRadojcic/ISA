import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {PagesModule} from "./pages/pages.module";
import {SidenavModule} from "./sidenav/sidenav.module";
import {ToolbarModule} from "./toolbar/toolbar.module";
import {ConfigModule} from "./config/config.module";
import {HTTP_INTERCEPTORS} from "@angular/common/http";
import {HttpRequestTokenInterceptorService} from "./config/http-request-token-interceptor.service";

@NgModule({
    declarations: [
        AppComponent
    ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        ToolbarModule,
        SidenavModule,
        ConfigModule,
        PagesModule
    ],
    providers: [
        {
            provide: HTTP_INTERCEPTORS,
            useClass: HttpRequestTokenInterceptorService,
            multi: true
        }
    ],
    bootstrap: [
        AppComponent
    ]
})
export class AppModule {
}
