import {HttpParams} from '@angular/common/http';

let params = new HttpParams().set("monthlyPayment", "1").set("interestRate", "2")
  .set("yearsToPaymentStop", "3").set("yearsToPayoutStop", "4");
let url: string = window.location.origin + "/monthlyPayout";
this.http.get(url, {params: params});
