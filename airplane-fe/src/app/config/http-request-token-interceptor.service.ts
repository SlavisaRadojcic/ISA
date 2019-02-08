import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {AuthService} from "./auth.service";

@Injectable({
    providedIn: 'root'
})
export class HttpRequestTokenInterceptorService implements HttpInterceptor {

    constructor(private authService: AuthService) {
    }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const token = this.authService.getToken();
        let request: HttpRequest<any> = req;

        if (token) {
            request = request.clone({
                setHeaders: {
                    'Authorization': `Bearer ${token}`
                }
            });
        }

        return next.handle(request);
    }
}
