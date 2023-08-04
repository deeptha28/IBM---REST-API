import { Component, OnInit } from '@angular/core';
import { Product } from './product';
@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent  implements OnInit {
  productList: Product[] = [
    new Product(1, "Laptop", 65000, true),
    new Product(2, "Mobile", 20000, true),
    new Product(3, "Camera", 95000, false),
    new Product(4, "Headset", 3500, true)
    ]
  constructor() { }
 ngOnInit() {
 }

}
