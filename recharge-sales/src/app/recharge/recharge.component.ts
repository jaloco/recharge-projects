import { Component, OnInit } from '@angular/core';
import { RechargeService } from '../services/recharge.service';
import { SaleService } from '../services/sale.service';

import { Recharge, Operador } from '../models/recharge.model';
import { Sale } from '../models/sale.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';



@Component({
  selector: 'app-recharge',
  templateUrl: './recharge.component.html',
  styleUrls: ['./recharge.component.scss']
})
export class RechargeComponent implements OnInit {
  recargas: Recharge[] = [];
  vendedor: string = '';

  rechargeForm: FormGroup
  recarga: any = { id: 0, operador: Operador.COMCEL, valor: 0, numero:0, cantidad: 0, vendedor:"" };

  operadores = Operador; 
  constructor(
    private fb: FormBuilder,
    private rechargeService: RechargeService,
    private saleService: SaleService,
  ) {
    this.rechargeForm = this.fb.group({
      vendedor: ['', Validators.required],
      operador: ['', Validators.required],
      numero: ['', Validators.required],
      valor: [0, [Validators.required, Validators.min(1)]],
      cantidad: [0, [Validators.required, Validators.min(1)]]
    });
  }
  //constructor(private rechargeService: RechargeService, private saleService: SaleService) {}

  ngOnInit(): void {
    this.loadRecharges();
  }

  /**
   * Metodo para listar recargas o actualizar tabla
   */
  loadRecharges(): void {
    this.rechargeService.getRecharges().subscribe(recharges => {
      this.recargas = [];
      recharges.forEach(recharge => {
        this.saleService.getSaleId(recharge.id).subscribe(sale => {
          this.recargas.push({ ...recharge, vendedor: sale.vendedor });
        });
      });
    });
  }

  onSubmit(): void {
    this.recarga.id = null;
    this.rechargeService.createRecharge(this.recarga).subscribe(responseRecharge => {
      const resRecharge : Recharge = responseRecharge;
      const newSale: Sale = {
        id: null, 
        vendedor: this.vendedor,
        recarga: {"id":resRecharge.id}
      };
      this.saleService.createSale(newSale).subscribe(response => {
        alert('Venta realizada con éxito');
        this.loadRecharges();
      }, error => {
        alert('Error al realizar la venta');
      });
    }, error => {
      alert('Error al realizar la venta');
    });
    
  }
}
