import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {GoogleLoginProvider, SocialAuthService} from "angularx-social-login";
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Today deals';

  constructor(
    private router: Router,
    private authService: SocialAuthService
  ) {}

  ngOnInit(): void {
  }

  signInHandler():void{
    this.authService.signIn(GoogleLoginProvider.PROVIDER_ID).then((data)=>{
      localStorage.setItem('google_auth', JSON.stringify(data));
      this.router.navigateByUrl('/coupons').then();
    });
  }
}
