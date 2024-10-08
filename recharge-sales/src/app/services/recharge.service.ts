import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RechargeService {
  private baseUrl = 'http://localhost:8000/api/recargas'; 

  constructor(private http: HttpClient) {}

  /* 
    Método para obtener todas las recargas
    @return lista de recargas
  */
  getRecharges(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl);
  }

  /* 
   Método para crear una nueva recargas
   @param recharge datos de la recarga
   @return recarga creada
 */
  createRecharge(recharge: any): Observable<any> {
    return this.http.post<any>(this.baseUrl, recharge);
  }
}