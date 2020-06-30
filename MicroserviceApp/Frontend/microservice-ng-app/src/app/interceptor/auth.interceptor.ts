import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({providedIn: 'root'})
export class AuthInterceptor implements HttpInterceptor {

    intercept(req: HttpRequest<any>,
              next: HttpHandler): Observable<HttpEvent<any>> {


      const token = localStorage.getItem("token");

      if (token) {
        const cloned = req.clone({
          headers: req.headers.set("Authorization", token)
        });

        console.log('AUTORIZATION JWT');

        return next.handle(cloned);
      } else {
        console.log('AUTORIZATION NO JWT');
        return next.handle(req);
      }

    }

}

