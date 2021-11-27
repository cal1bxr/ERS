import { Component, Input, OnInit } from '@angular/core';
import { Reimb } from 'src/app/models/reimb';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
@Input() cols!:string[];
@Input() data!:Reimb[];

  constructor() { 
    
  }

  ngOnInit(): void {
  }

}
