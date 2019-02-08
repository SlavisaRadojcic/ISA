import {Injectable} from '@angular/core';
import {UserProfileDTO} from "../pages/user/user-profile/user-profile.dto";

@Injectable({
    providedIn: 'root'
})
export class AuthService {

    getToken(): string {
        return localStorage.getItem('token');
    }

    setToken(token: string): void {
        localStorage.setItem('token', token);
    }

    removeTokenFromLocalStorage(): void {
        localStorage.removeItem('token');
    }

    getLoggedInUser(): UserProfileDTO | null {
        const localStorageUser = localStorage.getItem('user');
        if (localStorageUser) {
            return new UserProfileDTO(JSON.parse(localStorageUser));
        }

        return null;
    }

    setLoggedInUser(user: UserProfileDTO): void {
        localStorage.setItem('user', JSON.stringify(user));
    }

    removeUserFromLocalStorage(): void {
        localStorage.removeItem('user');
    }
}
