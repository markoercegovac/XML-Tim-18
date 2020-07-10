// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  advert: 'http://localhost:9090/api/advert',
  price: 'http://localhost:9090/api/price',
  car: 'http://localhost:9090/api/car',
  grade: 'http://localhost:9090/grades',
  comm: 'http://localhost:9090/comment/',
  report: 'http://localhost:9090/crud',
  searchUrl: 'http://localhost:9090/',
  message: 'http://localhost:9090/api/message',
  registration: 'http://localhost:9090/admin',
  statistics: 'http://localhost:9090/',
  client: 'http://localhost:9090/api/client',
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
