// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  localhost: 'http://localhost:8081',
  requestManagerUrl: 'http://localhost:8080/advert-request',
  advertManagerUrl: 'http://localhost:9090/advert-manager',
  searchManagerUrl: 'http://localhost:9090/search-manager/',
  chatManagerUrl: 'http://localhost:8080/chat-server'
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
