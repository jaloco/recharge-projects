/*
  Enumerador para tipo de operador
*/
export enum Operador {
    COMCEL = 'COMCEL',
    MOVISTAR = 'MOVISTAR',
    TIGO = 'TIGO',
    UFF = 'UFF'
  }
  
  /*
    Modelo que representa la clase recarga
  */
  export interface Recharge {
    id: any|null;
    operador: Operador;
    numero: number;
    valor: number;
    cantidad: number;
  }
  