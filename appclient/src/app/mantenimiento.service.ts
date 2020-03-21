import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MantenimientoService {

  private baseUrl = 'http://localhost:9090/mante/api/mantenimiento';

  constructor(private http: HttpClient) { }

  getMantenimiento(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createMantenimiento(mantenimiento: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, mantenimiento);
  }

  updateMantenimiento(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteMantenimiento(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getMantenimientosList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
