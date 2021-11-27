import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { Reimb } from '../models/reimb';

@Injectable({
  providedIn: 'root'
})
export class ReimbsService {
  apiUrl = "Http://localhost:8081/";
  constructor(private http: HttpClient) { }

  getReimbursements(): Observable<Reimb>{
    return this.http.get<Reimb>(`${this.apiUrl}reimbs`).pipe(map(res=>res), catchError(err=>throwError(err)));
  }
}
