import {Component, Injectable} from '@angular/core';
import {HttpRequest, HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-root',
  template: `
    <!--The content below is only a placeholder and can be replaced.-->
    <div style="text-align:center">
      <h1>
        Welcome to Pension calculator!
      </h1>
      <img width="300" src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAyNTAgMjUwIj4KICAgIDxwYXRoIGZpbGw9IiNERDAwMzEiIGQ9Ik0xMjUgMzBMMzEuOSA2My4ybDE0LjIgMTIzLjFMMTI1IDIzMGw3OC45LTQzLjcgMTQuMi0xMjMuMXoiIC8+CiAgICA8cGF0aCBmaWxsPSIjQzMwMDJGIiBkPSJNMTI1IDMwdjIyLjItLjFWMjMwbDc4LjktNDMuNyAxNC4yLTEyMy4xTDEyNSAzMHoiIC8+CiAgICA8cGF0aCAgZmlsbD0iI0ZGRkZGRiIgZD0iTTEyNSA1Mi4xTDY2LjggMTgyLjZoMjEuN2wxMS43LTI5LjJoNDkuNGwxMS43IDI5LjJIMTgzTDEyNSA1Mi4xem0xNyA4My4zaC0zNGwxNy00MC45IDE3IDQwLjl6IiAvPgogIDwvc3ZnPg==">
    </div>
    <h2>Calculate your monthly pension using the formular below: </h2>
        <b>Insert Monthly Payment</b>
        <div class="column">
          <input id="insertMonthlyPayment" type="number" ng-pattern="/^[0-9]+(\\.[0-9]{1,2})?$/"
                 placeholder="Decimal" ng-model="myDecimal" step="0.01" #insertMonthlyPayment/>
        </div>
        <b>Insert Yearly Interest As Decimal</b>
        <div class="column">
          <input id="insertYearlyInterestAsDecimal" type="number" ng-pattern="/^[0-9]+(\\.[0-9]{1,2})?$/"
                 placeholder="Decimal" ng-model="myDecimal" step="0.000001" #insertYearlyInterestAsDecimal/>
        </div>
        <b>Insert Years to pension (Rounded to nearest whole number)</b>
        <div class="column">
          <input id="insertYearstopension"
                 type="number" ng-pattern="/^[0-9]+(\\.[0-9]{1,2})?$/"
                 placeholder="Decimal" ng-model="myDecimal" step="1" #insertYearstopension/>
        </div>
        <b>Insert Years of pension payout (Rounded to nearest whole number)</b>
        <div class="column">
          <input id="insertYearsofpensionpayout"
                 type="number" ng-pattern="/^[0-9]+(\\.[0-9]{1,2})?$/"
                 placeholder="Decimal" ng-model="myDecimal" step="1" #insertYearsofpensionpayout/>
        </div>
        <input type="button" value="Caclulate Pension" (click) ="getPension(insertMonthlyPayment.value,
  insertYearlyInterestAsDecimal.value, insertYearstopension.value, 
  insertYearsofpensionpayout.value)">
    <b>{{ monthlyPension }}</b>
    <router-outlet></router-outlet>
  `,
  styleUrls: ['./app.component.css']
})

@Injectable()
export class AppComponent {
  title = 'web';
  monthlyPension = '';
  constructor(private http: HttpClient) { }
  getPension(monthlyPayment,
  interestRate,
  yearsToPaymentStop,
  yearsToPayoutStop) {
    let url: string = window.location.origin + "/monthlyPayout?monthlyPayment=" + monthlyPayment
      + "&interestRate=" + interestRate + "&yearsToPaymentStop=" + yearsToPaymentStop + "&yearsToPayoutStop="
      + yearsToPayoutStop;
    this.http.get(url, {responseType: 'text'}).subscribe(result => {this.monthlyPension = result})
  }
  getPensionTest() {

    let url: string = window.location.origin + "/monthlyPayout?monthlyPayment=2.2"
      + "&interestRate=1.1" + "&yearsToPaymentStop=2" + "&yearsToPayoutStop=2";
    this.http.get(url, {responseType: 'text'}).subscribe(result => {this.monthlyPension = result})
  }
}
