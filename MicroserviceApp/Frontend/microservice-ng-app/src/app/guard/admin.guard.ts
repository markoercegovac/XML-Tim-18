import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Injectable({providedIn: 'root'})
export class AdminGuard implements CanActivate{

    constructor(private authService: AuthService, private router: Router) {}

    canActivate(route: ActivatedRouteSnapshot, router: RouterStateSnapshot): boolean | UrlTree {
		let auths: string[] = this.authService.getPermissions();
        if(auths.includes('PERMISSION_ADMIN')) {
            return true;
        } else {
            return this.router.createUrlTree(['/home']);
        }

    }

}