import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Injectable({providedIn: 'root'})
export class UserGuard implements CanActivate{

    constructor(private authService: AuthService) {}

    canActivate(route: ActivatedRouteSnapshot, router: RouterStateSnapshot): boolean {
		let auths: string[] = this.authService.getPermissions();
        if(auths.includes('PERMISSION_USER')) {
            return true;
        } else {
            return false;
        }

    }

}