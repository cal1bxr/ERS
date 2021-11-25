import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm = this.fb.group({
    loginName: ['', Validators.required],
    loginPassword: ['']
  })
  constructor(private fb: FormBuilder, private loginService: LoginService) { }

  ngOnInit(): void {
  }

  onSubmit(loginName: string, loginPassword: string){
    console.warn(this.loginForm.value);
    let body = {
      userName: loginName,
      password: loginPassword
    }

    console.log(body);
    this.loginService.login(body)
  }
}
