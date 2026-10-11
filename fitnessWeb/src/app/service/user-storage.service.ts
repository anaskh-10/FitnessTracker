import { isPlatformBrowser } from '@angular/common';
import { Inject, Injectable, PLATFORM_ID } from '@angular/core';
const USER='user';
@Injectable({
  providedIn: 'root'
})
export class UserStorageService {
  isUserLoggedIn() {
    throw new Error('Method not implemented.');
  }
  private isBrowser: boolean;
  constructor(@Inject(PLATFORM_ID) private platformId: Object) {
    this.isBrowser = isPlatformBrowser(platformId); 
   }
  static saveUser(user:any):void{
    if (typeof window !== 'undefined') {
      window.localStorage.removeItem(USER);
      window.localStorage.setItem(USER, JSON.stringify(user));
    }
  }
  static getUser(){
    if (typeof window !== 'undefined') {
      const user = localStorage.getItem(USER);
      return user ? JSON.parse(user) : null;
    }
    return null;
  }
  static getUserId():string{
    const user=this.getUser();
    return user ? user.id : '';
  }
  static isUserLoggedin():boolean{
    if (typeof window !== 'undefined') {
      const user = this.getUser();
      return !!user;
    }
    return false;
  }

  static signout():void{
    if (typeof window !== 'undefined') {
      window.localStorage.removeItem(USER);
    }
  }
}
