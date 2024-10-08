import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Sale } from '../models/sale.model';

@Injectable({
  providedIn: 'root'
})
export class SaleService {
  private baseUrl = 'http://localhost:8000/api/ventas'; 

  constructor(private http: HttpClient) {}

  /* 
   Método para crear una nueva venta
   @param sale datos de la venta
   @return venta creada
 */
  createSale(sale: any): Observable<any> {
    return this.http.post<any>(this.baseUrl, sale);
  }
  /* 
   Método para obtener na venta por id
   @param id de la venta
   @return venta 
 */
  getSaleId(id:any): Observable<Sale> {
    return this.http.get<Sale>(this.baseUrl+"/"+id);
  }
}
