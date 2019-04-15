
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Thesis } from '../model/thesis';
 
@Injectable()
export class ThesisService {
 
  private allThesesUrl: string;
  private addThesisUrl: string;
 
  constructor(private http: HttpClient) {
    this.allThesesUrl = 'http://localhost:8080/thesis-api/theses';
    this.addThesisUrl = 'http://localhost:8080/thesis-api/add';
  }
 
  public findAll(): Observable<Thesis[]> {
    return this.http.get<Thesis[]>(this.allThesesUrl);
  }
 
  public save(thesis: Thesis) {
    return this.http.post<Thesis>(this.addThesisUrl, thesis);
  }
}