import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  login(body: any){
    console.log(body);
    this.http.post(`http://localhost:8081/login`, body, {observe: 'response'}).subscribe((res)=>{console.log(res.status)},
    (error)=>{console.error(`There was an error ${error}`)});
  }
}
