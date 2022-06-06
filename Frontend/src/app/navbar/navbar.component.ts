import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/user';
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  user = new User();
  msg =''
  invalidLogin = false;
  formValue!:FormGroup;
  loginForm!:FormGroup;
  public totalItem : number = 0;
  public searchTerm !: string;
  loginusers = new User();
  constructor(private userservice : UserService, private router:Router ,private fb:FormBuilder) { }
  ngOnInit(): void {

    this.loginForm=this.fb.group(
      {
        useremail:[""],
        password:[""],
      }
    )

  }


  login(){
    this.userservice.getUser(this.loginForm.value.useremail).subscribe(
      res=>{
        console.log('response'+res);
        this.user=res;
        if(this.user.password==this.loginForm.value.password){
          alert("Sign in successfully");
          this.router.navigate(['/admin']);
        }else{
          alert("Invalid Login Credentials");
          this.msg="Enter valid email and password";
        }
      } 
    )
  }
}
